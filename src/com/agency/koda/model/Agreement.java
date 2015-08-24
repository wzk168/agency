package com.agency.koda.model;

import java.io.Serializable;
import java.util.Date;
/**
 * 协议实体类
 * @author meng
 *
 */


@SuppressWarnings("serial")
public class Agreement implements Serializable
{
	/**
	 * 协议ID
	 * ag_agree_id
	 */
	private String agAgreeId;
	
	/**
	 * 分支机构
	 * ag_branch_id
	 */
	private String agBranchId;
	
	/**
	 * 险种
	 * ag_insurancetype
	 */
	private String agInsuranceType;
	
	/**
	 * 使用性质
	 * ag_agree_nature
	 */
	private String agAgreeNature;
	
	/**
	 * 登记
	 * ag_agree_grade
	 */
	private String agAgreeGrade;
	
	
	/**
	 * 系数
	 * ag_agree_factor
	 */
	private double agAgreeFactor;
	
	/**
	 * 费率
	 * ag_agree_rate
	 */
	private double agAgreeRate;
	
	
	/**
	 * 佣金1
	 * ag_agree_onecommis
	 */
	private double agAgreeOneCommis;
 
	
	/**
	 * 佣金2
	 * ag_agree_twocommis
	 */
	private double agAgreeTwoCommis;
	
	/**
	 * 生效时间
	 * ag_agree_effectivetime
	 */
	private Date agAgreeEffectiveTime;
	
	/**
	 * 截止时间
	 * ag_agree_expirytime
	 */
	private Date agAgreeExpiryTime;
	
	/**
	 * 备注信息
	 * ag_agree_remark
	 */
	private String agAgreeRemark;
	/**
	 * 批号
	 * ag_agree_batchnum
	 */
	private String agAgreeBatchnum;
    /**
     * 使用公司
     * ag_company_id	
     */
	private String agCompanyId;
	public String getAgAgreeId() {
		return agAgreeId;
	}
	public void setAgAgreeId(String agAgreeId) {
		this.agAgreeId = agAgreeId;
	}
	public String getAgBranchId() {
		return agBranchId;
	}
	public void setAgBranchId(String agBranchId) {
		this.agBranchId = agBranchId;
	}
	public String getAgInsuranceType() {
		return agInsuranceType;
	}
	public void setAgInsuranceType(String agInsuranceType) {
		this.agInsuranceType = agInsuranceType;
	}
	public String getAgAgreeNature() {
		return agAgreeNature;
	}
	public void setAgAgreeNature(String agAgreeNature) {
		this.agAgreeNature = agAgreeNature;
	}
	public String getAgAgreeGrade() {
		return agAgreeGrade;
	}
	public void setAgAgreeGrade(String agAgreeGrade) {
		this.agAgreeGrade = agAgreeGrade;
	}
	public double getAgAgreeFactor() {
		return agAgreeFactor;
	}
	public void setAgAgreeFactor(double agAgreeFactor) {
		this.agAgreeFactor = agAgreeFactor;
	}
	public double getAgAgreeRate() {
		return agAgreeRate;
	}
	public void setAgAgreeRate(double agAgreeRate) {
		this.agAgreeRate = agAgreeRate;
	}
	public double getAgAgreeOneCommis() {
		return agAgreeOneCommis;
	}
	public void setAgAgreeOneCommis(double agAgreeOneCommis) {
		this.agAgreeOneCommis = agAgreeOneCommis;
	}
	public double getAgAgreeTwoCommis() {
		return agAgreeTwoCommis;
	}
	public void setAgAgreeTwoCommis(double agAgreeTwoCommis) {
		this.agAgreeTwoCommis = agAgreeTwoCommis;
	}
	public Date getAgAgreeEffectiveTime() {
		return agAgreeEffectiveTime;
	}
	public void setAgAgreeEffectiveTime(Date agAgreeEffectiveTime) {
		this.agAgreeEffectiveTime = agAgreeEffectiveTime;
	}
	public Date getAgAgreeExpiryTime() {
		return agAgreeExpiryTime;
	}
	public void setAgAgreeExpiryTime(Date agAgreeExpiryTime) {
		this.agAgreeExpiryTime = agAgreeExpiryTime;
	}
	public String getAgAgreeRemark() {
		return agAgreeRemark;
	}
	public void setAgAgreeRemark(String agAgreeRemark) {
		this.agAgreeRemark = agAgreeRemark;
	}
	public String getAgAgreeBatchnum() {
		return agAgreeBatchnum;
	}
	public void setAgAgreeBatchnum(String agAgreeBatchnum) {
		this.agAgreeBatchnum = agAgreeBatchnum;
	}
	public String getAgCompanyId() {
		return agCompanyId;
	}
	public void setAgCompanyId(String agCompanyId) {
		this.agCompanyId = agCompanyId;
	}
	
	
	
}
