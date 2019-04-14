/**
 * 
 */
package com.att.edge.backend.reorg.dao;


import java.util.ArrayList;
import java.util.List;

import com.att.edge.backend.reorg.model.AssignedLocationDetail;
import com.att.edge.backend.reorg.model.AssignedTechLocation;
import com.att.edge.backend.reorg.model.DayDetail;
import com.att.edge.backend.reorg.model.TechLocation;

/**
 * @author pradyumna.k.khadanga
 *
 */
public interface TechLocationDao {

	public List<TechLocation> getTechLocationsByProcessStatus(String status);



	/**
	 * @author vineet.k.chaurasia
	 * @param dayDetails
	 * @param techLocation
	 * @param day
	 * @functionality : Delete functionality for assign location
	 */

	public static void deleteFunctionality(List<DayDetail> dayDetails ,TechLocation techLocation ,String day){

		//techLocation.setAction("SET_LOCATIONS");
		String getStartLocation = null,getEndLocation = null,getLocation = null;
		if(techLocation.getSundayStartLocation()!=null || techLocation.getMondayStartLocation()!=null || techLocation.getTuesdayStartLocation()!= null || techLocation.getWednesdayStartLocation()!=null || techLocation.getThursdayStartLocation()!=null || techLocation.getFridayStartLocation()!=null||techLocation.getSaturdayStartLocation()!=null){
			getStartLocation = "";
		}
		if(techLocation.getSundayEndLocation()!=null || techLocation.getMondayEndLocation()!=null || techLocation.getTuesdayEndLocation()!= null || techLocation.getWednesdayEndLocation()!=null || techLocation.getThursdayEndLocation()!=null || techLocation.getFridayEndLocation()!=null||techLocation.getSaturdayEndLocation()!=null){
			getEndLocation = "";
		}
		if(techLocation.getSundayHomeZoneCenterLocation()!=null || techLocation.getMondayHomeZoneCenterLocation()!=null || techLocation.getTuesdayHomeZoneCenterLocation()!= null || techLocation.getWednesdayHomeZoneCenterLocation()!=null || techLocation.getThursdayHomeZoneCenterLocation()!=null || techLocation.getFridayHomeZoneCenterLocation()!=null||techLocation.getSaturdayHomeZoneCenterLocation()!=null){
			getLocation = "";
		}

		dayDetails.add(new DayDetail.Builder()
				.withScheduleDay(day)
				.withStartLocationId(getStartLocation)
				.withEndLocationId(getEndLocation)	
				.withHomeZoneCentralId(getLocation)
				.build());

	}

	public static  AssignedTechLocation buildAssignedTechLocation(TechLocation techLocation){
		AssignedLocationDetail assignedLocationDetail=null;
		List<DayDetail> dayDetails = new ArrayList<>();
		if(techLocation.getSundayStartLocation()!=null || techLocation.getSundayEndLocation()!=null || techLocation.getSundayHomeZoneCenterLocation()!=null){

			//	 "DELETE".equalsIgnoreCase(techLocation.getAction()) ?"":techLocation.getSundayStartLocation()
			if("DELETE".equalsIgnoreCase(techLocation.getAction())){
				deleteFunctionality(dayDetails,techLocation ,"SUN");
			}else{
				dayDetails.add(new DayDetail.Builder()
						.withScheduleDay("SUN")
						.withStartLocationId(techLocation.getSundayStartLocation())
						.withEndLocationId(techLocation.getSundayEndLocation())	
						.withHomeZoneCentralId(techLocation.getSundayHomeZoneCenterLocation())
						.build());	
			}

		}
		if(techLocation.getMondayStartLocation()!=null || techLocation.getMondayEndLocation()!=null || techLocation.getMondayHomeZoneCenterLocation()!=null){
			if("DELETE".equalsIgnoreCase(techLocation.getAction())){
				deleteFunctionality(dayDetails,techLocation ,"MON");
			}else{
				dayDetails.add(new DayDetail.Builder()
						.withScheduleDay("MON")
						.withStartLocationId(techLocation.getMondayStartLocation())
						.withEndLocationId(techLocation.getMondayEndLocation())
						.withHomeZoneCentralId(techLocation.getMondayHomeZoneCenterLocation())
						.build());
			}
		}
		if(techLocation.getTuesdayStartLocation()!=null || techLocation.getTuesdayEndLocation()!=null || techLocation.getTuesdayHomeZoneCenterLocation()!=null){
			if("DELETE".equalsIgnoreCase(techLocation.getAction())){
				deleteFunctionality(dayDetails,techLocation ,"TUE");
			}else{
				dayDetails.add(new DayDetail.Builder()
						.withScheduleDay("TUE")
						.withStartLocationId(techLocation.getTuesdayStartLocation())
						.withEndLocationId(techLocation.getTuesdayEndLocation())
						.withHomeZoneCentralId(techLocation.getTuesdayHomeZoneCenterLocation())
						.build());
			}
		}
		if(techLocation.getWednesdayStartLocation()!=null || techLocation.getWednesdayEndLocation()!=null || techLocation.getWednesdayHomeZoneCenterLocation()!=null){
			if("DELETE".equalsIgnoreCase(techLocation.getAction())){
				deleteFunctionality(dayDetails,techLocation ,"WED");
			}else{
				dayDetails.add(new DayDetail.Builder()
						.withScheduleDay("WED")
						.withStartLocationId(techLocation.getWednesdayStartLocation())
						.withEndLocationId(techLocation.getWednesdayEndLocation())
						.withHomeZoneCentralId(techLocation.getWednesdayHomeZoneCenterLocation())
						.build());
			}

		}
		if(techLocation.getThursdayStartLocation()!=null || techLocation.getThursdayEndLocation()!=null || techLocation.getThursdayHomeZoneCenterLocation()!=null){
			if("DELETE".equalsIgnoreCase(techLocation.getAction())){
				deleteFunctionality(dayDetails,techLocation ,"THU");
			}else{
				dayDetails.add(new DayDetail.Builder()
						.withScheduleDay("THU")
						.withStartLocationId(techLocation.getThursdayStartLocation())
						.withEndLocationId(techLocation.getThursdayEndLocation())
						.withHomeZoneCentralId(techLocation.getThursdayHomeZoneCenterLocation())
						.build());
			}
		}
		if(techLocation.getFridayStartLocation()!=null || techLocation.getFridayEndLocation()!=null || techLocation.getFridayHomeZoneCenterLocation()!=null){
			if("DELETE".equalsIgnoreCase(techLocation.getAction())){
				deleteFunctionality(dayDetails,techLocation ,"FRI");
			}else{
				dayDetails.add(new DayDetail.Builder()
						.withScheduleDay("FRI")
						.withStartLocationId(techLocation.getFridayStartLocation())
						.withEndLocationId(techLocation.getFridayEndLocation())
						.withHomeZoneCentralId(techLocation.getFridayHomeZoneCenterLocation())
						.build());
			}
		}
		if(techLocation.getSaturdayStartLocation()!=null || techLocation.getSaturdayEndLocation()!=null || techLocation.getSaturdayHomeZoneCenterLocation()!=null){
			if("DELETE".equalsIgnoreCase(techLocation.getAction())){
				deleteFunctionality(dayDetails,techLocation ,"SAT");
			}else{
				dayDetails.add(new DayDetail.Builder()
						.withScheduleDay("SAT")
						.withStartLocationId(techLocation.getSaturdayStartLocation())
						.withEndLocationId(techLocation.getSaturdayEndLocation())
						.withHomeZoneCentralId(techLocation.getSaturdayHomeZoneCenterLocation())
						.build());
			}
		}		

		assignedLocationDetail = new AssignedLocationDetail.Builder()
				.withTechId(techLocation.getResourceId())
				.withAssignedLocationAction("SET_LOCATIONS")
				.withDayDetails(dayDetails)
				.build();

		return new AssignedTechLocation.Builder()
				.withSeqNo(techLocation.getSeqno())
				.withAssignedLocationDetails((assignedLocationDetail))
				.withFileName(techLocation.getFileName())
				.build();


	}

}
