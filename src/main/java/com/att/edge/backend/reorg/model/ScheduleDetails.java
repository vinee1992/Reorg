/**
 * 
 */
package com.att.edge.backend.reorg.model;

import java.util.List;

/**
 * @author pradyumna.k.khadanga
 *
 */
public class ScheduleDetails {
	private List<TechScheduleAttribute> scheduleDetails;

	/**
	 * @return the scheduleDetails
	 */
	public List<TechScheduleAttribute> getScheduleDetails() {
		return scheduleDetails;
	}


	/**
	 * @param scheduleDetails the scheduleDetails to set
	 */
	public void setScheduleDetails(List<TechScheduleAttribute> scheduleDetails) {
		this.scheduleDetails = scheduleDetails;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ScheduleDetails [scheduleDetails=" + scheduleDetails + "]";
	}



}
