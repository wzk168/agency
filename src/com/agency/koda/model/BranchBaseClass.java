package com.agency.koda.model;

import java.io.Serializable;
/**
 * 分支机构基类用于公共方法调用
 * @author meng
 *
 */

@SuppressWarnings("serial")
public class BranchBaseClass implements Serializable
{
	/**
	 * 分支机构ID
	 */
	private String branchId;
	/**
	 * 分支机构简称
	 */
	private String branchName;
	public String getBranchId() {
		return branchId;
	}
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	
	

}
