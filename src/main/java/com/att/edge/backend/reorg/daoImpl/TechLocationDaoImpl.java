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

import com.att.edge.backend.reorg.dao.TechLocationDao;
import com.att.edge.backend.reorg.model.TechLocation;

/**
 * @author pradyumna.k.khadanga
 *
 */
@Repository
public class TechLocationDaoImpl implements TechLocationDao {
	//@Value("${techLocation.select}")
	
/*	+" CASE "
	+"WHEN upper(TECH.ACTION)= 'ADD' THEN  'CREATE' "
	+"WHEN upper(TECH.ACTION)= 'UPDATE' THEN 'UPDATE' "
	+"WHEN upper(TECH.ACTION)= 'DELETE' THEN 'DELETE' "
	+"END AS ACTION, " */
	private String sql="SELECT BLKLOC.SEQ_NO ,BLKLOC.RESOURCE_ID,BLKLOC.FILENAME,  " 
			+"BLKLOC.ACTION, "
/*			+" CASE "
			+"WHEN upper(BLKLOC.ACTION)= 'ADD' THEN  'SET_LOCATIONS' "
			+"WHEN upper(BLKLOC.ACTION)= 'UPDATE' THEN 'SET_LOCATIONS' "
			+"WHEN upper(BLKLOC.ACTION)= 'DELETE' THEN 'DELETE' "
			+"END AS ACTION , "*/
			+"get_location_id(RESOURCE_ID,SUNDAY_START_LOCATION) AS SUNDAY_START_LOCATION_ID, "
			+"get_location_id(RESOURCE_ID,SUNDAY_END_LOCATION) AS SUNDAY_END_LOCATION_ID, "
			+"get_location_id(RESOURCE_ID,SUNDAY_HOME_ZONE_CENTER_LOCATI) AS SUNDAY_HOME_ZONE_CENTER_LOCATI, "
			+"get_location_id(RESOURCE_ID,MONDAY_START_LOCATION) AS MONDAY_START_LOCATION_ID, "
			+"get_location_id(RESOURCE_ID,MONDAY_END_LOCATION) AS MONDAY_END_LOCATION_ID, "
			+"get_location_id(RESOURCE_ID,MONDAY_HOME_ZONE_CENTER_LOCATI) AS MONDAY_HOME_ZONE_CENTER_LOCATI, "
			+"get_location_id(RESOURCE_ID,TUESDAY_START_LOCATION) AS TUESDAY_START_LOCATION_ID, "
			+"get_location_id(RESOURCE_ID,TUESDAY_END_LOCATION) AS TUESDAY_END_LOCATION_ID, "
			+"get_location_id(RESOURCE_ID,TUESDAY_HOME_ZONE_CENTER_LOCAT) AS TUESDAY_HOME_ZONE_CENTER_LOCAT, "
			+"get_location_id(RESOURCE_ID,WEDNESDAY_START_LOCATION) AS WEDNESDAY_START_LOCATION_ID, "
			+"get_location_id(RESOURCE_ID,WEDNESDAY_END_LOCATION) AS WEDNESDAY_END_LOCATION_ID, "
			+"get_location_id(RESOURCE_ID,WEDNESDAY_HOME_ZONE_CENTER_LOC) AS WEDNESDAY_HOME_ZONE_CENTER_LOC, "
			+"get_location_id(RESOURCE_ID,THURSDAY_START_LOCATION) AS THURSDAY_START_LOCATION_ID, " 
			+"get_location_id(RESOURCE_ID,THURSDAY_END_LOCATION) AS THURSDAY_END_LOCATION_ID, "
			+"get_location_id(RESOURCE_ID,THURSDAY_HOME_ZONE_CENTER_LOCA) AS THURSDAY_HOME_ZONE_CENTER_LOCA, "
			+"get_location_id(RESOURCE_ID,FRIDAY_START_LOCATION) AS FRIDAY_START_LOCATION_ID, "
			+"get_location_id(RESOURCE_ID,FRIDAY_END_LOCATION) AS FRIDAY_END_LOCATION_ID, "
			+"get_location_id(RESOURCE_ID,FRIDAY_HOME_ZONE_CENTER_LOCATI) AS FRIDAY_HOME_ZONE_CENTER_LOCATI, "
			+"get_location_id(RESOURCE_ID,SATURDAY_START_LOCATION) AS SATURDAY_START_LOCATION_ID, "
			+"get_location_id(RESOURCE_ID,SATURDAY_END_LOCATION) AS SATURDAY_END_LOCATION_ID, "
			+"get_location_id(RESOURCE_ID,SATURDAY_HOME_ZONE_CENTER_LOCA) AS SATURDAY_HOME_ZONE_CENTER_LOCA "
			+"FROM BULK_RM_TECH_LOCATIONS BLKLOC inner JOIN ADMIN_BULK_UPLOAD_DETAILS ADMIN " 
			+"on BLKLOC.PROCESS_STATUS='uploaded' AND BLKLOC.FILEName= ADMIN.FILE_NAME "
			+"and  ADMIN.category = 'Resource Management'  and ADMIN.TEMPLATE_TYPE='Technician Locations' "
			  +"and (admin.EFFECTIVE_DATE_TIME < sysdate or admin.EFFECTIVE_DATE_TIME is null)";
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.jdbcTemplate.setDataSource(dataSource);
	}

	@Override
	public List<TechLocation> getTechLocationsByProcessStatus(String status) {
		return jdbcTemplate.query(sql, (rs, row) -> {
			TechLocation techLocation = new TechLocation();
			
			techLocation.setSeqno(rs.getLong("SEQ_NO"));
			techLocation.setResourceId(rs.getString("RESOURCE_ID"));
			techLocation.setAction(rs.getString("ACTION"));
			techLocation.setMondayEndLocation(rs.getString("MONDAY_END_LOCATION_ID"));
			techLocation.setMondayStartLocation(rs.getString("MONDAY_START_LOCATION_ID"));
			techLocation.setMondayHomeZoneCenterLocation(rs.getString("MONDAY_HOME_ZONE_CENTER_LOCATI"));
			techLocation.setTuesdayEndLocation(rs.getString("TUESDAY_END_LOCATION_ID"));
			techLocation.setTuesdayStartLocation(rs.getString("TUESDAY_START_LOCATION_ID"));
			techLocation.setTuesdayHomeZoneCenterLocation(rs.getString("TUESDAY_HOME_ZONE_CENTER_LOCAT"));
			techLocation.setWednesdayEndLocation(rs.getString("WEDNESDAY_END_LOCATION_ID"));
			techLocation.setWednesdayStartLocation(rs.getString("WEDNESDAY_START_LOCATION_ID"));
			techLocation.setWednesdayHomeZoneCenterLocation(rs.getString("WEDNESDAY_HOME_ZONE_CENTER_LOC"));
			techLocation.setThursdayEndLocation(rs.getString("THURSDAY_END_LOCATION_ID"));
			techLocation.setThursdayStartLocation(rs.getString("THURSDAY_START_LOCATION_ID"));
			techLocation.setThursdayHomeZoneCenterLocation(rs.getString("THURSDAY_HOME_ZONE_CENTER_LOCA"));
			techLocation.setFridayEndLocation(rs.getString("FRIDAY_END_LOCATION_ID"));
			techLocation.setFridayStartLocation(rs.getString("FRIDAY_START_LOCATION_ID"));	
			techLocation.setFridayHomeZoneCenterLocation(rs.getString("FRIDAY_HOME_ZONE_CENTER_LOCATI"));
			techLocation.setSaturdayEndLocation(rs.getString("SATURDAY_END_LOCATION_ID"));
			techLocation.setSaturdayStartLocation(rs.getString("SATURDAY_START_LOCATION_ID"));
			techLocation.setSaturdayHomeZoneCenterLocation(rs.getString("SATURDAY_HOME_ZONE_CENTER_LOCA"));
			techLocation.setSundayEndLocation(rs.getString("SUNDAY_END_LOCATION_ID"));
			techLocation.setSundayStartLocation(rs.getString("SUNDAY_START_LOCATION_id"));
			techLocation.setSundayHomeZoneCenterLocation(rs.getString("SUNDAY_HOME_ZONE_CENTER_LOCATI"));
			techLocation.setFileName(rs.getString("FILENAME"));
			
			return techLocation;
		});
	}
	@Transactional
	public int[] batchUpdate(final List<TechLocation> techLocation) {
		int[] updateCounts = jdbcTemplate.batchUpdate(
				"update BULK_RM_TECH_LOCATIONS set process_status = 'Processed' where SEQ_NO = ?",
				new BatchPreparedStatementSetter() {
					public void setValues(PreparedStatement ps, int i) throws SQLException {
						ps.setLong(1, techLocation.get(i).getSeqno());
					}

					public int getBatchSize() {
						return techLocation.size();
					}
				});
		return updateCounts;
	}
}
