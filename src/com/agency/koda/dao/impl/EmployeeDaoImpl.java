package com.agency.koda.dao.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.agency.koda.dao.EmployeeDao;
import com.agency.koda.model.Employee;
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
				+ "es_empl_remark,es_company_id) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			return this.getJdbcTemplate().update(addSql,emp.getEsEmplId(),emp.getEsEmplName(),
					emp.getEsDeptId(),emp.getEsTeamId(),emp.getEsEmplSex(),emp.getEsEmplCard(),
					emp.getEsEmplBirthdate(),emp.getEsEmplMarry(),emp.getEsEmplEducation(),
					emp.getEsEmplHireEate(),emp.getEsEmplPosition(),emp.getEsEmplPhone(),emp.getEsEmplJob(),
					emp.getEsEmplSalesman(),emp.getEsEmplEmergency(),emp.getEsEmplEmergencyPhone(),
					emp.getEsEmplProfessionName(),emp.getEsEmplProfessionCard(),emp.getEsEmplDimissionDate(),
					emp.getEsEmplRemark(),emp.getEsCompanyId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	//查询员工条数
	@Override
	public int loadEmployeeCount(String esEmplName, String esDeptId) {
		// TODO Auto-generated method stub
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
				+ "es_empl_remark=?,es_company_id=? WHERE es_empl_id=?";
		try {
			return this.getJdbcTemplate().update(upSql,emp.getEsEmplName(),
					emp.getEsDeptId(),emp.getEsTeamId(),emp.getEsEmplSex(),emp.getEsEmplCard(),
					emp.getEsEmplBirthdate(),emp.getEsEmplMarry(),emp.getEsEmplEducation(),
					emp.getEsEmplHireEate(),emp.getEsEmplPosition(),emp.getEsEmplPhone(),emp.getEsEmplJob(),
					emp.getEsEmplSalesman(),emp.getEsEmplEmergency(),emp.getEsEmplEmergencyPhone(),
					emp.getEsEmplProfessionName(),emp.getEsEmplProfessionCard(),emp.getEsEmplDimissionDate(),
					emp.getEsEmplRemark(),emp.getEsCompanyId(),emp.getEsEmplId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	//分页显示员工信息
	@Override
	public List<Employee> loadEmployeeList(int pageNow, int pageSize,
			String esEmplName, String esDeptId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Employee loadEmployeeEntity(String esEmplId) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
