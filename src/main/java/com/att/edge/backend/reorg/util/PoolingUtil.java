/**
 * 
 */
package com.att.edge.backend.reorg.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.att.edge.appcommon.EdgeException;
import com.att.edge.appcommon.FileLogger;
import com.att.edge.appcommon.GlobalContext;
import static com.att.edge.backend.reorg.util.ReOrgConstatns.*;

/**
 * @author pradyumna.k.khadanga
 *
 */
public class PoolingUtil {
	
	public static boolean isPollingDuration(String lastUpdateDate, int pollingDuration) throws EdgeException {
		FileLogger log = (FileLogger) GlobalContext.get("log");
		if (lastUpdateDate == null || lastUpdateDate.isEmpty()) {
			return true;
		} else {
			boolean isPolled = false;
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				GregorianCalendar gCal = new GregorianCalendar();
				XMLGregorianCalendar sysDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gCal);

				String time1 = lastUpdateDate;
				String time2 = xmlGregorianToStringConversion(sysDate, DATE_TIME);

				Date date1 = format.parse(time1);
				Date date2 = format.parse(time2);

				long diff = date2.getTime() - date1.getTime();
				long diffSeconds = diff / 1000;
				long duration = (long) pollingDuration;
				if (diffSeconds >= duration) {
					log.writeLocation(FileLogger.ALWAYS, " Polling duration is over");
					isPolled = true;
				}
			} catch (ParseException | DatatypeConfigurationException e) {
				log.writeLocation(FileLogger.ALWAYS, " Exception inside isPollingDuration: %s", e);
			}
			return isPolled;
		}
	}

	public static String xmlGregorianToStringConversion(XMLGregorianCalendar xmlDate, String returnFormat) {
		String year = ((Integer) xmlDate.getYear()).toString();
		String month = ((Integer) xmlDate.getMonth()).toString();
		String day = ((Integer) xmlDate.getDay()).toString();
		String hour = ((Integer) xmlDate.getHour()).toString();
		String minute = ((Integer) xmlDate.getMinute()).toString();
		String second = ((Integer) xmlDate.getSecond()).toString();

		if (month.length() == 1) {
			month = "0" + month;
		}
		if (day.length() == 1) {
			day = "0" + day;
		}
		if (hour.length() == 1) {
			hour = "0" + hour;
		}
		if (minute.length() == 1) {
			minute = "0" + minute;
		}
		if (second.length() == 1) {
			second = "0" + second;
		}
		String dateTime = year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second;
		String date = year + "-" + month + "-" + day;
		String time = hour + ":" + minute + ":" + second;
		if (DATE_TIME.equalsIgnoreCase(returnFormat)) {
			return dateTime;
		} else if (DATE.equalsIgnoreCase(returnFormat)) {
			return date;
		} else if (TIME.equalsIgnoreCase(returnFormat)) {
			return time;
		}
		return null;
	}

}
