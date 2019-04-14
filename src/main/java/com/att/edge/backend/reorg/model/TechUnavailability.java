/**
 * 
 */
package com.att.edge.backend.reorg.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author pradyumna.k.khadanga
 *
 */

public class TechUnavailability {
	@JsonInclude(Include.NON_NULL)
	private long seqNo;
	@JsonIgnore
	private String processStatus;
	@JsonIgnore
	private String processStatusReason;
	@JsonIgnore
	private Date processedDttm;
	@JsonIgnore
	private String fileName;
	@JsonInclude(Include.NON_NULL)
	private String dateOfAction;
	@JsonInclude(Include.NON_NULL)
	private String techId;
	@JsonInclude(Include.NON_NULL)
	private String scheduleType;
	@JsonInclude(Include.NON_NULL)
	private String scheduleDate;
	@JsonInclude(Include.NON_NULL)
	private String scheduleTimeStart;
	@JsonInclude(Include.NON_NULL)
	private String scheduleTimeEnd;
	@JsonIgnore
	private String createdDTTM;

	public long getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(long seqNo) {
		this.seqNo = seqNo;
	}

	public String getProcessStatus() {
		return processStatus;
	}

	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}

	public String getProcessStatusReason() {
		return processStatusReason;
	}

	public void setProcessStatusReason(String processStatusReason) {
		this.processStatusReason = processStatusReason;
	}

	public Date getProcessedDttm() {
		return processedDttm;
	}

	public void setProcessedDttm(Date processedDttm) {
		this.processedDttm = processedDttm;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getDateOfAction() {
		return dateOfAction;
	}

	public void setDateOfAction(String dateOfAction) {
		this.dateOfAction = dateOfAction;
	}

	public String getTechId() {
		return techId;
	}

	public void setTechId(String techId) {
		this.techId = techId;
	}

	public String getScheduleType() {
		return scheduleType;
	}

	public void setScheduleType(String scheduleType) {
		this.scheduleType = scheduleType;
	}

	public String getScheduleDate() {
		return scheduleDate;
	}

	public void setScheduleDate(String scheduleDate) {
		this.scheduleDate = scheduleDate;
	}

	public String getScheduleTimeStart() {
		return scheduleTimeStart;
	}

	public void setScheduleTimeStart(String scheduleTimeStart) {
		this.scheduleTimeStart = scheduleTimeStart;
	}

	public String getScheduleTimeEnd() {
		return scheduleTimeEnd;
	}

	public void setScheduleTimeEnd(String scheduleTimeEnd) {
		this.scheduleTimeEnd = scheduleTimeEnd;
	}

	public String getCreatedDTTM() {
		return createdDTTM;
	}

	public void setCreatedDTTM(String createdDTTM) {
		this.createdDTTM = createdDTTM;
	}

}
