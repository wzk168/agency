package com.agency.koda.service;

import java.util.List;

import com.agency.koda.model.DeptBaseClass;
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
	
	/**
	 * 公共方法提取部门，部门ID
	 * @return
	 */
	public List<DeptBaseClass> loadDeptBase();

}
