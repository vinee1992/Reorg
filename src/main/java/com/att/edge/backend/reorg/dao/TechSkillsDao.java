/**
 * 
 */
package com.att.edge.backend.reorg.dao;

import java.util.List;

import com.att.edge.backend.reorg.model.SkillDetails;
import com.att.edge.backend.reorg.model.TechAttribute;

/**
 * @author pradyumna.k.khadanga
 *
 */
public interface TechSkillsDao {
	
	public List<SkillDetails> getTechSkillsByProcessStatus(String status);
	 public int[] batchUpdate(final List<SkillDetails> skillDetails) ;

}
