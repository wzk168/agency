package com.agency.koda.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 员工副实体类用户存储数据
 * @author meng
 *
 */
@SuppressWarnings("serial")
public class EmployeeBaseClass implements Serializable{
	
	/**
	 * 使用公司
	 */
	private String empCompanyName;
	/**
	 * 员工姓名
	 */
	private String empName;
	/**
	 * 部门名称
	 */
	private String empDeptName;
	/**
	 * 团队名称
	 */
	private String empTeamName;
	/**
	 * 入职时间
	 */
	private Date  empTheTime;
	/**
	 * 是否在职
	 */
	private String empTheJob;
	/**
	 * 是否是业务员
	 */
	private String empSalesMan;
	
	/**
	 * 员工ID
	 */
	private String empId;

	public String getEmpCompanyName() {
		return empCompanyName;
	}

	public void setEmpCompanyName(String empCompanyName) {
		this.empCompanyName = empCompanyName;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpDeptName() {
		return empDeptName;
	}

	public void setEmpDeptName(String empDeptName) {
		this.empDeptName = empDeptName;
	}

	public String getEmpTeamName() {
		return empTeamName;
	}

	public void setEmpTeamName(String empTeamName) {
		this.empTeamName = empTeamName;
	}

	public Date getEmpTheTime() {
		return empTheTime;
	}

	public void setEmpTheTime(Date empTheTime) {
		this.empTheTime = empTheTime;
	}

	public String getEmpTheJob() {
		return empTheJob;
	}

	public void setEmpTheJob(String empTheJob) {
		this.empTheJob = empTheJob;
	}

	public String getEmpSalesMan() {
		return empSalesMan;
	}

	public void setEmpSalesMan(String empSalesMan) {
		this.empSalesMan = empSalesMan;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}
	
	

}
