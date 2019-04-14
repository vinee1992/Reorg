package com.att.edge.backend.reorg.daoImpl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.att.edge.backend.reorg.dao.TechnicianPoolerDao;
import com.att.edge.backend.reorg.model.TechDetails;
import static com.att.edge.backend.reorg.util.DateUtil.*;
/**
 * @author pradyumna.k.khadanga
 *
 */
@Repository
public class TechnicianPoolerDaoImpl implements TechnicianPoolerDao{
	//@Value("${technician.select}")
	private String sql="select   TECH.PROCESS_STATUS,"
			+" CASE "
			+"WHEN upper(TECH.ACTION)= 'ADD' THEN  'CREATE' "
			+"WHEN upper(TECH.ACTION)= 'UPDATE' THEN 'UPDATE' "
			+"WHEN upper(TECH.ACTION)= 'DELETE' THEN 'DELETE' "
			+"END AS ACTION, " 
			+ "TECH.RESOURCE_NAME, TECH.TECHID, TECH.PARENT_RESOURCE, REF.NAME AS RESOURCE_TYPE, TECH.ORGANIZATION, TECH.TIME_ZONE, TECH.TIME_FORMAT, TECH.DATE_FORMAT, TECH.LANGUAGE, TECH.PHONE_NUMBER, TECH.EMAIL_ADDRESS, TECH.GARAGE_ID, upper(TECH.STATUS) AS STATUS, TECH.LOAD_TYPE, TECH.PROFILE, TECH.EC, TECH.TECH_TYPE, TECH.CREW, TECH.SUPERVISOR_ATTUID, TECH.REGION, TECH.CENTER, TECH.LOANED_STATE, TECH.LOANED_CNTER, TECH.MOVE_EFFECTIVE_DATE, TECH.DURATION_STATS_INITIAL_PERIOD, TECH.DURATION_STATS_INITIAL_RATIO, TECH.CREATED_DTTM, TECH.SEQ_NO, TECH.CUID, TECH.FILENAME,TECH.CREATED_BY , TECH.USER_TYPE, "
			+"get_resource_id (TECH.PARENT_RESOURCE) AS PARENT_RESOURCE_ID "
			+"FROM BULK_RM_TECHNICIAN TECH "
			+ "Inner JOIN "
			+ "ADMIN_WO_REFERENCE_DATA ref "
			+ "ON TECH.resource_type=ref.DISPLAY_VALUE "
			+ "inner JOIN ADMIN_BULK_UPLOAD_DETAILS ADMIN "
			+"on TECH.PROCESS_STATUS='uploaded' "
			+"AND TECH.FILEName= ADMIN.FILE_NAME "
			+"and  ADMIN.category = 'Resource Management' "
			+"and ADMIN.TEMPLATE_TYPE='Technician' "
			 +"and (admin.EFFECTIVE_DATE_TIME < sysdate or admin.EFFECTIVE_DATE_TIME is null)";	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		 this.jdbcTemplate.setDataSource(dataSource);
	}

	public List<TechDetails> getTechAttributeByStatus(String processStatus) {
		
		return jdbcTemplate.query(sql, (rs,row)->{			
			
			TechDetails techDetails = new TechDetails();
			techDetails.setSeqNo(rs.getLong("SEQ_NO"));
			techDetails.setTechId(rs.getString("TECHID"));
			techDetails.setLanguage(rs.getString("LANGUAGE"));
			techDetails.setPhone(rs.getString("PHONE_NUMBER"));
			techDetails.setTimeZone( rs.getString("TIME_ZONE"));
			techDetails.setParentResourceId( rs.getString("PARENT_RESOURCE_ID"));
			techDetails.setResourceType( rs.getString("RESOURCE_TYPE"));
			//techDetails.setPhoneNumber( rs.getString("PHONE_NUMBER"));
			techDetails.setName(rs.getString("RESOURCE_NAME"));
			

			techDetails.setTechAction(rs.getString("ACTION"));
			techDetails.setMoveEffectiveDate(convertStringToDate(rs.getString("MOVE_EFFECTIVE_DATE")));
			
			techDetails.setEmail(rs.getString("EMAIL_ADDRESS"));
			techDetails.setTechType(rs.getString("TECH_TYPE"));
			techDetails.setSupervisiorId(rs.getString("SUPERVISOR_ATTUID"));
			techDetails.setTimeFormat(rs.getString("TIME_FORMAT"));
			techDetails.setStatus(rs.getString("STATUS"));
			techDetails.setDateFormat(rs.getString("DATE_FORMAT"));
			techDetails.setCrew(rs.getString("CREW"));
			techDetails.setCuid(rs.getString("CUID"));
			techDetails.setGarageId(rs.getString("GARAGE_ID"));
			techDetails.setLoadType(rs.getString("LOAD_TYPE"));
			techDetails.setOrganization(rs.getString("ORGANIZATION"));
			techDetails.setProfile(rs.getString("PROFILE"));
			techDetails.setRegion(rs.getString("REGION"));
			techDetails.setCenter(rs.getString("CENTER"));
			techDetails.setLoanedCenter(rs.getString("LOANED_CNTER"));
			techDetails.setLoanedState(rs.getString("LOANED_STATE"));
			techDetails.setDurationStatisticsInitialPeriod(rs.getString("DURATION_STATS_INITIAL_PERIOD"));
			techDetails.setDurationStatisticsInitialRatio(rs.getString("DURATION_STATS_INITIAL_RATIO"));
			techDetails.setUserType(rs.getString("USER_TYPE"));
			techDetails.setFileName(rs.getString("FILENAME"));
			
			
			
			
			
			
			return techDetails;
		});
	}
	
	

	@Transactional
	 public int[] batchUpdate(final List<TechDetails> techDetails) {
	        int[] updateCounts = jdbcTemplate.batchUpdate(
	                "update BULK_RM_TECHNICIAN set process_status = 'Processed' where SEQ_NO = ?",
	                new BatchPreparedStatementSetter() {
	                    public void setValues(PreparedStatement ps, int i) throws SQLException {	                      
	                        ps.setLong(1, techDetails.get(i).getSeqNo());
	                    }

	                    public int getBatchSize() {
	                        return techDetails.size();
	                    }
	                } );
	        return updateCounts;
	    }
}
