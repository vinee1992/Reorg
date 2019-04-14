/**
 * 
 */
package com.att.edge.backend.reorg.serviceImpl;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.att.edge.backend.reorg.dao.ResourceDetailsDao;
import com.att.edge.backend.reorg.model.ResourceAttribute;
import com.att.edge.backend.reorg.model.ResourceDetails;
import com.att.edge.backend.reorg.service.ResourceDetailsService;

/**
 * @author pradyumna.k.khadanga
 *
 */
@Service("resourceDetailsService")
public class ResourceDetailsServiceImpl implements ResourceDetailsService{
	@Autowired
	ResourceDetailsDao resourceDetailsDao;

	@Override
	public List<ResourceAttribute> getResourceDetailsByProcessStatus(String status) {
		
		Function<Entry<Long, ResourceDetails>,ResourceAttribute > buildResourceAttributeFromMap =set->new ResourceAttribute.Builder()
				.withSeqNo(set.getKey())
				.withResourceId(set.getValue().getResourceId())
				.withResourceDetails(set.getValue())
				.withfileName(set.getValue().getFileName())
				.build(); 
		Function<Map<Long, ResourceDetails>,List<ResourceAttribute>> finisher =(resourceDetailsMap)-> resourceDetailsMap.entrySet()
				.stream()
				.map(buildResourceAttributeFromMap)
				.collect(Collectors.toList());
		
		Collector<ResourceDetails,?,Map<Long,ResourceDetails>>	groupingBy =Collectors.toMap(ResourceDetails::getSeqNo,Function.identity());
		
		List<ResourceDetails>  resourceDetails= resourceDetailsDao.getResourceDetailsByProcessStatus(status);
		
		List<ResourceAttribute>	resourceAttribute=resourceDetails.stream()
				.filter(resDetails->resDetails.getSeqNo()	!=null)
				.collect(Collectors.collectingAndThen(groupingBy,finisher));	

		return resourceAttribute;
	}


}
