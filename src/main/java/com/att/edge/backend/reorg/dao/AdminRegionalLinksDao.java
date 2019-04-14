package com.att.edge.backend.reorg.dao;

import java.util.List;

import com.att.edge.appcommon.AdminRegionalLinks;
import com.att.edge.appcommon.EdgeException;
import com.att.edge.backend.reorg.model.EmailNotification;

public interface AdminRegionalLinksDao {

	/** 
	 * This routine will retrieve data from ADMIN_REGIONAL_LINKS tables 
	 * 
	 * @return 
	 * @throws EdgeException 
	 */
	public List<AdminRegionalLinks> retrieveAdminRegionalLinks() throws EdgeException;
	
	
	/**
	 * @author vineet.k.chaurasia
	 * Email functionality  
	 * Email fetching method
	 */
//	public List<EmailNotification> fetchEmailAndFileNames()throws EdgeException;
	
	public List<String> fetchNotificationId(String fileNames) throws EdgeException;

}