/**
 * 
 */
package com.att.edge.backend.reorg.serviceGateWay;

import com.att.edge.backend.reorg.model.TechLocationDetail;

/**
 * @author vineet.k.chaurasia
 *
 */
public interface LocationDetailsGateway {
	public void send(TechLocationDetail workZones);

}
