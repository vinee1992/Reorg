/**
 * 
 */
package com.att.edge.backend.reorg.serviceImpl;

import static java.util.stream.Collectors.toMap;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.att.edge.appcommon.AdminRegionalLinks;
import com.att.edge.appcommon.EdgeException;
import com.att.edge.backend.reorg.dao.AdminRegionalLinksDao;
import com.att.edge.backend.reorg.service.AdminRegionalLinksService;

/**
 * @author pradyumna.k.khadanga
 *
 */
@Service("adminRegionalLinksService")
class AdminRegionalLinksServiceImpl implements AdminRegionalLinksService {
	@Autowired
	AdminRegionalLinksDao adminRegionalLinksDao;
	
	Map<String,String> notifactionMap=null;

	@Override
	public Map<String, AdminRegionalLinks> retrieveAdminRegionalLinks() throws EdgeException {

		return adminRegionalLinksDao.retrieveAdminRegionalLinks().stream()
				.filter(adminRegionalLinks -> adminRegionalLinks.getRegion() != null)
				.collect(toMap(AdminRegionalLinks::getRegion, Function.identity()));
	}

	@PostConstruct
	public void init() {
		Function<Map<String, AdminRegionalLinks>, Optional<AdminRegionalLinks>> urlMapping = urlMap -> urlMap.entrySet()
				.stream().filter(entrySet -> "E".equalsIgnoreCase(entrySet.getKey()))
				.map(entrySet -> entrySet.getValue()).findAny();
		try {
			Map<String, AdminRegionalLinks> urlMap = retrieveAdminRegionalLinks();
			Optional<AdminRegionalLinks> adminRegionalLinks = urlMapping.apply(urlMap);

			System.setProperty("resourceMaintServices.api", adminRegionalLinks.isPresent()
					? adminRegionalLinks.get().getMtsUrlStart() + "ResourceMaintServices/manageResourceAttributes"
					: null);
			System.setProperty("resourceLocationMaintServices.api", adminRegionalLinks.isPresent()
					? adminRegionalLinks.get().getMtsUrlStart() + "ResourceMaintServices/manageResourceLocations"
					: null);
			System.setProperty("resourceWorkzoneServices.api", adminRegionalLinks.isPresent()
					? adminRegionalLinks.get().getMtsUrlStart() + "ResourceMaintServices/manageResourceWorkZones"
					: null);
			System.setProperty("techMaintServices.api", adminRegionalLinks.isPresent()
					? adminRegionalLinks.get().getMtsUrlStart() + "TechMaintServices/manageTechAttributes" : null);
			System.setProperty("scheduleMaintServices.api", adminRegionalLinks.isPresent()
					? adminRegionalLinks.get().getMtsUrlStart() + "TechMaintServices/manageTechSchedule" : null);
		} catch (EdgeException e1) {
			e1.printStackTrace();
		}
		//	getNotificationDetail();
	}
/*
	private void getNotificationDetail() throws EdgeException{
		notifactionMap=	adminRegionalLinksDao.fetchEmailAndFileNames()
		.stream()
		.filter(fileName->fileName.getFileName() !=null && fileName.getNotificationId() !=null)
		.collect(toMap(EmailNotification::getFileName, EmailNotification::getNotificationId,
				(oldValue , newValue) ->oldValue
				
				));
	}*/
	
	@Override
	public List<String> fetchNotificationId(String fileName) throws EdgeException {
		// TODO Auto-generated method stub
		return adminRegionalLinksDao.fetchNotificationId(fileName);
	}

/*	@Override
	public Map<String,String> getNotifactionIdByFileName(String fileName) {
		// TODO Auto-generated method stub
		return notifactionMap;
	}*/

/*	@Override
	public List<String> getNotifactionIdByFileName(String fileName) {
		List<String> presentInMapList = null;

		if(fileName.contains(",")){
			 presentInMapList= Stream.of(fileName.split(","))
					.filter(file->notifactionMap.containsKey(file))
					.collect(Collectors.toList());
			if(!presentInMapList.isEmpty() && presentInMapList!=null){
				return presentInMapList;
			}else{
				try {
					return fetchNotificationId(fileName);
				} catch (EdgeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
						
		}else{
			if(notifactionMap.containsKey(fileName))
				return Arrays.asList(notifactionMap.get(fileName));
			else{
				try {
					return fetchNotificationId(fileName);
				} catch (EdgeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;

		
	}*/

}
