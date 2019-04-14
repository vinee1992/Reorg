package com.att.edge.backend.reorg.daoImpl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.att.edge.backend.reorg.dao.ResourceLocationDao;
import com.att.edge.backend.reorg.model.LocationDetails;
import com.att.edge.backend.reorg.model.ResourceLocation;
import com.att.edge.backend.reorg.model.SkillDetails;
import com.att.edge.backend.reorg.model.TechLocationDetail;
import com.att.edge.backend.reorg.model.TechScheduleAttribute;

/**
 * @author pradyumna.k.khadanga
 *
 */
@Repository
public class ResourceLocationDaoImpl implements ResourceLocationDao {
/*	private String sql = "select " + "CASE " + "WHEN upper(LOC.ACTION)= 'ADD' THEN"
			+ "  'CREATE' "
			+ "WHEN upper(LOC.ACTION)= 'UPDATE' THEN 'UPDATE' " + "WHEN upper(LOC.ACTION)= 'DELETE' THEN 'DELETE' "
			+ "END AS ACTION, "
			+ "LOC.SEQ_NO, LOC.PROCESS_STATUS, LOC.FILENAME,get_resource_id(LOC.RESOURCEID) as resourceid, LOC.LOCATION_NAME, LOC.LOCATION_STATUS, get_location_from_resource(LOC.RESOURCEID,LOC.LOCATION_NAME) AS LOCATION_ID, LOC.RESOURCE_TYPE, LOC.ADDRESS, LOC.CITY, LOC.STATE, LOC.ZIP_CODE, LOC.LATITUDE, LOC.LONGITUDE, LOC.CREATED_DTTM, LOC.CREATED_BY, LOC.COUNTRY , 'Y' as IS_TECH  "
			+ "FROM BULK_RM_LOCATIONS LOC inner JOIN ADMIN_BULK_UPLOAD_DETAILS ADMIN "
			+ "on LOC.PROCESS_STATUS='uploaded' " + "AND LOC.FILEName= ADMIN.FILE_NAME "
			+ "and  ADMIN.category = 'Resource Management' " + "and ADMIN.TEMPLATE_TYPE='Locations' "
			+ "and (admin.EFFECTIVE_DATE_TIME < sysdate or admin.EFFECTIVE_DATE_TIME is null)";*/
	
	private String sql = "SELECT CASE "+
			"WHEN UPPER (LOC.ACTION) = 'ADD' THEN "+ 
			"case when LOC.IS_TECH='Y' then 'CREATE_LOCATION' "+
			"ELSE 'CREATE' "+
			"end "+
			"WHEN UPPER (LOC.ACTION) = 'UPDATE' THEN "+
			"case when LOC.IS_TECH='Y' then 'UPDATE_LOCATION' "+
			" else 'UPDATE' "+
			"end "+
			"WHEN UPPER (LOC.ACTION) = 'DELETE' THEN "+ 
			"case when LOC.IS_TECH='Y' then 'DELETE_LOCATION' "+
			"else 'DELETE' "+
			"end "+
			" END "+
			"AS ACTION, "+
			"LOC.SEQ_NO, "+
			"LOC.PROCESS_STATUS, "+
			"LOC.FILENAME, "+
			"get_resource_id (LOC.RESOURCEID) AS resourceid, "+
			"LOC.LOCATION_NAME, " +
			"LOC.LOCATION_STATUS, "+
			 "CASE "+
			"WHEN LOC.IS_TECH= 'N' THEN "+
			"get_location_from_resource(LOC.RESOURCEID, LOC.LOCATION_NAME) "+
			"ELSE "+
			 "LOC.LOCATION_ID "+
		//	"get_location_from_tech(LOC.RESOURCEID, LOC.LOCATION_NAME) " +			
			"END "+
			"AS LOCATION_ID, "+
			"LOC.RESOURCE_TYPE, "+ 
			"LOC.ADDRESS, "+
			"LOC.CITY, "+
			"LOC.STATE, "+
			"LOC.ZIP_CODE, "+
			"LOC.LATITUDE, "+
			"LOC.LONGITUDE, "+
			"LOC.CREATED_DTTM, "+
			"LOC.CREATED_BY, "+
			"LOC.COUNTRY, "+
			"LOC.IS_TECH "+
			"FROM   BULK_RM_LOCATIONS LOC "+
			"INNER JOIN "+
			"ADMIN_BULK_UPLOAD_DETAILS ADMIN "+
			"ON     LOC.PROCESS_STATUS = 'uploaded' "+
			"AND LOC.FILEName = ADMIN.FILE_NAME "+
			"AND ADMIN.category = 'Resource Management' "+
			"AND ADMIN.TEMPLATE_TYPE = 'Locations' "+
			"AND (admin.EFFECTIVE_DATE_TIME < SYSDATE "+
			"OR admin.EFFECTIVE_DATE_TIME IS NULL) ";
	
/*	+"CASE "
	+" WHEN UPPER (WRKZ.ACTION) = 'ADD' THEN 'CREATE' "
	+" WHEN UPPER (WRKZ.ACTION) = 'UPDATE' THEN 'UPDATE' "
	+"WHEN UPPER (WRKZ.ACTION) = 'DELETE' THEN 'DELETE' "
	+"END "
	+" AS ACTION, 
*/	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.jdbcTemplate.setDataSource(dataSource);
		
		
		
	}

	@Override
	public List<TechLocationDetail> getResourceLocationByProcessStatus(String status) {

		return jdbcTemplate.query(sql, (rs, row) -> {
			TechLocationDetail techLocationDetails = new TechLocationDetail();

			LocationDetails locationDetails=null;
			ResourceLocation resourceLocation=null;
			List<LocationDetails> locationDetailList= new ArrayList<>();

			//String isTech=rs.getString("IS_TECH");
			
			techLocationDetails.setSeqNo(rs.getLong("SEQ_NO"));
			techLocationDetails.setIsTech(rs.getString("IS_TECH"));
			techLocationDetails.setFileName(rs.getString("FILENAME"));

			if("Y".equalsIgnoreCase(rs.getString("IS_TECH"))){
				techLocationDetails.setTechId(rs.getString("RESOURCEID"));
				 locationDetails =new LocationDetails();
				locationDetails.setLocationAction(rs.getString("ACTION"));
				locationDetails.setLocationName(rs.getString("LOCATION_NAME"));
				locationDetails.setAddress(rs.getString("ADDRESS"));
				locationDetails.setCity(rs.getString("CITY"));
				locationDetails.setLatitude(rs.getString("LATITUDE"));
				locationDetails.setLongitude(rs.getString("LONGITUDE"));
				locationDetails.setPostalCode(rs.getString("ZIP_CODE"));
				locationDetails.setState(rs.getString("STATE"));
				locationDetails.setLocationInternalId(rs.getString("LOCATION_ID"));
				locationDetailList.add(locationDetails);
				techLocationDetails.setLocationDetails(locationDetailList);
			}else{
				techLocationDetails.setResourceId(rs.getString("RESOURCEID"));
				 resourceLocation=new ResourceLocation();
				resourceLocation.setResourceId(rs.getString("RESOURCEID"));
				resourceLocation.setAction(rs.getString("ACTION"));
				resourceLocation.setAddress(rs.getString("ADDRESS"));
				// resourceLocation.setAttuid("PK4809");
				resourceLocation.setCity(rs.getString("CITY"));
				resourceLocation.setPostalCode(rs.getString("ZIP_CODE"));
				resourceLocation.setState(rs.getString("STATE"));
				resourceLocation.setStatus(rs.getString("PROCESS_STATUS"));
				resourceLocation.setCountry(rs.getString("COUNTRY"));
				resourceLocation.setLocationName(rs.getString("LOCATION_NAME"));
				resourceLocation.setLatitude(rs.getString("LATITUDE"));
				resourceLocation.setLongitude(rs.getString("LONGITUDE"));
				resourceLocation.setLocationId(rs.getString("LOCATION_ID"));
				resourceLocation.setLocationStatus(rs.getString("LOCATION_STATUS"));
				resourceLocation.setIsTech(rs.getString("IS_TECH"));
				techLocationDetails.setResourceLocations(resourceLocation);
			}
			
			
			
			
			return techLocationDetails;
		});


	}

	@Transactional
	public int[] batchUpdate(final List<ResourceLocation> resourceLocation) {
		int[] updateCounts = jdbcTemplate.batchUpdate(
				"update BULK_RM_LOCATIONS set process_status = 'Processed' where SEQ_NO = ?",
				new BatchPreparedStatementSetter() {
					public void setValues(PreparedStatement ps, int i) throws SQLException {

						ps.setLong(1, resourceLocation.get(i).getSeqNo());
					}

					public int getBatchSize() {
						return resourceLocation.size();
					}
				});
		return updateCounts;
	}

}
