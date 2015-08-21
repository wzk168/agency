package com.agency.koda.service;

import java.util.List;

import com.agency.koda.model.Employee;
import com.agency.koda.model.EmployeeBaseClass;

/**
 * 员工service实现
 * @author meng
 *
 */
public interface EmployeeService {


	/**
	 * 添加员工基本信息
	 * @param employee 员工对象
	 * @return 
	 */
	public int addEmployeeInfo(Employee employee);

    
	/**
	 * 修改员工基本信息
	 * @param employee 员工对象
	 * @return
	 */
	public int updateEmployeeInfo(Employee employee);

    /**
     * 根据条件查询员工条数分页中使用
     * @param esEmplName
     * @param esDeptId
     * @return
     */
	public int loadEmployeeCount(String esEmplName,String esDeptId);

	/**
	 * 根据条件分页查询员工信息
	 * @param pageNow 当前页
	 * @param pageSize 每页条数
	 * @param esEmplName 员工姓名
	 * @param esDeptId 归属部门
	 * @return
	 */
    public List<EmployeeBaseClass> loadEmployeeList(int pageNow,int pageSize,String esEmplName,String esDeptId);

    /**
	 * 查询员工对象
	 * @param esEmplId 员工ID
	 * @return
	 */
	public Employee loadEmployeeEntity(String esEmplId);


}
