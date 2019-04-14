/**
 * 
 */
package com.att.edge.backend.reorg.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author pradyumna.k.khadanga
 *
 */
public class DayDetail {
	@JsonInclude(Include.NON_NULL)
	private String scheduleDay;
	@JsonInclude(Include.NON_NULL)
	private String startLocationId;
	@JsonInclude(Include.NON_NULL)
	private String endLocationId;	
	@JsonInclude(Include.NON_NULL)
	private String homeZoneCentralId;

	private DayDetail(Builder builder) {
		this.scheduleDay=builder.scheduleDay;
		this.startLocationId=builder.startLocationId;
		this.endLocationId=builder.endLocationId;
		this.homeZoneCentralId=builder.homeZoneCentralId;
	}

	
	/**
	 * @return the startLocationId
	 */
	public String getStartLocationId() {
		return startLocationId;
	}

	/**
	 * @return the endLocationId
	 */
	public String getEndLocationId() {
		return endLocationId;
	}

	public static class Builder{
		private String scheduleDay;   
		private String startLocationId;
		private String endLocationId;	
		private String homeZoneCentralId;
		public Builder withScheduleDay(String scheduleDay){
			this.scheduleDay = scheduleDay;
			return this;
		}
		public Builder withStartLocationId(String startLocationId){
			this.startLocationId = startLocationId;
			return this;
		}
		public Builder withEndLocationId(String endLocationId){
			this.endLocationId = endLocationId;
			return this;
		}
		public Builder withHomeZoneCentralId(String homeZoneCentralId){
			this.homeZoneCentralId = homeZoneCentralId;
			return this;
		}
		
		public DayDetail build(){
			return new DayDetail(this);
		}

	} 
	
	


	/**
	 * @return the scheduleDay
	 */
	public String getScheduleDay() {
		return scheduleDay;
	}


	


	/**
	 * @return the homeZoneCentralId
	 */
	public String getHomeZoneCentralId() {
		return homeZoneCentralId;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DayDetail [scheduleDay=" + scheduleDay + ", startLocationId=" + startLocationId + ", endLocationId="
				+ endLocationId + ", homeZoneCentralId=" + homeZoneCentralId + "]";
	}

}
