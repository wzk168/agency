package com.agency.koda.dao;

import java.util.List;

import com.agency.koda.model.BranchCompany;
import com.agency.koda.model.InsuranceCompany;

/**
 * 机构管理（保险公司，保险公司分支机构）
 * @author Administrator
 *
 */
public interface InstitutionDao
{
	
	//保险公司
	/**
	 * 添加保险公司信息
	 * @param insuCompany 保险公司对象
	 * @return
	 */
	public int addInsurCompany(InsuranceCompany insuCompany);
	
	/**
	 * 修改保险公司信息
	 * @param insuCompany 保险公司对象
	 * @return
	 */
	public int updateInsuCompany(InsuranceCompany insuCompany);
	
	/**
	 * 加载及筛选保险公司信息列表
	 * @param icgInscompanyShort 公司简称
	 * @param icgInscompanyType 业务类型
	 * @return
	 */
	public List<InsuranceCompany> loadInsurCompany(String icgInscompanyShort,int icgInscompanyType);
	
	/**
	 * 根据ID查询保险公司对象
	 * @param icgInscompanyId 保险公司ID
	 * @return
	 */
	public InsuranceCompany loadInsurCompanyEntiy(String icgInscompanyId);
	
	//保险公司分支机构
	
	/**
	 * 添加保险公司分支机构信息
	 * @param branchCompany 分支机构对象
	 * @return
	 */
	public int addBranchCompany(BranchCompany branchCompany);
	
	/**
	 * 修改保险公司分支机构信息
	 * @param branchCompany
	 * @return
	 */
	public int updateBranchCompany(BranchCompany branchCompany);
	
	/**
	 * 根据条件筛选分支机构信息列表
	 * @param bcgBranchShort 分支机构简称
	 * @param bcgBranchType 分支机构业务类型
	 * @return
	 */
	public List<BranchCompany> loadBranchCompany(String bcgBranchShort,int bcgBranchType);
	
	/**
	 * 根据分支机构ID查询对象
	 * @param bcgBranchId 分支机构ID
	 * @return
	 */
	public BranchCompany loadBranchCompanyEntity(String bcgBranchId);

}
