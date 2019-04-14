package com.att.edge.backend.reorg.serviceGateWay;


import com.att.edge.backend.reorg.model.TechLocationDetail;

public interface ResourceLocationServiceGateway {
	public void send(TechLocationDetail workZones);
}
