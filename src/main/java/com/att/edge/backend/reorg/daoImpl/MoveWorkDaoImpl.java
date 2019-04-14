package com.att.edge.backend.reorg.daoImpl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.att.edge.backend.reorg.dao.MoveWorkDao;
import com.att.edge.backend.reorg.model.MoveWork;
/**
 * @author pradyumna.k.khadanga
 *
 */
@Repository
public class MoveWorkDaoImpl implements MoveWorkDao{
	private String sql;

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		 this.jdbcTemplate.setDataSource(dataSource);
	}


	@Override
	public List<MoveWork> getMoveWorkByProcessStatus(String status) {
		return jdbcTemplate.query(sql, (rs,row)->{
			MoveWork moveWork = new MoveWork();
			moveWork.setAction(rs.getString("ACTION"));
			moveWork.setCreatedDTTMDate(rs.getString("CREATED_DTTM DATE"));
			moveWork.setFilename(rs.getString("FILENAME"));
			moveWork.setFromWorkZone(rs.getString("FROM_WORK_ZONE"));
			moveWork.setProcessedDTTM(rs.getString("PROCESSED_DTTM"));
			moveWork.setProcessStatus(rs.getString("PROCESS_STATUS"));
			moveWork.setProcessStatusReason(rs.getString("PROCESS_STATUS_REASON"));
			moveWork.setSeqno(rs.getString("SEQ_NO"));
			moveWork.setToWorkZone(rs.getString("TO_WORK_ZONE "));
			
					return moveWork;
		});
	}

}
