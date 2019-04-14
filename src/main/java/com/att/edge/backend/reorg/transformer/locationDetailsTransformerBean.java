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
 *@author vineet.k.chaurasia
 *
 */
@Component("locationDetailsTransformerBean")
public class locationDetailsTransformerBean {

	FileLogger log=(FileLogger) GlobalContext.get("log");

	public TechLocationDetails transform(Message<?> Megssage){
		TechLocationDetails locationDetails = new TechLocationDetails();
		TechLocationDetail messages = (TechLocationDetail)Megssage.getPayload();		
		//locationDetails.setResourcesAttributes(Arrays.asList(messages));
		locationDetails.setTechAttributes(Arrays.asList(messages));
		 try {
			log.writeLocation(FileLogger.ALWAYS, "  inside locationDetailsTransformerBean class from transform method  : %s", locationDetails);
		} catch (EdgeException e) {
			log.write(FileLogger.ALWAYS, "Exception from locationDetailsTransformerBean class ", e.getMessage());
		}
		 return locationDetails;
	}


}
