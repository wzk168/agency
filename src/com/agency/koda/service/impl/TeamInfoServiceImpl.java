package com.agency.koda.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agency.koda.dao.TeamInfoDao;
import com.agency.koda.model.TeamBaseClass;
import com.agency.koda.model.TeamInfo;
import com.agency.koda.service.TeamInfoService;
/**
 * 团队serviceimpl实现
 * @author meng
 *
 */
@Service
public class TeamInfoServiceImpl implements TeamInfoService 
{
	@Autowired
	private TeamInfoDao teamDao;//团队dao
	//添加团队
	@Override
	public int addTeamInfo(TeamInfo teamInfo) {
		return teamDao.addTeamInfo(teamInfo);
	}
	//团队条件筛选列表
	@Override
	public List<TeamInfo> loadTeamList(String teamName, int teamType,
			String teamPrincipal) {
		return teamDao.loadTeamList(teamName, teamType, teamPrincipal);
	}
	//修改团队信息
	@Override
	public int updateTeamInfo(TeamInfo teamInfo) {
		return teamDao.updateTeamInfo(teamInfo);
	}
	//根据团队ID查询对象
	@Override
	public TeamInfo loadTeamEntity(String tsTeamId) {
		return teamDao.loadTeamEntity(tsTeamId);
	}
	//根据部门ID查询t团队信息	
	@Override
	public List<TeamBaseClass> loadTeamByDeptId(String tsDeptId) {
		return teamDao.loadTeamByDeptId(tsDeptId);
	}
	
	
	

}
