/** 
 * 
 */ 
package com.att.edge.backend.reorg.model; 
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude; 
import com.fasterxml.jackson.annotation.JsonInclude.Include; 
/** 
 * @author pradyumna.k.khadanga 
 * 
 */ 
public class TechScheduleAttribute { 
	@JsonInclude(Include.NON_NULL) 
	private  Long seqNo; 
	@JsonInclude(Include.NON_NULL) 
	private String scheduleAction; 
	@JsonInclude(Include.NON_NULL) 
	private String techId; 
	@JsonInclude(Include.NON_NULL) 
	private String startDate; 
	@JsonInclude(Include.NON_NULL) 
	private String endDate; 
	@JsonInclude(Include.NON_NULL) 
	private String startTime; 
	@JsonInclude(Include.NON_NULL) 
	private String endTime; 
	@JsonInclude(Include.NON_NULL) 
	private String lunchStartTime; 
	@JsonInclude(Include.NON_NULL) 
	private Long lunchDuration; 
	@JsonInclude(Include.NON_NULL) 
	private String scheduleType; 
 
	@JsonInclude(Include.NON_NULL) 
	private List<UnavailableDetails> unavailableDetails; 
	@JsonInclude(Include.NON_NULL) 
	private List<Overtime> overtime; 
	@JsonInclude(Include.NON_NULL) 
	private List<CalloutDetails> calloutDetails; 
	
	private String fileName;
	@JsonInclude(Include.NON_NULL) 
	private String sixOTIndicator; 
		private TechScheduleAttribute(Builder builder) { 
		this.seqNo = builder.seqNo; 
		this.scheduleAction=builder.scheduleAction; 
		this.techId= builder.techId; 
		this.startDate=builder.startDate; 
		this.endDate=builder.endDate; 
		this.startTime=builder.startTime; 
		this.endTime=builder.endTime; 
		this.lunchStartTime=builder.lunchStartTime; 
		this.lunchDuration=builder.lunchDuration; 
		this.scheduleType=builder.scheduleType; 
		this.unavailableDetails=builder.unavailableDetails; 
		this.overtime=builder.overtime; 
		this.calloutDetails=builder.calloutDetails; 
		this.fileName=builder.fileName;
		this.sixOTIndicator = builder.sixOTIndicator;
	} 
	public String getScheduleAction() { 
		return scheduleAction; 
	} 
 
	public String getTechId() { 
		return techId; 
	} 
 
	/**
	 * @return the sixOTIndicator
	 */
	public String getSixOTIndicator() {
		return sixOTIndicator;
	}
	/**
	 * @param sixOTIndicator the sixOTIndicator to set
	 */
	public void setSixOTIndicator(String sixOTIndicator) {
		this.sixOTIndicator = sixOTIndicator;
	}
	public String getStartDate() { 
		return startDate; 
	} 
	public String getEndDate() { 
		return endDate; 
	} 
	public String getStartTime() { 
		return startTime; 
	} 
	public String getEndTime() { 
		return endTime; 
	} 
	public String getLunchStartTime() { 
		return lunchStartTime; 
	} 
	
	/** 
	 * @return the unavailableDetails 
	 */ 
	public List<UnavailableDetails> getUnavailableDetails() { 
		return unavailableDetails; 
	} 
 
 
	public String getScheduleType() { 
		return scheduleType; 
	} 
 
	/** 
	 * @return the overtime 
	 */ 
	public List<Overtime> getOvertime() { 
		return overtime; 
	} 
 
	/** 
	 * @return the calloutDetails 
	 */ 
	public List<CalloutDetails> getCalloutDetails() { 
		return calloutDetails; 
	} 
	/** 
	 * @return the lunchDuration 
	 */ 
	public Long getLunchDuration() { 
		return lunchDuration; 
	} 
	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}
	/** 
	 * @return the seqNo 
	 */ 
	public Long getSeqNo() { 
		return seqNo; 
	} 


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TechScheduleAttribute [seqNo=" + seqNo + ", scheduleAction=" + scheduleAction + ", techId=" + techId
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", startTime=" + startTime + ", endTime="
				+ endTime + ", lunchStartTime=" + lunchStartTime + ", lunchDuration=" + lunchDuration
				+ ", scheduleType=" + scheduleType + ", unavailableDetails=" + unavailableDetails + ", overtime="
				+ overtime + ", calloutDetails=" + calloutDetails + ", fileName=" + fileName + ", sixOTIndicator="
				+ sixOTIndicator + "]";
	}


	public static class Builder{ 
		public String fileName;
		private  Long seqNo; 
		private String scheduleAction; 
		private String techId; 
		private String startDate; 
		private String endDate; 
		private String startTime; 
		private String endTime; 
		private String lunchStartTime; 
		private Long lunchDuration; 
		private String scheduleType; 
		private List<UnavailableDetails> unavailableDetails; 
		private List<Overtime> overtime; 
		private List<CalloutDetails> calloutDetails; 
		private String sixOTIndicator; 
 
		public Builder withSeqNo(Long seqNo){ 
			this.seqNo = seqNo; 
			return this; 
		} 
		public Builder withScheduleAction(String scheduleAction){ 
			this.scheduleAction=scheduleAction; 
			return this; 
		} 
		public Builder withTechId(String techId){ 
			this.techId=techId; 
			return this; 
		} 
		public Builder withStartDate(String startDate){ 
			this.startDate=startDate; 
			return this; 
		} 
		public Builder withEndDate(String endDate){ 
			this.endDate=endDate; 
			return this; 
		} 
		public Builder withStartTime(String startTime){ 
			this.startTime=startTime; 
			return this; 
		} 
		public Builder withEndTime(String endTime){ 
			this.endTime=endTime; 
			return this; 
		} 
		public Builder withLunchStartTime(String lunchStartTime){ 
			this.lunchStartTime=lunchStartTime; 
			return this; 
		} 
		public Builder withLunchDuration(Long lunchDuration){ 
			this.lunchDuration=lunchDuration; 
			return this; 
		} 
		public Builder withScheduleType(String scheduleType){ 
			this.scheduleType=scheduleType; 
			return this; 
		} 
		public Builder withUnavailableDetails(List<UnavailableDetails> unavailableDetails){ 
			this.unavailableDetails=unavailableDetails; 
			return this; 
		} 
		public Builder withOverTime(List<Overtime> overtime){ 
			this.overtime=overtime; 
			return this; 
		} 
		public Builder withCalloutDetails(List<CalloutDetails> calloutDetails){ 
			this.calloutDetails=calloutDetails; 
			return this; 
		} 
		public Builder withfileName(String fileName){ 
			this.fileName=fileName; 
			return this; 
		} 
		
		public Builder withSixOTIndicator(String sixOTIndicator){ 
			this.sixOTIndicator=sixOTIndicator; 
			return this; 
		} 
		public TechScheduleAttribute build(){ 
			return new TechScheduleAttribute(this); 
		} 
	}
	 
 
}