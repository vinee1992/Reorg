package com.att.edge.backend.reorg.dao;

import java.util.List;

import com.att.edge.backend.reorg.model.ResourceLocation;
import com.att.edge.backend.reorg.model.ResourceWorkZone;

public interface ResourceWorkZoneDao {
	public List<ResourceWorkZone> getResourceWorkZoneByProcessStatus(String status);
	public int[] batchUpdate(final List<ResourceWorkZone> resourceWorkZone);
}
