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
@Component("techAssignedLocationService")
public class TechAssignedLocationService {
	private static final FileLogger log = (FileLogger) GlobalContext.get("log");

	public Status updateTechAssignedLocation(Message<String> message) throws IOException {
		try {
			log.writeLocation(FileLogger.ALWAYS, " The response message is: %s", message.getPayload());
			log.writeLocation(FileLogger.ALWAYS, "for request message: %s", message.getHeaders().get("JSONPayload"));
		} catch (EdgeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//System.out.println("The response message is:" + message.getPayload() + " for request message:"
		//		+ message.getHeaders().get("JSONPayload"));
		log.write(FileLogger.ALWAYS, "from log The response message is: %s , for request message: %s ",   message.getPayload(), message.getHeaders().get("JSONPayload"));
		String jsonHeader = (String) message.getHeaders().get("JSONPayload");
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.readTree(jsonHeader);
		//JsonNode resourceAttr = node.get("resourceAttributes");
		JsonNode seqNo=null ;
		// check starts
		 if(node!=null)
		{
			 seqNo = node.get("seqNo");
			//System.out.println(seqNo.toString());
		}
		// check finish

		String jsonResponse = message.getPayload().toString();
		JsonNode jsonResponseNode = mapper.readTree(jsonResponse);
		JsonNode techAttributesResponse = (JsonNode) jsonResponseNode.get("techAttributesResponse");
		//JsonNode locationDetailsResponse = null;
		Status status = new Status();
		if (techAttributesResponse.size() > 0) {

		
			techAttributesResponse = ((JsonNode) jsonResponseNode.get("techAttributesResponse")).get(0)
					.get("techAttributesResponse");

		

		}
	
		if (techAttributesResponse != null && techAttributesResponse.size() > 0) {
			status.setStatus(techAttributesResponse.get(0).get("status").asText());
			status.setStatusReason(techAttributesResponse.get(0).get("message").asText());
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
