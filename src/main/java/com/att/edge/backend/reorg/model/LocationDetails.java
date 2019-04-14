package com.att.edge.backend.reorg.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class LocationDetails{
	@JsonIgnore
	private Long seqNo;
	@JsonIgnore
	private String techId;	
	@JsonInclude(Include.NON_NULL)
	private String locationAction;
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
	private String status;
	@JsonInclude(Include.NON_NULL)
	private String country;
	@JsonIgnore
	private String isTech;
	
	private String latitude;
	private  String longitude;


	private String locationInternalId;
	
	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public Long getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(Long seqNo) {
		this.seqNo = seqNo;
	}

	public String getTechId() {
		return techId;
	}

	public void setTechId(String techId) {
		this.techId = techId;
	}
	/**
	 * @return the locationAction
	 */
	public String getLocationAction() {
		return locationAction;
	}

	/**
	 * @param locationAction
	 *            the locationAction to set
	 */
	public void setLocationAction(String locationAction) {
		this.locationAction = locationAction;
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
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the isTech
	 */
	public String getIsTech() {
		return isTech;
	}

	/**
	 * @param isTech the isTech to set
	 */
	public void setIsTech(String isTech) {
		this.isTech = isTech;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */


	/**
	 * @return the locationInternalId
	 */
	public String getLocationInternalId() {
		return locationInternalId;
	}

	/**
	 * @param locationInternalId the locationInternalId to set
	 */
	public void setLocationInternalId(String locationInternalId) {
		this.locationInternalId = locationInternalId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LocationDetails [seqNo=" + seqNo + ", techId=" + techId + ", locationAction=" + locationAction
				+ ", locationName=" + locationName + ", address=" + address + ", city=" + city + ", postalCode="
				+ postalCode + ", state=" + state + ", status=" + status + ", country=" + country + ", isTech=" + isTech
				+ ", latitude=" + latitude + ", longitude=" + longitude + ", locationInternalId=" + locationInternalId
				+ "]";
	}


}
