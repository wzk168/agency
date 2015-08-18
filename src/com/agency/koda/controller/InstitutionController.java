package com.agency.koda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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

}
