package com.agency.koda.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.agency.koda.model.BranchCompany;
import com.agency.koda.model.InsuranceBaseClass;
import com.agency.koda.model.InsuranceCompany;
import com.agency.koda.service.InstitutionService;
import com.agency.koda.utils.BaseController;


/**
 * 保险公司，保险公司分支机构控制层
 * @author meng
 *
 */

@RequestMapping(value="/institution")
@Controller
public class InstitutionController extends BaseController
{
	@Autowired
	private InstitutionService institService;
	
	/**
	 * 加载进入保险公司，保险分支机构管理界面
	 * @return
	 */
	@RequestMapping(value = "/beforInstit", method = RequestMethod.GET)
	public ModelAndView beforInstit(@RequestParam(value="projectType",required=false) String projectType)
	{
		
		ModelAndView mav=new ModelAndView();
		List<InsuranceCompany> insurancelist=this.institService.loadInsurCompany(null,0);
		List<BranchCompany> branchlist=this.institService.loadBranchCompany(null, 0);
		mav.addObject("insurancelist", insurancelist);
		mav.addObject("branchlist", branchlist);
		mav.setViewName("sys/institutionList");
		if(null!=projectType && !projectType.equals(""))
		{
			mav.addObject("projectType", projectType);
		}else
		{
			mav.addObject("projectType", "insuran");
		}
		return mav;
	}
	
	/**
	 * 进入添加保险公司信息界面
	 * @return
	 */
	@RequestMapping(value = "/beforAddInstition", method = RequestMethod.GET)
	public ModelAndView beforAddInstition()
	{
		ModelAndView mav=new ModelAndView();
		mav.setViewName("sys/addInsurCompany");
		return mav;
	}
	
	/**
	 * 添加保险公司基本信息
	 * @param company 保险公司对象
	 * @param response
	 * @param request
	 */
	@RequestMapping(value = "/addInstitionCompany", method = RequestMethod.POST)
	@ResponseBody
	public void addInstitionCompany(InsuranceCompany company,HttpServletResponse response,HttpServletRequest request)
	{
		company.setIcgInscompanyId(major("ICG"));
		company.setIcgCompanyId(this.getUserFromSession(request).getUosCompanyId());//使用公司ID
		result=this.institService.addInsurCompany(company);
		this.writeMsg(response, result);
	}
	
	/**
	 * 进入修改保险公司街界面
	 * @param icgInscompanyId 公司ID
	 * @return
	 */
	@RequestMapping(value = "/beforUpdateInstition", method = RequestMethod.GET)
	public ModelAndView beforUpdateInstition(@RequestParam("icgInscompanyId") String icgInscompanyId)
	{
		ModelAndView mav=new ModelAndView();
		InsuranceCompany insurance=this.institService.loadInsurCompanyEntiy(icgInscompanyId);
		mav.addObject("insurance", insurance);
		mav.setViewName("sys/upInsurCompany");
		return mav;
	}
	/**
	 * 修改保险公司基本信息
	 * @param company 保险公司对象
	 * @param response
	 */
	@RequestMapping(value = "/updateInstition", method = RequestMethod.POST)
	@ResponseBody
	public void updateInstition(InsuranceCompany company,HttpServletResponse response)
	{
		result=this.institService.updateInsuCompany(company);
		this.writeMsg(response, result);
	}
	
	
	/**
	 * 进入添加分支机构界面
	 * @return
	 */
	@RequestMapping(value = "/beforAddBranch", method = RequestMethod.GET)
	public ModelAndView beforAddBranch(HttpServletRequest request)
	{
		ModelAndView mav=new ModelAndView();
		mav.setViewName("sys/addBranchCompany");
		List<InsuranceBaseClass> insuranceList=this.insuranList(this.getUserFromSession(request).getUosCompanyId());
		mav.addObject("insuranceList", insuranceList);
		return mav;
	}
	
	/**
	 * 添加分支机构
	 * @param branchCompany 分支机构对象
	 * @param response
	 */
	@RequestMapping(value = "/addBrabchCompany", method = RequestMethod.POST)
	@ResponseBody
	public void addBrabchCompany(BranchCompany branchCompany,
			HttpServletResponse response,HttpServletRequest request)
	{
		branchCompany.setBcgBranchId(major("BCG"));
		branchCompany.setBcgCompanyId(this.getUserFromSession(request).getUosCompanyId());
		result=this.institService.addBranchCompany(branchCompany);
		this.writeMsg(response, result);
	}
	
	/**
	 * 进入修改分支机构界面
	 * @return
	 */
	@RequestMapping(value = "/beforUpBranch", method = RequestMethod.GET)
	public ModelAndView beforUpBranch(@RequestParam("bcgBranchId") String bcgBranchId,
			HttpServletRequest request)
	{
		ModelAndView mav=new ModelAndView();
		mav.setViewName("sys/upBranchCompany");
		BranchCompany branch=this.institService.loadBranchCompanyEntity(bcgBranchId);
		List<InsuranceBaseClass> insuranceList=this.insuranList(this.getUserFromSession(request).getUosCompanyId());
		mav.addObject("insuranceList", insuranceList);
		mav.addObject("branch", branch);
		return mav;
	}
	
	/**
	 * 修改分支机构信息
	 * @param branchCompany
	 * @param response
	 */
	@RequestMapping(value = "/upBrabchCompany", method = RequestMethod.POST)
	@ResponseBody
	public void upBrabchCompany(BranchCompany branchCompany,HttpServletResponse response)
	{
		result=this.institService.updateBranchCompany(branchCompany);
		this.writeMsg(response, result);
	}

}
