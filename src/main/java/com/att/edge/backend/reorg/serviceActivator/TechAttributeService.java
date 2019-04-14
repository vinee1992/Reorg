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
@Component("techAttributeService")
public class TechAttributeService {
	private static final FileLogger log = (FileLogger) GlobalContext.get("log");

	public Status updateTechAttribute(Message<String> message) throws IOException {
		try {
			log.writeLocation(FileLogger.ALWAYS, " The response message is: %s", message.getPayload());
			log.writeLocation(FileLogger.ALWAYS, "for request message: %s", message.getHeaders().get("JSONPayload"));
		} catch (EdgeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//System.out.println("The response message is:" + message.getPayload() + " for request message:"
				//+ message.getHeaders().get("JSONPayload"));
		
		log.write(FileLogger.ALWAYS, "The response message is: %s , for request message: %s ",   message.getPayload(), message.getHeaders().get("JSONPayload"));
		String jsonHeader = (String) message.getHeaders().get("JSONPayload");
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.readTree(jsonHeader);
		JsonNode techAttr = node.get("techAttributes");
		
		JsonNode seqNo=null;
		// check starts
		if (techAttr != null) {
			 seqNo = techAttr.get(0).get("seqNo");
		//	System.out.println(seqNo.toString());
		}
		// check finish

		String jsonResponse = message.getPayload().toString();
		JsonNode jsonResponseNode = mapper.readTree(jsonResponse);
		JsonNode techAttributesResponse = (JsonNode) jsonResponseNode.get("techAttributesResponse");
		JsonNode techDetailsResponseNode = null;
		JsonNode locationDetailsResponse = null;
		JsonNode workSkillDetailsResponse = null;
		JsonNode workZoneDetailsResponse=null;
		JsonNode assignedLocationDetailsResponse=null;
		Status status = new Status();
		if (techAttributesResponse.size() > 0) {

			techDetailsResponseNode = ((JsonNode) jsonResponseNode.get("techAttributesResponse")).get(0)
					.get("techDetailsResponse");
			locationDetailsResponse = ((JsonNode) jsonResponseNode.get("techAttributesResponse")).get(0)
					.get("locationDetailsResponse");

			workSkillDetailsResponse = ((JsonNode) jsonResponseNode.get("techAttributesResponse")).get(0)
					.get("workSkillDetailsResponse");
			workZoneDetailsResponse=((JsonNode) jsonResponseNode.get("techAttributesResponse")).get(0)
					.get("workZoneDetailsResponse");
			assignedLocationDetailsResponse=((JsonNode) jsonResponseNode.get("techAttributesResponse")).get(0)
					.get("assignedLocationDetailsResponse").get("dayDetails");
			if (techDetailsResponseNode != null && techDetailsResponseNode.size() > 0) {
				status.setStatus(techDetailsResponseNode.get("status").asText());
				status.setStatusReason(techDetailsResponseNode.get("statusMessage").asText());
			}
			if (locationDetailsResponse != null && locationDetailsResponse.size() > 0) {
				status.setStatus(locationDetailsResponse.get(0).get("status").asText());
				status.setStatusReason((locationDetailsResponse.get(0).get("statusMessage").asText() != null)  ? locationDetailsResponse.get(0).get("statusMessage").asText() : "Sucess" );
			}
			if (workSkillDetailsResponse != null && workSkillDetailsResponse.size() > 0) {
				status.setStatus(workSkillDetailsResponse.get(0).get("status").asText());
				status.setStatusReason(workSkillDetailsResponse.get(0).get("statusMessage").asText());
			}
			if(workZoneDetailsResponse != null && workZoneDetailsResponse.size() > 0){
				status.setStatus(workZoneDetailsResponse.get(0).get("status").asText());
				status.setStatusReason(workZoneDetailsResponse.get(0).get("statusMessage").asText());
				
			}
			if(assignedLocationDetailsResponse != null && assignedLocationDetailsResponse.size() > 0){
				status.setStatus(assignedLocationDetailsResponse.get(0).get("status").asText());
				status.setStatusReason(assignedLocationDetailsResponse.get(0).get("statusMessage").asText());
				
			}
		}
		else {
			status.setStatus("Failure");
			status.setStatusReason(techAttributesResponse.get(0).get("message").asText());
		}

		status.setSeqNo(Long.parseLong(seqNo.toString()));
	

		return status;
	}
}
