package com.agency.koda.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agency.koda.dao.CompanyDao;
import com.agency.koda.model.CompanyInfo;
import com.agency.koda.service.CompanyService;

/**
 * 公司服务接口实现
 * 
 * @author Waco
 *
 */
@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyDao companyDao;

	@Override
	public CompanyInfo load(CompanyInfo companyInfo) {
		return companyDao.load(companyInfo);
	}

}
