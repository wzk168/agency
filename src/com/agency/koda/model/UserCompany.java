package com.agency.koda.model;
import java.io.Serializable;
/**
 *使用公司实体类
 *@author meng 
 *2015-07-28
 */
@SuppressWarnings("serial")
public class UserCompany implements Serializable
{

	/**
	 * 使用公司ID
	 * ucs_company_id
	 */
	private String ucsCompanyId;
	/**
	 * 使用公司名称
	 * ucs_company_name
	 */
	private String ucsCompanyName;

	/**
	 * 公司编号
	 * ucs_company_number
	 */
	private String ucsCompanyNumber;

	/**
	 *使用公司状态
	 *ucs_company_state 
	 */
	private int ucsCompanyState;

	/**
	 * 使用公司地址
	 * ucs_company_address
	 */
	private String ucsCompanyAddress;

	/**
	 * 使用公司电话
	 * ucs_company_phone
	 */
	private String ucsCompanyPhone;

	/**
	 * 联系人
	 * ucs_company_linkman
	 */
	private String ucsCompanyLinkman;


	public String getUcsCompanyId() {
		return ucsCompanyId;
	}

	public void setUcsCompanyId(String ucsCompanyId) {
		this.ucsCompanyId = ucsCompanyId;
	}

	public String getUcsCompanyName() {
		return ucsCompanyName;
	}

	public void setUcsCompanyName(String ucsCompanyName) {
		this.ucsCompanyName = ucsCompanyName;
	}

	public String getUcsCompanyNumber() {
		return ucsCompanyNumber;
	}

	public void setUcsCompanyNumber(String ucsCompanyNumber) {
		this.ucsCompanyNumber = ucsCompanyNumber;
	}

	public int getUcsCompanyState() {
		return ucsCompanyState;
	}

	public void setUcsCompanyState(int ucsCompanyState) {
		this.ucsCompanyState = ucsCompanyState;
	}

	public String getUcsCompanyAddress() {
		return ucsCompanyAddress;
	}

	public void setUcsCompanyAddress(String ucsCompanyAddress) {
		this.ucsCompanyAddress = ucsCompanyAddress;
	}

	public String getUcsCompanyPhone() {
		return ucsCompanyPhone;
	}

	public void setUcsCompanyPhone(String ucsCompanyPhone) {
		this.ucsCompanyPhone = ucsCompanyPhone;
	}

	public String getUcsCompanyLinkman() {
		return ucsCompanyLinkman;
	}

	public void setUcsCompanyLinkman(String ucsCompanyLinkman) {
		this.ucsCompanyLinkman = ucsCompanyLinkman;
	}




}
