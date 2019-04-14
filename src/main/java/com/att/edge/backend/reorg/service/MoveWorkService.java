/**
 * 
 */
package com.att.edge.backend.reorg.service;

import java.util.List;

import com.att.edge.backend.reorg.model.MoveWork;

/**
 * @author pradyumna.k.khadanga
 *
 */
public interface MoveWorkService {
	public List<MoveWork> getMoveWorkByProcessStatus(String Status);
}
