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

import com.agency.koda.model.DeptInfo;
import com.agency.koda.model.UserInfo;
import com.agency.koda.service.DeptInfoService;
import com.agency.koda.utils.BaseController;

/**
 * 部门管理信息控制类
 * @author meng
 */

@Controller
@RequestMapping(value="/deptInfo")
public class DeptInfoController extends BaseController
{
	
	@Autowired
	private DeptInfoService deptService;
	
	/**
	 * 加载部门管理信息列表
	 * @return
	 */
	@RequestMapping(value="/loadDeptInfoList",method=RequestMethod.GET)
	public ModelAndView loadDeptInfoList(HttpServletRequest request)
	{
		ModelAndView mav=new ModelAndView();
		UserInfo userInfo=this.getUserFromSession(request);
		if(null!=userInfo)
		{
			//根据使用公司ID查询当前用户所属公司下面的部门信息
			List<DeptInfo> deptlist=this.deptService.loadDeptList(userInfo.getUosCompanyId());
			mav.setViewName("sys/deptInfoList");
			mav.addObject("deptlist", deptlist);
		}
		return mav;
	}
	
	/**
	 * 进入添加部门信息界面
	 * @return
	 */
	@RequestMapping(value="/beforAddDept",method=RequestMethod.GET)
	public ModelAndView beforAddDept()
	{
		ModelAndView mav=new ModelAndView();
		mav.setViewName("sys/addDeptInfo");
		return mav;
	}
	
	/**
	 * 添加部门基本信息
	 * @param DeptInfo 部门对象
	 * @return
	 */
	@SuppressWarnings("static-access")
	@RequestMapping(value="/addDeptInfo",method=RequestMethod.POST)
	@ResponseBody
	public void addDeptInfo(DeptInfo deptInfo,HttpServletResponse response,HttpServletRequest request)
	{
		UserInfo userInfo=this.getUserFromSession(request);
		if(null!=userInfo)
		{
		deptInfo.setDsCompanyId(userInfo.getUosCompanyId());//使用公司
		deptInfo.setDsDeptId(this.major("DS"));//部门ID
		result=this.deptService.addDeptInfo(deptInfo);
		}
		this.writeMsg(response, result);
	}
	
	/**
	 * 根据部门ID查询部门对象信息
	 * @param dsDeptId 部门ID
	 * @return
	 */
	@RequestMapping(value="/beforUpdateDept",method=RequestMethod.GET)
	public ModelAndView beforUpdateDept(@RequestParam("dsDeptId") String dsDeptId)
	{
		ModelAndView mav=new ModelAndView();
		if(null!=dsDeptId && !dsDeptId.equals(""))
		{
			DeptInfo dept=this.deptService.loadDeptEntity(dsDeptId);
			mav.setViewName("sys/updateDeptInfo");
			mav.addObject("dept",dept);
		}
		return mav;
	}
	
	/**
	 * 修改部门信息
	 * @param deptInfo 部门对象
	 * @param response
	 */
	@RequestMapping(value="/updateDept",method=RequestMethod.POST)
	@ResponseBody
	public void updateDept(DeptInfo deptInfo,HttpServletResponse response)
	{
		result=this.deptService.updateDepetlist(deptInfo);
		this.writeMsg(response, result);
	}

}
