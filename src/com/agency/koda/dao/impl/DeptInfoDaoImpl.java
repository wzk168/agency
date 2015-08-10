package com.agency.koda.dao.impl;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.agency.koda.dao.DeptInfoDao;
import com.agency.koda.model.DeptInfo;
import com.agency.koda.utils.BaseDaoImpl;
/**
 * 部门接口实现
 * @author meng
 *
 */
@Repository
public class DeptInfoDaoImpl extends BaseDaoImpl implements DeptInfoDao
{
	//添加部门
	@Override
	public int addDeptInfo(DeptInfo deptInfo) {
		String adddeptSql="INSERT INTO ay_deptinfo_sys(ds_dept_id,ds_dept_name,ds_dept_abbreviation,ds_dept_principal,ds_dept_type,ds_dept_address,ds_dept_onephone,ds_dept_twophone,ds_dept_email,ds_company_id) VALUES(?,?,?,?,?,?,?,?,?,?)";
		try {
			return this.getJdbcTemplate().update(adddeptSql, deptInfo.getDsDeptId(),
					deptInfo.getDsDeptName(),deptInfo.getDsDeptAbbreviation(),deptInfo.getDsDeptPrincipal()
					,deptInfo.getDs_dept_type(),deptInfo.getDsDeptAddress(),
					deptInfo.getDsDeptOnephone(),deptInfo.getDsDeptTwophone(),
					deptInfo.getDsDeptEmail(),deptInfo.getDsCompanyId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	//加载部门信息列表
	@Override
	public List<DeptInfo> loadDeptList(String dsCompanyId) {
    String selSql="SELECT ds_dept_id,ds_dept_name,ds_dept_abbreviation,ds_dept_principal,ds_company_id FROM ay_deptinfo_sys WHERE ds_company_id=?";
		
		return null;
	}


}
