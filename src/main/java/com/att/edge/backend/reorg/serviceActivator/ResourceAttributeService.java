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
@Component("resourceAttributeService")
public class ResourceAttributeService {
	private static final FileLogger log = (FileLogger) GlobalContext.get("log");

	public Status updateResourceAttribute(Message<String> message) throws IOException {
		try {
			log.writeLocation(FileLogger.ALWAYS, " The response message is: %s", message.getPayload());
			log.writeLocation(FileLogger.ALWAYS, "for request message: %s", message.getHeaders().get("JSONPayload"));
		} catch (EdgeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
		log.write(FileLogger.ALWAYS, "The response message is: %s , for request message: %s ",   message.getPayload(), message.getHeaders().get("JSONPayload"));
		//System.out.println("The response message is:" + message.getPayload() + " for request message:"+ message.getHeaders().get("JSONPayload"));
		String jsonHeader = (String) message.getHeaders().get("JSONPayload");
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.readTree(jsonHeader);
		JsonNode resourceAttr = node.get("resourcesAttributes");
		JsonNode seqNo=null ;
		// check starts
		 if(resourceAttr!=null)
		{
			 seqNo = resourceAttr.get(0).get("seqNo");
			//System.out.println(seqNo.toString());
		}
		// check finish

		String jsonResponse = message.getPayload().toString();
		JsonNode jsonResponseNode = mapper.readTree(jsonResponse);
		JsonNode resourceAttributesResponse = (JsonNode) jsonResponseNode.get("resourceAttributeResponses");
		JsonNode locationDetailsResponse = null;
		
		Status status = new Status();	
		if (resourceAttributesResponse.size() > 0) {

		
			locationDetailsResponse = ((JsonNode) jsonResponseNode.get("resourceAttributeResponses")).get(0)
					.get("locationDetailsResponse");
			
		

		}
	
		if (locationDetailsResponse != null && locationDetailsResponse.size() > 0) {
			status.setStatus(locationDetailsResponse.get(0).get("status").asText());
			status.setStatusReason(locationDetailsResponse.get(0).get("message").asText());
		} else {
			if(resourceAttributesResponse.get(0).get("status").isNull()){
				status.setStatus("Unknown");
			}else{
				status.setStatus(resourceAttributesResponse.get(0).get("status").asText());
			}
			if(resourceAttributesResponse.get(0).get("message").isNull()){
				status.setStatus("Unknown");
			}else{
				status.setStatusReason(resourceAttributesResponse.get(0).get("message").asText());
			}		
			
		}

		status.setSeqNo(Long.parseLong(seqNo.toString()));

		return status;
	}
}
