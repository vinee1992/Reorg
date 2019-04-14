package com.att.edge.backend.reorg.model;

public class ApplicationDetails {
	private String sourceUserId;



	public ApplicationDetails() {
		super();
	}

	public ApplicationDetails(String techId) {
		this.sourceUserId = techId;
	}

	/**
	 * @return the sourceUserId
	 */
	public String getSourceUserId() {
		return sourceUserId;
	}

	/**
	 * @param sourceUserId the sourceUserId to set
	 */
	public void setSourceUserId(String sourceUserId) {
		this.sourceUserId = sourceUserId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ApplicationDetails [sourceUserId=" + sourceUserId + "]";
	}

}
