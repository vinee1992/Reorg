/**
 * 
 */
package com.att.edge.backend.reorg.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.att.edge.backend.reorg.dao.ResourceWorkZoneDao;
import com.att.edge.backend.reorg.daoImpl.ResourceWorkZoneDaoImpl;
import com.att.edge.backend.reorg.model.ResourceAttribute;
import com.att.edge.backend.reorg.model.ResourceLocation;
import com.att.edge.backend.reorg.model.ResourceWorkZone;
import com.att.edge.backend.reorg.service.ResourceWorkZoneService;

/**
 * @author pradyumna.k.khadanga
 *
 */
@Service("resourceWorkZoneService")
public class ResourceWorkZoneServiceImpl implements ResourceWorkZoneService{
	@Autowired
	ResourceWorkZoneDao resourceWorkZoneDao;

	@Override
	public List<ResourceAttribute>getResourceWorkZoneByProcessStatus(String status) {
		List<ResourceWorkZone>  resourceWorkZone= resourceWorkZoneDao.getResourceWorkZoneByProcessStatus(status);
		Map<Long,ResourceWorkZone>	resWorkZoneMap=resourceWorkZone.stream()
				.filter(resWorkZones->resWorkZones.getSeqNo()!=null)
				.collect(Collectors.toMap(ResourceWorkZone::getSeqNo,Function.identity()));
		resourceWorkZoneDao.batchUpdate(resourceWorkZone);
	List<ResourceAttribute>	 resAttributes = resWorkZoneMap.entrySet()
			.stream()
			.map(set-> new ResourceAttribute.Builder()
						.withSeqNo(set.getKey())
						.withResourceId(set.getValue().getResourceId())
						.withResourceWorkZones(set.getValue())
						.withfileName(set.getValue().getFileName())
						.build()		
				).collect(Collectors.toList());

		return resAttributes;
	}

}

