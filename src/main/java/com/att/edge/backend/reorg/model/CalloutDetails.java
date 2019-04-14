package com.att.edge.backend.reorg.model;

import java.util.List;

import com.att.edge.backend.reorg.model.TechScheduleAttribute.Builder;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author anand.arjan.jhamnani
 *
 */
public class CalloutDetails {
	
	@JsonInclude(Include.NON_NULL)
	private String calloutAction;
	@JsonInclude(Include.NON_NULL)
	private String calloutProfile;
	@JsonInclude(Include.NON_NULL)
	private String calloutStartTime;
	@JsonInclude(Include.NON_NULL)
	private String calloutDuration;

	private CalloutDetails(Builder builder) {
		this.calloutAction=builder.calloutAction;
		this.calloutProfile=builder.calloutProfile;
		this.calloutStartTime =builder.calloutStartTime;
		this.calloutDuration = builder.calloutDuration;
	}

	public String getCalloutAction() {
		return calloutAction;
	}
	
	public String getCalloutProfile() {
		return calloutProfile;
	}
	/**
	 * @return the calloutStartTime
	 */
	public String getCalloutStartTime() {
		return calloutStartTime;
	}
	
	/**
	 * @return the calloutDuration
	 */
	public String getCalloutDuration() {
		return calloutDuration;
	}	

	public static class Builder{ 
		@JsonIgnore
		public List<String> fileName;
		
		private String calloutAction; 
		private String calloutProfile; 		
		private String calloutStartTime;	
		private String calloutDuration;
		
 
		public Builder withScheduleAction(String calloutAction){ 
			this.calloutAction=calloutAction; 
			return this; 
		} 
		public Builder withCalloutProfile(String calloutProfile){ 
			this.calloutProfile=calloutProfile; 
			return this; 
		} 
		public Builder withCalloutStartTime(String calloutStartTime){ 
			this.calloutStartTime=calloutStartTime; 
			return this; 
		} 
		public Builder withCalloutDuration(String calloutDuration){ 
			this.calloutDuration=calloutDuration; 
			return this; 
		} 
		public CalloutDetails build(){ 
			return new CalloutDetails(this); 
		} 
	}
	
	@Override
	public String toString() {
		return "CalloutDetails [calloutAction=" + calloutAction + ", calloutProfile=" + calloutProfile
				+ ", calloutStartTime=" + calloutStartTime + ", calloutDuration=" + calloutDuration + "]";
	}
	

}
