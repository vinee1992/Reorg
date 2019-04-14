/**
 * 
 */
package com.att.edge.backend.reorg.dao;

import java.util.List;

import com.att.edge.backend.reorg.model.WorkZoneDetails;

/**
 * @author pradyumna.k.khadanga
 *
 */
public interface TechWorkZoneDao {
	
	public List<WorkZoneDetails> getTechWorkZoneByProcessStatus(String status);
	public int[] batchUpdate(final List<WorkZoneDetails> workZone);
}
