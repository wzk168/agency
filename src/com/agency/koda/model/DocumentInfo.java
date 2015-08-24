package com.agency.koda.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 单证实体类
 * @author meng
 */

@SuppressWarnings("serial")
public class DocumentInfo implements Serializable
{
	//1入库2出库3领用4回销5结余6	丢失;
	/**
	 * 入库
	 */
	public static final int enter=1;
	
	/**
	 * 出库
	 */
	public static final int put=2;
	
	/**
	 * 领用
	 */
	@SuppressWarnings("unused")
	private static final int employ=3;
	/**
	 * 回销
	 */
	public static final int resold=4;	
    
    /**
     * 结余
     */
	public static final int surplus=5;
    
    /**
     * 丢失
     */
	public static final int lose=6;
    
    
	/**
	 * dg_document_id
	 * 单证ID
	 */
	private String dgDocumentId;
	
	/**
	 * 单证序号
	 * dg_document_serial
	 */
	private String dgDocumentSerial;
	
	/**
	 * 分支机构
	 * dg_branch_id
	 */
	private String dgBranchId;
	
	/**
	 * 单证类型
	 * dg_document_type
	 */
	private int dgDocumentType;
	
	/**
	 * 单证状态
	 * dg_document_state
	 */
	private int dgDocumentState;
	
	/**
	 * 入库时间
	 * dg_document_entertime
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dgDocumentEnterTime;
	
	/**
	 * 出库时间
	 * dg_document_cometime
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dgDocumentComeTime;
	
	/**
	 * 领用时间
	 * dg_document_usetime
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dgDocumentUsetime;

	/**
	 * 批号
	 * dg_document_batchnumber
	 */
	private String dgDocumentBatchNumber;
	
	/**
	 * 领用人
	 * dg_document_useman
	 */
	private String dgDocumentUseman;
	
	/**
	 * 领用部门
	 * dg_document_dept_id
	 */
	private String dgDocumentDeptId;
	
	/**
	 * 备注信息
	 * dg_document_remark
	 */
	private String dgDocumentRemark;
	
	/**
	 * 使用公司
	 * dg_company_id
	 */
	private String dgCompanyId;
	
	/**
	 * 操作人
	 * dg_document_operation
	 */
	private String dgDocumentOperation;
	
	//**********以下字段不在数据库字段中**********
	private String serial;
	private int seria2;
	private int seria3;
	/**
	 * 分支机构名称
	 */
	private String branchName;
	

	public String getDgDocumentId() {
		return dgDocumentId;
	}

	public void setDgDocumentId(String dgDocumentId) {
		this.dgDocumentId = dgDocumentId;
	}

	public String getDgDocumentSerial() {
		return dgDocumentSerial;
	}

	public void setDgDocumentSerial(String dgDocumentSerial) {
		this.dgDocumentSerial = dgDocumentSerial;
	}

	public String getDgBranchId() {
		return dgBranchId;
	}

	public void setDgBranchId(String dgBranchId) {
		this.dgBranchId = dgBranchId;
	}

	public int getDgDocumentType() {
		return dgDocumentType;
	}

	public void setDgDocumentType(int dgDocumentType) {
		this.dgDocumentType = dgDocumentType;
	}

	public int getDgDocumentState() {
		return dgDocumentState;
	}

	public void setDgDocumentState(int dgDocumentState) {
		this.dgDocumentState = dgDocumentState;
	}

	public Date getDgDocumentEnterTime() {
		return dgDocumentEnterTime;
	}

	public void setDgDocumentEnterTime(Date dgDocumentEnterTime) {
		this.dgDocumentEnterTime = dgDocumentEnterTime;
	}

	public Date getDgDocumentComeTime() {
		return dgDocumentComeTime;
	}

	public void setDgDocumentComeTime(Date dgDocumentComeTime) {
		this.dgDocumentComeTime = dgDocumentComeTime;
	}

	public Date getDgDocumentUsetime() {
		return dgDocumentUsetime;
	}

	public void setDgDocumentUsetime(Date dgDocumentUsetime) {
		this.dgDocumentUsetime = dgDocumentUsetime;
	}

	public String getDgDocumentBatchNumber() {
		return dgDocumentBatchNumber;
	}

	public void setDgDocumentBatchNumber(String dgDocumentBatchNumber) {
		this.dgDocumentBatchNumber = dgDocumentBatchNumber;
	}

	public String getDgDocumentUseman() {
		return dgDocumentUseman;
	}

	public void setDgDocumentUseman(String dgDocumentUseman) {
		this.dgDocumentUseman = dgDocumentUseman;
	}

	public String getDgDocumentDeptId() {
		return dgDocumentDeptId;
	}

	public void setDgDocumentDeptId(String dgDocumentDeptId) {
		this.dgDocumentDeptId = dgDocumentDeptId;
	}

	public String getDgDocumentRemark() {
		return dgDocumentRemark;
	}

	public void setDgDocumentRemark(String dgDocumentRemark) {
		this.dgDocumentRemark = dgDocumentRemark;
	}

	public String getDgCompanyId() {
		return dgCompanyId;
	}

	public void setDgCompanyId(String dgCompanyId) {
		this.dgCompanyId = dgCompanyId;
	}

	
	public String getDgDocumentOperation() {
		return dgDocumentOperation;
	}

	public void setDgDocumentOperation(String dgDocumentOperation) {
		this.dgDocumentOperation = dgDocumentOperation;
	}

	public void setSeria2(int seria2) {
		this.seria2 = seria2;
	}

	public void setSeria3(int seria3) {
		this.seria3 = seria3;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public int getSeria2() {
		return seria2;
	}

	public int getSeria3() {
		return seria3;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	
	
	
}
