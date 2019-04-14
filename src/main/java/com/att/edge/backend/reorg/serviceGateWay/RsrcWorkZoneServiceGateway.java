/**
 * 
 */
package com.att.edge.backend.reorg.serviceGateWay;

import java.util.List;
import com.att.edge.backend.reorg.model.TechAttribute;

/**
 * @author pradyumna.k.khadanga
 *
 */
public interface RsrcWorkZoneServiceGateway {

	public void send(List<TechAttribute> rsrcWorkZones);
}
