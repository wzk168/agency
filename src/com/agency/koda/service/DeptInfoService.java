package com.agency.koda.service;

import java.util.List;

import com.agency.koda.model.DeptInfo;

/**
 * 部门service
 * @author meng
 *
 */
public interface DeptInfoService 
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

}
