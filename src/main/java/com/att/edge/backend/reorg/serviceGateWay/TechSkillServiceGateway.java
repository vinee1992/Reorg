/**
 * 
 */
package com.att.edge.backend.reorg.serviceGateWay;

import java.util.List;
import com.att.edge.backend.reorg.model.SkillDetails;
import com.att.edge.backend.reorg.model.TechAttribute;

/**
 * @author pradyumna.k.khadanga
 *
 */
public interface TechSkillServiceGateway {

	public String send(List<TechAttribute> techSkills);
}
