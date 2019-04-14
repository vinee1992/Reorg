/**
 * 
 */
package com.att.edge.backend.reorg.model;

import java.util.List;

import com.att.edge.backend.reorg.model.ResourceAttribute.Builder;
import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * @author pradyumna.k.khadanga
 *
 */
public class AssignedTechLocation {
	
	private Long seqNo;	
	@JsonIgnore
	private String fileName;
	private ApplicationDetails applicationDetails;
	private AssignedLocationDetail assignedLocationDetail;

	private AssignedTechLocation(Builder builder) {
		this.seqNo = builder.seqNo;
		this.fileName= builder.fileName;
		this.applicationDetails=builder.applicationDetails;	
		this.assignedLocationDetail=builder.assignedLocationDetail;	
	}



	public AssignedLocationDetail getAssignedLocationDetail() {
		return assignedLocationDetail;
	}
	/**
	 * @return the applicationDetails
	 */
	public ApplicationDetails getApplicationDetails() {
		return applicationDetails;
	}
	
	public Long getSeqNo() {
		return seqNo;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}	
	
	public static class Builder{
		private Long seqNo;	
		private String fileName;
		private ApplicationDetails applicationDetails;
		private AssignedLocationDetail assignedLocationDetail;
		public Builder withSeqNo(Long seqNo){
			this.seqNo = seqNo;
			return this;
		}
		public Builder withFileName(String fileName){
			this.fileName = fileName;
			return this;
		}
		public Builder withApplicationDetails(ApplicationDetails applicationDetails){
			this.applicationDetails = applicationDetails;
			return this;
		}
		public Builder withAssignedLocationDetails(AssignedLocationDetail assignedLocationDetail){
			this.assignedLocationDetail = assignedLocationDetail;
			return this;
		}
		public AssignedTechLocation build(){
			return new AssignedTechLocation(this);
		}
	
	}
	


}
