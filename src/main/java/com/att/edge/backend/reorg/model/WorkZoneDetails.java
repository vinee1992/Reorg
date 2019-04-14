/**
 * 
 */
package com.att.edge.backend.reorg.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author pradyumna.k.khadanga
 *
 */
public class WorkZoneDetails {
	@JsonIgnore
	private Long seqno;
	@JsonIgnore
	private String processStatus;
	@JsonIgnore
	private String processStatusreason;
	@JsonIgnore
	private String processedDttm;
	@JsonIgnore
	private String filename;
	@JsonInclude(Include.NON_NULL)
	private String workZoneAction;
	@JsonInclude(Include.NON_NULL)
	private String workZoneInternalId;
	@JsonIgnore
	private String techId;
	@JsonInclude(Include.NON_NULL)
	private String recurrence;
	@JsonInclude(Include.NON_NULL)
	private Long recurEvery;
	@JsonInclude(Include.NON_NULL)
	private String workZone;
	@JsonInclude(Include.NON_NULL)
	private String startDate;
	@JsonInclude(Include.NON_NULL)
	private String endDate;
	@JsonInclude(Include.NON_NULL)
	private String ratio;
	@JsonInclude(Include.NON_NULL)
	private String type;
	@JsonInclude(Include.NON_NULL)
	private String daysBetweenOccurences;
	@JsonInclude(Include.NON_NULL)
	private String createdDttm;
	@JsonIgnore
	private String  weekDays;
	@JsonInclude(Include.NON_NULL)
	private String  workZoneItemId;
	@JsonIgnore
	private String fileName;
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private WeekDay weekdays;
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
	 * @return the processStatus
	 */
	public String getProcessStatus() {
		return processStatus;
	}
	/**
	 * @param processStatus the processStatus to set
	 */
	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}
	/**
	 * @return the processStatusreason
	 */
	public String getProcessStatusreason() {
		return processStatusreason;
	}
	/**
	 * @param processStatusreason the processStatusreason to set
	 */
	public void setProcessStatusreason(String processStatusreason) {
		this.processStatusreason = processStatusreason;
	}
	/**
	 * @return the processedDttm
	 */
	public String getProcessedDttm() {
		return processedDttm;
	}
	/**
	 * @param processedDttm the processedDttm to set
	 */
	public void setProcessedDttm(String processedDttm) {
		this.processedDttm = processedDttm;
	}
	/**
	 * @return the filename
	 */
	public String getFilename() {
		return filename;
	}
	/**
	 * @param filename the filename to set
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}
	/**
	 * @return the workZoneAction
	 */
	public String getWorkZoneAction() {
		return workZoneAction;
	}
	/**
	 * @param workZoneAction the workZoneAction to set
	 */
	public void setWorkZoneAction(String workZoneAction) {
		this.workZoneAction = workZoneAction;
	}
	/**
	 * @return the workZoneInternalId
	 */
	public String getWorkZoneInternalId() {
		return workZoneInternalId;
	}
	/**
	 * @param workZoneInternalId the workZoneInternalId to set
	 */
	public void setWorkZoneInternalId(String workZoneInternalId) {
		this.workZoneInternalId = workZoneInternalId;
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
	 * @return the recurrence
	 */
	public String getRecurrence() {
		return recurrence;
	}
	/**
	 * @param recurrence the recurrence to set
	 */
	public void setRecurrence(String recurrence) {
		this.recurrence = recurrence;
	}
	
	/**
	 * @return the workZone
	 */
	public String getWorkZone() {
		return workZone;
	}
	/**
	 * @param workZone the workZone to set
	 */
	public void setWorkZone(String workZone) {
		this.workZone = workZone;
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
	 * @return the ratio
	 */
	public String getRatio() {
		return ratio;
	}
	/**
	 * @param ratio the ratio to set
	 */
	public void setRatio(String ratio) {
		this.ratio = ratio;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the daysBetweenOccurences
	 */
	public String getDaysBetweenOccurences() {
		return daysBetweenOccurences;
	}
	/**
	 * @param daysBetweenOccurences the daysBetweenOccurences to set
	 */
	public void setDaysBetweenOccurences(String daysBetweenOccurences) {
		this.daysBetweenOccurences = daysBetweenOccurences;
	}
	/**
	 * @return the createdDttm
	 */
	public String getCreatedDttm() {
		return createdDttm;
	}
	/**
	 * @param createdDttm the createdDttm to set
	 */
	public void setCreatedDttm(String createdDttm) {
		this.createdDttm = createdDttm;
	}
	/**
	 * @return the weekDays
	 */
	public String getWeekDays() {
		return weekDays;
	}
	/**
	 * @param weekDays the weekDays to set
	 */
	public void setWeekDays(String weekDays) {
		this.weekDays = weekDays;
	}
	/**
	 * @return the workZoneItemId
	 */
	public String getWorkZoneItemId() {
		return workZoneItemId;
	}
	/**
	 * @param workZoneItemId the workZoneItemId to set
	 */
	public void setWorkZoneItemId(String workZoneItemId) {
		this.workZoneItemId = workZoneItemId;
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
	 * @return the weekdays
	 */
	public WeekDay getWeekdays() {
		return weekdays;
	}
	/**
	 * @param weekdays the weekdays to set
	 */
	public void setWeekdays(WeekDay weekdays) {
		this.weekdays = weekdays;
	}
	/**
	 * @return the recurEvery
	 */
	public Long getRecurEvery() {
		return recurEvery;
	}
	/**
	 * @param recurEvery the recurEvery to set
	 */
	public void setRecurEvery(Long recurEvery) {
		this.recurEvery = recurEvery;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "WorkZoneDetails [seqno=" + seqno + ", processStatus=" + processStatus + ", processStatusreason="
				+ processStatusreason + ", processedDttm=" + processedDttm + ", filename=" + filename
				+ ", workZoneAction=" + workZoneAction + ", workZoneInternalId=" + workZoneInternalId + ", techId="
				+ techId + ", recurrence=" + recurrence + ", recurEvery=" + recurEvery + ", workZone=" + workZone
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", ratio=" + ratio + ", type=" + type
				+ ", daysBetweenOccurences=" + daysBetweenOccurences + ", createdDttm=" + createdDttm + ", weekDays="
				+ weekDays + ", workZoneItemId=" + workZoneItemId + ", fileName=" + fileName + ", weekdays=" + weekdays
				+ "]";
	}
	
	
	
	
}
