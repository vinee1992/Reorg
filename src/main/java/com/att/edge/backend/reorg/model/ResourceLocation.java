package com.att.edge.backend.reorg.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class ResourceLocation{
	@JsonIgnore
	private Long seqNo;
	@JsonIgnore
	private String resourceId;
	@JsonInclude(Include.NON_NULL) 
	private String action;
	@JsonInclude(Include.NON_NULL) 
	private String locationName;
	@JsonInclude(Include.NON_NULL) 
	private String address;
	@JsonInclude(Include.NON_NULL) 
	private String city;
	@JsonInclude(Include.NON_NULL) 
	private String postalCode;
	@JsonInclude(Include.NON_NULL) 
	private String state;
	@JsonInclude(Include.NON_NULL)
	@JsonIgnore
	private String status;
	@JsonInclude(Include.NON_NULL) 
	private String country;
	
	@JsonInclude(Include.NON_NULL) 
	private String attuid;
	@JsonInclude(Include.NON_NULL) 
	private String latitude;
	@JsonInclude(Include.NON_NULL) 
	private String locationId;
	@JsonInclude(Include.NON_NULL) 
	private String locationStatus;
	@JsonInclude(Include.NON_NULL) 
	private String longitude;
	@JsonIgnore
	private String processStatusReason;
	@JsonIgnore
	private String processedDttm;
	@JsonInclude(Include.NON_NULL) 
	private String resourceType;
	@JsonIgnore
	private String fileName;
	
	@JsonIgnore
	private String isTech;
	
	public String getIsTech() {
		return isTech;
	}

	public void setIsTech(String isTech) {
		this.isTech = isTech;
	}

	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}

	/**
	 * @param action
	 *            the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}

	/**
	 * @return the locationName
	 */
	public String getLocationName() {
		return locationName;
	}

	/**
	 * @param locationName
	 *            the locationName to set
	 */
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * @param postalCode
	 *            the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the attuid
	 */
	public String getAttuid() {
		return attuid;
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
	 * @param attuid
	 *            the attuid to set
	 */
	public void setAttuid(String attuid) {
		this.attuid = attuid;
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

	
	/**
	 * @return the latitude
	 */
	public String getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the locationId
	 */
	public String getLocationId() {
		return locationId;
	}

	/**
	 * @param locationId the locationId to set
	 */
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	/**
	 * @return the locationStatus
	 */
	public String getLocationStatus() {
		return locationStatus;
	}

	/**
	 * @param locationStatus the locationStatus to set
	 */
	public void setLocationStatus(String locationStatus) {
		this.locationStatus = locationStatus;
	}

	/**
	 * @return the longitude
	 */
	public String getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
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
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param string the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
		
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ResourceLocation [seqNo=" + seqNo + ", resourceId=" + resourceId + ", action=" + action
				+ ", locationName=" + locationName + ", address=" + address + ", city=" + city + ", postalCode="
				+ postalCode + ", state=" + state + ", status=" + status + ", country=" + country + ", attuid=" + attuid
				+ ", latitude=" + latitude + ", locationId=" + locationId + ", locationStatus=" + locationStatus
				+ ", longitude=" + longitude + ", processStatusReason=" + processStatusReason + ", processedDttm="
				+ processedDttm + ", resourceType=" + resourceType + ", fileName=" + fileName + "]";
	}

	
}
