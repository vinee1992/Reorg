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

import com.att.edge.backend.reorg.dao.ResourceLocationDao;
import com.att.edge.backend.reorg.model.TechLocationDetail;
import com.att.edge.backend.reorg.service.ResourceLocationService;

/**
 * @author pradyumna.k.khadanga
 *
 */
@Service("resourceLocationService")
public class ResourceLocationServiceImpl implements ResourceLocationService{
	@Autowired
	ResourceLocationDao resourceLocationDao;

	@Override
	public List<TechLocationDetail> getResourceLocationByProcessStatus(String status) {

		List<TechLocationDetail> resourceLocation= resourceLocationDao.getResourceLocationByProcessStatus(status);
		
		//TechLocationDetails details = new TechLocationDetails()l

		
		
		/*List<TechLocationDetails>	 TechLocationDetails0 =partionMap.get(true);
		List<TechLocationDetails>	 TechLocationDetails1 =partionMap.get(false);
		
		
		Map<Long, LocationDetails> techLocationDetails = TechLocationDetails0.stream()
				.filter(resourceLocations->resourceLocations.getSeqNo() !=null)
				.collect(Collectors.toMap(LocationDetails::getSeqNo, Function.identity()));
		
		Map<Long,ResourceLocation> resourceLocationsDetails = TechLocationDetails1.stream()
				.filter(resourceLocations->resourceLocations.getSeqNo() !=null)
				.collect(Collectors.toMap(ResourceLocation::getSeqNo, Function.identity()));
		
		List<TechLocationDetails> one=	  techLocationDetails.entrySet()
				.stream()
				.map(set->new TechLocationDetails.Builder()
						.withSeqNo(set.getKey())
						.withResourceId(set.getValue().getResourceId())
						.withLocationDetails(set.getValue())
						.build())
				.collect(Collectors.toList());
		
		List<TechLocationDetails> one=   resourceLocationsDetails.entrySet()
				.stream()
				.map(set->new TechLocationDetails.Builder()
						.withSeqNo(set.getKey())
						.withResourceId(set.getValue().getResourceId())
						.withResourceLocation(set.getValue())
						.build())
				.collect(Collectors.toList());*/
				
				
				
		
		/*	Map<Long,TechLocationDetails>	resourceLocationMap=resourceLocation.stream()
				.filter(resourceLocations->resourceLocations.getSeqNo()	!=null)
				.collect(Collectors.toMap(TechLocationDetails::getSeqNo,Function.identity()));
		resourceLocationDao.batchUpdate(resourceLocation);

		return	resourceLocationMap.entrySet()
				.stream()
				.map(set->new ResourceAttribute.Builder()
						.withSeqNo(set.getKey())
						.withResourceId(set.getValue().getResourceId())		
						.withResourceLocation(set.getValue())
						.withfileName(set.getValue().getFileName())
						.withIsTech(set.getValue().getIsTech())
						.build())
				.collect(Collectors.toList());*/
		return resourceLocation;

	}


}
