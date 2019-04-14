/**
 * 
 */
package com.att.edge.backend.reorg.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author anand.arjan.jhamnani
 *
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class WeekDay {
	
	private List<String> weekday;

	/**
	 * @return the weekday
	 */
	public List<String> getWeekday() {
		return weekday;
	}

	/**
	 * @param weekday the weekday to set
	 */
	public void setWeekday(List<String> weekday) {
		this.weekday = weekday;
	}


	

}
