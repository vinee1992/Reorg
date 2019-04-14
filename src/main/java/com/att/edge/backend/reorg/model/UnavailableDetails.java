package com.att.edge.backend.reorg.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author anand.arjan.jhamnani
 *
 */
public class UnavailableDetails {
	

	//private String techId;
	@JsonInclude(Include.NON_NULL)
	private Long seqnO;
	@JsonIgnore
	private String techId;
	@JsonInclude(Include.NON_NULL)
	private String unavailableAction;
	@JsonInclude(Include.NON_NULL)
	private String timeType;
	@JsonInclude(Include.NON_NULL)
	private String unavailableStartTime;
	@JsonInclude(Include.NON_NULL)
	private String unavailableDuration;
	
	@JsonIgnore
	private String scheduleDate;
	

	private String activityId;
	/**
	 * @return the activityId
	 */
	public String getActivityId() {
		return activityId;
	}

	/**
	 * @param activityId the activityId to set
	 */
	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

	/**
	 * @return the scheduleDate
	 */
	public String getScheduleDate() {
		return scheduleDate;
	}

	/**
	 * @param scheduleDate the scheduleDate to set
	 */
	public void setScheduleDate(String scheduleDate) {
		this.scheduleDate = scheduleDate;
	}

	@JsonIgnore
	private String fileName;
	

	public String getUnavailableAction() {
		return unavailableAction;
	}

	public void setUnavailableAction(String unavailableAction) {
		this.unavailableAction = unavailableAction;
	}

	public String getTimeType() {
		return timeType;
	}

	public void setTimeType(String timeType) {
		this.timeType = timeType;
	}

	public String getUnavailableStartTime() {
		return unavailableStartTime;
	}

	public void setUnavailableStartTime(String unavailableStartTime) {
		this.unavailableStartTime = unavailableStartTime;
	}

	public String getUnavailableDuration() {
		return unavailableDuration;
	}

	public void setUnavailableDuration(String unavailableDuration) {
		this.unavailableDuration = unavailableDuration;
	}

	/**
	 * @return the seqnO
	 */
	public Long getSeqnO() {
		return seqnO;
	}

	/**
	 * @param seqnO the seqnO to set
	 */
	public void setSeqnO(Long seqnO) {
		this.seqnO = seqnO;
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

}
