package com.att.edge.backend.reorg.daoImpl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.function.Function;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.att.edge.backend.reorg.dao.TechScheduleDao;
import com.att.edge.backend.reorg.model.TechSchedule;
import static com.att.edge.backend.reorg.util.DateUtil.*;
import static com.att.edge.backend.reorg.util.ReOrgConstatns.BLANK;

/**
 * @author pradyumna.k.khadanga
 *
 */
@Repository
public class TechScheduleDaoImpl implements TechScheduleDao {

	int CONSTANT_TIME_LENGTH=7;
//+ "TO_NUMBER(24 * 60 * ABS (TO_DATE (TUNAV.SCHEDULE_TIME_END, 'hh24:mi:ss') - TO_DATE (TUNAV.SCHEDULE_TIME_START, 'hh24:mi:ss'))) unavailable_duration ,"

	private String sql="select TSCHED.SEQ_NO, TSCHED.PROCESS_STATUS, TSCHED.FILENAME, "
			+"CASE "
			+"WHEN upper(TSCHED.ACTION)= 'ADD' THEN 'ADD' "
			+"WHEN upper(TSCHED.ACTION)= 'UPDATE' THEN 'UPDATE' "
			+"WHEN upper(TSCHED.ACTION)= 'DELETE' THEN 'DELETE' "
			+"END AS ACTION , " 
			+ "TSCHED.TECH_TIME_ZONE, TSCHED.TECH_ID, TSCHED.SCHEDULE_TYPE, TSCHED.SCHEDULE_PROFILE, TO_CHAR (TO_DATE (TSCHED.SCHEDULE_DATE, 'yyyy/mm/dd hh24:mi:ss'),'yyyy-mm-dd') AS SCHEDULE_DATE, TSCHED.SCHEDULE_TIME_START, TSCHED.SCHEDULE_TIME_END, TSCHED.LUNCH_TIME_START, TSCHED.LUNCH_DURATION, TSCHED.OVERTIME_TYPE, TSCHED.OVERTIME_DURATION, TSCHED.SIXTH_DAY_OT_INDICATOR, TSCHED.CREATED_DTTM,"
			+ "TO_NUMBER(24 * 60 * ABS (TO_DATE (TSCHED.SCHEDULE_TIME_END, 'hh24:mi:ss') - TO_DATE (TSCHED.SCHEDULE_TIME_START, 'hh24:mi:ss'))) callout_duration , TSCHED.CREATED_BY "
			+"FROM BULK_RM_TECH_SCHEDULES TSCHED inner JOIN ADMIN_BULK_UPLOAD_DETAILS ADMIN "
			+"on TSCHED.PROCESS_STATUS='uploaded' "
			+"AND TSCHED.FILEName= ADMIN.FILE_NAME "
			+"and  ADMIN.category = 'Resource Management' "
			+"and (admin.EFFECTIVE_DATE_TIME < sysdate or admin.EFFECTIVE_DATE_TIME is null)";
	//+"and trunc(admin.EFFECTIVE_DATE_TIME)=trunc(sysdate)";


	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.jdbcTemplate.setDataSource(dataSource);
	}

	@Override
	public List<TechSchedule> getTechSchudulesByProcessStatus(String status) {
		return jdbcTemplate.query(sql, (rs, row) -> {
			TechSchedule techSchedule = new TechSchedule();				
			Function<String,String> addZeroAtFront = time->{
				if(time==null ||  BLANK.equals(time.trim()))
					return null;
				int scheduleTimeStartIndex=time.length();
				if(scheduleTimeStartIndex==CONSTANT_TIME_LENGTH){
					time="0"+time;
				}
				return time;
			};
		
			techSchedule.setSeqNo(convertStringToLong(rs.getString("SEQ_NO")));
			techSchedule.setScheduleAction(rs.getString("ACTION"));
			techSchedule.setTechId(rs.getString("TECH_ID"));
			techSchedule.setStartDate( rs.getString("SCHEDULE_DATE"));
			techSchedule.setStartTime(addZeroAtFront.apply(rs.getString("SCHEDULE_TIME_START")));
			techSchedule.setEndTime(addZeroAtFront.apply(rs.getString("SCHEDULE_TIME_END")));
			techSchedule.setLunchStartTime(addZeroAtFront.apply(rs.getString("LUNCH_TIME_START")));
			techSchedule.setLunchDuration(convertStringToLong(rs.getString("LUNCH_DURATION")));
			techSchedule.setScheduleType(rs.getString("SCHEDULE_TYPE"));
			techSchedule.setOvertimeAction(rs.getString("ACTION"));
			techSchedule.setOvertimeDuration(convertStringToLong(rs.getString("OVERTIME_DURATION")));
			techSchedule.setOvertimeType(rs.getString("OVERTIME_TYPE"));
			techSchedule.setCallOutProfile(rs.getString("SCHEDULE_PROFILE"));	
			techSchedule.setSixOTIndicator(rs.getString("SIXTH_DAY_OT_INDICATOR"));
			techSchedule.setTechTimeZone(rs.getString("TECH_TIME_ZONE"));
			techSchedule.setFileName(rs.getString("FILENAME"));
			techSchedule.setCallOutDuration(String.valueOf(rs.getInt("CALLOUT_DURATION")));
			return techSchedule;
		});
	}
	//no seq no present
	@Transactional
	public int[] batchUpdate(final List<TechSchedule> techSchedule) {
		int[] updateCounts = jdbcTemplate.batchUpdate(
				"update BULK_RM_TECH_SCHEDULES set process_status = 'Processed' where SEQ_NO = ?",
				new BatchPreparedStatementSetter() {
					public void setValues(PreparedStatement ps, int i) throws SQLException {	                      
						ps.setLong(1, techSchedule.get(i).getSeqNo());
					}

					public int getBatchSize() {
						return techSchedule.size();
					}
				} );
		return updateCounts;
	}
}
