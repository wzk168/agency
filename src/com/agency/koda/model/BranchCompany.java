package com.agency.koda.model;
import java.io.Serializable;
/**
 * 分支机构实体
 * @author meng
 */
@SuppressWarnings("serial")
public class BranchCompany implements Serializable
{

	/**
	 * 分支机构ID
	 * bcg_branch_id
	 */
	private String bcgBranchId;
	
	/**
	 * 分支机构全称
	 * bcg_branch_name
	 */
	private String bcgBranchName;
	
	/**
	 * 分支机构简称
	 * bcgBranchShort
	 */
	private String bcgBranchShort;
	
	/**
	 * 分支机构地址
	 * bcg_branch_adress
	 */
	private String bcgBranchAdress;
	
	/**
	 * 公司业务类型类型
	 * bcg_branch_type
	 */
     private int bcgBranchType;
	
     /**
      * 公司出单情况
      * bcg_branch_situation
      */
     private int bcgBranchSituation;
     
     /**
      * 机构电话
      * bcg_branch_phone
      */
     private String bcgBranchPhone;
	
     /**
      * 公司邮箱
      * bcg_branch_email
      */
     private String bcgBranchEmail;
     
     /**
      * 联系人
      * bcg_branch_man
      */
     private String bcgBranchMan;
     
     /**
      * 备注信息
      * bcg_branch_remark
      */
     private String bcgBranchRemark;
     
     /**
      * 使用公司ID
      * bcg_company_id
      */
     private String bcgCompanyId;
     
     
     /**
      * 保险公司ID
      * bcg_inscompany_id
      * @return
      */
     private String bcgInscompanyId;

	public String getBcgBranchId() {
		return bcgBranchId;
	}

	public void setBcgBranchId(String bcgBranchId) {
		this.bcgBranchId = bcgBranchId;
	}

	public String getBcgBranchName() {
		return bcgBranchName;
	}

	public void setBcgBranchName(String bcgBranchName) {
		this.bcgBranchName = bcgBranchName;
	}

	public String getBcgBranchShort() {
		return bcgBranchShort;
	}

	public void setBcgBranchShort(String bcgBranchShort) {
		this.bcgBranchShort = bcgBranchShort;
	}

	public String getBcgBranchAdress() {
		return bcgBranchAdress;
	}

	public void setBcgBranchAdress(String bcgBranchAdress) {
		this.bcgBranchAdress = bcgBranchAdress;
	}

	public int getBcgBranchType() {
		return bcgBranchType;
	}

	public void setBcgBranchType(int bcgBranchType) {
		this.bcgBranchType = bcgBranchType;
	}

	public int getBcgBranchSituation() {
		return bcgBranchSituation;
	}

	public void setBcgBranchSituation(int bcgBranchSituation) {
		this.bcgBranchSituation = bcgBranchSituation;
	}

	public String getBcgBranchPhone() {
		return bcgBranchPhone;
	}

	public void setBcgBranchPhone(String bcgBranchPhone) {
		this.bcgBranchPhone = bcgBranchPhone;
	}

	public String getBcgBranchEmail() {
		return bcgBranchEmail;
	}

	public void setBcgBranchEmail(String bcgBranchEmail) {
		this.bcgBranchEmail = bcgBranchEmail;
	}

	public String getBcgBranchMan() {
		return bcgBranchMan;
	}

	public void setBcgBranchMan(String bcgBranchMan) {
		this.bcgBranchMan = bcgBranchMan;
	}

	public String getBcgBranchRemark() {
		return bcgBranchRemark;
	}

	public void setBcgBranchRemark(String bcgBranchRemark) {
		this.bcgBranchRemark = bcgBranchRemark;
	}

	public String getBcgCompanyId() {
		return bcgCompanyId;
	}

	public void setBcgCompanyId(String bcgCompanyId) {
		this.bcgCompanyId = bcgCompanyId;
	}

	public String getBcgInscompanyId() {
		return bcgInscompanyId;
	}

	public void setBcgInscompanyId(String bcgInscompanyId) {
		this.bcgInscompanyId = bcgInscompanyId;
	}
     
     
}
