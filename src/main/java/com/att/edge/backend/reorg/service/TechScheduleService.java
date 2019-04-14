/**
 * 
 */
package com.att.edge.backend.reorg.service;

import java.util.List;
import com.att.edge.backend.reorg.model.TechScheduleAttribute;

/**
 * @author pradyumna.k.khadanga
 *
 */
public interface TechScheduleService {
	public List<TechScheduleAttribute> getTechSchudulesByProcessStatus(String status);
}
