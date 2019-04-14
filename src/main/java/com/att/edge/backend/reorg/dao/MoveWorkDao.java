/**
 * 
 */
package com.att.edge.backend.reorg.dao;

import java.util.List;

import com.att.edge.backend.reorg.model.MoveWork;

/**
 * @author pradyumna.k.khadanga
 *
 */
public interface MoveWorkDao {
	
	public List<MoveWork> getMoveWorkByProcessStatus(String status);

}
