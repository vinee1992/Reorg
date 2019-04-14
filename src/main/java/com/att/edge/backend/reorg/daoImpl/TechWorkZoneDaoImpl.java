package com.att.edge.backend.reorg.daoImpl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.att.edge.backend.reorg.dao.TechWorkZoneDao;
import com.att.edge.backend.reorg.model.WorkZoneDetails;
import static com.att.edge.backend.reorg.util.DateUtil.*;
/**
 * @author pradyumna.k.khadanga
 *
 */
@Repository
public class TechWorkZoneDaoImpl implements TechWorkZoneDao {
	private static String sql = "SELECT   TWRK.SEQ_NO, "
			+" TWRK.PROCESS_STATUS, " 
			+"TWRK.FILENAME, " 
			+" CASE "
			+"  WHEN UPPER (TWRK.ACTION) = 'ADD' THEN 'ADD' "
			+"  WHEN UPPER (TWRK.ACTION) = 'UPDATE' THEN 'UPDATE' "
			+"  WHEN UPPER (TWRK.ACTION) = 'DELETE' THEN 'DELETE' " 
			+" END "
			+"    AS ACTION, TWRK.WORK_ZONE_ID, TWRK.TECH_ID, TWRK.RECURRENCE, TWRK.WORK_ZONE,TO_CHAR (TO_DATE (TWRK.WORKZONE_START_DT, 'yyyy/mm/dd hh24:mi:ss'),  'yyyy-mm-dd') " 
			+"   AS WORKZONE_START_DT, "
			+"TO_CHAR (TO_DATE (TWRK.WORKZONE_END_DT, 'yyyy/mm/dd hh24:mi:ss'), 'yyyy-mm-dd') "
			+"   AS WORKZONE_END_DT, TWRK.WORK_WEIGHTING, TWRK.WORKZONE_TYPE, TWRK.DAYS_BETWEEN_OCCURRENCES,TWRK.CREATED_DTTM, TWRK.WORKZONE_ITEM_ID, TWRK.WORKZONE_RATIO, TWRK.CREATED_BY, TWRK.WEEKDAYS " 
			+"FROM      BULK_RM_TECH_WORKZONES TWRK " 
			+"   INNER JOIN "
			+"      ADMIN_BULK_UPLOAD_DETAILS ADMIN "
			+"  ON     TWRK.PROCESS_STATUS = 'uploaded' "
			+"  AND TWRK.FILEName = ADMIN.FILE_NAME "
			+"AND ADMIN.category = 'Resource Management' "
			+"AND ADMIN.TEMPLATE_TYPE = 'Technician Work Zones' " 
			+"  AND (admin.EFFECTIVE_DATE_TIME < SYSDATE "
			+"       OR admin.EFFECTIVE_DATE_TIME IS NULL) "
			/*+"   LEFT OUTER JOIN (SELECT   twz.resource_id, owz.work_zone_id,  work_zone_name,  owz.active, twz.seq_no AS Work_Zone_Internal_Id, twz.start_date,  twz.end_date, twz.WORK_ZONE_ITEM_ID " 
			+"FROM   ofsc_work_zone owz, tech_work_zones twz "
			+"WHERE   twz.work_zone_id = owz.work_zone_id) TW "
			+" ON TW.work_zone_name=TWRK.WORK_ZONE "
			+ "and TW.resource_id=TWRK.tech_id "*/;
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.jdbcTemplate.setDataSource(dataSource);
	}

	@Override
	public List<WorkZoneDetails> getTechWorkZoneByProcessStatus(String status) {
		return jdbcTemplate.query(sql, (rs, row) -> {
			WorkZoneDetails workZone = new WorkZoneDetails();
			//workZone.setAction(rs.getString("ACTION"));
			workZone.setTechId(rs.getString("TECH_ID"));
			workZone.setWorkZoneAction(rs.getString("ACTION"));
			workZone.setWorkZone(rs.getString("WORK_ZONE")); 
			workZone.setStartDate( rs.getString("WORKZONE_START_DT"));
			workZone.setEndDate( rs.getString("WORKZONE_END_DT"));
			workZone.setType(rs.getString("WORKZONE_TYPE"));
			workZone.setRecurrence(rs.getString("RECURRENCE"));
			workZone.setRatio(rs.getString("WORKZONE_RATIO"));
			workZone.setRecurEvery(convertStringToLong(rs.getString("DAYS_BETWEEN_OCCURRENCES")));
			workZone.setSeqno(rs.getLong("SEQ_NO"));
			workZone.setProcessStatus(rs.getString("PROCESS_STATUS"));
			workZone.setWorkZoneInternalId(rs.getString("WORK_ZONE_ID"));
			workZone.setWorkZoneItemId(rs.getString("WORKZONE_ITEM_ID"));
			workZone.setFileName(rs.getString("FILENAME"));
			workZone.setWeekDays(rs.getString("weekdays"));
			
			return workZone;
		});
	}
	  @Transactional
	  public int[] batchUpdate(final List<WorkZoneDetails> workZone) { int[]
	  updateCounts = jdbcTemplate.batchUpdate(
	  "update BULK_RM_TECH_WORKZONES set process_status = 'Processed' where SEQ_NO = ?"
	  , new BatchPreparedStatementSetter() { public void
	  setValues(PreparedStatement ps, int i) throws SQLException {
	  ps.setLong(1, workZone.get(i).getSeqno()); }
	  public int getBatchSize() { return workZone.size(); } } ); return
	  updateCounts; }
	 
}
