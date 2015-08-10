package com.agency.koda.model;

import java.io.Serializable;

/**
 * 子菜单对象
 * 
 * @author Waco
 *
 */
public class SubmenuInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 子菜单ID
	 */
	private String smsSubmenuId;
	/**
	 * 子菜单名称
	 */
	private String smsSubmenuName;
	/**
	 * 菜单链接路径
	 */
	private String smsSubmenuLike;

	/**
	 * 主菜单ID
	 */
	private String smsMenuId;
	/**
	 * 菜单类型
	 */
	private int smsSubmenuType;

	public String getSmsSubmenuId() {
		return smsSubmenuId;
	}

	public void setSmsSubmenuId(String smsSubmenuId) {
		this.smsSubmenuId = smsSubmenuId;
	}

	public String getSmsSubmenuName() {
		return smsSubmenuName;
	}

	public void setSmsSubmenuName(String smsSubmenuName) {
		this.smsSubmenuName = smsSubmenuName;
	}

	public String getSmsSubmenuLike() {
		return smsSubmenuLike;
	}

	public void setSmsSubmenuLike(String smsSubmenuLike) {
		this.smsSubmenuLike = smsSubmenuLike;
	}

	public String getSmsMenuId() {
		return smsMenuId;
	}

	public void setSmsMenuId(String smsMenuId) {
		this.smsMenuId = smsMenuId;
	}

	public int getSmsSubmenuType() {
		return smsSubmenuType;
	}

	public void setSmsSubmenuType(int smsSubmenuType) {
		this.smsSubmenuType = smsSubmenuType;
	}

	public SubmenuInfo() {
		super();
	}

	public SubmenuInfo(String smsSubmenuId, String smsSubmenuName,
			String smsSubmenuLike, String smsMenuId, int smsSubmenuType) {
		super();
		this.smsSubmenuId = smsSubmenuId;
		this.smsSubmenuName = smsSubmenuName;
		this.smsSubmenuLike = smsSubmenuLike;
		this.smsMenuId = smsMenuId;
		this.smsSubmenuType = smsSubmenuType;
	}

}
