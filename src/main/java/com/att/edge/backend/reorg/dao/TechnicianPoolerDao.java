package com.att.edge.backend.reorg.dao;

import java.util.List;

import com.att.edge.backend.reorg.model.TechAttribute;
import com.att.edge.backend.reorg.model.TechDetails;

public interface TechnicianPoolerDao {

	public List<TechDetails> getTechAttributeByStatus(String processStatus);
	 public int[] batchUpdate(final List<TechDetails> techDetails);
}
