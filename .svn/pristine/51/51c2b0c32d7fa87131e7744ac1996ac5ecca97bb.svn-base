package com.agency.koda.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agency.koda.dao.PlatformSettingsDao;
import com.agency.koda.model.UserCompany;
import com.agency.koda.service.PlatformSettingsService;
/**
 * 平台接口daoimpl
 * @author meng
 * 2015-07-29 
 */
@Service
public class PlatformSettingsServiceImpl implements PlatformSettingsService
{
    
	@Autowired
	private PlatformSettingsDao platsetDao;//平台接口dao
	
	@Override
	public int addUserCompany(UserCompany userCompany) {
		return platsetDao.addUserCompany(userCompany);
	}
	@Override
	public int loadUserCompanyCount(String ucsCompanyName, int ucsCompanyState) {
		return platsetDao.loadUserCompanyCount(ucsCompanyName, ucsCompanyState);
	}
	@Override
	public List<UserCompany> loadUserCompanyList(int pageSize, int pageNow,
			String ucsCompanyName, int ucsCompanyState) {
		return platsetDao.loadUserCompanyList(pageSize, pageNow, ucsCompanyName, ucsCompanyState);
	}
	
	@Override
	public UserCompany loadUserCompanyEntity(String ucsCompanyId) {
		return platsetDao.loadUserCompanyEntity(ucsCompanyId);
	}
	@Override
	public int upUserCompany(UserCompany userCompany) {
		return platsetDao.upUserCompany(userCompany);
	}

	
	
}
