package com.att.edge.backend.reorg.model;

import java.util.List;

import com.att.edge.backend.reorg.model.CalloutDetails.Builder;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author anand.arjan.jhamnani
 *
 */
public class Overtime {
	@JsonInclude(Include.NON_NULL)
	private String overtimeAction;
	@JsonInclude(Include.NON_NULL)
	private String overtimeType;
	@JsonInclude(Include.NON_NULL)
	private Long overtimeDuration;

	private Overtime(Builder builder) {
		this.overtimeAction=builder.overtimeAction;
		this.overtimeType=builder.overtimeType;
		this.overtimeDuration=builder.overtimeDuration;
	}

	public String getOvertimeAction() {
		return overtimeAction;
	}

	public String getOvertimeType() {
		return overtimeType;
	}

	/**
	 * @return the overtimeDuration
	 */
	public Long getOvertimeDuration() {
		return overtimeDuration;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Overtime [overtimeAction=" + overtimeAction + ", overtimeType=" + overtimeType + ", overtimeDuration="
				+ overtimeDuration + "]";
	}
	public static class Builder{ 
		private String overtimeAction;
		private String overtimeType;
		private Long overtimeDuration;	
 
		public Builder withOvertimeAction(String overtimeAction){ 
			this.overtimeAction=overtimeAction; 
			return this; 
		} 
		public Builder withOvertimeType(String overtimeType){ 
			this.overtimeType=overtimeType; 
			return this; 
		} 
		public Builder withOvertimeDuration(Long overtimeDuration){ 
			this.overtimeDuration=overtimeDuration; 
			return this; 
		} 
		
		public Overtime build(){ 
			return new Overtime(this); 
		} 
	}
}
