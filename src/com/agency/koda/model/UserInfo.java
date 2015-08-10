package com.agency.koda.model;

import java.io.Serializable;

/**
 * 用户对象
 * 
 * @author Waco
 *
 */
public class UserInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final String ADMINID = "USER000000000000000";// 超级管理员ID
	public static final String ADMINCOMPANYID = "CPY000000000000000";// 超级管理员公司ID

	/**
	 * 用户ID
	 */
	private String uosUserinfoId;
	/**
	 * 用户名
	 * 
	 */
	private String uosUserinfoName;
	/**
	 * 密码
	 */
	private String uosUserinfoPwd;
	/**
	 * 用户状态
	 */
	private int uosUserinfoState;

	/**
	 * 员工ID
	 */
	private String uosEmployeeId;
	/**
	 * 所属公司ID
	 */
	private String uosCompanyId;
	/**
	 * 公司名称(只是用作对象接收数据，并不映射到数据库字段)
	 */
	private String ucsCompanyName;

	public String getUosUserinfoId() {
		return uosUserinfoId;
	}

	public void setUosUserinfoId(String uosUserinfoId) {
		this.uosUserinfoId = uosUserinfoId;
	}

	public String getUosUserinfoName() {
		return uosUserinfoName;
	}

	public void setUosUserinfoName(String uosUserinfoName) {
		this.uosUserinfoName = uosUserinfoName;
	}

	public String getUosUserinfoPwd() {
		return uosUserinfoPwd;
	}

	public void setUosUserinfoPwd(String uosUserinfoPwd) {
		this.uosUserinfoPwd = uosUserinfoPwd;
	}

	public int getUosUserinfoState() {
		return uosUserinfoState;
	}

	public void setUosUserinfoState(int uosUserinfoState) {
		this.uosUserinfoState = uosUserinfoState;
	}

	public String getUosCompanyId() {
		return uosCompanyId;
	}

	public void setUosCompanyId(String uosCompanyId) {
		this.uosCompanyId = uosCompanyId;
	}

	public String getUosEmployeeId() {
		return uosEmployeeId;
	}

	public void setUosEmployeeId(String uosEmployeeId) {
		this.uosEmployeeId = uosEmployeeId;
	}

	public String getUcsCompanyName() {
		return ucsCompanyName;
	}

	public void setUcsCompanyName(String ucsCompanyName) {
		this.ucsCompanyName = ucsCompanyName;
	}

	public UserInfo() {
		super();
	}

	public UserInfo(String uosUserinfoId, String uosUserinfoName,
			String uosUserinfoPwd, int uosUserinfoState, String uosCompanyId,
			String uosEmployeeId) {
		super();
		this.uosUserinfoId = uosUserinfoId;
		this.uosUserinfoName = uosUserinfoName;
		this.uosUserinfoPwd = uosUserinfoPwd;
		this.uosUserinfoState = uosUserinfoState;
		this.uosCompanyId = uosCompanyId;
		this.uosEmployeeId = uosEmployeeId;
	}

}
