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
public interface TechUnavailibilityService {
	public List<TechScheduleAttribute> getTechUnavailibilitiesByProcessStatus(String status);
}
