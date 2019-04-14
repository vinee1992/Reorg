/**
 * 
 */
package com.att.edge.backend.reorg.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import static com.att.edge.backend.reorg.util.ReOrgConstatns.*;

/**
 * @author anand.arjan.jhamnani
 *
 */
public class DateUtil {
	public static String convertStringToDate(String date){
		if(date==null){
			return null;
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime dateTime= LocalDateTime.parse(date,formatter);
		return  dateTime.format(formatter);

	}
	public static Long convertStringToLong(String id){
	if(id==null || BLANK.equals(id.trim()))
			return null;
		return Long.parseLong(id);

	}

}
