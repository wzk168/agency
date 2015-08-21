package com.agency.koda.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class DeptBaseClass implements Serializable
{
	/**
	 * 部门ID
	 */
	private String deptId;
	/**
	 * 部门姓名
	 */
	private String deptName;
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	
	

}
