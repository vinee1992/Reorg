package com.att.edge.backend.reorg.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class ResourceAttribute {
	
	private final Long seqNo;
	private final String resourceId;
	
	private final ResourceLocation resourceLocations;
	@JsonInclude(Include.NON_NULL)
	private final ResourceWorkZone resourceWorkZones;	
	@JsonInclude(Include.NON_NULL)
	private final ResourceDetails resourceDetails;
	@JsonIgnore
	private String fileName;
	@JsonIgnore
	private String isTech;
	
	private ResourceAttribute(Builder builder) {
		this.seqNo = builder.seqNo;
		this.resourceId= builder.resourceId;
		this.resourceLocations=builder.resourceLocations;
		this.resourceWorkZones=builder.resourceWorkZones;
		this.resourceDetails=builder.resourceDetails;
		this.fileName = builder.fileName;
		this.isTech = builder.isTech;
	}

	public String getIsTech() {
		return isTech;
	}

	public void setIsTech(String isTech) {
		this.isTech = isTech;
	}

/*	public ResourceWorkZone getResourceWorkZones() {
		return resourceWorkZones;
	}
*/
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return the resourceId
	 */
	public String getResourceId() {
		return resourceId;
	}

		
	/**
	 * @return the resourceLocations
	 */
	public ResourceLocation getResourceLocations() {
		return resourceLocations;
	}

	
	/**
	 * @return the resourceWorkZone
	 */
	public ResourceWorkZone getResourceWorkZone() {
		return resourceWorkZones;
	}

		
	/**
	 * @return the seqNo
	 */
	public Long getSeqNo() {
		return seqNo;
	}

	
	/**
	 * @return the resourceDetails
	 */
	public ResourceDetails getResourceDetails() {
		return resourceDetails;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ResourceAttribute [seqNo=" + seqNo + ", resourceId=" + resourceId + ", resourceLocations="
				+ resourceLocations + ", resourceWorkZones=" + resourceWorkZones + ", resourceDetails="
				+ resourceDetails + ", fileName=" + fileName + "]";
	}

	
	public static class Builder{
		public String fileName;
		private Long seqNo;
		private String resourceId;
		private ResourceLocation resourceLocations;
		private ResourceWorkZone resourceWorkZones;	
		private ResourceDetails resourceDetails;
		private String isTech;
		
		
		
		
		public Builder withSeqNo(Long seqNo){
			this.seqNo = seqNo;
			return this;
		}
		public Builder withResourceId(String resourceId){
			this.resourceId = resourceId;
			return this;
		}
		public Builder withResourceLocation(ResourceLocation resourceLocations){
			this.resourceLocations = resourceLocations;
			return this;
		}
		public Builder withResourceWorkZones(ResourceWorkZone resourceWorkZones){
			this.resourceWorkZones = resourceWorkZones;
			return this;
		}
		public Builder withResourceDetails(ResourceDetails resourceDetails){
			this.resourceDetails = resourceDetails;
			return this;
		}
		public Builder withfileName(String fileName){
			this.fileName = fileName;
			return this;
		}
		public Builder withIsTech(String isTech){
			this.isTech = isTech;
			return this;
		}
		public ResourceAttribute build(){
			return new ResourceAttribute(this);
		}
	}
	
}
