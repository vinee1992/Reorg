package com.att.edge.backend.reorg.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.att.edge.appcommon.AdminRegionalLinks;
import com.att.edge.appcommon.EdgeException;
import com.att.edge.backend.reorg.dao.AdminRegionalLinksDao;
import com.att.edge.backend.reorg.model.EmailNotification;
/**
 * @author pradyumna.k.khadanga
 *
 */
@Repository("adminRegionalLinksDao")
public class AdminRegionalLinksDaoImpl implements AdminRegionalLinksDao {
	
	private static final String FETCH_ADMIN_REGIONAL_LINKS = "SELECT REGION, URL_START, CAWO_URL_START, UDWO_URL_START, MTS_URL_START FROM ADMIN_REGIONAL_LINKS";
	
	private static final String FETCH_EMAIL_AND_FILES= "select distinct FILE_NAME, notification_id from ADMIN_BULK_UPLOAD_DETAILS det ,ADMIN_BULK_UPLOAD_NOTIFICATION notify where det.seq_no=notify.details_seq_no where det.file_name = ";

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.jdbcTemplate.setDataSource(dataSource);
	}	
	
	@Override
	public List<AdminRegionalLinks> retrieveAdminRegionalLinks() throws EdgeException { 
		return jdbcTemplate.query(FETCH_ADMIN_REGIONAL_LINKS, 
				(ResultSet rs, int row)->{
			AdminRegionalLinks adminRegionalLinks = new AdminRegionalLinks();
			adminRegionalLinks.setRegion(rs.getString("REGION"));
			adminRegionalLinks.setUrlStart(rs.getString("URL_START"));
			adminRegionalLinks.setCawoUrlStart(rs.getString("CAWO_URL_START"));
			adminRegionalLinks.setUdwoUrlStart(rs.getString("UDWO_URL_START"));
			adminRegionalLinks.setMtsUrlStart(rs.getString("MTS_URL_START"));
			return adminRegionalLinks;
		}); 
	}

	@Override
	public List<String> fetchNotificationId(String fileNames) throws EdgeException {
		// TODO Auto-generated method stub
		//String sql = "select distinct notification_id from ADMIN_BULK_UPLOAD_DETAILS det ,ADMIN_BULK_UPLOAD_NOTIFICATION notify where det.seq_no=notify.details_seq_no and det.file_name = "+"'"+fileNames+"'";
		String[] ArrayString=fileNames.split(",");
		String QueryParameter=Stream.of(ArrayString).collect(Collectors.joining("','", "'", "'"));
		String sql="select notification_id from ADMIN_BULK_UPLOAD_DETAILS det , ADMIN_BULK_UPLOAD_NOTIFICATION notify where det.seq_no=notify.details_seq_no and det.file_name IN ("+QueryParameter+")";
		List<String> notificationId = jdbcTemplate.queryForList(sql,String.class);
		return notificationId;
	}



/*	@Override
	public List<String> fetchNotificationId(String fileNames) throws EdgeException {
		String[] ArrayString=fileNames.split(",");
		String QueryParameter=Stream.of(ArrayString).collect(Collectors.joining("','", "'", "'"));
		//System.out.println("("+QueryParameter+")");
		String sql="select notification_id from ADMIN_BULK_UPLOAD_DETAILS det , ADMIN_BULK_UPLOAD_NOTIFICATION notify where det.seq_no=notify.details_seq_no and det.file_name IN ("+QueryParameter+")";
		List<String> notificationId=jdbcTemplate.queryForList(sql,String.class);
		return notificationId;
	}*/

	
/*	@Override
	public List<EmailNotification> fetchEmailAndFileNames() throws EdgeException {
		return jdbcTemplate.query(FETCH_EMAIL_AND_FILES, 
				(ResultSet rs, int row) ->{
					EmailNotification emailNotification = new EmailNotification();
					emailNotification.setFileName(rs.getString("FILE_NAME"));
					emailNotification.setNotificationId(rs.getString("NOTIFICATION_ID"));
					return emailNotification;
				});
				
				
		
	}
		*/
	
}
