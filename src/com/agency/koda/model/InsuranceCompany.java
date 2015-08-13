package com.agency.koda.model;

import java.io.Serializable;

/**
 * 保险公司实体
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class InsuranceCompany implements Serializable{
	
	/**
	 * 保险公司ID
	 * icg_inscompany_id
	 */
	private String icgInscompanyId;
	
	/**
	 * 保险公司全称
	 * icg_inscompany_name
	 */
	private String icgInscompanyName;
	
	/**
	 * 保险公司简称
	 * icg_inscompany_short
	 */
	private String icgInscompanyShort;
	
	/**
	 * 公司地址
	 * icg_inscompany_address
	 */
	private String icgInscompanyAddress;
	
	/**
	 * 业务类型
	 * icg_inscompany_type
	 */
	private int icgInscompanyType;
	
	/**
	 * 出单情况
	 * icg_inscompany_situation
	 */
	private int icgInscompanySituation;
	
	/**
	 * 公司电话
	 * icg_inscompany_phone
	 */
	private String icgInscompanyPhone;
	
	/**
	 * 公司邮箱
	 * icg_inscompany_email
	 */
	private String icgInscompanyEmail;

	/**
	 * 公司传真
	 * icg_inscompany_fax
	 */
	private String icgInscompanyFax;
	
	/**
	 * 公司联系人
	 * icg_inscompany_man
	 */
	private String icgInscompanyMan;
	
	/**
	 * 公司网站
	 * icg_inscompany_website
	 */
	private String icgInscompanyWebsite;
	
	/**
	 * 开户银行
	 * icg_inscompany_bank
	 */
	private String icgInscompanyBank;
	
	/**
	 * 银行账号
	 * icg_inscompany_account
	 */
	private String icgInscompanyAccount;
	
	/**
	 * 备注信息
	 * icg_inscompany_remark
	 */
	private String icgInscompanyRemark;
	
	/**
	 * 使用公司
	 * icg_company_id
	 */
	private String icgCompanyId;

	public String getIcgInscompanyId() {
		return icgInscompanyId;
	}

	public void setIcgInscompanyId(String icgInscompanyId) {
		this.icgInscompanyId = icgInscompanyId;
	}

	public String getIcgInscompanyName() {
		return icgInscompanyName;
	}

	public void setIcgInscompanyName(String icgInscompanyName) {
		this.icgInscompanyName = icgInscompanyName;
	}

	public String getIcgInscompanyShort() {
		return icgInscompanyShort;
	}

	public void setIcgInscompanyShort(String icgInscompanyShort) {
		this.icgInscompanyShort = icgInscompanyShort;
	}

	public String getIcgInscompanyAddress() {
		return icgInscompanyAddress;
	}

	public void setIcgInscompanyAddress(String icgInscompanyAddress) {
		this.icgInscompanyAddress = icgInscompanyAddress;
	}

	public int getIcgInscompanyType() {
		return icgInscompanyType;
	}

	public void setIcgInscompanyType(int icgInscompanyType) {
		this.icgInscompanyType = icgInscompanyType;
	}

	public int getIcgInscompanySituation() {
		return icgInscompanySituation;
	}

	public void setIcgInscompanySituation(int icgInscompanySituation) {
		this.icgInscompanySituation = icgInscompanySituation;
	}

	public String getIcgInscompanyPhone() {
		return icgInscompanyPhone;
	}

	public void setIcgInscompanyPhone(String icgInscompanyPhone) {
		this.icgInscompanyPhone = icgInscompanyPhone;
	}

	public String getIcgInscompanyEmail() {
		return icgInscompanyEmail;
	}

	public void setIcgInscompanyEmail(String icgInscompanyEmail) {
		this.icgInscompanyEmail = icgInscompanyEmail;
	}

	public String getIcgInscompanyFax() {
		return icgInscompanyFax;
	}

	public void setIcgInscompanyFax(String icgInscompanyFax) {
		this.icgInscompanyFax = icgInscompanyFax;
	}

	public String getIcgInscompanyMan() {
		return icgInscompanyMan;
	}

	public void setIcgInscompanyMan(String icgInscompanyMan) {
		this.icgInscompanyMan = icgInscompanyMan;
	}

	public String getIcgInscompanyWebsite() {
		return icgInscompanyWebsite;
	}

	public void setIcgInscompanyWebsite(String icgInscompanyWebsite) {
		this.icgInscompanyWebsite = icgInscompanyWebsite;
	}

	public String getIcgInscompanyBank() {
		return icgInscompanyBank;
	}

	public void setIcgInscompanyBank(String icgInscompanyBank) {
		this.icgInscompanyBank = icgInscompanyBank;
	}

	public String getIcgInscompanyAccount() {
		return icgInscompanyAccount;
	}

	public void setIcgInscompanyAccount(String icgInscompanyAccount) {
		this.icgInscompanyAccount = icgInscompanyAccount;
	}

	public String getIcgInscompanyRemark() {
		return icgInscompanyRemark;
	}

	public void setIcgInscompanyRemark(String icgInscompanyRemark) {
		this.icgInscompanyRemark = icgInscompanyRemark;
	}

	public String getIcgCompanyId() {
		return icgCompanyId;
	}

	public void setIcgCompanyId(String icgCompanyId) {
		this.icgCompanyId = icgCompanyId;
	}
	
	
}
