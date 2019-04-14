/**
 * 
 */
package com.att.edge.backend.reorg.service;

import java.util.List;

import com.att.edge.backend.reorg.model.SkillDetails;
import com.att.edge.backend.reorg.model.TechAttribute;

/**
 * @author pradyumna.k.khadanga
 *
 */
public interface TechSkillService {
	public List<TechAttribute> getTechSkillsByProcessStatus(String Status);
}
