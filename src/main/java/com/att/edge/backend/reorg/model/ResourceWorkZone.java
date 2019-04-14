package com.att.edge.backend.reorg.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class ResourceWorkZone {
	@JsonIgnore
	private Long seqNo;
	@JsonIgnore
	private String resourceId;
	@JsonInclude(Include.NON_NULL)
	private String action;
	@JsonInclude(Include.NON_NULL)
	private String workZone;
	@JsonInclude(Include.NON_NULL)
	private Long workZoneId;
	@JsonInclude(Include.NON_NULL)
	private String ratio;
	@JsonInclude(Include.NON_NULL)
	private String startDate;
	@JsonInclude(Include.NON_NULL)
	private String endDate;
	@JsonInclude(Include.NON_NULL)
	private String recurEvery;
	@JsonInclude(Include.NON_NULL)
	private String recurrence;
	@JsonInclude(Include.NON_NULL)
	private String weekdaysString;
	@JsonInclude(Include.NON_NULL)
	private String workZoneItemId;
	@JsonInclude(Include.NON_NULL)
	private String attuid;
	
	@JsonInclude(Include.NON_NULL)
	private String workZoneSeqNo;
	@JsonIgnore
	private String fileName;
	/**
	 * @return the workZoneSeqNo
	 */
	public String getWorkZoneSeqNo() {
		return workZoneSeqNo;
	}
	/**
	 * @param workZoneSeqNo the workZoneSeqNo to set
	 */
	public void setWorkZoneSeqNo(String workZoneSeqNo) {
		this.workZoneSeqNo = workZoneSeqNo;
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
	 * @return the workZoneId
	 */
	
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
	 * @return the recurEvery
	 */
	public String getRecurEvery() {
		return recurEvery;
	}
	/**
	 * @param recurEvery the recurEvery to set
	 */
	public void setRecurEvery(String recurEvery) {
		this.recurEvery = recurEvery;
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
	 * @return the weekdaysString
	 */
	public String getWeekdaysString() {
		return weekdaysString;
	}
	/**
	 * @param weekdaysString the weekdaysString to set
	 */
	public void setWeekdaysString(String weekdaysString) {
		this.weekdaysString = weekdaysString;
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
	 * @return the attuid
	 */
	public String getAttuid() {
		return attuid;
	}
	/**
	 * @param attuid the attuid to set
	 */
	public void setAttuid(String attuid) {
		this.attuid = attuid;
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
	 * @return the seqNo
	 */
	public Long getSeqNo() {
		return seqNo;
	}
	/**
	 * @param seqNo the seqNo to set
	 */
	public void setSeqNo(Long seqNo) {
		this.seqNo = seqNo;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
	/**
	 * @return the workZoneId
	 */
	public Long getWorkZoneId() {
		return workZoneId;
	}
	/**
	 * @param workZoneId the workZoneId to set
	 */
	public void setWorkZoneId(Long workZoneId) {
		this.workZoneId = workZoneId;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ResourceWorkZone [seqNo=" + seqNo + ", resourceId=" + resourceId + ", action=" + action + ", workZone="
				+ workZone + ", workZoneId=" + workZoneId + ", ratio=" + ratio + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", recurEvery=" + recurEvery + ", recurrence=" + recurrence
				+ ", weekdaysString=" + weekdaysString + ", workZoneItemId=" + workZoneItemId + ", attuid=" + attuid
				+ ", workZoneSeqNo=" + workZoneSeqNo + ", fileName=" + fileName + "]";
	}
	
}
