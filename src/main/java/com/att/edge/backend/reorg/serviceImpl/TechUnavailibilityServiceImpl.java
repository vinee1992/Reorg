/**
 * 
 */
package com.att.edge.backend.reorg.serviceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.att.edge.backend.reorg.dao.TechUnavailibilityDao;
import com.att.edge.backend.reorg.model.TechScheduleAttribute;
import com.att.edge.backend.reorg.model.UnavailableDetails;
import com.att.edge.backend.reorg.service.TechUnavailibilityService;

/**
 * @author pradyumna.k.khadanga
 *
 */
@Service("techUnavailibilityService")
public class TechUnavailibilityServiceImpl implements TechUnavailibilityService{
	@Autowired
	TechUnavailibilityDao techUnavailibilityDao;

	@Override
	public List<TechScheduleAttribute> getTechUnavailibilitiesByProcessStatus(String status) {

		List<UnavailableDetails> unavailableDetails = techUnavailibilityDao.getTechUnavailibilitiesByProcessStatus(status);
		techUnavailibilityDao.batchUpdate(unavailableDetails);
		return unavailableDetails.stream().map(TechUnavailibilityServiceImpl::buildTechScheduleAttribute)
				.collect(Collectors.toList());

	}
	private static TechScheduleAttribute buildTechScheduleAttribute(UnavailableDetails unavailableDetails) {
		return new TechScheduleAttribute.Builder()
				.withSeqNo(unavailableDetails.getSeqnO())
				.withScheduleAction("UPDATE")
				.withTechId(unavailableDetails.getTechId())
				.withStartDate(unavailableDetails.getScheduleDate())
				.withEndDate(unavailableDetails.getScheduleDate())
				.withUnavailableDetails(Arrays.asList(unavailableDetails))		
				.withfileName(unavailableDetails.getFileName())
				.build();

	}
}
