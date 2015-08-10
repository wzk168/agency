package com.agency.koda.service;

import java.util.List;

import com.agency.koda.model.UserCompany;

/**
 * 平台设置Service
 * @author meng
 * 2015-08-04
 */
public interface PlatformSettingsService 
{
	
	/**
	 *添加使用公司信息
	 *@param userCompany使用公司对象
	 *@return 大于0添加成功反之
	 */
	public int addUserCompany(UserCompany userCompany);	
	
	/**
	 *加载所有的使用公司 
	 *@param pageSize 分页显示条数
	 *@param pageNow 当前页
	 *@param ucsCompanyName 使用公司名称
	 *@param ucsCompanyState 使用状态
	 *@return
	 */
	public List<UserCompany> loadUserCompanyList(int pageSize,int pageNow,String ucsCompanyName,int ucsCompanyState);

	/**
	 *加载所有使用公司条数
	 *@param ucsCompanyName 使用公司名称
	 *@param ucsCompanyState 使用状态
	 *@return
	 */
	public int loadUserCompanyCount(String ucsCompanyName,int ucsCompanyState);
	
	/**
	 * 修改使用公司状态
	 * @param userCompany 公司对象
	 * @return
	 */
	public int upUserCompany(UserCompany userCompany);

	/**
	 *查询使用公司对象
	 *@param ucsCompanyId
	 *@return
	 */
	public UserCompany loadUserCompanyEntity(String ucsCompanyId);
	
}
