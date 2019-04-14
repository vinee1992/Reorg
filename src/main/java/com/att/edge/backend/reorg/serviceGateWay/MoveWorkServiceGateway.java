/**
 * 
 */
package com.att.edge.backend.reorg.serviceGateWay;

import java.util.List;

import com.att.edge.backend.reorg.model.MoveWork;

/**
 * @author pradyumna.k.khadanga
 *
 */
public interface MoveWorkServiceGateway {

	public void send(List<MoveWork> moveWorks);
}
