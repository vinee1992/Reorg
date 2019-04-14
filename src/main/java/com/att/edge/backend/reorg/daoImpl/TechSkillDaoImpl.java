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

import com.att.edge.backend.reorg.dao.TechSkillsDao;
import com.att.edge.backend.reorg.model.SkillDetails;
import static com.att.edge.backend.reorg.util.DateUtil.*;

/**
 * @author pradyumna.k.khadanga
 *
 */
@Repository
public class TechSkillDaoImpl implements TechSkillsDao {
	
	//@Value("${techSkill.select}")
	private String sql = "SELECT   TSKILL.SEQ_NO, "
			+" TSKILL.PROCESS_STATUS, "
        		 +" TSKILL.FILENAME, "
        		 +"  CASE "
        		 +" WHEN UPPER (TSKILL.ACTION) = 'ADD' THEN 'ADD' "
            		+"  WHEN UPPER (TSKILL.ACTION) = 'UPDATE' THEN 'UPDATE' " 
            		+"  WHEN UPPER (TSKILL.ACTION) = 'DELETE' THEN 'DELETE' "
            		+"  END "
        		 +"  AS ACTION, "
            		+" TSKILL.TECHNICIAN_ID, " 
        		 +" TSKILL.WORKSKILLID, " 
        		 +"  TSKILL.WORK_SKILL, "
        		 +" TO_CHAR ( TO_DATE (TSKILL.WORK_SKILL_START_DT, 'yyyy/mm/dd hh24:mi:ss'),'yyyy-mm-dd') " 
        		 +"  AS WORK_SKILL_START_DT, "
            		+" TO_CHAR (TO_DATE (WORK_SKILL_END_DT, 'yyyy/mm/dd hh24:mi:ss'), 'yyyy-mm-dd') "
        		 +"    AS WORK_SKILL_END_DT, "  
        		 +" TSKILL.WORK_SKILL_WEIGHTING, " 
        		 +" TSKILL.CREATED_DTTM, "
        		 +"  TSKILL.CREATED_BY "       		 
            		+"FROM         BULK_RM_TECH_SKILLS TSKILL " 
		  +" INNER JOIN "
            		+"   ADMIN_BULK_UPLOAD_DETAILS ADMIN " 
            		   +" ON     TSKILL.PROCESS_STATUS = 'uploaded' " 
            		+" AND TSKILL.FILEName = ADMIN.FILE_NAME "
            		   +" AND ADMIN.category = 'Resource Management' "
            		   +"AND ADMIN.TEMPLATE_TYPE = 'Technician Skills' "
            		   +"AND (admin.EFFECTIVE_DATE_TIME < SYSDATE "
            		   +"OR admin.EFFECTIVE_DATE_TIME IS NULL) ";
                   /* +" LEFT OUTER JOIN "
        		 +"(SELECT   tws.seq_no AS workSkillInternalId, " 
            		+"tws.resource_id, "
                      +"aws.name, "
                      +"tws.start_date, " 
                      +"tws.end_date, "
                      + "tws.ratio "
               +"FROM   tech_work_skills tws, admin_work_skills aws " 
              +"WHERE   tws.work_skill_id = aws.work_skill_id) AWS "
        +"ON AWS.name = TSKILL.WORK_SKILL "
        + "AND AWS.resource_id=TSKILL.TECHNICIAN_ID "
        + " AND AWS.ratio=TSKILL.WORK_SKILL_WEIGHTING "
        + "and trunc(aws.start_Date)=trunc(to_date(WORK_SKILL_START_DT,'YYYY/MM/DDHH24:MI:SS')) "
        + "and trunc(aws.end_Date)=trunc((to_date(WORK_SKILL_END_DT,'YYYY/MM/DDHH24:MI:SS')))" ;*/ 
	
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.jdbcTemplate.setDataSource(dataSource);
	}

	@Override
	public List<SkillDetails> getTechSkillsByProcessStatus(String status) {
		return jdbcTemplate.query(sql, (rs, row) -> {

			SkillDetails skillDetails = new SkillDetails();
			skillDetails.setSeqNo(rs.getLong("SEQ_NO"));
			skillDetails.setTechId(rs.getString("TECHNICIAN_ID"));
		//	skillDetails.setSkillAction(rs.getString("ACTION"));
			skillDetails.setSkillAction(rs.getString("ACTION"));
			skillDetails.setWorkSkill(rs.getString("WORK_SKILL"));
			skillDetails.setStartDate( rs.getString("WORK_SKILL_START_DT"));
			skillDetails.setEndDate( rs.getString("WORK_SKILL_END_DT"));
			skillDetails.setWorkSkillInternalId(convertStringToLong(rs.getString("WORKSKILLID")));
			skillDetails.setRatio(rs.getInt("WORK_SKILL_WEIGHTING"));
			skillDetails.setFileName(rs.getString("FILENAME"));
			return skillDetails;
		});
	}
	@Transactional
	public int[] batchUpdate(final List<SkillDetails> skillDetails) {
		int[] updateCounts = jdbcTemplate.batchUpdate(
				"update BULK_RM_TECH_SKILLS set process_status = 'Processed' where SEQ_NO = ?",
				new BatchPreparedStatementSetter() {
					public void setValues(PreparedStatement ps, int i) throws SQLException {
						ps.setLong(1, skillDetails.get(i).getSeqNo());
					}

					public int getBatchSize() {
						return skillDetails.size();
					}
				});
		return updateCounts;
	}

}
