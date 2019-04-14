package com.att.edge.backend.reorg.reOrgEventSubscription;

import static com.att.edge.backend.reorg.util.PoolingUtil.isPollingDuration;
import static com.att.edge.backend.reorg.util.PoolingUtil.xmlGregorianToStringConversion;
import static com.att.edge.backend.reorg.util.ReOrgConstatns.DATE_TIME;

import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.att.edge.appcommon.EdgeException;
import com.att.edge.appcommon.FileLogger;
import com.att.edge.appcommon.GlobalContext;
import com.att.edge.appcommon.ProgramConfig;
import com.att.edge.appcommon.SendMail;

import com.att.edge.backend.reorg.Reorg;
import com.att.edge.backend.reorg.model.ResourceAttribute;
import com.att.edge.backend.reorg.model.TechAttribute;
import com.att.edge.backend.reorg.model.TechLocationDetail;
import com.att.edge.backend.reorg.model.TechScheduleAttribute;
import com.att.edge.backend.reorg.service.AdminRegionalLinksService;
import com.att.edge.backend.reorg.service.BulkUploadService;
import com.att.edge.backend.reorg.service.ResourceDetailsService;
import com.att.edge.backend.reorg.service.ResourceLocationService;
import com.att.edge.backend.reorg.service.ResourceWorkZoneService;
import com.att.edge.backend.reorg.service.TechLocationService;
import com.att.edge.backend.reorg.service.TechScheduleService;
import com.att.edge.backend.reorg.service.TechSkillService;
import com.att.edge.backend.reorg.service.TechUnavailibilityService;
import com.att.edge.backend.reorg.service.TechWorkZoneService;
import com.att.edge.backend.reorg.service.TechnicianPoolerService;
import com.att.edge.backend.reorg.serviceGateWay.HierarchyServiceGateway;
import com.att.edge.backend.reorg.serviceGateWay.LocationDetailsGateway;
import com.att.edge.backend.reorg.serviceGateWay.ResourceLocationServiceGateway;
import com.att.edge.backend.reorg.serviceGateWay.ResourceWorkZoneServiceGateway;
import com.att.edge.backend.reorg.serviceGateWay.TechLocationServiceGateway;
import com.att.edge.backend.reorg.serviceGateWay.TechScheduleServiceGateway;
import com.att.edge.backend.reorg.serviceGateWay.TechSkillServiceGateway;
import com.att.edge.backend.reorg.serviceGateWay.TechUnavailibilityServiceGateway;
import com.att.edge.backend.reorg.serviceGateWay.TechWorkZoneServiceGateway;
import com.att.edge.backend.reorg.serviceGateWay.TechnicianServiceGateway;
import com.att.edge.backend.reorg.util.ReOrgConstatns;
import com.att.edge.backend.reorg.util.SpringContextUtil;

public class ReOrgEventPublisher implements Runnable {
	
	

	private static BulkUploadService bulkUploadService = (BulkUploadService) SpringContextUtil.getApplicationContext()
			.getBean("bulkUploadService");
	
	private static AdminRegionalLinksService adminRegionalLinksService = (AdminRegionalLinksService) SpringContextUtil.getApplicationContext()
			.getBean("adminRegionalLinksService");

	@Override
	public void run() {
		try {
			Reorg.threadInitialize(null);
		} catch (EdgeException e1) {
			e1.printStackTrace();
		}
		FileLogger log = (FileLogger) GlobalContext.get("log");
		ProgramConfig cfg = (ProgramConfig) GlobalContext.get("cfg");

		int pollingDuration = (int) cfg.getLong("polling_duration");
		String lastUpdateDttm = "";
		while (Reorg.stillRunning()) {
			try {
				// check if polling duration is over
				boolean isPolled = isPollingDuration(lastUpdateDttm, pollingDuration);
				if (isPolled) {
					processHierarchy();
					processWorkZones();
					processTechSkill();
					processLocation();
					processAssignLocation();
					processTechSchedule();	
					processTechnicianAttribute();
					processTechUnavailable();					
					processResourceWorkZone();
					
					GregorianCalendar gCal = new GregorianCalendar();
					XMLGregorianCalendar updateDateXML = null;
					try {
						updateDateXML = DatatypeFactory.newInstance().newXMLGregorianCalendar(gCal);
					} catch (DatatypeConfigurationException e) {
						log.writeLocation(FileLogger.ALWAYS, "  inside run: %s", e);
					}
					lastUpdateDttm = xmlGregorianToStringConversion(updateDateXML, DATE_TIME);
				}
			} catch (EdgeException e) {
				e.printStackTrace();
			}
		}
	}

	private void processTechUnavailable() {

		FileLogger log = (FileLogger) GlobalContext.get("log");
		log.write(FileLogger.ALWAYS, "Entring  processTechUnavailable  method");
		TechUnavailibilityService techUnavailibilityService = (TechUnavailibilityService) SpringContextUtil
				.getApplicationContext().getBean("techUnavailibilityService");

		List<TechScheduleAttribute> techUnavailble = techUnavailibilityService
				.getTechUnavailibilitiesByProcessStatus(null);
		final TechUnavailibilityServiceGateway techUnavailbleServiceGateway = SpringContextUtil.getApplicationContext()
				.getBean(TechUnavailibilityServiceGateway.class);

		if (techUnavailble.isEmpty()) {
			log.write(FileLogger.ALWAYS, "No data in techUnavailble from processTechUnavailable method");
		}

		if (!techUnavailble.isEmpty()) {
			techUnavailble.stream().forEach(techUnavailbleServiceGateway::send);
		}
		Set<String> fileNames = techUnavailble.stream()
				.filter(techScheduleAttribute -> techScheduleAttribute.getFileName() != null)
				.map(techScheduleAttribute -> techScheduleAttribute.getFileName()).collect(Collectors.toSet());


		//	bulkUploadService.UpdateBulkStatus(fileNames);		


		int[] updateCounts = bulkUploadService.UpdateBulkStatus(fileNames);
		List<String> notificationID=null;

		try {
			notificationID=adminRegionalLinksService.fetchNotificationId(fileNames.stream().collect(Collectors.joining(",")));
		} catch (EdgeException e) {
			e.printStackTrace();
		}
		try {
			checkUpdateCounts(updateCounts , fileNames.stream().collect(Collectors.joining(",")) ,notificationID);
		} catch (EdgeException e) {
			
			e.printStackTrace();
		}

		log.write(FileLogger.ALWAYS, "exiting  processTechUnavailable  method");
	}

	public void  sendEMail(String mailData,String subject,  String toUser)  {
		FileLogger log = (FileLogger) GlobalContext.get("log");
		try {
			log.writeLocation(FileLogger.ALWAYS, "MailData:" +mailData + "ToUser:" +toUser);
		} catch (EdgeException e) {
			
			e.printStackTrace();
		}
		SendMail sendMail = new SendMail(toUser, subject, log);
		sendMail.setText(mailData);
		sendMail.send();
	}

	private void processHierarchy() {

		FileLogger log = (FileLogger) GlobalContext.get("log");
		log.write(FileLogger.ALWAYS, "Entring  processHierarchy  method");

		ResourceDetailsService resourceDetailsService = (ResourceDetailsService) SpringContextUtil
				.getApplicationContext().getBean("resourceDetailsService");

		List<ResourceAttribute> hierarchies = resourceDetailsService.getResourceDetailsByProcessStatus(null);

		if (hierarchies.isEmpty()) {
			log.write(FileLogger.ALWAYS, "No data in hierarchies from processHierarchy method");
		}

		final HierarchyServiceGateway hierarchyServiceGateway = SpringContextUtil.getApplicationContext()
				.getBean(HierarchyServiceGateway.class);
		if (!hierarchies.isEmpty()) {
			hierarchies.stream().forEach(hierarchyServiceGateway::send);
		}

		Set<String> fileNames = hierarchies.stream()
				.filter(resourceAttribute -> resourceAttribute.getFileName() != null)
				.map(resourceAttribute -> resourceAttribute.getFileName()).collect(Collectors.toSet());


		int[] updateCounts = bulkUploadService.UpdateBulkStatus(fileNames);
		List<String> notificationID=null;

		try {
			notificationID=adminRegionalLinksService.fetchNotificationId(fileNames.stream().collect(Collectors.joining(",")));
		} catch (EdgeException e) {
			e.printStackTrace();
		}
		try {
			checkUpdateCounts(updateCounts , fileNames.stream().collect(Collectors.joining(",")) ,notificationID);
		} catch (EdgeException e) {
			
			e.printStackTrace();
		}
	//	checkUpdateCounts(updateCounts , filesCommaSeperated);		log.write(FileLogger.ALWAYS, "exiting  processHierarchy  method");

	}

	private void processWorkZones() {

		FileLogger log = (FileLogger) GlobalContext.get("log");

		TechWorkZoneService techWorkZoneService = (TechWorkZoneService) SpringContextUtil.getApplicationContext()
				.getBean("techWorkZoneService");
		log.write(FileLogger.ALWAYS, "Entring  processWorkZones  method");

		List<TechAttribute> techAttributes = techWorkZoneService.getTechWorkZoneByProcessStatus(null);
		final TechWorkZoneServiceGateway techWorkZoneServiceGateway = SpringContextUtil.getApplicationContext()
				.getBean(TechWorkZoneServiceGateway.class);

		if (techAttributes.isEmpty()) {
			log.write(FileLogger.ALWAYS, "No data in techAttributes from processWorkZones method");
		}
		if (!techAttributes.isEmpty()) {
			techAttributes.stream().forEach(techWorkZoneServiceGateway::send);
		}

		Set<String> fileNames = techAttributes.stream().filter(techAttribute -> techAttribute.getFileName() != null)
				.map(techAttribute -> techAttribute.getFileName()).collect(Collectors.toSet());


		int[] updateCounts = bulkUploadService.UpdateBulkStatus(fileNames);
	//	checkUpdateCounts(updateCounts , filesCommaSeperated);
		List<String> notificationID=null;

		try {
			notificationID=adminRegionalLinksService.fetchNotificationId(fileNames.stream().collect(Collectors.joining(",")));
		} catch (EdgeException e) {
			e.printStackTrace();
		}
		try {
			checkUpdateCounts(updateCounts , fileNames.stream().collect(Collectors.joining(",")) ,notificationID);
		} catch (EdgeException e) {
			
			e.printStackTrace();
		}
		log.write(FileLogger.ALWAYS, "exiting  processWorkZones  method");
	}

	private String processTechSkill() {

		FileLogger log = (FileLogger) GlobalContext.get("log");
		String response = null;
		TechSkillService techSkillService = (TechSkillService) SpringContextUtil.getApplicationContext()
				.getBean("techSkillService");
		log.write(FileLogger.ALWAYS, "entering  processTechSkill  method");
		List<TechAttribute> techSkills = techSkillService.getTechSkillsByProcessStatus(null);
		final TechSkillServiceGateway techSkillServiceGateway = SpringContextUtil.getApplicationContext()
				.getBean(TechSkillServiceGateway.class);
		if (techSkills.isEmpty()) {
			log.write(FileLogger.ALWAYS, "No data in techSkills from processTechSkill method");
		}

		if (!techSkills.isEmpty()) {
			response = techSkillServiceGateway.send(techSkills);
			try {
				log.writeLocation(FileLogger.ALWAYS, " Inside processTechSkill method: %s", response);
			} catch (EdgeException e) {
				e.printStackTrace();
			}
		}

		Set<String> fileNames = techSkills.stream().filter(techAttribute -> techAttribute.getFileName() != null)
				.map(techAttribute -> techAttribute.getFileName()).collect(Collectors.toSet());

		String filesCommaSeperated =fileNames
				.stream()
				.collect(Collectors.joining(","));

		int[] updateCounts = bulkUploadService.UpdateBulkStatus(fileNames);
//		checkUpdateCounts(updateCounts , filesCommaSeperated);
		
		List<String> notificationID=null;

		try {
			notificationID=adminRegionalLinksService.fetchNotificationId(fileNames.stream().collect(Collectors.joining(",")));
		} catch (EdgeException e) {
			e.printStackTrace();
		}
		try {
			checkUpdateCounts(updateCounts , fileNames.stream().collect(Collectors.joining(",")) ,notificationID);
		} catch (EdgeException e) {
			
			e.printStackTrace();
		}

		log.write(FileLogger.ALWAYS, "exiting  processTechSkill  method");
		return response;
	}

	private String processTechnicianAttribute() {

		FileLogger log = (FileLogger) GlobalContext.get("log");
		TechnicianPoolerService technicianPoolerService = (TechnicianPoolerService) SpringContextUtil
				.getApplicationContext().getBean("technicianPoolerService");

		log.write(FileLogger.ALWAYS, "entering  processTechnicianAttribute  method");
		String response = null;
		List<TechAttribute> technicianList = technicianPoolerService.getTechAttributeByStatus(null);

		if (technicianList.isEmpty()) {
			log.write(FileLogger.ALWAYS, "No data in technicianList from processTechnicianAttribute method");
		}

		final TechnicianServiceGateway service = SpringContextUtil.getApplicationContext()
				.getBean(TechnicianServiceGateway.class);
		if (!technicianList.isEmpty()) {
			technicianList.stream().forEach(service::send);
		}

		Set<String> fileNames = technicianList.stream().filter(techAttribute -> techAttribute.getFileName() != null)
				.map(techAttribute -> techAttribute.getFileName()).collect(Collectors.toSet());


		int[] updateCounts = bulkUploadService.UpdateBulkStatus(fileNames);
	//	checkUpdateCounts(updateCounts , filesCommaSeperated);
		List<String> notificationID=null;

		try {
			notificationID=adminRegionalLinksService.fetchNotificationId(fileNames.stream().collect(Collectors.joining(",")));
		} catch (EdgeException e) {
			e.printStackTrace();
		}
		try {
			checkUpdateCounts(updateCounts , fileNames.stream().collect(Collectors.joining(",")) ,notificationID);
		} catch (EdgeException e) {
			
			e.printStackTrace();
		}

		log.write(FileLogger.ALWAYS, "exiting  processTechnicianAttribute  method");
		return response;
	}

	private String processLocation() {

		FileLogger log = (FileLogger) GlobalContext.get("log");
		ResourceLocationService resourceLocationService = (ResourceLocationService) SpringContextUtil
				.getApplicationContext().getBean("resourceLocationService");
		String response = null;
		log.write(FileLogger.ALWAYS, "entring into  processLocation  method");
		List<TechLocationDetail> resourceAttributes = resourceLocationService.getResourceLocationByProcessStatus(null);
		Map<Boolean,List<TechLocationDetail>> partionMap=	resourceAttributes.stream()
				.filter(techLocationDetails->techLocationDetails!=null)
				.collect(Collectors.partitioningBy(techLocationDetails->"Y".equalsIgnoreCase(techLocationDetails.getIsTech())));
		
		List<TechLocationDetail>	 locationDetails =partionMap.get(true);
		List<TechLocationDetail>	 resourceLocations =partionMap.get(false);
		
		if(!locationDetails.isEmpty()){
			final LocationDetailsGateway service = SpringContextUtil.getApplicationContext()
					.getBean(LocationDetailsGateway.class);
			if (!locationDetails.isEmpty()) {
				locationDetails.stream().forEach(service::send);
			}
		}
			
		if(!resourceLocations.isEmpty()){
		final ResourceLocationServiceGateway resourceLocationServiceGateway = SpringContextUtil.getApplicationContext()
				.getBean(ResourceLocationServiceGateway.class);
		if (!resourceLocations.isEmpty()) {
			resourceLocations.stream().forEach(resourceLocationServiceGateway::send);
		}
		}

		if (resourceAttributes.isEmpty()) {
			log.write(FileLogger.ALWAYS, "No data in resourceAttributes from processLocation method");
		}
		
		Set<String> fileNames = resourceAttributes.stream()
				.filter(techAttribute -> techAttribute.getFileName() != null)
				.map(techAttribute -> techAttribute.getFileName()).collect(Collectors.toSet());


		int[] updateCounts = bulkUploadService.UpdateBulkStatus(fileNames);

		//notificationID=adminRegionalLinksService.getNotifactionIdByFileName(filesCommaSeperated);
/*		String emalCommaSeperated=notificationID
				.stream()
				.collect(Collectors.joining(";"));*/

		List<String> notificationID=null;

		try {
			notificationID=adminRegionalLinksService.fetchNotificationId(fileNames.stream().collect(Collectors.joining(",")));
		} catch (EdgeException e) {
			e.printStackTrace();
		}
		try {
			checkUpdateCounts(updateCounts , fileNames.stream().collect(Collectors.joining(",")) ,notificationID);
		} catch (EdgeException e) {
			
			e.printStackTrace();
		}
		
	//	checkUpdateCounts(updateCounts , filesCommaSeperated  ,emalCommaSeperated);
		log.write(FileLogger.ALWAYS, "exiting  processLocation  method");
		return response;
	}

	private String processTechSchedule() {
		FileLogger log = (FileLogger) GlobalContext.get("log");
		TechScheduleService techScheduleService = (TechScheduleService) SpringContextUtil.getApplicationContext()
				.getBean("techScheduleService");
		log.write(FileLogger.ALWAYS, "entring into  processTechSchedule  method");
		String response = null;
		List<TechScheduleAttribute> techSchedules = techScheduleService.getTechSchudulesByProcessStatus(null);
		final TechScheduleServiceGateway techScheduleServiceGateway = SpringContextUtil.getApplicationContext()
				.getBean(TechScheduleServiceGateway.class);
		if (techSchedules.isEmpty()) {
			log.write(FileLogger.ALWAYS, "No data in techSchedules from processTechSchedule method");
		}
		if (!techSchedules.isEmpty()) {
			techSchedules.stream().forEach(techSchedule->{
				techScheduleServiceGateway.send(techSchedule);
				techSchedule.getFileName();
			});
		}
		Set<String> fileNames = techSchedules.stream().filter(techAttribute -> techAttribute.getFileName() != null)
				.map(techAttribute -> techAttribute.getFileName()).collect(Collectors.toSet());

		int[] updateCounts = bulkUploadService.UpdateBulkStatus(fileNames);
		
		List<String> notificationID=null;

		try {
			notificationID=adminRegionalLinksService.fetchNotificationId(fileNames.stream().collect(Collectors.joining(",")));
		} catch (EdgeException e) {
			e.printStackTrace();
		}
		try {
			checkUpdateCounts(updateCounts , fileNames.stream().collect(Collectors.joining(",")) ,notificationID);
		} catch (EdgeException e) {
			
			e.printStackTrace();
		}
	//	checkUpdateCounts(updateCounts , filesCommaSeperated);
		log.write(FileLogger.ALWAYS, "exiting  processTechSchedule  method");
		return response;
	}

	private void processAssignLocation() {
		FileLogger log = (FileLogger) GlobalContext.get("log");
		TechLocationService techLocationService = (TechLocationService) SpringContextUtil.getApplicationContext()
				.getBean("techLocationService");
		log.write(FileLogger.ALWAYS, "entring  processAssignLocation  method");
		List<TechAttribute> assignedLocationDetails = techLocationService.getTechLocationsByProcessStatus(null);
		final TechLocationServiceGateway techLocationServiceGateway = SpringContextUtil.getApplicationContext()
				.getBean(TechLocationServiceGateway.class);
		if (!assignedLocationDetails.isEmpty()) {
			assignedLocationDetails.stream().forEach(assignedLocation->{
				techLocationServiceGateway.send(assignedLocation);
				//sendEMail( assignedLocation.getFileName()+"\n"+" succesfully Processed" ,   "Files Status..!!" , "vineet.k.chaurasia@accenture.com");
			});
		}
		Set<String> fileNames = assignedLocationDetails.stream()
				.filter(techAttribute -> techAttribute.getFileName() != null)
				.map(techAttribute -> techAttribute.getFileName()).collect(Collectors.toSet());

		int[] updateCounts = bulkUploadService.UpdateBulkStatus(fileNames);
		
/*		String filesCommaSeperated =fileNames
				.stream()
				.collect(Collectors.joining(","));*/
		
		List<String> notificationID=null;

			try {
				notificationID=adminRegionalLinksService.fetchNotificationId(fileNames.stream().collect(Collectors.joining(",")));
			} catch (EdgeException e) {
				e.printStackTrace();
			}

			//sendEMail( filesCommaSeperated+"\n"+" succesfully Processed" ,   "Files Status..!!" , notificationID.stream().collect(Collectors.joining(";")));
			//sendEMail( filesCommaSeperated+"\n"+" succesfully Processed" ,   "Files Status..!!" , "vineet.k.chaurasia@accenture.com; siddhartha.a.ghosh@accenture.com");
		try {
			checkUpdateCounts(updateCounts , fileNames.stream().collect(Collectors.joining(",")) ,notificationID);
		} catch (EdgeException e) {
			
			e.printStackTrace();
		}
		log.write(FileLogger.ALWAYS, "exiting  processAssignLocation  method");
	}

	public  void checkUpdateCounts(int[] updateCounts ,String filesCommaSeperated,List<String> notificationId) throws EdgeException {
		FileLogger log = (FileLogger) GlobalContext.get("log");
		// TODO Auto-generated method stub
		int count=0;
		for(int i=0;i<updateCounts.length;i++){
			if (updateCounts[i] >= 0) {
				log.write(FileLogger.ALWAYS, "Before sending 1 mail");
				count++;
				log.write(FileLogger.ALWAYS, "After sending 1 mail");
			}else if (updateCounts[i] == ReOrgConstatns.SUCCESS_NO_INFO) {
				log.write(FileLogger.ALWAYS, "Before sending 2 mail");
				count++;
				log.write(FileLogger.ALWAYS, "After sending 2 mail");
			}else{
				log.write(FileLogger.ALWAYS, "could not send mail :: internal Error..!!");
			}
		}
		//sendEMail( filesCommaSeperated+"\n"+" succesfully Processed" ,   "Files Status..!!" , notificationId.stream().collect(Collectors.joining(":")));
		if(count>0){
			sendEMail( filesCommaSeperated+"\n"+" succesfully Processed" ,   filesCommaSeperated +"Files Status..!!" , notificationId.stream().collect(Collectors.joining(";")));
			log.write(FileLogger.ALWAYS, "Email Sent successfully");	
		}

	}

	
	private void processResourceWorkZone() {
		FileLogger log = (FileLogger) GlobalContext.get("log");
		ResourceWorkZoneService resourceWorkZoneService = (ResourceWorkZoneService) SpringContextUtil
				.getApplicationContext().getBean("resourceWorkZoneService");
		log.write(FileLogger.ALWAYS, "Entring  processWorkZones  method");

		List<ResourceAttribute> resourceAttributes = resourceWorkZoneService.getResourceWorkZoneByProcessStatus(null);
		final ResourceWorkZoneServiceGateway resourceWorkZoneServiceGateway = SpringContextUtil.getApplicationContext()
				.getBean(ResourceWorkZoneServiceGateway.class);
		if (!resourceAttributes.isEmpty()) {
			resourceAttributes.stream().forEach(resourceWorkZoneServiceGateway::send);
		}

		Set<String> fileNames = resourceAttributes.stream()
				.filter(techAttribute -> techAttribute.getFileName() != null)
				.distinct()
				.map(techAttribute -> techAttribute.getFileName()).collect(Collectors.toSet());

		int[] updateCounts = bulkUploadService.UpdateBulkStatus(fileNames);
	//	checkUpdateCounts(updateCounts , filesCommaSeperated);
		List<String> notificationID=null;
		try {
			notificationID=adminRegionalLinksService.fetchNotificationId(fileNames.stream().collect(Collectors.joining(",")));
		} catch (EdgeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			checkUpdateCounts(updateCounts , fileNames.stream().collect(Collectors.joining(",")) ,notificationID);
		} catch (EdgeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		log.write(FileLogger.ALWAYS, "exiting  processWorkZones  method");
	}

}
