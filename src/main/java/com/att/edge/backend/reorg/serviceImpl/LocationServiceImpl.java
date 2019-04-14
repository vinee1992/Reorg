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
import com.att.edge.backend.reorg.dao.LocationDao;
import com.att.edge.backend.reorg.model.LocationDetails;
import com.att.edge.backend.reorg.model.TechAttribute;
import com.att.edge.backend.reorg.service.LocationService;

/**
 * @author pradyumna.k.khadanga
 *
 */
@Service("locationService")
public class LocationServiceImpl implements LocationService{
	@Autowired
	LocationDao locationDao;

	@Override
	public List<TechAttribute> getLocationsByProcessStatus(String status) {
		List<LocationDetails>  locationDetails= locationDao.getLocationsByProcessStatus(status);
		Map<Long,List<LocationDetails>>	techLocationMap=locationDetails.stream()
				.filter(locationDetail->locationDetail.getTechId()!=null)
				.collect(Collectors.groupingBy(LocationDetails::getSeqNo));
		locationDao.batchUpdate(locationDetails);
		List<TechAttribute>	 techAttributes = techLocationMap.entrySet()
				.stream()
				.map(set-> new TechAttribute.Builder()
							.withSeqNo(set.getKey())
							.withTechId(set.getValue().get(0).getTechId())
							.withLocationDetails(set.getValue())
							.build()).collect(Collectors.toList());

		return techAttributes;
	}

}
