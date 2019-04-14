/**
 * 
 */
package com.att.edge.backend.reorg.dao;

import java.util.List;

import com.att.edge.backend.reorg.model.UnavailableDetails;

/**
 * @author pradyumna.k.khadanga
 *
 */
public interface TechUnavailibilityDao {
	
	public List<UnavailableDetails> getTechUnavailibilitiesByProcessStatus(String status);
	 public int[] batchUpdate(final List<UnavailableDetails> unavailableDetails);

}
