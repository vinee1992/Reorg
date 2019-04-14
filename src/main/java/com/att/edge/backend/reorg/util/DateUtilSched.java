/**
 * 
 */
package com.att.edge.backend.reorg.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author anand.arjan.jhamnani
 *
 */
public class DateUtilSched {
	public static String convertStringToDateSched(String date){
		if(date==null){
			return null;
		}

		/* DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		 LocalDate dateTime= LocalDate.parse(date,formatter);
		 dateTime.format(formatter);
		 */

		DateFormat inputFormatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date inputDate = null;
		try {
			inputDate = inputFormatter.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		DateFormat outputFormatter = new SimpleDateFormat("yyyy-MM-dd");
		String output = outputFormatter.format(inputDate);
		return  output;
	}
}
