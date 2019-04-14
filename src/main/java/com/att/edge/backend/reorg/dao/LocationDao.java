/**
 * 
 */
package com.att.edge.backend.reorg.dao;

import java.util.List;

import com.att.edge.backend.reorg.model.LocationDetails;
import com.att.edge.backend.reorg.model.TechAttribute;

/**
 * @author pradyumna.k.khadanga
 *
 */
public interface LocationDao {
	
	public List<LocationDetails> getLocationsByProcessStatus(String status);
	 public int[] batchUpdate(final List<LocationDetails> locationDetails);
}
