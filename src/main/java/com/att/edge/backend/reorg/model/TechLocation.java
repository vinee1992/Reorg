/**
 * 
 */
package com.att.edge.backend.reorg.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author pradyumna.k.khadanga
 *
 */

public class TechLocation {
	@JsonInclude(Include.NON_NULL)
	private Long seqno;
	@JsonInclude(Include.NON_NULL)
	private String action;
	@JsonInclude(Include.NON_NULL)
	private String resourceId;
	@JsonInclude(Include.NON_NULL)
	private String mondayStartLocation;
	@JsonInclude(Include.NON_NULL)
	private String mondayEndLocation;
	@JsonInclude(Include.NON_NULL)
	private String tuesdayStartLocation;
	@JsonInclude(Include.NON_NULL)
	private String tuesdayEndLocation;
	@JsonInclude(Include.NON_NULL)
	private String wednesdayStartLocation;
	@JsonInclude(Include.NON_NULL)
	private String wednesdayEndLocation;
	@JsonInclude(Include.NON_NULL)
	private String thursdayStartLocation;
	@JsonInclude(Include.NON_NULL)
	private String thursdayEndLocation;
	@JsonInclude(Include.NON_NULL)
	private String fridayStartLocation;
	@JsonInclude(Include.NON_NULL)	
	private String fridayEndLocation;
	@JsonInclude(Include.NON_NULL)
	private String saturdayStartLocation;
	@JsonInclude(Include.NON_NULL)
	private String saturdayEndLocation;
	@JsonInclude(Include.NON_NULL)
	private String sundayStartLocation;
	@JsonInclude(Include.NON_NULL)
	private String sundayEndLocation;
	@JsonInclude(Include.NON_NULL)
	private String fridayHomeZoneCenterLocation;
	@JsonInclude(Include.NON_NULL)
	private String thursdayHomeZoneCenterLocation;
	@JsonInclude(Include.NON_NULL)
	private String wednesdayHomeZoneCenterLocation;
	@JsonInclude(Include.NON_NULL)
	private String tuesdayHomeZoneCenterLocation;
	@JsonInclude(Include.NON_NULL)
	private String mondayHomeZoneCenterLocation	;
	@JsonInclude(Include.NON_NULL)
	private String sundayHomeZoneCenterLocation	;
	@JsonInclude(Include.NON_NULL)
	private String saturdayHomeZoneCenterLocation	;
	
	
	@JsonIgnore
	private String fileName;
	/**
	 * @return the seqno
	 */
	public Long getSeqno() {
		return seqno;
	}
	/**
	 * @param seqno the seqno to set
	 */
	public void setSeqno(Long seqno) {
		this.seqno = seqno;
	}
	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}
	/**
	 * @param action the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}
	/**
	 * @return the resourceId
	 */
	public String getResourceId() {
		return resourceId;
	}
	/**
	 * @param resourceId the resourceId to set
	 */
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}
	/**
	 * @return the mondayStartLocation
	 */
	public String getMondayStartLocation() {
		return mondayStartLocation;
	}
	/**
	 * @param mondayStartLocation the mondayStartLocation to set
	 */
	public void setMondayStartLocation(String mondayStartLocation) {
		this.mondayStartLocation = mondayStartLocation;
	}
	/**
	 * @return the mondayEndLocation
	 */
	public String getMondayEndLocation() {
		return mondayEndLocation;
	}
	/**
	 * @param mondayEndLocation the mondayEndLocation to set
	 */
	public void setMondayEndLocation(String mondayEndLocation) {
		this.mondayEndLocation = mondayEndLocation;
	}
	/**
	 * @return the tuesdayStartLocation
	 */
	public String getTuesdayStartLocation() {
		return tuesdayStartLocation;
	}
	/**
	 * @param tuesdayStartLocation the tuesdayStartLocation to set
	 */
	public void setTuesdayStartLocation(String tuesdayStartLocation) {
		this.tuesdayStartLocation = tuesdayStartLocation;
	}
	/**
	 * @return the tuesdayEndLocation
	 */
	public String getTuesdayEndLocation() {
		return tuesdayEndLocation;
	}
	/**
	 * @param tuesdayEndLocation the tuesdayEndLocation to set
	 */
	public void setTuesdayEndLocation(String tuesdayEndLocation) {
		this.tuesdayEndLocation = tuesdayEndLocation;
	}
	/**
	 * @return the wednesdayStartLocation
	 */
	public String getWednesdayStartLocation() {
		return wednesdayStartLocation;
	}
	/**
	 * @param wednesdayStartLocation the wednesdayStartLocation to set
	 */
	public void setWednesdayStartLocation(String wednesdayStartLocation) {
		this.wednesdayStartLocation = wednesdayStartLocation;
	}
	/**
	 * @return the wednesdayEndLocation
	 */
	public String getWednesdayEndLocation() {
		return wednesdayEndLocation;
	}
	/**
	 * @param wednesdayEndLocation the wednesdayEndLocation to set
	 */
	public void setWednesdayEndLocation(String wednesdayEndLocation) {
		this.wednesdayEndLocation = wednesdayEndLocation;
	}
	/**
	 * @return the thursdayStartLocation
	 */
	public String getThursdayStartLocation() {
		return thursdayStartLocation;
	}
	/**
	 * @param thursdayStartLocation the thursdayStartLocation to set
	 */
	public void setThursdayStartLocation(String thursdayStartLocation) {
		this.thursdayStartLocation = thursdayStartLocation;
	}
	/**
	 * @return the thursdayEndLocation
	 */
	public String getThursdayEndLocation() {
		return thursdayEndLocation;
	}
	/**
	 * @param thursdayEndLocation the thursdayEndLocation to set
	 */
	public void setThursdayEndLocation(String thursdayEndLocation) {
		this.thursdayEndLocation = thursdayEndLocation;
	}
	/**
	 * @return the fridayStartLocation
	 */
	public String getFridayStartLocation() {
		return fridayStartLocation;
	}
	/**
	 * @param fridayStartLocation the fridayStartLocation to set
	 */
	public void setFridayStartLocation(String fridayStartLocation) {
		this.fridayStartLocation = fridayStartLocation;
	}
	/**
	 * @return the fridayEndLocation
	 */
	public String getFridayEndLocation() {
		return fridayEndLocation;
	}
	/**
	 * @param fridayEndLocation the fridayEndLocation to set
	 */
	public void setFridayEndLocation(String fridayEndLocation) {
		this.fridayEndLocation = fridayEndLocation;
	}
	/**
	 * @return the saturdayStartLocation
	 */
	public String getSaturdayStartLocation() {
		return saturdayStartLocation;
	}
	/**
	 * @param saturdayStartLocation the saturdayStartLocation to set
	 */
	public void setSaturdayStartLocation(String saturdayStartLocation) {
		this.saturdayStartLocation = saturdayStartLocation;
	}
	/**
	 * @return the saturdayEndLocation
	 */
	public String getSaturdayEndLocation() {
		return saturdayEndLocation;
	}
	/**
	 * @param saturdayEndLocation the saturdayEndLocation to set
	 */
	public void setSaturdayEndLocation(String saturdayEndLocation) {
		this.saturdayEndLocation = saturdayEndLocation;
	}
	/**
	 * @return the sundayStartLocation
	 */
	public String getSundayStartLocation() {
		return sundayStartLocation;
	}
	/**
	 * @param sundayStartLocation the sundayStartLocation to set
	 */
	public void setSundayStartLocation(String sundayStartLocation) {
		this.sundayStartLocation = sundayStartLocation;
	}
	/**
	 * @return the sundayEndLocation
	 */
	public String getSundayEndLocation() {
		return sundayEndLocation;
	}
	/**
	 * @param sundayEndLocation the sundayEndLocation to set
	 */
	public void setSundayEndLocation(String sundayEndLocation) {
		this.sundayEndLocation = sundayEndLocation;
	}
	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}
	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/**
	 * @return the fridayHomeZoneCenterLocation
	 */
	public String getFridayHomeZoneCenterLocation() {
		return fridayHomeZoneCenterLocation;
	}
	/**
	 * @param fridayHomeZoneCenterLocation the fridayHomeZoneCenterLocation to set
	 */
	public void setFridayHomeZoneCenterLocation(String fridayHomeZoneCenterLocation) {
		this.fridayHomeZoneCenterLocation = fridayHomeZoneCenterLocation;
	}
	/**
	 * @return the thursdayHomeZoneCenterLocation
	 */
	public String getThursdayHomeZoneCenterLocation() {
		return thursdayHomeZoneCenterLocation;
	}
	/**
	 * @param thursdayHomeZoneCenterLocation the thursdayHomeZoneCenterLocation to set
	 */
	public void setThursdayHomeZoneCenterLocation(String thursdayHomeZoneCenterLocation) {
		this.thursdayHomeZoneCenterLocation = thursdayHomeZoneCenterLocation;
	}
	/**
	 * @return the wednesdayHomeZoneCenterLocation
	 */
	public String getWednesdayHomeZoneCenterLocation() {
		return wednesdayHomeZoneCenterLocation;
	}
	/**
	 * @param wednesdayHomeZoneCenterLocation the wednesdayHomeZoneCenterLocation to set
	 */
	public void setWednesdayHomeZoneCenterLocation(String wednesdayHomeZoneCenterLocation) {
		this.wednesdayHomeZoneCenterLocation = wednesdayHomeZoneCenterLocation;
	}
	/**
	 * @return the tuesdayHomeZoneCenterLocation
	 */
	public String getTuesdayHomeZoneCenterLocation() {
		return tuesdayHomeZoneCenterLocation;
	}
	/**
	 * @param tuesdayHomeZoneCenterLocation the tuesdayHomeZoneCenterLocation to set
	 */
	public void setTuesdayHomeZoneCenterLocation(String tuesdayHomeZoneCenterLocation) {
		this.tuesdayHomeZoneCenterLocation = tuesdayHomeZoneCenterLocation;
	}
	/**
	 * @return the mondayHomeZoneCenterLocation
	 */
	public String getMondayHomeZoneCenterLocation() {
		return mondayHomeZoneCenterLocation;
	}
	/**
	 * @param mondayHomeZoneCenterLocation the mondayHomeZoneCenterLocation to set
	 */
	public void setMondayHomeZoneCenterLocation(String mondayHomeZoneCenterLocation) {
		this.mondayHomeZoneCenterLocation = mondayHomeZoneCenterLocation;
	}
	/**
	 * @return the sundayHomeZoneCenterLocation
	 */
	public String getSundayHomeZoneCenterLocation() {
		return sundayHomeZoneCenterLocation;
	}
	/**
	 * @param sundayHomeZoneCenterLocation the sundayHomeZoneCenterLocation to set
	 */
	public void setSundayHomeZoneCenterLocation(String sundayHomeZoneCenterLocation) {
		this.sundayHomeZoneCenterLocation = sundayHomeZoneCenterLocation;
	}
	/**
	 * @return the saturdayHomeZoneCenterLocation
	 */
	public String getSaturdayHomeZoneCenterLocation() {
		return saturdayHomeZoneCenterLocation;
	}
	/**
	 * @param saturdayHomeZoneCenterLocation the saturdayHomeZoneCenterLocation to set
	 */
	public void setSaturdayHomeZoneCenterLocation(String saturdayHomeZoneCenterLocation) {
		this.saturdayHomeZoneCenterLocation = saturdayHomeZoneCenterLocation;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TechLocation [seqno=" + seqno + ", action=" + action + ", resourceId=" + resourceId
				+ ", mondayStartLocation=" + mondayStartLocation + ", mondayEndLocation=" + mondayEndLocation
				+ ", tuesdayStartLocation=" + tuesdayStartLocation + ", tuesdayEndLocation=" + tuesdayEndLocation
				+ ", wednesdayStartLocation=" + wednesdayStartLocation + ", wednesdayEndLocation="
				+ wednesdayEndLocation + ", thursdayStartLocation=" + thursdayStartLocation + ", thursdayEndLocation="
				+ thursdayEndLocation + ", fridayStartLocation=" + fridayStartLocation + ", fridayEndLocation="
				+ fridayEndLocation + ", saturdayStartLocation=" + saturdayStartLocation + ", saturdayEndLocation="
				+ saturdayEndLocation + ", sundayStartLocation=" + sundayStartLocation + ", sundayEndLocation="
				+ sundayEndLocation + ", fridayHomeZoneCenterLocation=" + fridayHomeZoneCenterLocation
				+ ", thursdayHomeZoneCenterLocation=" + thursdayHomeZoneCenterLocation
				+ ", wednesdayHomeZoneCenterLocation=" + wednesdayHomeZoneCenterLocation
				+ ", tuesdayHomeZoneCenterLocation=" + tuesdayHomeZoneCenterLocation + ", mondayHomeZoneCenterLocation="
				+ mondayHomeZoneCenterLocation + ", sundayHomeZoneCenterLocation=" + sundayHomeZoneCenterLocation
				+ ", saturdayHomeZoneCenterLocation=" + saturdayHomeZoneCenterLocation + ", fileName=" + fileName + "]";
	}
	
		
}
