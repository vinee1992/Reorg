package com.att.edge.backend.reorg.dao;

import java.util.List;

import com.att.edge.backend.reorg.model.LocationDetails;
import com.att.edge.backend.reorg.model.ResourceDetails;
import com.att.edge.backend.reorg.model.ResourceLocation;

public interface ResourceDetailsDao {
	public List<ResourceDetails> getResourceDetailsByProcessStatus(String status);
	public int[] batchUpdate(final List<ResourceDetails> resourceDetails);
}
