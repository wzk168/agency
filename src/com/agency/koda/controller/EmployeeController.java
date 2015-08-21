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

import com.agency.koda.model.DeptBaseClass;
import com.agency.koda.model.Employee;
import com.agency.koda.model.EmployeeBaseClass;
import com.agency.koda.service.EmployeeService;
import com.agency.koda.utils.BaseController;
import com.agency.koda.utils.Page;

/**
 * 员工控制层实现
 * @author meng
 */
@Controller
@RequestMapping(value="/employee")
public class EmployeeController extends BaseController
{
	
	@Autowired
	private EmployeeService empService;
	
	/**
	 * 进入员工信息列表
	 * @return
	 */
	@RequestMapping(value="/beforLoadEmployeeList",method=RequestMethod.GET)
	public ModelAndView beforLoadEmployeeList(@RequestParam("pageNow") int pageNow,
			@RequestParam(value="esEmplName",required=false) String esEmplName,
			@RequestParam(value="esDeptId",required=false) String esDeptId)
	{
		ModelAndView mav=new ModelAndView();
		mav.setViewName("sys/employeeList");
		Page page=new Page(pageNow, pageSize, this.empService.loadEmployeeCount(esEmplName, esDeptId));
		List<EmployeeBaseClass> emplist=this.empService.loadEmployeeList(pageNow, pageSize, esEmplName, esDeptId);
		List<DeptBaseClass> deptlist=this.deptlist();
		mav.addObject("page", page);
		mav.addObject("emplist", emplist);
		mav.addObject("deptlist", deptlist);
		return mav;
	}
	
	/**
	 * 进入员工添加界面
	 * @return
	 */
	@RequestMapping(value="/beforAddEmployee",method=RequestMethod.GET)
	public ModelAndView beforAddEmployee()
	{
		ModelAndView mav=new ModelAndView();
		List<DeptBaseClass> deptlist=this.deptlist();
		mav.setViewName("sys/addEmployee");
		mav.addObject("deptlist",deptlist);
		return mav;
	}
	
	/**
	 * 添加员工基本信息
	 * @param employee
	 * @param response
	 */
	@RequestMapping(value="/addEmployee",method=RequestMethod.POST)
	@ResponseBody
	public void addEmployee(Employee employee,HttpServletResponse response,
			HttpServletRequest request)
	{
		employee.setEsEmplId(major("ES"));//主键
		employee.setEsCompanyId(this.getUserFromSession(request).getUosCompanyId());//使用公司
		result=this.empService.addEmployeeInfo(employee);
		this.writeMsg(response, result);
	}
	
	
	
	
	
	
	
	
	

}
