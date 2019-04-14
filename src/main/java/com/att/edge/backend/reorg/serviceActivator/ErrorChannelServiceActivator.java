/**
 * 
 */
package com.att.edge.backend.reorg.serviceActivator;

import java.io.IOException;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandlingException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

import com.att.edge.appcommon.FileLogger;
import com.att.edge.appcommon.GlobalContext;
import com.att.edge.backend.reorg.model.Status;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author pradyumna.k.khadanga
 *
 */
@Component("errorChannelServiceActivator")
public class ErrorChannelServiceActivator  {
	private static final FileLogger log = (FileLogger) GlobalContext.get("log");

	public Status updateTechAttribute(Message<?> message)  throws Exception {
		String seqNo=null;
		Status status = new Status();
		MessageHandlingException exception =(MessageHandlingException) message.getPayload(); 
		log.writeLocation(FileLogger.ALWAYS, "  Error for request message %s",   exception.getFailedMessage().getPayload()); 
		try { 
			 seqNo=getSeqNo(exception); 
		} catch (Exception e) { 
			// TODO Auto-generated catch block 
			log.write(FileLogger.ALWAYS, "Exception from  MessageLoggingService method", e.getMessage()); 
		} 
		String exceptionError=null;
		if(exception.getCause() instanceof HttpClientErrorException){		
		HttpClientErrorException httpClientErrorException =(HttpClientErrorException)exception.getCause(); 
		 exceptionError= httpClientErrorException.getStatusCode().toString().concat("_").concat(httpClientErrorException.getStatusText() ) ;
		}
		log.writeLocation(FileLogger.ALWAYS, "  Error  Details %s", exceptionError);
		
			status.setStatus("Failure");
			status.setStatusReason(exceptionError);

		status.setSeqNo(Long.parseLong(seqNo));
	

		return status;
	}
	
	private String getSeqNo(MessageHandlingException message) throws Exception{ 
		 
		ObjectMapper mapper = new ObjectMapper(); 
		String seqNo=null; 
		String jsonResponse =(String) message.getFailedMessage().getPayload(); 
		JsonNode jsonResponseNode =mapper.readTree(jsonResponse); 
		JsonNode techAttributesResponse = (JsonNode) jsonResponseNode.get("techAttributes"); 
		JsonNode scheduleDetailsResponse = (JsonNode) jsonResponseNode.get("scheduleDetails"); 
		JsonNode resourcesAttributesResponses = (JsonNode) jsonResponseNode.get("resourcesAttributes"); 
		if (techAttributesResponse!=null ) { 
			 seqNo = ((JsonNode) jsonResponseNode.get("techAttributes")).get(0) 
					.get("seqNo").asText(); 
		} 
		if (scheduleDetailsResponse!=null) { 
			 seqNo = ((JsonNode) jsonResponseNode.get("scheduleDetails")).get(0) 
					.get("seqNo").asText(); 
		} 
		if (resourcesAttributesResponses!=null) { 
			 seqNo = ((JsonNode) jsonResponseNode.get("resourcesAttributes")).get(0) 
					.get("seqNo").asText(); 
		} 
		return seqNo; 
	} 
}
