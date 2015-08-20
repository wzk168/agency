package com.agency.koda.model;

import java.io.Serializable;

/**
 * 保险公司基类用于公共方法
 * @author meng
 *
 */
@SuppressWarnings("serial")
public class InsuranceBaseClass implements Serializable
{
	/**
	 * 保险公司ID
	 */
	private String insuranceId;
	
	/**
	 * 保险公司简称
	 */
	private String insuranceName;

	public String getInsuranceId() {
		return insuranceId;
	}

	public void setInsuranceId(String insuranceId) {
		this.insuranceId = insuranceId;
	}

	public String getInsuranceName() {
		return insuranceName;
	}

	public void setInsuranceName(String insuranceName) {
		this.insuranceName = insuranceName;
	}
	
	
	

}
