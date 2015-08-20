package com.agency.koda.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agency.koda.dao.InstitutionDao;
import com.agency.koda.model.BranchBaseClass;
import com.agency.koda.model.BranchCompany;
import com.agency.koda.model.InsuranceBaseClass;
import com.agency.koda.model.InsuranceCompany;
import com.agency.koda.service.InstitutionService;
/**
 * 机构serviceimpl(包含保险公司，保险公司分支机构)
 * @author meng
 *
 */
@Service
public class InstitutionServiceImpl implements InstitutionService
{
	@Autowired
	private InstitutionDao instdao;//机构dao
	
	@Override
	public int addBranchCompany(BranchCompany branchCompany) {
		return instdao.addBranchCompany(branchCompany);
	}
	@Override
	public int addInsurCompany(InsuranceCompany insuCompany) {
		return instdao.addInsurCompany(insuCompany);
	}
	@Override
	public List<BranchCompany> loadBranchCompany(String bcgBranchShort,
			int bcgBranchType) {
		return instdao.loadBranchCompany(bcgBranchShort, bcgBranchType);
	}
	@Override
	public BranchCompany loadBranchCompanyEntity(String bcgBranchId) {
		return instdao.loadBranchCompanyEntity(bcgBranchId);
	}
	@Override
	public List<InsuranceCompany> loadInsurCompany(String icgInscompanyShort,
			int icgInscompanyType) {
		return instdao.loadInsurCompany(icgInscompanyShort, icgInscompanyType);
	}
	@Override
	public InsuranceCompany loadInsurCompanyEntiy(String icgInscompanyId) {
		return instdao.loadInsurCompanyEntiy(icgInscompanyId);
	}
	@Override
	public int updateBranchCompany(BranchCompany branchCompany) {
		return instdao.updateBranchCompany(branchCompany);
	}
	@Override
	public int updateInsuCompany(InsuranceCompany insuCompany) {
		return instdao.updateInsuCompany(insuCompany);
	}
	
	@Override
	public List<BranchBaseClass> loadBranchList(String bcgCompanyId) {
		return instdao.loadBranchList(bcgCompanyId);
	}
	@Override
	public List<InsuranceBaseClass> loadInsuranList(String icgInscompanyId) {
		return instdao.loadInsuranList(icgInscompanyId);
	}
	

}
