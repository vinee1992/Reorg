/**
 * 
 */
package com.att.edge.backend.reorg.transformer;

import java.util.Arrays;

import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.att.edge.appcommon.EdgeException;
import com.att.edge.appcommon.FileLogger;
import com.att.edge.appcommon.GlobalContext;

import com.att.edge.backend.reorg.model.TechLocationDetail;
import com.att.edge.backend.reorg.model.TechLocationDetails;


/**
 * @author pradyumna.k.khadanga
 *
 */
@Component("resourceAttributeTransformerBean")
public class ResourceAttributeTransformerBean {
	FileLogger log=(FileLogger) GlobalContext.get("log");

	public TechLocationDetails transform(Message<?> Megssage){
		TechLocationDetails resourceAttributes = new TechLocationDetails();
		TechLocationDetail messages = (TechLocationDetail)Megssage.getPayload();		
	//	resourceAttributes.setResourcesAttributes(Arrays.asList(messages));
		resourceAttributes.setResourcesAttributes(Arrays.asList(messages));
		 try {
			log.writeLocation(FileLogger.ALWAYS, "  inside ResourceAttributeTransformerBean class from transform method  : %s", resourceAttributes);
		} catch (EdgeException e) {
			log.write(FileLogger.ALWAYS, "Exception from ResourceAttributeTransformerBean class ", e.getMessage());
		}
		 return resourceAttributes;
	}
}
