/**
 * 
 */
package com.att.edge.backend.reorg.daoImpl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.att.edge.backend.reorg.dao.BulkUploadDao;

/**
 * @author anand.arjan.jhamnani
 *
 */



@Repository	
public class BulkUploadDaoImpl implements  BulkUploadDao{
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		 this.jdbcTemplate.setDataSource(	);
	}
	
	@Transactional
	 public int[] batchUpdateAdmin(final Set<String> fileNames) {

	        int[] updateCounts = jdbcTemplate.batchUpdate(
	                "update ADMIN_BULK_UPLOAD_DETAILS set status = 'COMPLETE' where file_Name = ?",
	                new BatchPreparedStatementSetter() {
	                    public void setValues(PreparedStatement ps, int i) throws SQLException {	                      
	                        ps.setString(1, fileNames.stream().collect(Collectors.toList()).get(i));
	                    }

	                    public int getBatchSize() {		    	                    	
	                        return fileNames.size();
	                        
	                    }
	                } );
	        return updateCounts;
	    }

	
}
