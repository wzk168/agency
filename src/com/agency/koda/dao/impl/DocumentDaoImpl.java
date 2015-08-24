package com.agency.koda.dao.impl;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
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

	//分页查询需要出库单证
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<DocumentInfo> loadDocmentPage(String date1,String date2,String dgBranchId,
			int dgDocumentType, int pageNow, int pageSize) {
		List list=new ArrayList();
		Object[] parae=null;
		StringBuffer selSql=new StringBuffer("SELECT dg_document_batchnumber,dg_document_id,dg_document_serial,dg_document_type,dg_document_state,dg_document_entertime,"
				+ "bcg_branch_short FROM ay_document_msg  AS docu LEFT JOIN "
				+ "ay_branch_company_msg AS bran ON docu.dg_branch_id=bran.bcg_branch_id");
		//分支机构
		if(null!=dgBranchId && !dgBranchId.equals(""))
		{
			selSql.append(" AND bran.bcg_branch_id = ?");
			list.add(dgBranchId);
		}
		//单证类型
		if(dgDocumentType!=0)
		{
			selSql.append(" AND docu.dg_document_type= ?");
			list.add(dgDocumentType);
		}
		//时间段
		if((null!=date1&& !date1.equals(""))&&(null!=date2&&!date2.equals("")))
		{
			selSql.append(" AND dg_document_entertime >= ? AND dg_document_entertime < ?");
			list.add(date1);
			list.add(date2);
		}
		selSql.append(" ORDER BY dg_document_entertime DESC LIMIT ?,?");
		list.add((pageNow-1)*pageSize);
		list.add(pageSize);
		parae=list.toArray();
		try {
			List<DocumentInfo> doculist=this.getJdbcTemplate().query(selSql.toString(), parae, new DocumentSer());
			return (null!=doculist && doculist.size()>0?doculist:null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//单证遍历
	@SuppressWarnings("rawtypes")
	public class DocumentSer implements RowMapper
	{	
		@Override
		public Object mapRow(ResultSet rs, int index) throws SQLException {
			DocumentInfo info=new DocumentInfo();
			info.setBranchName(rs.getString("bcg_branch_short"));//分支机构
			info.setDgDocumentSerial(rs.getString("dg_document_serial"));//单证号码
			info.setDgDocumentType(rs.getInt("dg_document_type"));//单证类型
			info.setDgDocumentState(rs.getInt("dg_document_state"));//单证状态
			info.setDgDocumentBatchNumber(rs.getString("dg_document_batchnumber"));//批号
			info.setDgDocumentEnterTime(rs.getDate("dg_document_entertime"));
			return info;

		}
	}
	//查询需要出库单证条数
	@SuppressWarnings({ "deprecation", "unchecked", "rawtypes" })
	@Override
	public int loadDocumentCount(String date1,String date2,String dgBranchId, int dgDocumentType) {
		List list=new ArrayList();
		Object[] parae=null;
		StringBuffer selSql=new StringBuffer("SELECT COUNT(1) FROM ay_document_msg  AS docu LEFT JOIN "
				+ "ay_branch_company_msg AS bran ON docu.dg_branch_id=bran.bcg_branch_id");
		//分支机构
		if(null!=dgBranchId && !dgBranchId.equals(""))
		{
			selSql.append(" AND bran.bcg_branch_id = ?");
			list.add(dgBranchId);
		}
		//单证类型
		if(dgDocumentType!=0)
		{
			selSql.append(" AND docu.dg_document_type= ?");
			list.add(dgDocumentType);
		}
		//时间段
		if((null!=date1&& !date1.equals(""))&&(null!=date2&&!date2.equals("")))
		{
			selSql.append(" AND dg_document_entertime >= ? AND dg_document_entertime < ?");
			list.add(date1);
			list.add(date2);
		}
		parae=list.toArray();
		try {
			return this.getJdbcTemplate().queryForInt(selSql.toString(), parae);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}



}
