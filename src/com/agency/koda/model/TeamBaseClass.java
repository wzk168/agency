package com.agency.koda.model;
import java.io.Serializable;
/**
 * 团队公共方法
 * @author meng
 *
 */
@SuppressWarnings("serial")
public class TeamBaseClass implements Serializable
{

	/**
	 * 团队ID
	 */
	private String teamId;

	/**
	 * 团队姓名
	 */
	private String teanName;

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public String getTeanName() {
		return teanName;
	}

	public void setTeanName(String teanName) {
		this.teanName = teanName;
	}

}
