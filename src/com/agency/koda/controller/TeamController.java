package com.agency.koda.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.agency.koda.model.DeptInfo;
import com.agency.koda.model.TeamBaseClass;
import com.agency.koda.model.TeamInfo;
import com.agency.koda.service.DeptInfoService;
import com.agency.koda.service.TeamInfoService;
import com.agency.koda.utils.BaseController;
import com.agency.koda.utils.JsonUtil;
/**
 * 团队控制类
 * @author meng
 *
 */
@Controller
@RequestMapping(value="/team")
public class TeamController extends BaseController
{
	@Autowired
	private TeamInfoService teamService;//团队Service
	
	@Autowired
	private DeptInfoService deptService;//部门Serivce
	
	/**
	 * 加载筛选团队列表信息
	 * @param teamName 团队名
	 * @param teamPrincipal 负责人
	 * @param teamType 团队类型
	 * @return
	 */
	@RequestMapping(value="/loadTeamList",method=RequestMethod.GET)
	public ModelAndView loadTeamList(@RequestParam(value="teamName",required=false) String teamName,
			@RequestParam(value="teamPrincipal",required=false) String teamPrincipal,
			@RequestParam("teamType") int teamType,HttpServletRequest request)
	{
		ModelAndView mav=new ModelAndView();
		List<DeptInfo> deptlist=this.deptService.loadDeptList(this.getUserFromSession(request).getUosCompanyId());
		List<TeamInfo> teamlist=this.teamService.loadTeamList(teamName, teamType, teamPrincipal);
		mav.addObject("teamlist",teamlist);
		mav.addObject("deptlist",deptlist);
		mav.setViewName("sys/teamList");
		return mav;
	}
	
	/**
	 * 添加团队信息
	 * @param teamInfo 团队对象
	 * @param response
	 */
	@SuppressWarnings("static-access")
	@RequestMapping(value="/addTeamInfo",method=RequestMethod.POST)
	@ResponseBody
	public void addTeamInfo(TeamInfo teamInfo,HttpServletResponse response,HttpServletRequest request)
	{
		teamInfo.setTsCompanyId(this.getUserFromSession(request).getUosCompanyId());//公司
		teamInfo.setTsTeamId(this.major("TS"));//主键
		result=this.teamService.addTeamInfo(teamInfo);
		this.writeMsg(response, result);
	}
	
	/**
	 * 修改团队信息
	 * @param teamInfo 团队对象
	 * @param response
	 */
	@RequestMapping(value="/updTeamInfo",method=RequestMethod.POST)
	@ResponseBody
	public void updTeamInfo(TeamInfo teamInfo,HttpServletResponse response)
	{
		result=this.teamService.updateTeamInfo(teamInfo);
		this.writeMsg(response, result);
	}
	
	/**
	 * 根据团队ID查询团队对象
	 * @param tsTeamId 团队ID
	 * @return
	 */
	@RequestMapping(value="/loadTeamInfoEntity",method=RequestMethod.POST)
	@ResponseBody
	public void loadTeamInfoEntity(@RequestParam("tsTeamId") String tsTeamId,HttpServletResponse response)
	{
		TeamInfo teamInfo=this.teamService.loadTeamEntity(tsTeamId);
		String team=JsonUtil.beanToJson(teamInfo);
		this.writeMsg(response, team);
	}
	
	//根据部门ID查询该部门下的所有团队
	@RequestMapping(value="/teamListByDeptId",method=RequestMethod.POST)
	@ResponseBody
	public void teamListByDeptId(@RequestParam("tsDeptId") String tsDeptId,HttpServletResponse response)
	{
		List<TeamBaseClass> teamlist=this.teamService.loadTeamByDeptId(tsDeptId);
		JSONObject json = new JSONObject();
		json.put("teamlist", teamlist);
		this.writeMsg(response, json.toString());
		
	}

}
