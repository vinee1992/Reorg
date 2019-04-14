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
public class SkillDetails {
	@JsonIgnore
	private Long seqNo;
	@JsonIgnore
	private String techId;	
	@JsonInclude(Include.NON_NULL)
	private String skillAction;
	@JsonInclude(Include.NON_NULL)
	private String workSkill;	
	@JsonInclude(Include.NON_NULL)
	private String startDate; 
	@JsonInclude(Include.NON_NULL)
	private String endDate; 
	@JsonInclude(Include.NON_NULL) 
	private Long workSkillInternalId;
	@JsonIgnore
	private String fileName;
	
	private Integer ratio;
	/**
	 * @return the workSkillInternalId
	 */
	public Long getWorkSkillInternalId() {
		return workSkillInternalId;
	}
	/**
	 * @param workSkillInternalId the workSkillInternalId to set
	 */
	public void setWorkSkillInternalId(Long workSkillInternalId) {
		this.workSkillInternalId = workSkillInternalId;
	}

		
	/**
	 * @return the skillAction
	 */
	public String getSkillAction() {
		return skillAction;
	}
	/**
	 * @param skillAction the skillAction to set
	 */
	public void setSkillAction(String skillAction) {
		this.skillAction = skillAction;
	}
	/**
	 * @return the workSkill
	 */
	public String getWorkSkill() {
		return workSkill;
	}
	/**
	 * @param workSkill the workSkill to set
	 */
	public void setWorkSkill(String workSkill) {
		this.workSkill = workSkill;
	}
	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	

	/**
	 * @return the ratio
	 */
	public Integer getRatio() {
		return ratio;
	}
	/**
	 * @param ratio the ratio to set
	 */
	public void setRatio(Integer ratio) {
		this.ratio = ratio;
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
		return "SkillDetails [seqNo=" + seqNo + ", techId=" + techId + ", skillAction=" + skillAction + ", workSkill="
				+ workSkill + ", startDate=" + startDate + ", endDate=" + endDate + ", workSkillInternalId="
				+ workSkillInternalId + ", fileName=" + fileName + ", ratio=" + ratio + "]";
	}


}
