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
public class TechSchedule {
	@JsonInclude(Include.NON_NULL)
	private long seqNo;
	@JsonInclude(Include.NON_NULL)
	private String scheduleAction;
	@JsonInclude(Include.NON_NULL)
	private String techId;
	@JsonInclude(Include.NON_NULL)
	private String startDate;
	@JsonInclude(Include.NON_NULL)
	private String endDate;
	
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
	private String overtimeAction;
	@JsonInclude(Include.NON_NULL)
	private String overtimeType;
	@JsonInclude(Include.NON_NULL)
	private Long overtimeDuration;
	@JsonInclude(Include.NON_NULL)
	private String callOutProfile;
	@JsonInclude(Include.NON_NULL)
	private String sixOTIndicator;
	@JsonInclude(Include.NON_NULL)
	private String techTimeZone;
	@JsonIgnore
	private String fileName;
	
	
	private String callOutDuration;
	/**
	 * @return the callOutDuration
	 */
	public String getCallOutDuration() {
		return callOutDuration;
	}
	/**
	 * @param callOutDuration the callOutDuration to set
	 */
	public void setCallOutDuration(String callOutDuration) {
		this.callOutDuration = callOutDuration;
	}
	/**
	 * @return the techTimeZone
	 */
	public String getTechTimeZone() {
		return techTimeZone;
	}
	/**
	 * @param techTimeZone the techTimeZone to set
	 */
	public void setTechTimeZone(String techTimeZone) {
		this.techTimeZone = techTimeZone;
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
	/**
	 * @return the scheduleAction
	 */
	public String getScheduleAction() {
		return scheduleAction;
	}
	/**
	 * @param scheduleAction the scheduleAction to set
	 */
	public void setScheduleAction(String scheduleAction) {
		this.scheduleAction = scheduleAction;
	}
	/**
	 * @return the techId
	 */
	public String getTechId() {
		return techId;
	}
	/**
	 * @param techId the techId to set
	 */
	public void setTechId(String techId) {
		this.techId = techId;
	}
	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	/**
	 * @return the startTime
	 */
	public String getStartTime() {
		return startTime;
	}
	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	/**
	 * @return the endTime
	 */
	public String getEndTime() {
		return endTime;
	}
	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	/**
	 * @return the lunchStartTime
	 */
	public String getLunchStartTime() {
		return lunchStartTime;
	}
	/**
	 * @param lunchStartTime the lunchStartTime to set
	 */
	public void setLunchStartTime(String lunchStartTime) {
		this.lunchStartTime = lunchStartTime;
	}
	/**
	 * @return the lunchDuration
	 */
	
	/**
	 * @return the scheduleType
	 */
	public String getScheduleType() {
		return scheduleType;
	}
	/**
	 * @param scheduleType the scheduleType to set
	 */
	public void setScheduleType(String scheduleType) {
		this.scheduleType = scheduleType;
	}
	
	/**
	 * @return the overtimeAction
	 */
	public String getOvertimeAction() {
		return overtimeAction;
	}
	/**
	 * @param overtimeAction the overtimeAction to set
	 */
	public void setOvertimeAction(String overtimeAction) {
		this.overtimeAction = overtimeAction;
	}
	/**
	 * @return the overtimeType
	 */
	public String getOvertimeType() {
		return overtimeType;
	}
	/**
	 * @param overtimeType the overtimeType to set
	 */
	public void setOvertimeType(String overtimeType) {
		this.overtimeType = overtimeType;
	}
	/**
	 * @return the overtimeDuration
	 */
	
	/**
	 * @return the seqNo
	 */
	public long getSeqNo() {
		return seqNo;
	}
	/**
	 * @param seqNo the seqNo to set
	 */
	public void setSeqNo(long seqNo) {
		this.seqNo = seqNo;
	}
	
	/**
	 * @return the callOutProfile
	 */
	public String getCallOutProfile() {
		return callOutProfile;
	}
	/**
	 * @param callOutProfile the callOutProfile to set
	 */
	public void setCallOutProfile(String callOutProfile) {
		this.callOutProfile = callOutProfile;
	}
	/**
	 * @return the lunchDuration
	 */
	public Long getLunchDuration() {
		return lunchDuration;
	}
	/**
	 * @param lunchDuration the lunchDuration to set
	 */
	public void setLunchDuration(Long lunchDuration) {
		this.lunchDuration = lunchDuration;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
	/**
	 * @return the overtimeDuration
	 */
	public Long getOvertimeDuration() {
		return overtimeDuration;
	}
	/**
	 * @param overtimeDuration the overtimeDuration to set
	 */
	public void setOvertimeDuration(Long overtimeDuration) {
		this.overtimeDuration = overtimeDuration;
	}
	
	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TechSchedule [seqNo=" + seqNo + ", scheduleAction=" + scheduleAction + ", techId=" + techId
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", startTime=" + startTime + ", endTime="
				+ endTime + ", lunchStartTime=" + lunchStartTime + ", lunchDuration=" + lunchDuration
				+ ", scheduleType=" + scheduleType + ", overtimeAction=" + overtimeAction + ", overtimeType="
				+ overtimeType + ", overtimeDuration=" + overtimeDuration + ", callOutProfile=" + callOutProfile
				+ ", sixOTIndicator=" + sixOTIndicator + ", techTimeZone=" + techTimeZone + ", fileName=" + fileName
				+ ", callOutDuration=" + callOutDuration + "]";
	}
	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	
	

}
