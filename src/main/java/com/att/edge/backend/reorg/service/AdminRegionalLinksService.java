/**
 * 
 */
package com.att.edge.backend.reorg.service;

import java.util.List;
import java.util.Map;

import com.att.edge.appcommon.AdminRegionalLinks;
import com.att.edge.appcommon.EdgeException;

/**
 * @author pradyumna.k.khadanga
 *
 */
public interface AdminRegionalLinksService {
	Map<String, AdminRegionalLinks> retrieveAdminRegionalLinks() throws EdgeException;
	public List<String> fetchNotificationId(String fileName) throws EdgeException;
	
	//public Map<String, String> getNotifactionIdByFileName(String fileName);
}
