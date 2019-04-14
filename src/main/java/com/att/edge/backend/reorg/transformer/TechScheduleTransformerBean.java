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
import com.att.edge.backend.reorg.model.TechAttributes;
import com.att.edge.backend.reorg.model.TechScheduleAttribute;
import com.att.edge.backend.reorg.model.TechScheduleAttributes;


/**
 * @author pradyumna.k.khadanga
 *
 */
@Component("techScheduleTransformerBean")
public class TechScheduleTransformerBean {
	FileLogger log=(FileLogger) GlobalContext.get("log");

	public TechScheduleAttributes transform(Message<?> Megssage){
		TechScheduleAttributes techSchedAttributes = new TechScheduleAttributes();
		TechScheduleAttribute messages = (TechScheduleAttribute)Megssage.getPayload();		
		techSchedAttributes.setScheduleDetails((Arrays.asList(messages)));
		 try {
			log.writeLocation(FileLogger.ALWAYS, " inside TechScheduleTransformerBean class: %s", techSchedAttributes);
		} catch (EdgeException e) {
			log.write(FileLogger.ALWAYS, " Exception TechScheduleTransformerBean class", e.getMessage());
		}
		 return techSchedAttributes;
	}
}
