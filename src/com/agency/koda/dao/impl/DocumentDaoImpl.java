package com.agency.koda.dao.impl;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
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
				+ "dg_document_remark,dg_company_id,dg_document_operation) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
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
                   SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");

					ps.setDate(6, java.sql.Date.valueOf(dateFormat.format(docinfo.getDgDocumentEnterTime())));
					if(null!=docinfo.getDgDocumentComeTime() && !docinfo.getDgDocumentComeTime().equals(""))
					{
						ps.setDate(7,java.sql.Date.valueOf(dateFormat.format(docinfo.getDgDocumentComeTime()))); 
					}else
					{
						ps.setDate(7,null); 
					}
					if(null!=docinfo.getDgDocumentUsetime() && !docinfo.getDgDocumentUsetime().equals(""))
					{
						ps.setDate(8,java.sql.Date.valueOf(dateFormat.format(docinfo.getDgDocumentUsetime())));
					}else
					{
						ps.setDate(8,null);
					}
					ps.setString(9, docinfo.getDgDocumentBatchNumber());
					ps.setString(10, docinfo.getDgDocumentUseman());
					ps.setString(11, docinfo.getDgDocumentDeptId());
					ps.setString(12, docinfo.getDgDocumentRemark());
					ps.setString(13, docinfo.getDgCompanyId());
					ps.setString(14, docinfo.getDgDocumentOperation());
				}
				@Override
				public int getBatchSize() {
					return documlist.size();
				}
			});
			  return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
	

}
