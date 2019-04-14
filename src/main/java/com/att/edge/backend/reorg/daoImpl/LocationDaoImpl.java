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

import com.att.edge.backend.reorg.dao.LocationDao;
import com.att.edge.backend.reorg.model.LocationDetails;
/**
 * @author pradyumna.k.khadanga
 *
 */
@Repository
public class LocationDaoImpl implements LocationDao{
	//@Value("${location.select}")

	private String sql = "select "
			+"CASE "
			+"WHEN upper(LOC.ACTION)= 'ADD' THEN  'CREATE' "
			+"WHEN upper(LOC.ACTION)= 'UPDATE' THEN 'UPDATE' "
			+"WHEN upper(LOC.ACTION)= 'DELETE' THEN 'DELETE' "
			+"END AS ACTION, " 
			+"LOC.SEQ_NO, LOC.PROCESS_STATUS, LOC.FILENAME, LOC.RESOURCEID, LOC.LOCATION_NAME, LOC.LOCATION_STATUS, LOC.LOCATION_ID, LOC.RESOURCE_TYPE, LOC.ADDRESS, LOC.CITY, LOC.STATE, LOC.ZIP_CODE, LOC.LATITUDE, LOC.LONGITUDE, LOC.CREATED_DTTM, LOC.CREATED_BY, LOC.COUNTRY  "
			+"FROM BULK_RM_LOCATIONS LOC inner JOIN ADMIN_BULK_UPLOAD_DETAILS ADMIN "
			+"on LOC.PROCESS_STATUS='uploaded' "
			+"AND LOC.FILEName= ADMIN.FILE_NAME "
			+"and  ADMIN.category = 'Resource Management' "
			+"and ADMIN.TEMPLATE_TYPE='Locations' "
			+"and trunc(admin.EFFECTIVE_DATE_TIME)=trunc(sysdate)";

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		 this.jdbcTemplate.setDataSource(dataSource);
	}
	

	@Override
	public List<LocationDetails> getLocationsByProcessStatus(String status) {
		return jdbcTemplate.query(sql, (rs,row)->{	
			LocationDetails locationDetails= new LocationDetails();
			locationDetails.setSeqNo(rs.getLong("SEQ_NO"));
			locationDetails.setTechId(rs.getString("RESOURCEID"));
			locationDetails.setAddress("ADDRESS");
			locationDetails.setCity(rs.getString("CITY"));
			locationDetails.setLocationAction(rs.getString("ACTION"));
			locationDetails.setLocationName(rs.getString("LOCATION_NAME"));
			locationDetails.setPostalCode(rs.getString("ZIP_CODE"));
			locationDetails.setState(rs.getString("STATE"));
			locationDetails.setStatus(rs.getString("PROCESS_STATUS"));		
			locationDetails.setCountry(rs.getString("COUNTRY"));
			return locationDetails;
			
		});
	}
	
	
	@Transactional
	 public int[] batchUpdate(final List<LocationDetails> locationDetails) {
	        int[] updateCounts = jdbcTemplate.batchUpdate(
	                "update BULK_RM_LOCATIONS set process_status = 'Processed' where SEQ_NO = ?",
	                new BatchPreparedStatementSetter() {
	                    public void setValues(PreparedStatement ps, int i) throws SQLException {	                      
	                        ps.setLong(1, locationDetails.get(i).getSeqNo());
	                    }

	                    public int getBatchSize() {
	                        return locationDetails.size();
	                    }
	                } );
	        return updateCounts;
	    }
}
