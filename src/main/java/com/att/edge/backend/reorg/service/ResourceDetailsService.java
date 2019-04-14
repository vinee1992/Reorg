package com.att.edge.backend.reorg.service;

import java.util.List;

import com.att.edge.backend.reorg.model.ResourceAttribute;

public interface ResourceDetailsService {
	public List<ResourceAttribute> getResourceDetailsByProcessStatus(String status);
}
