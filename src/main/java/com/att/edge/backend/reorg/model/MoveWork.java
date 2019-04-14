/**
 * 
 */
package com.att.edge.backend.reorg.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author pradyumna.k.khadanga
 *
 */
public class MoveWork {
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MoveWork [seqno=" + seqno + ", processStatus=" + processStatus + ", processStatusReason="
				+ processStatusReason + ", processedDTTM=" + processedDTTM + ", filename=" + filename + ", action="
				+ action + ", fromWorkZone=" + fromWorkZone + ", toWorkZone=" + toWorkZone + ", createdDTTMDate="
				+ createdDTTMDate + "]";
	}
	private String seqno;
	@JsonIgnore
	private String processStatus;
	@JsonIgnore
	private String processStatusReason;
	@JsonIgnore
	private String processedDTTM;
	@JsonIgnore
	private String filename;
	private String action;
	private String fromWorkZone;
	private String toWorkZone;
	@JsonIgnore
	private String createdDTTMDate;
	public String getSeqno() {
		return seqno;
	}
	public void setSeqno(String seqno) {
		this.seqno = seqno;
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
	
	public String getProcessedDTTM() {
		return processedDTTM;
	}
	public void setProcessedDTTM(String processedDTTM) {
		this.processedDTTM = processedDTTM;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getFromWorkZone() {
		return fromWorkZone;
	}
	public void setFromWorkZone(String fromWorkZone) {
		this.fromWorkZone = fromWorkZone;
	}
	public String getToWorkZone() {
		return toWorkZone;
	}
	public void setToWorkZone(String toWorkZone) {
		this.toWorkZone = toWorkZone;
	}
	public String getCreatedDTTMDate() {
		return createdDTTMDate;
	}
	public void setCreatedDTTMDate(String createdDTTMDate) {
		this.createdDTTMDate = createdDTTMDate;
	}


}
