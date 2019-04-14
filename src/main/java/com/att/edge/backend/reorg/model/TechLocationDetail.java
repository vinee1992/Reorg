package com.att.edge.backend.reorg.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class TechLocationDetail {

	private Long seqNo;
	@JsonInclude(Include.NON_NULL)
	private String resourceId;
	@JsonInclude(Include.NON_NULL)
	private String techId;
	@JsonIgnore
	private String isTech;
	@JsonInclude(Include.NON_NULL) 
	private ResourceLocation resourceLocations;
	//@JsonInclude(Include.NON_NULL) 
	//private LocationDetails locationDetails;
	@JsonInclude(Include.NON_NULL) 
	private List<LocationDetails> locationDetails;
	
	private String fileName;

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

	/**
	 * @return the resourceLocations
	 */
	public ResourceLocation getResourceLocations() {
		return resourceLocations;
	}

	/**
	 * @param resourceLocations the resourceLocations to set
	 */
	public void setResourceLocations(ResourceLocation resourceLocations) {
		this.resourceLocations = resourceLocations;
	}

	/**
	 * @return the locationDetails
	 */
	public List<LocationDetails> getLocationDetails() {
		return locationDetails;
	}

	/**
	 * @param locationDetails the locationDetails to set
	 */
	public void setLocationDetails(List<LocationDetails> locationDetails) {
		this.locationDetails = locationDetails;
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
		return "TechLocationDetail [seqNo=" + seqNo + ", resourceId=" + resourceId + ", techId=" + techId + ", isTech="
				+ isTech + ", resourceLocations=" + resourceLocations + ", locationDetails=" + locationDetails
				+ ", fileName=" + fileName + "]";
	}
	
	
}

