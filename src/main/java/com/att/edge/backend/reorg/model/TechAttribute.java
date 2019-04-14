/**
 * 
 */
package com.att.edge.backend.reorg.model;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author pradyumna.k.khadanga
 *
 */
public class TechAttribute {

	private final Long seqNo;

	private final String techId;
	
	@JsonInclude(Include.NON_NULL) 
	private final TechDetails techDetails;
	
	@JsonInclude(Include.NON_NULL) 
	private final List<SkillDetails> skillDetails;
	
	@JsonInclude(Include.NON_NULL) 
	private final List<LocationDetails> locationDetails;
	
	@JsonInclude(Include.NON_NULL) 
	private final List<ApplicationDetails> applicationDetails;
	
	@JsonInclude(Include.NON_NULL) 
	private final List<WorkZoneDetails> workZoneDetails;
	
	@JsonInclude(Include.NON_NULL) 
	private final AssignedLocationDetail assignedLocationDetails;
	
	public AssignedLocationDetail getAssignedLocationDetails() {
		return assignedLocationDetails;
	}
	@JsonIgnore
	private String fileName;	
	
	private TechAttribute(Builder builder) {
		this.seqNo=builder.seqNo;
		this.techId=builder.techId;
		this.techDetails=builder.techDetails;
		this.skillDetails=builder.skillDetails;
		this.locationDetails=builder.locationDetails;
		this.applicationDetails=builder.applicationDetails;
		this.workZoneDetails=builder.workZoneDetails;
		this.fileName=builder.fileName;
		this.assignedLocationDetails=builder.assignedLocationDetails;		
	}

	public Long getSeqNo() {
		return seqNo;
	}	

	public String getTechId() {
		return techId;
	}
	
	public TechDetails getTechDetails() {
		return techDetails;
	}


	public List<ApplicationDetails> getApplicationDetails() {
		return applicationDetails;
	}

	/**
	 * @return the skillDetails
	 */
	public List<SkillDetails> getSkillDetails() {
		return skillDetails;
	}	

	/**
	 * @return the locationDetails
	 */
	public List<LocationDetails> getLocationDetails() {
		return locationDetails;
	}

	/**
	 * @return the workZoneDetails
	 */
	public List<WorkZoneDetails> getWorkZoneDetails() {
		return workZoneDetails;
	}	


	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}


	
	



	public static class Builder{
		public String fileName;

		private Long seqNo;

		private String techId;
		
		private TechDetails techDetails;
		
		private List<SkillDetails> skillDetails;
		
		private List<LocationDetails> locationDetails;
		
		private List<ApplicationDetails> applicationDetails;
		
		private List<WorkZoneDetails> workZoneDetails;
		private  AssignedLocationDetail assignedLocationDetails;
		
		public Builder withSeqNo(Long seqNo){
			this.seqNo = seqNo;
			return this;
		}
		public Builder withTechId(String techId){
			this.techId = techId;
			return this;
		}
		public Builder withTechDetails(TechDetails techDetails){
			this.techDetails = techDetails;
			return this;
		}
		
		public Builder withSkillDetails(List<SkillDetails> skillDetails){
			this.skillDetails = skillDetails;
			return this;
		}
		public Builder withLocationDetails(List<LocationDetails> locationDetails){
			this.locationDetails = locationDetails;
			return this;
		}
		public Builder withApplicationDetails(List<ApplicationDetails> applicationDetails){
			this.applicationDetails = applicationDetails;
			return this;
		}
		public Builder withWorkZoneDetails(List<WorkZoneDetails> workZoneDetails){
			this.workZoneDetails = workZoneDetails;
			return this;
		}
		public Builder withfileName(String fileName){
			this.fileName = fileName;
			return this;
		}
		public Builder withAssignedLocationDetail(AssignedLocationDetail assignedLocationDetails){
			this.assignedLocationDetails = assignedLocationDetails;
			return this;
		}
		public TechAttribute build(){
			return new TechAttribute(this);
		}
		
	}

	@Override
	public String toString() {
		return "TechAttribute [seqNo=" + seqNo + ", techId=" + techId + ", techDetails=" + techDetails
				+ ", skillDetails=" + skillDetails + ", locationDetails=" + locationDetails + ", applicationDetails="
				+ applicationDetails + ", workZoneDetails=" + workZoneDetails + ", assignedLocationDetails="
				+ assignedLocationDetails + ", fileName=" + fileName + "]";
	}


	
}
