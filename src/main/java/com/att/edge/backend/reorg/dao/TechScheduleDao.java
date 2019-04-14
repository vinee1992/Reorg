/**
 * 
 */
package com.att.edge.backend.reorg.dao;

import java.util.List;

import com.att.edge.backend.reorg.model.TechLocation;
import com.att.edge.backend.reorg.model.TechSchedule;
import com.att.edge.backend.reorg.model.TechScheduleAttribute;

/**
 * @author pradyumna.k.khadanga
 *
 */
public interface TechScheduleDao {
	
	public List<TechSchedule> getTechSchudulesByProcessStatus(String status);
	 public int[] batchUpdate(final List<TechSchedule> techSchedule);

}
