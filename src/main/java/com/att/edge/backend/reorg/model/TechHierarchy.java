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
public class TechHierarchy {
	@JsonInclude(Include.NON_NULL)
	private String seqno;
	@JsonIgnore
	private String processStatus;
	@JsonIgnore
	private String processStatusreason;
	@JsonIgnore
	private String processedDttm;
	@JsonIgnore
	private String filename;
	@JsonInclude(Include.NON_NULL)
	private String action;
	@JsonInclude(Include.NON_NULL)
	private String resourcename;
	@JsonInclude(Include.NON_NULL)
	private String parentResourceid;
	@JsonInclude(Include.NON_NULL)
	private String resourceType;
	@JsonInclude(Include.NON_NULL)
	private String status;
	@JsonInclude(Include.NON_NULL)
	private String timezone;
	@JsonInclude(Include.NON_NULL)
	private String language;
	@JsonInclude(Include.NON_NULL)
	private String emailaddress;
	@JsonInclude(Include.NON_NULL)
	private String garageId;
	@JsonInclude(Include.NON_NULL)
	private String organization;
	@JsonInclude(Include.NON_NULL)
	private String useAsCapacityBucket;
	@JsonIgnore
	private String createdDttm;

	 
	 

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




	public String getProcessStatusreason() {
		return processStatusreason;
	}




	public void setProcessStatusreason(String processStatusreason) {
		this.processStatusreason = processStatusreason;
	}




	public String getProcessedDttm() {
		return processedDttm;
	}




	public void setProcessedDttm(String processedDttm) {
		this.processedDttm = processedDttm;
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




	public String getResourcename() {
		return resourcename;
	}




	public void setResourcename(String resourcename) {
		this.resourcename = resourcename;
	}




	public String getParentResourceid() {
		return parentResourceid;
	}




	public void setParentResourceid(String parentResourceid) {
		this.parentResourceid = parentResourceid;
	}




	public String getResourceType() {
		return resourceType;
	}




	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}




	public String getStatus() {
		return status;
	}




	public void setStatus(String status) {
		this.status = status;
	}




	public String getTimezone() {
		return timezone;
	}




	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}




	public String getLanguage() {
		return language;
	}




	public void setLanguage(String language) {
		this.language = language;
	}




	public String getEmailaddress() {
		return emailaddress;
	}




	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}




	public String getGarageId() {
		return garageId;
	}




	public void setGarageId(String garageId) {
		this.garageId = garageId;
	}




	public String getOrganization() {
		return organization;
	}




	public void setOrganization(String organization) {
		this.organization = organization;
	}




	public String getUseAsCapacityBucket() {
		return useAsCapacityBucket;
	}




	public void setUseAsCapacityBucket(String useAsCapacityBucket) {
		this.useAsCapacityBucket = useAsCapacityBucket;
	}




	public String getCreatedDttm() {
		return createdDttm;
	}




	public void setCreatedDttm(String createdDttm) {
		this.createdDttm = createdDttm;
	}




	/*@Override
	public String toString() {
		return "TechHierarchy[seqNo=" + seqNo + ", techId=" + techId + ", techDetails=" + techDetails + "]";
	}
*/
	
	
}
