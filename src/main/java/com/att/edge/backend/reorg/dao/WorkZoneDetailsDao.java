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
public interface WorkZoneDetailsDao {
	
	public List<WorkZoneDetails> getRsrcWorkZoneByProcessStatus(String status);

}
