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
public class TechDetails {
	@JsonIgnore
	private Long seqNo;
	@JsonIgnore
	private String techId;
	@JsonInclude(Include.NON_NULL)
	private String  language; 
	@JsonInclude(Include.NON_NULL)
	private String  phone; 
	@JsonInclude(Include.NON_NULL)
	private String  timeZone; 
	@JsonInclude(Include.NON_NULL)
	private String  resourceType; 
	@JsonInclude(Include.NON_NULL)
	private String  name;
	@JsonInclude(Include.NON_NULL)
	private String techAction;
	@JsonInclude(Include.NON_NULL)
	private String moveEffectiveDate;
	@JsonInclude(Include.NON_NULL)
	private String parentResourceId;
	// Newly added variables
	@JsonInclude(Include.NON_NULL)
	private String email;
	@JsonInclude(Include.NON_NULL)
	private String techType;
	@JsonInclude(Include.NON_NULL)
	private String supervisiorId;
	@JsonInclude(Include.NON_NULL)
	private String status;
	@JsonInclude(Include.NON_NULL)
	private String timeFormat;
	@JsonInclude(Include.NON_NULL)
	private String dateFormat;
	@JsonInclude(Include.NON_NULL)
	private String employeeCode;
	@JsonInclude(Include.NON_NULL)
	private String crew;
	@JsonInclude(Include.NON_NULL)
	private String cuid;
	@JsonInclude(Include.NON_NULL)
	private String garageId;
	@JsonInclude(Include.NON_NULL)
	private String loadType;
	@JsonInclude(Include.NON_NULL)
	private String userType;
	@JsonInclude(Include.NON_NULL)
	private String organization;
	@JsonInclude(Include.NON_NULL)
	private String profile;
	@JsonInclude(Include.NON_NULL)
	private String region;
	@JsonInclude(Include.NON_NULL)
	private String center;
	@JsonInclude(Include.NON_NULL)
	private String loanedState; 
	@JsonInclude(Include.NON_NULL)
	private String loanedCenter;
	@JsonInclude(Include.NON_NULL)
	protected String durationStatisticsInitialPeriod;
	@JsonInclude(Include.NON_NULL)
    protected String durationStatisticsInitialRatio;
	@JsonIgnore
	private String fileName;
  
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
	 * @return the phoneNumber
	 */

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
	 * @return the resourceName
	 */

	
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
	 * @return the moveEffDate
	 */

	
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
	 * @return the techType
	 */
	public String getTechType() {
		return techType;
	}
	/**
	 * @param techType the techType to set
	 */
	public void setTechType(String techType) {
		this.techType = techType;
	}
	/**
	 * @return the supervisiorId
	 */
	public String getSupervisiorId() {
		return supervisiorId;
	}
	/**
	 * @param supervisiorId the supervisiorId to set
	 */
	public void setSupervisiorId(String supervisiorId) {
		this.supervisiorId = supervisiorId;
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
	 * @return the employeeCode
	 */
	public String getEmployeeCode() {
		return employeeCode;
	}
	/**
	 * @param employeeCode the employeeCode to set
	 */
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	/**
	 * @return the crew
	 */
	public String getCrew() {
		return crew;
	}
	/**
	 * @param crew the crew to set
	 */
	public void setCrew(String crew) {
		this.crew = crew;
	}
	/**
	 * @return the cuid
	 */
	public String getCuid() {
		return cuid;
	}
	/**
	 * @param cuid the cuid to set
	 */
	public void setCuid(String cuid) {
		this.cuid = cuid;
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
	 * @return the loadType
	 */
	public String getLoadType() {
		return loadType;
	}
	/**
	 * @param loadType the loadType to set
	 */
	public void setLoadType(String loadType) {
		this.loadType = loadType;
	}
	/**
	 * @return the userType
	 */
	public String getUserType() {
		return userType;
	}
	/**
	 * @param userType the userType to set
	 */
	public void setUserType(String userType) {
		this.userType = userType;
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
	 * @return the profile
	 */
	public String getProfile() {
		return profile;
	}
	/**
	 * @param profile the profile to set
	 */
	public void setProfile(String profile) {
		this.profile = profile;
	}
	/**
	 * @return the region
	 */
	public String getRegion() {
		return region;
	}
	/**
	 * @param region the region to set
	 */
	public void setRegion(String region) {
		this.region = region;
	}
	/**
	 * @return the center
	 */
	public String getCenter() {
		return center;
	}
	/**
	 * @param center the center to set
	 */
	public void setCenter(String center) {
		this.center = center;
	}
	/**
	 * @return the loanedState
	 */
	public String getLoanedState() {
		return loanedState;
	}
	/**
	 * @param loanedState the loanedState to set
	 */
	public void setLoanedState(String loanedState) {
		this.loanedState = loanedState;
	}
	/**
	 * @return the loanedCenter
	 */
	public String getLoanedCenter() {
		return loanedCenter;
	}
	/**
	 * @param loanedCenter the loanedCenter to set
	 */
	public void setLoanedCenter(String loanedCenter) {
		this.loanedCenter = loanedCenter;
	}
	/**
	 * @return the durationStatisticsInitialPeriod
	 */
	public String getDurationStatisticsInitialPeriod() {
		return durationStatisticsInitialPeriod;
	}
	/**
	 * @param durationStatisticsInitialPeriod the durationStatisticsInitialPeriod to set
	 */
	public void setDurationStatisticsInitialPeriod(String durationStatisticsInitialPeriod) {
		this.durationStatisticsInitialPeriod = durationStatisticsInitialPeriod;
	}
	/**
	 * @return the durationStatisticsInitialRatio
	 */
	public String getDurationStatisticsInitialRatio() {
		return durationStatisticsInitialRatio;
	}
	/**
	 * @param durationStatisticsInitialRatio the durationStatisticsInitialRatio to set
	 */
	public void setDurationStatisticsInitialRatio(String durationStatisticsInitialRatio) {
		this.durationStatisticsInitialRatio = durationStatisticsInitialRatio;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
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
	 * @return the moveEffectiveDate
	 */
	public String getMoveEffectiveDate() {
		return moveEffectiveDate;
	}
	/**
	 * @param moveEffectiveDate the moveEffectiveDate to set
	 */
	public void setMoveEffectiveDate(String moveEffectiveDate) {
		this.moveEffectiveDate = moveEffectiveDate;
	}
	/**
	 * @return the timeFormat
	 */
	public String getTimeFormat() {
		return timeFormat;
	}
	/**
	 * @param timeFormat the timeFormat to set
	 */
	public void setTimeFormat(String timeFormat) {
		this.timeFormat = timeFormat;
	}
	/**
	 * @return the dateFormat
	 */
	public String getDateFormat() {
		return dateFormat;
	}
	/**
	 * @param dateFormat the dateFormat to set
	 */
	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
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
		return "TechDetails [seqNo=" + seqNo + ", techId=" + techId + ", language=" + language + ", phone=" + phone
				+ ", timeZone=" + timeZone + ", resourceType=" + resourceType + ", name=" + name + ", techAction="
				+ techAction + ", moveEffectiveDate=" + moveEffectiveDate + ", parentResourceId=" + parentResourceId
				+ ", email=" + email + ", techType=" + techType + ", supervisiorId=" + supervisiorId + ", status="
				+ status + ", timeFormat=" + timeFormat + ", dateFormat=" + dateFormat + ", employeeCode="
				+ employeeCode + ", crew=" + crew + ", cuid=" + cuid + ", garageId=" + garageId + ", loadType="
				+ loadType + ", userType=" + userType + ", organization=" + organization + ", profile=" + profile
				+ ", region=" + region + ", center=" + center + ", loanedState=" + loanedState + ", loanedCenter="
				+ loanedCenter + ", durationStatisticsInitialPeriod=" + durationStatisticsInitialPeriod
				+ ", durationStatisticsInitialRatio=" + durationStatisticsInitialRatio + ", fileName=" + fileName + "]";
	}


	
}
