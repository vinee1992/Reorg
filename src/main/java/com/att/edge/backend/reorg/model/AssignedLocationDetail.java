/**
 * 
 */
package com.att.edge.backend.reorg.model;

import java.util.List;

/**
 * @author pradyumna.k.khadanga
 *
 */
public class AssignedLocationDetail {

	private String techId;

	private String assignedLocationAction;

	private List<DayDetail> dayDetails;

	private AssignedLocationDetail(Builder builder) {
		this.techId = builder.techId;
		this.assignedLocationAction= builder.assignedLocationAction;
		this.dayDetails=builder.dayDetails;		
	}

	/**
	 * @return the dayDetails
	 */
	public List<DayDetail> getDayDetails() {
		return dayDetails;
	}

	/**
	 * @return the techId
	 */
	public String getTechId() {
		return techId;
	}

	
	/**
	 * @return the assignedLocationAction
	 */
	public String getAssignedLocationAction() {
		return assignedLocationAction;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AssignedLocationDetail [techId=" + techId + ", assignedLocationAction=" + assignedLocationAction
				+ ", dayDetails=" + dayDetails + "]";
	}
	public static class Builder{
		private String techId;

		private String assignedLocationAction;

		private List<DayDetail> dayDetails;
		
		public Builder withTechId(String techId){
			this.techId = techId;
			return this;
		}
		public Builder withAssignedLocationAction(String assignedLocationAction){
			this.assignedLocationAction = assignedLocationAction;
			return this;
		}
		public Builder withDayDetails(List<DayDetail> dayDetails){
			this.dayDetails = dayDetails;
			return this;
		}
		
		public AssignedLocationDetail build(){
			return new AssignedLocationDetail(this);
		}
	}

	
}
