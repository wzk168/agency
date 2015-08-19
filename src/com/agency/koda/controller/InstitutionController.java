package com.agency.koda.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView beforInstit()
	{
		ModelAndView mav=new ModelAndView();
		mav.setViewName("sys/institutionList");
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

}
