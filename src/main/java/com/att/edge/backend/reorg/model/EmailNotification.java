package com.att.edge.backend.reorg.model;

public class EmailNotification {
	private String notificationId;
	private String fileName;
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EmailFunctionality [notificationId=" + notificationId + ", fileName=" + fileName + "]";
	}
	/**
	 * @return the notificationId
	 */
	public String getNotificationId() {
		return notificationId;
	}
	/**
	 * @param notificationId the notificationId to set
	 */
	public void setNotificationId(String notificationId) {
		this.notificationId = notificationId;
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

}
