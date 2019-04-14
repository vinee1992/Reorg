/** 
 * 
 */ 
package com.att.edge.backend.reorg.serviceActivator; 
 
import org.springframework.messaging.Message; 
import org.springframework.messaging.MessageChannel; 
import org.springframework.messaging.MessageHandlingException; 
import org.springframework.messaging.support.ChannelInterceptorAdapter; 
import org.springframework.stereotype.Component; 
import org.springframework.web.client.HttpClientErrorException; 
 
import com.att.edge.appcommon.EdgeException; 
import com.att.edge.appcommon.FileLogger; 
import com.att.edge.appcommon.GlobalContext; 
import com.fasterxml.jackson.databind.JsonNode; 
import com.fasterxml.jackson.databind.ObjectMapper; 
 
/** 
 * @author pradyumna.k.khadanga 
 * 
 */ 
@Component("messageLoggingService") 
public class MessageLoggingService extends ChannelInterceptorAdapter { 
 
	private static final  FileLogger log=(FileLogger) GlobalContext.get("log"); 
 
 
	@Override 
	public Message<?> preSend(Message<?> message, MessageChannel channel) { 
 
		String channelName= channel.toString(); 
		if ( channelName != null ) channelName=channelName.trim(); 
		try { 
			log.writeLocation(FileLogger.ALWAYS, "  inside run MessageLoggingService() channelName: %s", channelName); 
			log.writeLocation(FileLogger.ALWAYS, "  inside run MessageLoggingService()channel.toString(): %s", channel.toString()); 
			log.writeLocation(FileLogger.ALWAYS, "  inside run MessageLoggingService():message.getPayload() %s",  message.getPayload()); 
			
		} catch (EdgeException e) { 
			// TODO Auto-generated catch block 
			log.write(FileLogger.ALWAYS, "Exception from  MessageLoggingService method", e.getMessage()); 
		} 
 
		return message; 
	} 
 
}