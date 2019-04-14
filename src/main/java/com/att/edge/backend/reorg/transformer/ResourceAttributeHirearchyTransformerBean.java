package com.att.edge.backend.reorg.transformer;

import java.util.Arrays;

import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.att.edge.appcommon.EdgeException;
import com.att.edge.appcommon.FileLogger;
import com.att.edge.appcommon.GlobalContext;
import com.att.edge.backend.reorg.model.ResourceAttribute;
import com.att.edge.backend.reorg.model.ResourceAttributes;


/**
 * 
 * @author vineet.k.chaurasia
 * date 23/05/2018
 *
 */
@Component("resourceAttributeHirearchyTransformerBean")
public class ResourceAttributeHirearchyTransformerBean {


	FileLogger log=(FileLogger) GlobalContext.get("log");

	public ResourceAttributes transform(Message<?> Megssage){
		ResourceAttributes resourceAttributes = new ResourceAttributes();
		ResourceAttribute messages = (ResourceAttribute)Megssage.getPayload();		
		resourceAttributes.setResourcesAttributes(Arrays.asList(messages));
		 try {
			log.writeLocation(FileLogger.ALWAYS, "inside ResourceAttributeWorkZoneTransformerBean class  : %s", resourceAttributes);
		} catch (EdgeException e) {
			log.write(FileLogger.ALWAYS, "Exception from ResourceAttributeWorkZoneTransformerBean", e.getMessage());
		}
		 return resourceAttributes;
	}




}
