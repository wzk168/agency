package com.agency.koda.dao.impl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.stereotype.Repository;
import com.agency.koda.dao.DocumentDao;
import com.agency.koda.model.DocumentInfo;
import com.agency.koda.utils.BaseDaoImpl;
/**
 * 单证接口实现
 * @author meng
 *
 */
@Repository
public class DocumentDaoImpl extends BaseDaoImpl implements DocumentDao
{
	
	//批量添加单证入库
	@Override
	public int addDocumentInfo(final List<DocumentInfo> documlist) {
		String addSql="INSERT INTO ay_document_msg(dg_document_id,dg_document_serial,"
				+ "dg_branch_id,dg_document_type,dg_document_state,"
				+ "dg_document_entertime,dg_document_cometime,dg_document_usetime,"
				+ "dg_document_batchnumber,dg_document_useman,dg_document_dept_id,"
				+ "dg_document_remark,dg_company_id) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			   this.getJdbcTemplate().batchUpdate(addSql,new BatchPreparedStatementSetter() {
				@Override
				public void setValues(PreparedStatement ps, int index) throws SQLException {
					DocumentInfo docinfo=documlist.get(index);
					ps.setString(1, docinfo.getDgDocumentId());//单证ID
					ps.setString(2, docinfo.getDgDocumentSerial());
					ps.setString(3, docinfo.getDgBranchId());
					ps.setInt(4, docinfo.getDgDocumentType());
					ps.setInt(5, docinfo.getDgDocumentState());//单证状态
					ps.setDate(6, (Date)docinfo.getDgDocumentEnterTime());
					ps.setDate(7, (Date) docinfo.getDgDocumentComeTime());
					ps.setDate(8, (Date) docinfo.getDgDocumentUsetime());
					ps.setString(9, docinfo.getDgDocumentBatchNumber());
					ps.setString(10, docinfo.getDgDocumentUseman());
					ps.setString(11, docinfo.getDgDocumentDeptId());
					ps.setString(12, docinfo.getDgDocumentRemark());
					ps.setString(13, docinfo.getDgCompanyId());
				}
				@Override
				public int getBatchSize() {
					return documlist.size();
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
	

}
