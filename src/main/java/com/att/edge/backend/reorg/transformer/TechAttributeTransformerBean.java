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
import com.att.edge.backend.reorg.model.TechAttribute;
import com.att.edge.backend.reorg.model.TechAttributes;


/**
 * @author pradyumna.k.khadanga
 *
 */
@Component("techAttributeTransformerBean")
public class TechAttributeTransformerBean {
	FileLogger log=(FileLogger) GlobalContext.get("log");

	public TechAttributes transform(Message<?> Megssage){
		TechAttributes techAttributes = new TechAttributes();
		TechAttribute messages = (TechAttribute)Megssage.getPayload();		
		 techAttributes.setTechAttributes(Arrays.asList(messages));
		 try {
			log.writeLocation(FileLogger.ALWAYS, "  inside TechAttributeTransformerBean class : %s", techAttributes);
		} catch (EdgeException e) {
			log.write(FileLogger.ALWAYS, "  exception from TechAttributeTransformerBean ", e.getMessage());
		}
		 return techAttributes;
	}
}
