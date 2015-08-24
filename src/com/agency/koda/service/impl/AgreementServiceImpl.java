package com.agency.koda.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agency.koda.dao.AgreementDao;
import com.agency.koda.model.Agreement;
import com.agency.koda.service.AgreementService;
/**
 * AgreementService接口实现
 * @author meng
 *
 */
@Service
public class AgreementServiceImpl implements AgreementService
{
	@Autowired
	private AgreementDao agreeDao;
	
	@Override
	public int addAgreementInfo(List<Agreement> agree) {
		
		return agreeDao.addAgreementInfo(agree);
	}
	
	
	
	
	
	
	

}
