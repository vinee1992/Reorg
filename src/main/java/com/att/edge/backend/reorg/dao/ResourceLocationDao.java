package com.att.edge.backend.reorg.dao;

import java.util.List;

import com.att.edge.backend.reorg.model.ResourceLocation;
import com.att.edge.backend.reorg.model.TechLocationDetail;

public interface ResourceLocationDao {
	public List<TechLocationDetail> getResourceLocationByProcessStatus(String status);
	public int[] batchUpdate(final List<ResourceLocation> resourceLocation);
}
