package com.agency.koda.model;

import java.io.Serializable;
/**
 * 团队实体类
 * @author meng
 */

@SuppressWarnings("serial")
public class TeamInfo implements Serializable
{
	/**
	 * 团队ID
	 * ts_team_id
	 */
	private String tsTeamId;

	/**
	 * 团队名称
	 * ts_team_name
	 */
	private String tsTeamName;

	/**
	 * 团队负责人
	 * ts_team_principal
	 */
	private String tsTeamPrincipal;

	/**
	 * 部门ID
	 * ts_dept_id
	 */
	private String tsDeptId;

	/**
	 * 团队类型
	 * ts_team_type 
	 */
	private int tsTeamType;

	/**
	 * 使用公司
	 * ts_company_id
	 */
	private String tsCompanyId;

	public String getTsTeamId() {
		return tsTeamId;
	}

	public void setTsTeamId(String tsTeamId) {
		this.tsTeamId = tsTeamId;
	}

	public String getTsTeamName() {
		return tsTeamName;
	}

	public void setTsTeamName(String tsTeamName) {
		this.tsTeamName = tsTeamName;
	}

	public String getTsTeamPrincipal() {
		return tsTeamPrincipal;
	}

	public void setTsTeamPrincipal(String tsTeamPrincipal) {
		this.tsTeamPrincipal = tsTeamPrincipal;
	}

	public String getTsDeptId() {
		return tsDeptId;
	}

	public void setTsDeptId(String tsDeptId) {
		this.tsDeptId = tsDeptId;
	}

	public int getTsTeamType() {
		return tsTeamType;
	}

	public void setTsTeamType(int tsTeamType) {
		this.tsTeamType = tsTeamType;
	}

	public String getTsCompanyId() {
		return tsCompanyId;
	}

	public void setTsCompanyId(String tsCompanyId) {
		this.tsCompanyId = tsCompanyId;
	}


}
