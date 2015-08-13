package com.agency.koda.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.agency.koda.model.TeamInfo;
import com.agency.koda.service.TeamInfoService;
import com.agency.koda.utils.BaseController;
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
	
	/**
	 * 加载筛选团队列表信息
	 * @param teamName 团队名
	 * @param teamPrincipal 负责人
	 * @param teamType 团队类型
	 * @return
	 */
	@RequestMapping(value="/loadTeamList",method=RequestMethod.GET)
	public ModelAndView loadTeamList(@RequestParam("teamName") String teamName,
			@RequestParam("teamPrincipal") String teamPrincipal,
			@RequestParam("teamType") int teamType)
	{
		ModelAndView mav=new ModelAndView();
		List<TeamInfo> teamlist=this.teamService.loadTeamList(teamName, teamType, teamPrincipal);
		mav.addObject("teamlist",teamlist);
		mav.setViewName("");
		return mav;
	}
	
	/**
	 * 添加团队信息
	 * @param teamInfo 团队对象
	 * @param response
	 */
	@RequestMapping(value="/addTeamInfo",method=RequestMethod.POST)
	@ResponseBody
	public void addTeamInfo(TeamInfo teamInfo,HttpServletResponse response)
	{
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
	
	
	
	

}
