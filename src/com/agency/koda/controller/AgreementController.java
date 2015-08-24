package com.agency.koda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.agency.koda.utils.BaseController;
/**
 * 协议控制层
 * @author meng
 *
 */
@Controller
@RequestMapping(value="/agreement")
public class AgreementController extends BaseController
{
	
	
	/**
	 * 进入协议导入界面
	 * @return
	 */
	@RequestMapping(value="/beforImplAgreement",method=RequestMethod.GET)
	public ModelAndView beforImplAgreement(){
		ModelAndView mav=new ModelAndView();
		mav.setViewName("sys/impleAgreement");
		return mav;
	}
	
	
	
	

}
