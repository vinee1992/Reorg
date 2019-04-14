package com.att.edge.backend.reorg.service;

import java.util.List;

import com.att.edge.backend.reorg.model.TechLocationDetail;

public interface ResourceLocationService {
	public List<TechLocationDetail> getResourceLocationByProcessStatus(String status);
}
