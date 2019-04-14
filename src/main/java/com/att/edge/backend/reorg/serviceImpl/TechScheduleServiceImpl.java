/**
 * 
 */
package com.att.edge.backend.reorg.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.att.edge.backend.reorg.dao.TechScheduleDao;
import com.att.edge.backend.reorg.daoImpl.TechScheduleDaoImpl;
import com.att.edge.backend.reorg.model.CalloutDetails;
import com.att.edge.backend.reorg.model.Overtime;
import com.att.edge.backend.reorg.model.TechSchedule;
import com.att.edge.backend.reorg.model.TechScheduleAttribute;
import com.att.edge.backend.reorg.service.TechScheduleService;

/**
 * @author pradyumna.k.khadanga
 *
 */
@Service("techScheduleService") 
public class TechScheduleServiceImpl implements TechScheduleService {
	@Autowired
	TechScheduleDao techScheduleDao;

	@Override
	public List<TechScheduleAttribute> getTechSchudulesByProcessStatus(String status) {
		List<TechSchedule> techSchedules = techScheduleDao.getTechSchudulesByProcessStatus(status);
		techScheduleDao.batchUpdate(techSchedules);
		return techSchedules.stream().map(TechScheduleServiceImpl::buildTechScheduleAttribute)
				.collect(Collectors.toList());

	}

	private static TechScheduleAttribute buildTechScheduleAttribute(TechSchedule techSchedule) {
		CalloutDetails calloutDetails = null;
		Overtime overtime = null;
		List<Overtime> overTimes = null;
		List<CalloutDetails> callOuts = null;

		if ("ON_CALL".equalsIgnoreCase(techSchedule.getScheduleType())) {
			calloutDetails = new CalloutDetails.Builder()
					.withCalloutProfile(techSchedule.getCallOutProfile())
					.withScheduleAction(techSchedule.getScheduleAction())
					.withCalloutStartTime(techSchedule.getStartTime())
					.withCalloutDuration(techSchedule.getCallOutDuration())
					.build();		
			if (calloutDetails != null) {
				callOuts = new ArrayList<>();
				callOuts.add(calloutDetails);
			}

			TechScheduleAttribute techScheduleAttributes = new TechScheduleAttribute.Builder()
					.withSeqNo(techSchedule.getSeqNo())
					.withScheduleAction("UPDATE")
					.withTechId(techSchedule.getTechId())
					.withStartDate(techSchedule.getStartDate())
					.withfileName(techSchedule.getFileName())
					.withCalloutDetails(callOuts)
					.build();
			return techScheduleAttributes;
		}
		else{


			if (techSchedule.getOvertimeType() != null) {
				overtime = new Overtime.Builder()
						.withOvertimeAction(techSchedule.getOvertimeAction())
						.withOvertimeType(techSchedule.getOvertimeType())
						.withOvertimeDuration(techSchedule.getOvertimeDuration())
						.build();			
			}

			if (overtime != null) {
				overTimes = new ArrayList<>();
				overTimes.add(overtime);
			}
			TechScheduleAttribute techScheduleAttributes = new TechScheduleAttribute.Builder()
					.withSeqNo(techSchedule.getSeqNo())
					.withScheduleAction(techSchedule.getScheduleAction())
					.withTechId(techSchedule.getTechId())
					.withStartDate(techSchedule.getStartDate())
					.withEndDate(techSchedule.getEndDate())
					.withStartTime(techSchedule.getStartTime())
					.withEndTime(techSchedule.getEndTime())
					.withSixOTIndicator(techSchedule.getSixOTIndicator())
					.withLunchStartTime(techSchedule.getLunchStartTime())
					.withLunchDuration(techSchedule.getLunchDuration())
					.withfileName(techSchedule.getFileName())
					.withOverTime(overTimes)					
					.build();		
			return techScheduleAttributes;
		}
	}

}
