package com.att.edge.backend.reorg.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class ResourceDetails {
	@JsonIgnore
	private Long seqNo;
	@JsonIgnore
	private String resourceId;
	@JsonIgnore
	private String fileName;
	@JsonInclude(Include.NON_NULL) 
	private String techAction;
	@JsonInclude(Include.NON_NULL) 
	private String email;
	@JsonInclude(Include.NON_NULL) 
	private String language;
	@JsonInclude(Include.NON_NULL) 
	private String name;
	@JsonInclude(Include.NON_NULL) 
	private String parentResourceId;
	@JsonInclude(Include.NON_NULL) 
	private String resourceType;
	@JsonInclude(Include.NON_NULL) 
	private String status;
	@JsonInclude(Include.NON_NULL) 
	private String timeZone;
	@JsonInclude(Include.NON_NULL) 
	private String createdBy;
	@JsonInclude(Include.NON_NULL) 
	private String garageId;
	@JsonInclude(Include.NON_NULL) 
	private String organization;
	@JsonInclude(Include.NON_NULL) 
	private String parentResource;
	@JsonIgnore
	private String processStatus;
	@JsonIgnore
	private String processStatusReason;
	@JsonIgnore
	private String processedDTTM;
	@JsonInclude(Include.NON_NULL) 
	private String resourceName;
	@JsonInclude(Include.NON_NULL) 
	private String useAsCapacityBucket;
	
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
	 * @return the techAction
	 */
	public String getTechAction() {
		return techAction;
	}
	/**
	 * @param techAction the techAction to set
	 */
	public void setTechAction(String techAction) {
		this.techAction = techAction;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}
	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the parentResourceId
	 */
	public String getParentResourceId() {
		return parentResourceId;
	}
	/**
	 * @param parentResourceId the parentResourceId to set
	 */
	public void setParentResourceId(String parentResourceId) {
		this.parentResourceId = parentResourceId;
	}
	/**
	 * @return the resourceType
	 */
	public String getResourceType() {
		return resourceType;
	}
	/**
	 * @param resourceType the resourceType to set
	 */
	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the timeZone
	 */
	public String getTimeZone() {
		return timeZone;
	}
	/**
	 * @param timeZone the timeZone to set
	 */
	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}
	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}
	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	
	/**
	 * @return the garageId
	 */
	public String getGarageId() {
		return garageId;
	}
	/**
	 * @param garageId the garageId to set
	 */
	public void setGarageId(String garageId) {
		this.garageId = garageId;
	}
	/**
	 * @return the organization
	 */
	public String getOrganization() {
		return organization;
	}
	/**
	 * @param organization the organization to set
	 */
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	/**
	 * @return the parentResource
	 */
	public String getParentResource() {
		return parentResource;
	}
	/**
	 * @param parentResource the parentResource to set
	 */
	public void setParentResource(String parentResource) {
		this.parentResource = parentResource;
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
	 * @return the processStatusReason
	 */
	public String getProcessStatusReason() {
		return processStatusReason;
	}
	/**
	 * @param processStatusReason the processStatusReason to set
	 */
	public void setProcessStatusReason(String processStatusReason) {
		this.processStatusReason = processStatusReason;
	}
	/**
	 * @return the processedDTTM
	 */
	public String getProcessedDTTM() {
		return processedDTTM;
	}
	/**
	 * @param processedDTTM the processedDTTM to set
	 */
	public void setProcessedDTTM(String processedDTTM) {
		this.processedDTTM = processedDTTM;
	}
	/**
	 * @return the resourceName
	 */
	public String getResourceName() {
		return resourceName;
	}
	/**
	 * @param resourceName the resourceName to set
	 */
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	/**
	 * @return the useAsCapacityBucket
	 */
	public String getUseAsCapacityBucket() {
		return useAsCapacityBucket;
	}
	/**
	 * @param useAsCapacityBucket the useAsCapacityBucket to set
	 */
	public void setUseAsCapacityBucket(String useAsCapacityBucket) {
		this.useAsCapacityBucket = useAsCapacityBucket;
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
		return "ResourceDetails [seqNo=" + seqNo + ", resourceId=" + resourceId + ", fileName=" + fileName
				+ ", techAction=" + techAction + ", email=" + email + ", language=" + language + ", name=" + name
				+ ", parentResourceId=" + parentResourceId + ", resourceType=" + resourceType + ", status=" + status
				+ ", timeZone=" + timeZone + ", createdBy=" + createdBy + ", garageId=" + garageId + ", organization="
				+ organization + ", parentResource=" + parentResource + ", processStatus=" + processStatus
				+ ", processStatusReason=" + processStatusReason + ", processedDTTM=" + processedDTTM
				+ ", resourceName=" + resourceName + ", useAsCapacityBucket=" + useAsCapacityBucket + "]";
	}
	
	
	
}
