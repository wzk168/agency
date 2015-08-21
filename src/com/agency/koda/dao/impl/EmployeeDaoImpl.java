package com.agency.koda.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.agency.koda.dao.EmployeeDao;
import com.agency.koda.model.Employee;
import com.agency.koda.model.EmployeeBaseClass;
import com.agency.koda.utils.BaseDaoImpl;
/**
 * 员工接口实现
 * @author meng
 *
 */
@Repository
public class EmployeeDaoImpl extends BaseDaoImpl implements EmployeeDao
{


	//添加员工
	@Override
	public int addEmployeeInfo(Employee emp) {
		String addSql="INSERT INTO ay_employee_msg(es_empl_id,es_empl_name,"
				+ "es_dept_id,es_team_id,es_empl_sex,es_empl_card,"
				+ "es_empl_birthdate,es_empl_marry,es_empl_education,"
				+ "es_empl_hiredate,es_empl_position,es_empl_phone,es_empl_job,"
				+ "es_empl_salesman,es_empl_emergency,es_empl_emergencyphone,"
				+ "es_empl_professionname,es_empl_professioncard,es_empl_dimissiondate,"
				+ "es_empl_remark,es_company_id,es_placedo_micile,es_actual_residence) "
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			return this.getJdbcTemplate().update(addSql,emp.getEsEmplId(),emp.getEsEmplName(),
					emp.getEsDeptId(),emp.getEsTeamId(),emp.getEsEmplSex(),emp.getEsEmplCard(),
					emp.getEsEmplBirthdate(),emp.getEsEmplMarry(),emp.getEsEmplEducation(),
					emp.getEsEmplHireEate(),emp.getEsEmplPosition(),emp.getEsEmplPhone(),emp.getEsEmplJob(),
					emp.getEsEmplSalesman(),emp.getEsEmplEmergency(),emp.getEsEmplEmergencyPhone(),
					emp.getEsEmplProfessionName(),emp.getEsEmplProfessionCard(),emp.getEsEmplDimissionDate(),
					emp.getEsEmplRemark(),emp.getEsCompanyId(),emp.getEsPlacedoMicile(),emp.getEsActualResidence());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	//修改员工信息
	@Override
	public int updateEmployeeInfo(Employee emp) {
		String upSql="UPDATE ay_employee_msg SET es_empl_name=?,"
				+ "es_dept_id=?,es_team_id=?,es_empl_sex=?,es_empl_card=?,"
				+ "es_empl_birthdate=?,es_empl_marry=?,es_empl_education=?,"
				+ "es_empl_hiredate=?,es_empl_position=?,es_empl_phone=?,"
				+ "es_empl_job=?,es_empl_salesman=?,es_empl_emergency=?,"
				+ "es_empl_emergencyphone=?,es_empl_professionname=?,"
				+ "es_empl_professioncard=?,es_empl_dimissiondate=?,"
				+ "es_empl_remark=?,es_company_id=?,es_placedo_micile=?,"
				+ "es_actual_residence=? WHERE es_empl_id=?";
		try {
			return this.getJdbcTemplate().update(upSql,emp.getEsEmplName(),
					emp.getEsDeptId(),emp.getEsTeamId(),emp.getEsEmplSex(),emp.getEsEmplCard(),
					emp.getEsEmplBirthdate(),emp.getEsEmplMarry(),emp.getEsEmplEducation(),
					emp.getEsEmplHireEate(),emp.getEsEmplPosition(),emp.getEsEmplPhone(),emp.getEsEmplJob(),
					emp.getEsEmplSalesman(),emp.getEsEmplEmergency(),emp.getEsEmplEmergencyPhone(),
					emp.getEsEmplProfessionName(),emp.getEsEmplProfessionCard(),emp.getEsEmplDimissionDate(),
					emp.getEsEmplRemark(),emp.getEsCompanyId(),emp.getEsPlacedoMicile(),emp.getEsActualResidence(),
					emp.getEsEmplId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	//分页显示员工信息
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<EmployeeBaseClass> loadEmployeeList(int pageNow, int pageSize,
			String esEmplName, String esDeptId) {
		List list=new ArrayList();
		Object[] obj=null;
		StringBuffer strbuffer=new StringBuffer();
		strbuffer.append("SELECT us.ucs_company_name,dept.ds_dept_abbreviation,team.ts_team_name,emp.es_empl_name,emp.es_empl_job,emp.es_empl_salesman,emp.es_empl_hiredate"+
"  FROM ay_employee_msg AS emp LEFT JOIN ay_deptinfo_sys AS dept ON emp.es_dept_id=dept.ds_dept_id LEFT JOIN ay_teaminfo_msg AS team ON"+
" emp.es_team_id=team.ts_team_id LEFT JOIN ay_user_company_sys AS us ON emp.es_company_id=us.ucs_company_id WHERE 1=1 ");
		//部门
		if(null!=esDeptId && !esDeptId.equals(""))
		{
			strbuffer.append(" AND dept.ds_dept_abbreviation=?");
			list.add(esDeptId);
		}
		//员工姓名
		if(null!=esEmplName && !esEmplName.equals(""))
		{
			strbuffer.append(" AND emp.es_empl_name LIKE ?");
			list.add("%"+esEmplName+"%");
		}
		strbuffer.append(" LIMIT ?,?");
		list.add((pageNow-1)*pageSize);
		list.add(pageSize);
		obj=list.toArray();
		
		try {
			List<EmployeeBaseClass> emplist=this.getJdbcTemplate().query(strbuffer.toString(),obj,new EmpSet());
			return (null!=emplist&&emplist.size()>0?emplist:null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@SuppressWarnings("rawtypes")
	public class EmpSet implements RowMapper
	{
		@Override
		public Object mapRow(ResultSet rs, int index) throws SQLException {
			EmployeeBaseClass empclass=new EmployeeBaseClass();
			empclass.setEmpCompanyName(rs.getString("ucs_company_name"));
			empclass.setEmpDeptName(rs.getString("ds_dept_abbreviation"));
			empclass.setEmpId(rs.getString("es_empl_name"));
			
			if(rs.getInt("es_empl_salesman")==1)
			{
				empclass.setEmpSalesMan("是");
			}else{
				empclass.setEmpSalesMan("否");
			}
			empclass.setEmpTeamName(rs.getString("ts_team_name"));
			if(rs.getInt("es_empl_job")==1)
			{
				empclass.setEmpTheJob("在职");
			}else
			{
				empclass.setEmpTheJob("离职");
			}
			
			
			empclass.setEmpTheTime(rs.getDate("es_empl_hiredate"));
			return empclass;
		}
	}

	//查询员工条数
	@SuppressWarnings({ "deprecation", "unchecked", "rawtypes" })
	@Override
	public int loadEmployeeCount(String esEmplName, String esDeptId) {
		List list=new ArrayList();
		Object[] obj=null;
		StringBuffer strbuffer=new StringBuffer();
		strbuffer.append("SELECT COUNT(1) FROM ay_employee_msg AS emp LEFT JOIN ay_deptinfo_sys AS dept ON emp.es_dept_id=dept.ds_dept_id LEFT JOIN ay_teaminfo_msg AS team ON"+
" emp.es_team_id=team.ts_team_id LEFT JOIN ay_user_company_sys AS us ON emp.es_company_id=us.ucs_company_id WHERE 1=1 ");
		//部门
		if(null!=esDeptId && !esDeptId.equals(""))
		{
			strbuffer.append(" AND dept.ds_dept_abbreviation=?");
			list.add(esDeptId);
		}
		//员工姓名
		if(null!=esEmplName && !esEmplName.equals(""))
		{
			strbuffer.append(" AND emp.es_empl_name LIKE ?");
			list.add("%"+esEmplName+"%");
		}
		obj=list.toArray();
		try {
			return this.getJdbcTemplate().queryForInt(strbuffer.toString(),obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	//查询员工对象
	@Override
	public Employee loadEmployeeEntity(String esEmplId) {
		// TODO Auto-generated method stub
		return null;
	}


}
