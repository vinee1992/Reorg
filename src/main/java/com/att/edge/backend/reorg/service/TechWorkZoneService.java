/**
 * 
 */
package com.att.edge.backend.reorg.service;

import java.util.List;

import com.att.edge.backend.reorg.model.TechAttribute;

/**
 * @author pradyumna.k.khadanga
 *
 */
public interface TechWorkZoneService {
	public List<TechAttribute> getTechWorkZoneByProcessStatus(String Status);
}
