package com.att.edge.backend.reorg.daoImpl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.att.edge.backend.reorg.dao.TechUnavailibilityDao;
import com.att.edge.backend.reorg.model.UnavailableDetails;

/**
 * @author pradyumna.k.khadanga
 *
 */
@Repository
public class TechUnavailibilityDaoImpl implements TechUnavailibilityDao {
	private String sql="select TUNAV.SEQ_NO, TUNAV.PROCESS_STATUS, TUNAV.TECH_ID, TUNAV.SCHEDULE_TYPE,  TO_CHAR ( TO_DATE (TUNAV.SCHEDULE_DATE, 'yyyy/mm/dd hh24:mi:ss'),'yyyy-mm-dd') SCHEDULE_DATE, TUNAV.SCHEDULE_TIME_START, TUNAV.SCHEDULE_TIME_END, TUNAV.CREATED_DTTM, TUNAV.FILENAME, TUNAV.tech_id, "
			//+" null as activity_id , "
			+ " TUNAV.activity_id, "
			+ "TUNAV.SCHEDULE_DATE, "
			+ "TO_NUMBER(24 * 60 * ABS (TO_DATE (TUNAV.SCHEDULE_TIME_END, 'hh24:mi:ss') - TO_DATE (TUNAV.SCHEDULE_TIME_START, 'hh24:mi:ss'))) unavailable_duration ,"		
			+"CASE "
			+"WHEN upper(TUNAV.ACTION)= 'ADD' THEN 'ADD' "
			+"WHEN upper(TUNAV.ACTION)= 'UPDATE' THEN 'UPDATE' "
			+"WHEN upper(TUNAV.ACTION)= 'DELETE' THEN 'DELETE' "
			+"END AS ACTION, "
			+ "TUNAV.CREATED_BY "
+"FROM BULK_RM_TECH_UNAVAILABLE TUNAV inner JOIN ADMIN_BULK_UPLOAD_DETAILS ADMIN "
+"on TUNAV.PROCESS_STATUS='uploaded' "
+"AND TUNAV.FILEName= ADMIN.FILE_NAME "
+"and ADMIN.category = 'Resource Management' "
+"and ADMIN.TEMPLATE_TYPE='Technician Unavailable' ";
/*+"LEFT OUTER JOIN tech_activities ta   ON TUNAV.tech_id = ta.tech_id "
+ " AND TRUNC (ta.schedule_date) ="
+ "TRUNC (TO_DATE (TUNAV.schedule_date, 'yyyy/mm/dd hh24:mi:ss')) "
+ "AND TO_CHAR (ta.planned_start_dttm, 'hh24:mi:ss') = TUNAV.SCHEDULE_TIME_START  "
+ "AND TO_CHAR (ta.planned_end_dttm, 'hh24:mi:ss') =  TUNAV.SCHEDULE_TIME_END ";*/
/*+"and trunc(admin.EFFECTIVE_DATE_TIME)=trunc(sysdate)";*/

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.jdbcTemplate.setDataSource(dataSource);
	}

	public List<UnavailableDetails> getTechUnavailibilitiesByProcessStatus(String status) {
		return jdbcTemplate.query(sql, (rs, row) -> {

			UnavailableDetails unavailableDetail = new UnavailableDetails();
			unavailableDetail.setUnavailableAction(rs.getString("ACTION"));
			unavailableDetail.setSeqnO(rs.getLong("SEQ_NO"));	
			unavailableDetail.setTechId(rs.getString("TECH_ID"));
			unavailableDetail.setUnavailableStartTime(rs.getString("SCHEDULE_TIME_START"));
			unavailableDetail.setTimeType(rs.getString("SCHEDULE_TYPE"));
			unavailableDetail.setFileName(rs.getString("FILENAME"));
			unavailableDetail.setScheduleDate(rs.getString("SCHEDULE_DATE"));
			unavailableDetail.setUnavailableDuration(String.valueOf(rs.getInt("unavailable_duration")));
			unavailableDetail.setActivityId(rs.getString("ACTIVITY_ID"));
			
			return unavailableDetail;
		});
	}
	
	@Transactional
	 public int[] batchUpdate(final List<UnavailableDetails> unavailableDetails) {
	        int[] updateCounts = jdbcTemplate.batchUpdate(
	                "update BULK_RM_TECH_UNAVAILABLE set process_status = 'Processed' where SEQ_NO = ?",
	                new BatchPreparedStatementSetter() {
	                    public void setValues(PreparedStatement ps, int i) throws SQLException {	                      
	                        ps.setLong(1, unavailableDetails.get(i).getSeqnO());
	                    }

	                    public int getBatchSize() {
	                        return unavailableDetails.size();
	                    }
	                } );
	        return updateCounts;
	    }
	// TechSchedule or Unavailable?
	/*
	 * public int[] batchUpdate(final List<TechScheduleAttribute> techSchedule)
	 * { int[] updateCounts = jdbcTemplate.batchUpdate(
	 * "update BULK_RM_TECH_SKILLS set process_status = 'Processed' where SEQ_NO = ?"
	 * , new BatchPreparedStatementSetter() { public void
	 * setValues(PreparedStatement ps, int i) throws SQLException {
	 * ps.setLong(1, techSchedule.get(i).getSeqNo()); }
	 * 
	 * public int getBatchSize() { return techSchedule.size(); } } ); return
	 * updateCounts; }
	 */
}
