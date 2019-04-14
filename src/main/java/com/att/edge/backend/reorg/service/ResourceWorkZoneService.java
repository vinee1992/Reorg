package com.att.edge.backend.reorg.service;

import java.util.List;

import com.att.edge.backend.reorg.model.ResourceAttribute;
import com.att.edge.backend.reorg.model.TechAttribute;

public interface ResourceWorkZoneService {
	public List<ResourceAttribute>  getResourceWorkZoneByProcessStatus(String status);
}
