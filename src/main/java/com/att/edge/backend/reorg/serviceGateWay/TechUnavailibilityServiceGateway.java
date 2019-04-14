/**
 * 
 */
package com.att.edge.backend.reorg.serviceGateWay;

import com.att.edge.backend.reorg.model.TechScheduleAttribute;

/**
 * @author pradyumna.k.khadanga
 *
 */
public interface TechUnavailibilityServiceGateway {

	public void send(TechScheduleAttribute techUnavailibilities);
}
