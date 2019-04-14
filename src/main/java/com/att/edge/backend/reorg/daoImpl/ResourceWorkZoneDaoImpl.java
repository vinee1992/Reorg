package com.att.edge.backend.reorg.daoImpl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.att.edge.backend.reorg.dao.ResourceWorkZoneDao;
import com.att.edge.backend.reorg.model.ResourceLocation;
import com.att.edge.backend.reorg.model.ResourceWorkZone;
import com.att.edge.backend.reorg.util.DateUtil;
/**
 * @author pradyumna.k.khadanga
 *
 */
@Repository
public class ResourceWorkZoneDaoImpl implements ResourceWorkZoneDao{
	private static String sql = "SELECT   WRKZ.SEQ_NO, " 
			+"WRKZ.PROCESS_STATUS, " 
			+ "WRKZ.FILENAME, "
			+"CASE "
			+" WHEN UPPER (WRKZ.ACTION) = 'ADD' THEN 'CREATE' "
			+" WHEN UPPER (WRKZ.ACTION) = 'UPDATE' THEN 'UPDATE' "
			+"WHEN UPPER (WRKZ.ACTION) = 'DELETE' THEN 'DELETE' "
			+"END "
			+" AS ACTION, "
			//+"TW.WORK_ZONE_ITEM_ID, "
			+ " WRKZ.WORK_ZONE_ITEM_ID, " 
			+" WRKZ.WORKZONE_SEQ_NO, "
			+"get_resource_id(WRKZ.RESOURCE_ID) as RESOURCE_ID, "
			+"WRKZ.RECURRENCE, "
			+"WRKZ.WORKZONE, "
			+"TO_CHAR (TO_DATE (WRKZ.WORKZONE_START_DT, 'yyyy/mm/dd hh24:mi:ss'),'yyyy-mm-dd')  AS WORKZONE_START_DT, "
			+"TO_CHAR (TO_DATE (WRKZ.WORKZONE_END_DT, 'yyyy/mm/dd hh24:mi:ss'),'yyyy-mm-dd') AS WORKZONE_END_DT, "
			+"WRKZ.WORK_WEIGHTING, "
			+"WRKZ.DAYS_BETWEEN_OCCURRENCES, "
			+"WRKZ.CREATED_DTTM, "
			+"WRKZ.WEEKDAYS, "
			+"WRKZ.CREATED_BY, "
			//+"TW.WORK_ZONE_ID "
			+" TW.WORK_ZONE_ID "
			+"FROM  BULK_RM_RSRC_WORKZONES WRKZ "
			+"INNER JOIN "
			+"ADMIN_BULK_UPLOAD_DETAILS ADMIN "
			+"ON     WRKZ.PROCESS_STATUS = 'uploaded' "
			+"AND WRKZ.FILEName = ADMIN.FILE_NAME "
			+"AND ADMIN.category = 'Resource Management' "
			+"AND ADMIN.TEMPLATE_TYPE = 'Resource Work Zones' "
			+"AND (admin.EFFECTIVE_DATE_TIME < SYSDATE "
			+" OR admin.EFFECTIVE_DATE_TIME IS NULL) "
			+"LEFT OUTER JOIN ofsc_work_zone TW "
			/*+" (SELECT   twz.resource_id, "
			+"owz.work_zone_id, "
			+"  work_zone_name, "
			+"owz.active, "
			+"twz.start_date, "
			+"twz.end_date, "
			+"twz.WORK_ZONE_ITEM_ID "
			+"FROM   ofsc_work_zone owz, RESOURCE_WORK_ZONE twz "
			+"WHERE   twz.work_zone_id = owz.work_zone_id) TW "*/
			+"ON work_zone_name = WRKZ.WORKZONE "
			+ "LEFT OUTER JOIN RESOURCE_HIERARCHY rh "
			+ "ON rh.RESOURCE_NAME=WRKZ.RESOURCE_ID " ;
			
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		 this.jdbcTemplate.setDataSource(dataSource);
	}
	

	@Override
	public List<ResourceWorkZone> getResourceWorkZoneByProcessStatus(String status) {
		return jdbcTemplate.query(sql, (rs,row)->{			
			ResourceWorkZone resourceWorkZone= new ResourceWorkZone();
			resourceWorkZone.setSeqNo(rs.getLong("SEQ_NO"));
			resourceWorkZone.setResourceId(rs.getString("RESOURCE_ID"));
			resourceWorkZone.setAction(rs.getString("ACTION"));
			resourceWorkZone.setWorkZone(rs.getString("WORKZONE"));
			resourceWorkZone.setWorkZoneId(rs.getLong("WORK_ZONE_ID"));
			resourceWorkZone.setRatio(rs.getString("WORK_WEIGHTING"));
			resourceWorkZone.setStartDate(( rs.getString("WORKZONE_START_DT")));
			resourceWorkZone.setEndDate((rs.getString("WORKZONE_END_DT")));
			resourceWorkZone.setRecurEvery(rs.getString("DAYS_BETWEEN_OCCURRENCES"));
			resourceWorkZone.setRecurrence(rs.getString("RECURRENCE"));
			resourceWorkZone.setWeekdaysString(rs.getString("WEEKDAYS"));			
			resourceWorkZone.setWorkZoneItemId(rs.getString("WORK_ZONE_ITEM_ID"));	
			resourceWorkZone.setWorkZoneSeqNo(rs.getString("WORKZONE_SEQ_NO"));
			resourceWorkZone.setFileName(rs.getString("FILENAME"));
			//resourceWorkZone.setAttuid(rs.getString(""));//Not present 			
			
		return resourceWorkZone;
		});
	}

	 public int[] batchUpdate(final List<ResourceWorkZone> resourceWorkZone) {
	        int[] updateCounts = jdbcTemplate.batchUpdate(
	        		"update BULK_RM_RSRC_WORKZONES set process_status = 'Processed' where SEQ_NO = ?",
	                new BatchPreparedStatementSetter() {
	                    public void setValues(PreparedStatement ps, int i) throws SQLException {
	                       
	                        ps.setLong(1, resourceWorkZone.get(i).getSeqNo());
	                    }

	                    public int getBatchSize() {
	                        return resourceWorkZone.size();
	                    }
	                } );
	        return updateCounts;
	    }

	/*@Override
	public List<ResourceLocation> getResourceLocationByProcessStatus(String status) {
		// TODO Auto-generated method stub
		return null;
	}
*/

	/*@Override
	//public List<Location> getLocationsByProcessStatus(String status) {
		// TODO Auto-generated method stub
		return null;
	}*/

}
