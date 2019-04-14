/**
 * 
 */
package com.att.edge.backend.reorg.service;

import java.util.List;

import com.att.edge.backend.reorg.model.AssignedTechLocation;
import com.att.edge.backend.reorg.model.TechAttribute;

/**
 * @author pradyumna.k.khadanga
 *
 */
public interface TechLocationService {
	public List<TechAttribute> getTechLocationsByProcessStatus(String status);
}
