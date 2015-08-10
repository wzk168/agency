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

import com.agency.koda.model.MenuInfo;
import com.agency.koda.model.SubmenuInfo;
import com.agency.koda.model.UserInfo;
import com.agency.koda.service.MenuService;
import com.agency.koda.utils.BaseController;
import com.agency.koda.utils.JsonUtil;
import com.agency.koda.utils.Page;

/**
 * 菜单控制层
 * 
 * @author Waco
 *
 */
@Controller
@RequestMapping(value = "/menu")
public class MenuController extends BaseController {
	@Autowired
	private MenuService menuService;

	/**
	 * 登录加载系统菜单
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView menuList(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		UserInfo uinfo = this.getUserFromSession(request);
		List<MenuInfo> menuInfos = menuService.loadMu(uinfo.getUosUserinfoId(),
				uinfo.getUosCompanyId(), 0, 0);
		List<SubmenuInfo> submenuInfos = menuService.loadSu(
				uinfo.getUosUserinfoId(), uinfo.getUosCompanyId(), 0, 0);
		mav.addObject("menuInfos", menuInfos);
		mav.addObject("submenuInfos", submenuInfos);
		mav.setViewName("sys/left");
		return mav;
	}

	/**
	 * 加载菜单列表
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/menuList", method = RequestMethod.GET)
	public ModelAndView sysMenuList(@RequestParam("pageNow") int pageNow,
			HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		UserInfo uinfo = this.getUserFromSession(request);
		Page page;
		List<MenuInfo> menuInfos;
		if (uinfo.getUosUserinfoId().equals(UserInfo.ADMINID)
				&& uinfo.getUosCompanyId().equals(UserInfo.ADMINCOMPANYID)) {
			page = new Page(pageNow, pageSize, menuService.count(0));
			menuInfos = menuService.loadMu(page.getPageSize(),
					page.getPageNow());
		} else {
			page = new Page(pageNow, pageSize, menuService.count(
					uinfo.getUosUserinfoId(), uinfo.getUosCompanyId(), 0));
			menuInfos = menuService.loadMu(uinfo.getUosUserinfoId(),
					uinfo.getUosCompanyId(), page.getPageSize(),
					page.getPageNow());
		}

		mav.addObject("menuInfos", menuInfos);
		mav.addObject("page", page);
		mav.setViewName("sys/menuList");
		return mav;
	}

	/**
	 * 添加菜单
	 * 
	 * @param menuInfo
	 * @return
	 */
	@RequestMapping(value = "/addMenu", method = RequestMethod.POST)
	public ModelAndView addMenu(MenuInfo menuInfo) {
		menuInfo.setMsMenuId(major("MENU"));// 自定义ID
		result = menuService.add(menuInfo);
		if (result > 0) {
			return new ModelAndView("redirect:menuList.html?pageNow=1");
		}
		return null;

	}

	/**
	 * 修改菜单
	 * 
	 * @param menuInfo
	 * @return
	 */
	@RequestMapping(value = "/updateMenu", method = RequestMethod.POST)
	public ModelAndView updateMenu(MenuInfo menuInfo) {
		result = menuService.update(menuInfo);
		if (result > 0) {
			return new ModelAndView("redirect:menuList.html?pageNow=1");
		}
		return null;

	}

	/**
	 * 获取菜单对象
	 * 
	 * @param menuId
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/loadMenu", method = RequestMethod.POST)
	@ResponseBody
	public void loadMenu(@RequestParam("menuId") String menuId,
			HttpServletRequest request, HttpServletResponse response) {
		MenuInfo menuInfo=menuService.loadMu(menuId);
		String msg=JsonUtil.beanToJson(menuInfo);
		this.writeMsg(response, msg);
	}
}
