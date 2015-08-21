package com.agency.koda.service;

import java.util.List;

import com.agency.koda.model.TeamBaseClass;
import com.agency.koda.model.TeamInfo;

/**
 * 团队service
 * @author meng
 *
 */
public interface TeamInfoService {

	
	/**
	 * 添加团队基本信息
	 * @param teamInfo
	 * @return
	 */
	public int addTeamInfo(TeamInfo teamInfo);
	
	/**
	 * 修改团队信息
	 * @param teamInfo
	 * @return
	 */
	public int updateTeamInfo(TeamInfo teamInfo);
	
	/**
	 * 团队查询信息
	 * @param teamName 团队名称
	 * @param teamType 团队类型
	 * @param teamPrincipal 团队负责人
	 * @return
	 */
	public List<TeamInfo> loadTeamList(String teamName,int teamType,String teamPrincipal);
	
	/**
	 * 根据团队ID查询团队对象
	 * @param tsTeamId 团队ID
	 * @return
	 */
	public TeamInfo loadTeamEntity(String tsTeamId);
	
	
	/**
	 * 根据部门ID查询t团队信息	
	 * @param tsDeptId 根据部门ID查询团队
	 * @return
	 */
	public List<TeamBaseClass> loadTeamByDeptId(String tsDeptId);
	
	
}
