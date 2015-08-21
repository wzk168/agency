package com.agency.koda.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agency.koda.dao.DeptInfoDao;
import com.agency.koda.model.DeptBaseClass;
import com.agency.koda.model.DeptInfo;
import com.agency.koda.service.DeptInfoService;
/**
 * 部门service实现
 * @author meng
 */
@Service
public class DeptInfoServiceImpl implements DeptInfoService 
{
	@Autowired
	private DeptInfoDao deptDao;
	//添加部门信息
	@Override
	public int addDeptInfo(DeptInfo deptInfo) {
		
		return deptDao.addDeptInfo(deptInfo);
	}
	//部门信息列表
	@Override
	public List<DeptInfo> loadDeptList(String dsCompanyId) {
		
		return deptDao.loadDeptList(dsCompanyId);
	}
	//修改部门信息
	@Override
	public int updateDepetlist(DeptInfo deptInfo) {
		return deptDao.updateDepetlist(deptInfo);
	}
	//根据ID查询部门对象
	@Override
	public DeptInfo loadDeptEntity(String dsDeptId) {
		return deptDao.loadDeptEntity(dsDeptId);
	}
	//公共方法
	@Override
	public List<DeptBaseClass> loadDeptBase() {
		return deptDao.loadDeptBase();
	}
}
