/**
 * 
 */
package com.att.edge.backend.reorg.serviceActivator;

import java.io.IOException;

import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.att.edge.appcommon.EdgeException;
import com.att.edge.appcommon.FileLogger;
import com.att.edge.appcommon.GlobalContext;
import com.att.edge.backend.reorg.model.Status;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author pradyumna.k.khadanga
 *
 */
@Component("techScheduleServiceActivator")
public class TechScheduleServiceActivator {
	private static final FileLogger log = (FileLogger) GlobalContext.get("log");

	public Status updateTechSchedule(Message<String> message) throws IOException {
		try {
			log.writeLocation(FileLogger.ALWAYS, " The response message is: %s", message.getPayload());
			log.writeLocation(FileLogger.ALWAYS, "for request message: %s", message.getHeaders().get("JSONPayload"));
		} catch (EdgeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//System.out.println("The response message is:" + message.getPayload() + " for request message:"
			//	+ message.getHeaders().get("JSONPayload"));
		log.write(FileLogger.ALWAYS, "The response message is: %s , for request message: %s ",   message.getPayload(), message.getHeaders().get("JSONPayload"));
		String jsonHeader = (String) message.getHeaders().get("JSONPayload");
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.readTree(jsonHeader);
		JsonNode scheduleDetails = node.get("scheduleDetails");
		JsonNode seqNo=null ;
		// check starts
		 /*if(node!=null)
		{
			 seqNo = node.get("seqNo");
			System.out.println(seqNo.toString());
		}*/
		// check finish
		if (scheduleDetails != null) {
			 seqNo = scheduleDetails.get(0).get("seqNo");
			//System.out.println(seqNo.toString());
		}
		String jsonResponse = message.getPayload().toString();
		JsonNode jsonResponseNode = mapper.readTree(jsonResponse);
		JsonNode scheduleDetailsResponse = (JsonNode) jsonResponseNode.get("scheduleDetailsResponse");
		JsonNode scheduleDayDetailResponse = null;
		JsonNode calloutScheduleResponse = null;
		Status status = new Status();
		if (scheduleDetailsResponse.size() > 0) {

		
			scheduleDetailsResponse = ((JsonNode) jsonResponseNode.get("scheduleDetailsResponse")).get(0)
					.get("scheduleDetailsResponse");
			scheduleDayDetailResponse = ((JsonNode) jsonResponseNode.get("scheduleDetailsResponse")).get(0)
					.get("scheduleDayDetailResponse");
			calloutScheduleResponse = ((JsonNode) jsonResponseNode.get("scheduleDetailsResponse")).get(0)
					.get("scheduleDayDetailResponse").get(0).get("calloutScheduleResponse");
			
		

		}
	
		if (scheduleDetailsResponse != null && scheduleDetailsResponse.size() > 0) {
			status.setStatus(scheduleDetailsResponse.get(0).get("status").asText());
			//status.setStatusReason(scheduleDetailsResponse.get(0).get("statusMessage").asText());
		} 
		if (scheduleDayDetailResponse != null && scheduleDayDetailResponse.size() > 0) {
			if(!scheduleDayDetailResponse.get(0).get("status").isNull()){
			status.setStatus(scheduleDayDetailResponse.get(0).get("status").asText());
			status.setStatusReason(scheduleDayDetailResponse.get(0).get("statusMessage").asText());
			}else{
				status.setStatus(calloutScheduleResponse.get("calloutSchedulestatus").asText());
				status.setStatusReason(calloutScheduleResponse.get("calloutSchedulestatusMessage").asText());
			}
		} 

		else {
			status.setStatus("Failure");
			status.setStatusReason("No response");
			//status.setStatusReason(techAttributesResponse.get(0).get("message").asText());
		}

		status.setSeqNo(Long.parseLong(seqNo.toString()));

		return status;
	}
}
