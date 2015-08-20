package com.agency.koda.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agency.koda.dao.EmployeeDao;
import com.agency.koda.model.Employee;
import com.agency.koda.service.EmployeeService;
/***
 * 员工serviceImpl实现
 * @author meng
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService 
{

	@Autowired
	private EmployeeDao empdao;
	
	@Override
	public int addEmployeeInfo(Employee employee) {
		return empdao.addEmployeeInfo(employee);
	}
	@Override
	public int updateEmployeeInfo(Employee employee) {
		return empdao.updateEmployeeInfo(employee);
	}
	@Override
	public int loadEmployeeCount(String esEmplName, String esDeptId) {
		return empdao.loadEmployeeCount(esEmplName, esDeptId);
	}
	@Override
	public List<Employee> loadEmployeeList(int pageNow, int pageSize,
			String esEmplName, String esDeptId) {
		return empdao.loadEmployeeList(pageNow, pageSize, esEmplName, esDeptId);
	}
	@Override
	public Employee loadEmployeeEntity(String esEmplId) {
		return empdao.loadEmployeeEntity(esEmplId);
	}

}
