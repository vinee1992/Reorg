/**
 * 
 */
package com.att.edge.backend.reorg.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.att.edge.backend.reorg.dao.MoveWorkDao;
import com.att.edge.backend.reorg.model.MoveWork;
import com.att.edge.backend.reorg.service.MoveWorkService;

/**
 * @author pradyumna.k.khadanga
 *
 */
@Service("moveWorkService")
public class MoveWorkServiceImpl implements MoveWorkService{
	@Autowired
	MoveWorkDao moveWorkDao;

	@Override
	public List<MoveWork> getMoveWorkByProcessStatus(String status) {
		return moveWorkDao.getMoveWorkByProcessStatus(status);
	}

}
