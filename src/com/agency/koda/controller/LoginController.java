package com.agency.koda.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.agency.koda.model.CompanyInfo;
import com.agency.koda.model.UserInfo;
import com.agency.koda.service.CompanyService;
import com.agency.koda.service.UserService;
import com.agency.koda.utils.BaseController;

/**
 * 登录controller
 * 
 * @author Waco
 *
 */
@Controller
@RequestMapping(value = "/user")
public class LoginController extends BaseController {
	@Autowired
	private UserService userService;
	@Autowired
	private CompanyService companyservice;

	/**
	 * session过期提示
	 * 
	 * @return
	 */
	@RequestMapping(value = "/sessionAlert", method = RequestMethod.GET)
	public String sessionAlert() {
		return "sys/sessionAlert";
	}

	/**
	 * 登录
	 *  
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginView() {
		return "sys/index";
	}

	/**
	 * 退出登录
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/goOut", method = RequestMethod.GET)
	public String goOutSystem(HttpSession session) {
		session.removeAttribute("userInfo");
		return "sys/index";
	}

	/**
	 * 用户登录
	 * 
	 * @param request
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request, UserInfo user) {
		ModelAndView mav = new ModelAndView();
		CompanyInfo cinfo = new CompanyInfo();
		cinfo.setUcsCompanyName(user.getUcsCompanyName());
		CompanyInfo companyInfo = companyservice.load(cinfo);
		if (null == companyInfo) {
			mav.setViewName("sys/index");
			mav.addObject("user", user);
			mav.addObject("companyMsg", "企业账号有误！");
			return mav;
		}
		String pwd = user.getUosUserinfoPwd();
		user.setUosUserinfoPwd(null);
		UserInfo uinfo = userService.load(user);
		if (null == uinfo) {
			mav.setViewName("sys/index");
			mav.addObject("user", user);
			mav.addObject("userNameMsg", "个人账号有误！");
			return mav;
		}
		if (!uinfo.getUosUserinfoPwd().equals(pwd)) {
			user.setUosUserinfoPwd(pwd);
			mav.setViewName("sys/index");
			mav.addObject("user", user);
			mav.addObject("pwMsg", "密码有误！");
			return mav;
		}
		uinfo.setUcsCompanyName(companyInfo.getUcsCompanyName());
		request.getSession().setAttribute("userInfo", uinfo);
		mav.setViewName("sys/main");
		return mav;
	}
}
