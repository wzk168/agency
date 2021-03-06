package com.agency.koda.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.agency.koda.dao.DeptInfoDao;
import com.agency.koda.model.DeptBaseClass;
import com.agency.koda.model.DeptInfo;
import com.agency.koda.utils.BaseDaoImpl;

/**
 * 部门接口实现
 * 
 * @author meng
 *
 */
@Repository
public class DeptInfoDaoImpl extends BaseDaoImpl implements DeptInfoDao {
	// 添加部门
	@Override
	public int addDeptInfo(DeptInfo deptInfo) {
		String adddeptSql = "INSERT INTO ay_deptinfo_sys(ds_dept_id,ds_dept_name,ds_dept_abbreviation,"
				+ "ds_dept_principal,ds_dept_type,ds_dept_address,ds_dept_onephone,ds_dept_twophone,"
				+ "ds_dept_email,ds_company_id) VALUES(?,?,?,?,?,?,?,?,?,?)";
		try {
			return this.getJdbcTemplate().update(adddeptSql,
					deptInfo.getDsDeptId(), deptInfo.getDsDeptName(),
					deptInfo.getDsDeptAbbreviation(),
					deptInfo.getDsDeptPrincipal(), deptInfo.getDsDeptType(),
					deptInfo.getDsDeptAddress(), deptInfo.getDsDeptOnephone(),
					deptInfo.getDsDeptTwophone(), deptInfo.getDsDeptEmail(),
					deptInfo.getDsCompanyId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	// 加载部门信息列表
	@SuppressWarnings("unchecked")
	@Override
	public List<DeptInfo> loadDeptList(String dsCompanyId) {
		String selSql = "SELECT ds_dept_id,ds_dept_name,ds_dept_abbreviation,ds_dept_principal,"
				+ "ds_company_id,ds_dept_onephone,ds_dept_type FROM ay_deptinfo_sys WHERE ds_company_id=?";
		try {
			List<DeptInfo> deptlist = this.getJdbcTemplate().query(selSql,
					new Object[] { dsCompanyId }, new int[] { Types.VARCHAR },
					new DeptInfoSet());
			return (null != deptlist && deptlist.size() > 0 ? deptlist : null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 部门集合遍历
	@SuppressWarnings("rawtypes")
	public class DeptInfoSet implements RowMapper {
		@Override
		public Object mapRow(ResultSet rs, int index) throws SQLException {
			DeptInfo dept = new DeptInfo();
			dept.setDsCompanyId(rs.getString("ds_company_id"));
			dept.setDsDeptAbbreviation(rs.getString("ds_dept_abbreviation"));
			dept.setDsDeptId(rs.getString("ds_dept_id"));
			dept.setDsDeptName(rs.getString("ds_dept_name"));
			dept.setDsDeptPrincipal(rs.getString("ds_dept_principal"));
			dept.setDsDeptOnephone(rs.getString("ds_dept_onephone"));
			dept.setDsDeptType(rs.getInt("ds_dept_type"));
			return dept;
		}

	}

	// 修改部门信息
	@Override
	public int updateDepetlist(DeptInfo deptInfo) {
		String upDeptSql = "UPDATE ay_deptinfo_sys SET ds_dept_name=?,ds_dept_abbreviation=?,"
				+ "ds_dept_principal=?,ds_dept_type=?,ds_dept_address=?,ds_dept_onephone=?,"
				+ "ds_dept_twophone=?,ds_dept_email=?,ds_company_id=? WHERE ds_dept_id=?";
		try {
			return this.getJdbcTemplate().update(upDeptSql,
					deptInfo.getDsDeptName(), deptInfo.getDsDeptAbbreviation(),
					deptInfo.getDsDeptPrincipal(), deptInfo.getDsDeptType(),
					deptInfo.getDsDeptAddress(), deptInfo.getDsDeptOnephone(),
					deptInfo.getDsDeptTwophone(), deptInfo.getDsDeptEmail(),
					deptInfo.getDsCompanyId(), deptInfo.getDsDeptId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	// 根据部门ID查询部门对象
	@Override
	public DeptInfo loadDeptEntity(String dsDeptId) {
		String selDeptEntitySql = "SELECT ds_dept_id,ds_dept_name,ds_dept_abbreviation,"
				+ "ds_dept_principal,ds_dept_type,ds_dept_address,ds_dept_onephone,"
				+ "ds_dept_twophone,ds_dept_email,ds_company_id FROM ay_deptinfo_sys WHERE ds_dept_id=?";
		try {
			List<DeptInfo> deptlist = this.getJdbcTemplate().query(
					selDeptEntitySql, new Object[] { dsDeptId },
					new int[] { Types.VARCHAR }, new RowMapper<DeptInfo>() {

						@Override
						public DeptInfo mapRow(ResultSet rs, int index)
								throws SQLException {
							DeptInfo dept = new DeptInfo();
							dept.setDsCompanyId(rs.getString("ds_company_id"));// 公司ID
							dept.setDsDeptAbbreviation(rs
									.getString("ds_dept_abbreviation"));// 简称
							dept.setDsDeptId(rs.getString("ds_dept_id"));// ID
							dept.setDsDeptName(rs.getString("ds_dept_name"));// 部门名
							dept.setDsDeptPrincipal(rs
									.getString("ds_dept_principal"));// 负责人
							dept.setDsDeptOnephone(rs
									.getString("ds_dept_onephone"));// 联系电话1
							dept.setDsDeptType(rs.getInt("ds_dept_type"));// 类型
							dept.setDsDeptAddress(rs
									.getString("ds_dept_address"));// 地址
							dept.setDsDeptTwophone(rs
									.getString("ds_dept_twophone"));// 联系电话2
							dept.setDsDeptEmail(rs.getString("ds_dept_email"));// 邮箱
							return dept;
						}
					});
			if (null != deptlist && deptlist.size() > 0) {
				return deptlist.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	//公共方法部门提起
	@SuppressWarnings("unchecked")
	@Override
	public List<DeptBaseClass> loadDeptBase() {
		String selDeptEntitySql = "SELECT ds_dept_id,ds_dept_name FROM ay_deptinfo_sys WHERE ds_dept_type=1";
		try {
			List<DeptBaseClass> deptlist=this.getJdbcTemplate().query(selDeptEntitySql,new DeptSet());
			return (null!=deptlist&&deptlist.size()>0?deptlist:null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	@SuppressWarnings("rawtypes")
	public class DeptSet implements RowMapper
	{
		@Override
		public Object mapRow(ResultSet rs, int index) throws SQLException {
			DeptBaseClass dept=new DeptBaseClass();
			dept.setDeptId(rs.getString("ds_dept_id"));
			dept.setDeptName(rs.getString("ds_dept_name"));
			return dept;
		}

	}

}
