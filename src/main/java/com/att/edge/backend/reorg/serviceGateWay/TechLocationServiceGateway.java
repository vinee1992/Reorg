/**
 * 
 */
package com.att.edge.backend.reorg.serviceGateWay;

import java.util.List;

import com.att.edge.backend.reorg.model.AssignedTechLocation;
import com.att.edge.backend.reorg.model.TechAttribute;

/**
 * @author pradyumna.k.khadanga
 *
 */
public interface TechLocationServiceGateway {

	public String send(TechAttribute techWorkZones);
}
