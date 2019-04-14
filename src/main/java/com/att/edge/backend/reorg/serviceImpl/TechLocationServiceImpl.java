/**
 * 
 */
package com.att.edge.backend.reorg.serviceImpl;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.att.edge.backend.reorg.dao.TechLocationDao;
import com.att.edge.backend.reorg.model.AssignedTechLocation;
import com.att.edge.backend.reorg.model.TechAttribute;
import com.att.edge.backend.reorg.model.TechLocation;
import com.att.edge.backend.reorg.service.TechLocationService;

/**
 * @author pradyumna.k.khadanga
 *
 */
@Service("techLocationService")
public class TechLocationServiceImpl implements TechLocationService{

	@Autowired
	private TechLocationDao techLocationDao;

	@Override
	public List<TechAttribute> getTechLocationsByProcessStatus(String status) {
		List<TechLocation> techLocations=techLocationDao.getTechLocationsByProcessStatus(null);
		Map<Long,AssignedTechLocation> assignedTechLocationMap= techLocations.stream()
				.filter(techLocation->techLocation.getSeqno()!=null)
				.map(TechLocationDao::buildAssignedTechLocation)
				.collect(Collectors.toMap(AssignedTechLocation::getSeqNo,Function.identity()));

		return assignedTechLocationMap.entrySet()
				.stream()
				.map(entrySet->{
					return new TechAttribute.Builder()
							.withSeqNo(entrySet.getKey())
							.withTechId(entrySet.getValue().getAssignedLocationDetail().getTechId())
							.withAssignedLocationDetail(entrySet.getValue().getAssignedLocationDetail())
							.withfileName(entrySet.getValue().getFileName())
							.build();
				})
				.collect(Collectors.toList());



	}
}
