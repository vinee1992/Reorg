/**
 * 
 */
package com.att.edge.backend.reorg.serviceImpl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.att.edge.backend.reorg.dao.TechWorkZoneDao;
import com.att.edge.backend.reorg.model.TechAttribute;
import com.att.edge.backend.reorg.model.WeekDay;
import com.att.edge.backend.reorg.model.WorkZoneDetails;
import com.att.edge.backend.reorg.service.TechWorkZoneService;

/**
 * @author pradyumna.k.khadanga
 *
 */
@Service("techWorkZoneService")
public class WorkZoneServiceImpl implements TechWorkZoneService{
	@Autowired
	TechWorkZoneDao techWorkZoneDao;
	@Override
	public List<TechAttribute> getTechWorkZoneByProcessStatus(String status) {
		List<WorkZoneDetails> workZones= techWorkZoneDao.getTechWorkZoneByProcessStatus(status);
		techWorkZoneDao.batchUpdate(workZones);
		Map<Long,List<WorkZoneDetails>> workZonesMap=workZones.parallelStream()
				.map(WorkZoneServiceImpl::buildWeekDayObject)
				.collect(Collectors.groupingBy(WorkZoneDetails::getSeqno));
		return 	workZonesMap.entrySet()
				.parallelStream()				
				.map(WorkZoneServiceImpl::buildTechAttribute )
				.collect(Collectors.toList());
	}

	private static WorkZoneDetails buildWeekDayObject(WorkZoneDetails workZoneDetails){ 
		if(workZoneDetails.getWeekDays()==null){
			return workZoneDetails; 
		}
		List<String> weekDays=		Arrays.asList(workZoneDetails.getWeekDays().split(","));
		if(!weekDays.isEmpty()){ 
			WeekDay weekDay = new WeekDay(); 
			weekDay.setWeekday(weekDays); 
			workZoneDetails.setWeekdays(weekDay); 
		} 
		return workZoneDetails; 
	} 
	

	private static TechAttribute buildTechAttribute(final Entry<Long, List<WorkZoneDetails>> entryMap){
		final Long seqNo = entryMap.getKey();
		final List<WorkZoneDetails> workZoneDetails =entryMap.getValue();
		return	new TechAttribute.Builder()
				.withSeqNo(seqNo)
				.withTechId(workZoneDetails.get(0).getTechId())		
				.withfileName(workZoneDetails.get(0).getFileName())
				.withWorkZoneDetails(workZoneDetails)
				.build();
	}


}
