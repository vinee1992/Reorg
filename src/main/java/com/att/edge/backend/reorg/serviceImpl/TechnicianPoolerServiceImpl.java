package com.att.edge.backend.reorg.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.att.edge.backend.reorg.dao.TechnicianPoolerDao;
import com.att.edge.backend.reorg.daoImpl.TechnicianPoolerDaoImpl;
import com.att.edge.backend.reorg.model.LocationDetails;
import com.att.edge.backend.reorg.model.TechAttribute;
import com.att.edge.backend.reorg.model.TechDetails;
import com.att.edge.backend.reorg.service.TechnicianPoolerService;

@Service("technicianPoolerService")
public class TechnicianPoolerServiceImpl implements TechnicianPoolerService{
	@Autowired
	TechnicianPoolerDao technicianPoolerDao;

	@Override
	public List<TechAttribute> getTechAttributeByStatus(String processStatus) {
		List<TechDetails> techDetails=new ArrayList<>();
		techDetails= technicianPoolerDao.getTechAttributeByStatus(null);
		Map<Long,TechDetails>	techDetailsMap=techDetails.stream()
				.filter(techDetail->techDetail.getSeqNo()!=null)
				.collect(Collectors.toMap(TechDetails::getSeqNo,Function.identity()));
		technicianPoolerDao.batchUpdate(techDetails);
		return	techDetailsMap.entrySet()
				.stream()
				.map(set->new TechAttribute.Builder()
						.withSeqNo(set.getKey())
						.withTechId(set.getValue().getTechId())							
						.withTechDetails(set.getValue())
						.withfileName(set.getValue().getFileName())
						.build())
				.collect(Collectors.toList());

	}

}
