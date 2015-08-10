package com.agency.koda.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.agency.koda.model.UserCompany;
import com.agency.koda.service.PlatformSettingsService;
import com.agency.koda.utils.BaseController;
import com.agency.koda.utils.Page;

/**
 * 系统平台设置管理controller
 *
 * @author meng 2015-07-28
 */

@Controller
@RequestMapping(value = "/platformSettings")
public class PlatformSettingsController extends BaseController {
	@Autowired
	private PlatformSettingsService platsetService;// 平台service

	/**
	 * 加载及使用公司分页查询
	 * @param ucsCompanyName
	 * @param pageNow
	 * @param ucsCompanyState
	 * @return
	 */
	@RequestMapping(value = "/beforUserCompanyList", method = RequestMethod.GET)
	public ModelAndView beforUserCompanyList() {
		ModelAndView mav = new ModelAndView();
		Page page = new Page(1, pageSize,
				this.platsetService.loadUserCompanyCount(null, 0));
		List<UserCompany> uslist = this.platsetService.loadUserCompanyList(
				page.getPageSize(), page.getPageNow(), null, 0);
		mav.addObject("uslist", uslist);
		mav.addObject("page", page);
		mav.setViewName("sys/userCompanyList");
		return mav;
	}

	/**
	 * 加载及使用公司分页查询
	 * 
	 * @param ucsCompanyName
	 * @param pageNow
	 * @param ucsCompanyState
	 * @return
	 */
	@RequestMapping(value = "/userCompanyList", method = RequestMethod.GET)
	public ModelAndView userCompanyList(
			@RequestParam("pageNow") int pageNow,
			@RequestParam(value = "ucsCompanyName", required = false) String ucsCompanyName) {
		int ucsCompanyState = 0;// 公司状态默认0
		ModelAndView mav = new ModelAndView();
		String ucsCompanyNames = null;
		if (null != ucsCompanyName) {
			try {
				ucsCompanyNames = new String(
						ucsCompanyName.getBytes("ISO-8859-1"), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		Page page = new Page(pageNow, pageSize,
				this.platsetService.loadUserCompanyCount(ucsCompanyNames,
						ucsCompanyState));
		List<UserCompany> uslist = this.platsetService.loadUserCompanyList(
				page.getPageSize(), page.getPageNow(), ucsCompanyNames,
				ucsCompanyState);
		mav.addObject("uslist", uslist);
		mav.addObject("page", page);
		mav.setViewName("sys/userCompanyList");
		return mav;
	}

	/**
	 * 添加使用公司信息
	 *
	 * @param userCompany
	 *            使用公司对象
	 * @param response
	 *            响应事件
	 * @return
	 */
	@SuppressWarnings("static-access")
	@RequestMapping(value = "/addUserCompany", method = RequestMethod.POST)
	@ResponseBody
	public void addUserCompanyController(UserCompany userCompany,
			HttpServletResponse response) {
		userCompany.setUcsCompanyId(this.major("CPY"));
		result = this.platsetService.addUserCompany(userCompany);
		this.writeMsg(response, result);
	}

	/**
	 * 进入使用公司添加界面
	 *
	 * @return
	 */
	@RequestMapping(value = "/beforaddUserCompany", method = RequestMethod.GET)
	public ModelAndView beforaddUserCompany() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("sys/addUserCompany");
		return mav;
	}

	/**
	 * 进入修改公司信息界面
	 * 
	 * @param ucsCompanyId
	 *            使用公司ID
	 * @return
	 */
	@RequestMapping(value = "/beforUpUserCompany", method = RequestMethod.GET)
	public ModelAndView beforUpUserCompany(
			@RequestParam("ucsCompanyId") String ucsCompanyId) {
		UserCompany uy = this.platsetService
				.loadUserCompanyEntity(ucsCompanyId);
		ModelAndView mav = new ModelAndView();
		mav.addObject("uy", uy);
		mav.setViewName("sys/upUserCompany");
		return mav;
	}

	/**
	 * 修改使用公司信息
	 *
	 * @param userCompany
	 *            使用公司对象
	 * @param response
	 *            响应事件
	 * @return
	 */
	@RequestMapping(value = "/upUserCompanyController", method = RequestMethod.POST)
	@ResponseBody
	public void upUserCompanyController(UserCompany userCompany,
			HttpServletResponse response) {
		result = this.platsetService.upUserCompany(userCompany);
		this.writeMsg(response, result);
	}

}
