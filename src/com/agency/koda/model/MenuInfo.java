package com.agency.koda.model;

import java.io.Serializable;

/**
 * 系统菜单对象
 * 
 * @author Waco
 *
 */
public class MenuInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 菜单ID
	 */
	private String msMenuId;
	/**
	 * 菜单名
	 */
	private String msMenuname;
	/**
	 * 图片名
	 */
	private String msMenuImg;

	public String getMsMenuId() {
		return msMenuId;
	}

	public void setMsMenuId(String msMenuId) {
		this.msMenuId = msMenuId;
	}

	public String getMsMenuname() {
		return msMenuname;
	}

	public void setMsMenuname(String msMenuname) {
		this.msMenuname = msMenuname;
	}

	public String getMsMenuImg() {
		return msMenuImg;
	}

	public void setMsMenuImg(String msMenuImg) {
		this.msMenuImg = msMenuImg;
	}

	public MenuInfo(String msMenuId, String msMenuname, String msMenuImg) {
		super();
		this.msMenuId = msMenuId;
		this.msMenuname = msMenuname;
		this.msMenuImg = msMenuImg;
	}

	public MenuInfo() {
		super();
	}

}
