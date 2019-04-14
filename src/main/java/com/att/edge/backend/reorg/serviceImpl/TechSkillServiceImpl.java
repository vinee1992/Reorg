/**
 * 
 */
package com.att.edge.backend.reorg.serviceImpl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.att.edge.backend.reorg.dao.TechSkillsDao;
import com.att.edge.backend.reorg.model.SkillDetails;
import com.att.edge.backend.reorg.model.TechAttribute;
import com.att.edge.backend.reorg.service.TechSkillService;

/**
 * @author pradyumna.k.khadanga
 */
@Service("techSkillService")
public class TechSkillServiceImpl implements TechSkillService{
	@Autowired
	TechSkillsDao techSkillDao;
	

	@Override
	public List<TechAttribute> getTechSkillsByProcessStatus(String status) {


		List<SkillDetails>  skillDetails= techSkillDao.getTechSkillsByProcessStatus(status);
		Map<Long,List<SkillDetails>>	techLocationMap=skillDetails.stream()
				.filter(skillDetail->skillDetail.getTechId()!=null)
				.collect(Collectors.groupingBy(SkillDetails::getSeqNo));
		techSkillDao.batchUpdate(skillDetails) ;
		List<TechAttribute>	 techAttributes = techLocationMap.entrySet()
				.stream()
				.map(set-> new TechAttribute.Builder()
						.withSeqNo(set.getKey())
						.withTechId(set.getValue().get(0).getTechId())
						.withSkillDetails(set.getValue())
						.withfileName(set.getValue().get(0).getFileName())
						.build())
				.collect(Collectors.toList());

		return techAttributes;

	}

}
