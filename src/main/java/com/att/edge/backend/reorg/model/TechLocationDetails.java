package com.att.edge.backend.reorg.model;

import java.util.List;

import com.att.edge.backend.reorg.model.TechLocationDetail;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL) 
public class TechLocationDetails {
	 
	@JsonInclude(Include.NON_NULL) 
	private List<TechLocationDetail> techAttributes;
	@JsonInclude(Include.NON_NULL) 
	private List<TechLocationDetail> resourcesAttributes;
	/**
	 * @return the techAttributes
	 */
	public List<TechLocationDetail> getTechAttributes() {
		return techAttributes;
	}
	/**
	 * @return the resourcesAttributes
	 */
	public List<TechLocationDetail> getResourcesAttributes() {
		return resourcesAttributes;
	}
	/**
	 * @param resourcesAttributes the resourcesAttributes to set
	 */
	public void setResourcesAttributes(List<TechLocationDetail> resourcesAttributes) {
		this.resourcesAttributes = resourcesAttributes;
	}
	/**
	 * @param techAttributes the techAttributes to set
	 */
	public void setTechAttributes(List<TechLocationDetail> techAttributes) {
		this.techAttributes = techAttributes;
	}



}
