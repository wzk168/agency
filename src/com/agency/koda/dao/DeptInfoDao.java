package com.agency.koda.dao;

import java.util.List;

import com.agency.koda.model.DeptInfo;

/**
 * 部门接口
 * @author meng
 */
public interface DeptInfoDao 
{
	/**
	 * 添加部门信息
	 * @param deptInfo
	 * @return
	 */
	public int addDeptInfo(DeptInfo deptInfo);

	/**
	 * 部门信息列表
	 * @param dsCompanyId
	 * @return
	 */
	public List<DeptInfo> loadDeptList(String dsCompanyId);
	
	/**
	 * 修改部门信息
	 * @param deptInfo
	 * @return
	 */
	public int updateDepetlist(DeptInfo deptInfo);
	
	/**
	 * 根据部门ID查询部门对象
	 * @param dsDeptId 部门ID
	 * @return
	 */
	public DeptInfo loadDeptEntity(String dsDeptId);

}
