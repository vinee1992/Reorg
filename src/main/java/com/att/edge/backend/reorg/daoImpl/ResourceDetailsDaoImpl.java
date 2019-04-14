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
import org.springframework.transaction.annotation.Transactional;

import com.att.edge.backend.reorg.dao.ResourceDetailsDao;
import com.att.edge.backend.reorg.model.LocationDetails;
import com.att.edge.backend.reorg.model.ResourceDetails;
import com.att.edge.backend.reorg.model.ResourceLocation;

/**
 * @author pradyumna.k.khadanga
 *
 */
@Repository
public class ResourceDetailsDaoImpl implements ResourceDetailsDao {
	//@Value("${hierarchy.select}")
	private String sql = "SELECT HIR.SEQ_NO, "
			+"HIR.PROCESS_STATUS, "
+"HIR.FILENAME, "
+"CASE "
+"WHEN UPPER (HIR.ACTION) = 'ADD' THEN 'CREATE' "
+"WHEN UPPER (HIR.ACTION) = 'UPDATE' THEN 'UPDATE' "
+"WHEN UPPER (HIR.ACTION) = 'DELETE' THEN 'DELETE' "
+"END "
+"AS ACTION,HIR.RESOURCE_NAME,HIR.PARENT_RESOURCE,REF.NAME AS RESOURCE_TYPE,HIR.STATUS,HIR.TIME_ZONE,HIR.LANGUAGE,HIR.EMAIL_ADDRESS,HIR.GARAGE_ID,HIR.ORGANIZATION,HIR.USE_AS_CAPACITY_BUCKET,HIR.CREATED_DTTM, "
+"HIR.CREATED_BY, HIR.FILENAME,HIR.PROCESS_STATUS_REASON,HIR.PROCESSED_DTTM,HIR.RESOURCE_NAME,HIR.USE_AS_CAPACITY_BUCKET, "
+"get_resource_id (HIR.resource_name) AS RESOURCE_ID, "
+"get_resource_id (HIR.PARENT_RESOURCE) AS PARENT_RESOURCE_ID "
+"FROM BULK_RM_HIERARCHY HIR "
+"   INNER JOIN "
+ " ADMIN_WO_REFERENCE_DATA ref "
+ "ON HIR.resource_type=ref.DISPLAY_VALUE "
+"INNER JOIN "
+"ADMIN_BULK_UPLOAD_DETAILS ADMIN "
+"ON HIR.PROCESS_STATUS = 'uploaded' "
+"AND HIR.FILEName = ADMIN.FILE_NAME "
+"AND ADMIN.category = 'Resource Management' "
        +"and (admin.EFFECTIVE_DATE_TIME < sysdate or admin.EFFECTIVE_DATE_TIME is null)";

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.jdbcTemplate.setDataSource(dataSource);
	}

	@Override
	public List<ResourceDetails> getResourceDetailsByProcessStatus(String status) {
		return jdbcTemplate.query(sql, (rs, row) -> {
			ResourceDetails resourceDetails = new ResourceDetails();
			resourceDetails.setSeqNo(rs.getLong("SEQ_NO"));
			resourceDetails.setResourceId(rs.getString("RESOURCE_ID"));	
			resourceDetails.setTechAction(rs.getString("ACTION"));
			resourceDetails.setEmail(rs.getString("EMAIL_ADDRESS"));
			resourceDetails.setLanguage(rs.getString("LANGUAGE"));
			resourceDetails.setName(rs.getString("RESOURCE_NAME"));
			resourceDetails.setParentResourceId(rs.getString("PARENT_RESOURCE_ID"));
			resourceDetails.setResourceType(rs.getString("RESOURCE_TYPE"));
			resourceDetails.setStatus(rs.getString("STATUS"));
			resourceDetails.setTimeZone(rs.getString("TIME_ZONE"));
			 resourceDetails.setCreatedBy(rs.getString("CREATED_BY"));
			 resourceDetails.setGarageId(rs.getString("GARAGE_ID"));
			 resourceDetails.setOrganization(rs.getString("ORGANIZATION"));
			 resourceDetails.setParentResource(rs.getString("PARENT_RESOURCE"));
			 resourceDetails.setProcessStatus(rs.getString("PROCESS_STATUS"));
			 resourceDetails.setProcessStatusReason(rs.getString("PROCESS_STATUS_REASON"));
			return resourceDetails;
		});
	}
	@Transactional
	public int[] batchUpdate(final List<ResourceDetails> resourceDetails) {
		int[] updateCounts = jdbcTemplate.batchUpdate(
				"update BULK_RM_Hierarchy set process_status = 'Processed' where SEQ_NO = ?",
				new BatchPreparedStatementSetter() {
					public void setValues(PreparedStatement ps, int i) throws SQLException {
						ps.setLong(1, resourceDetails.get(i).getSeqNo());
					}

					public int getBatchSize() {
						return resourceDetails.size();
					}
				});
		return updateCounts;
	}

}
