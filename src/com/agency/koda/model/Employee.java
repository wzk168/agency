package com.agency.koda.model;
import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 员工实体类
 * @author meng
 */

@SuppressWarnings("serial")
public class Employee implements Serializable
{
	/**
	 * 员工ID
	 * es_empl_id
	 */
	private String esEmplId;

	/**
	 * 员工姓名
	 * es_empl_name
	 */
	private String esEmplName;

	/**
	 * 归属部门
	 * es_dept_id
	 */
	private String esDeptId;

	/**
	 * 团队ID
	 * es_team_id
	 */
	private String esTeamId;

	/**
	 * 性别
	 * es_empl_sex
	 */
	private int esEmplSex;

	/**
	 * 身份证号码
	 * es_empl_card
	 */
	private String esEmplCard;

	/**
	 * 出生日期
	 * es_empl_birthdate
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd")  
	private Date esEmplBirthdate;

	/**
	 * es_empl_marry
	 * 婚否
	 */
	private int esEmplMarry;

	/**
	 * 学历
	 * es_empl_education
	 */
	private int esEmplEducation;

	/**
	 * 入职时间
	 * es_empl_hiredate
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd") 
	private Date esEmplHireEate;
	/**
	 * 职位
	 * es_empl_position
	 */
	private int esEmplPosition;
	
	/**
	 * 电话
	 * esEmplPhone
	 */
	private String esEmplPhone;
	
	/**
	 * 是否在职
	 * es_empl_job
	 */
	private int esEmplJob;
	
	/**
	 * 是否是业务员
	 * es_empl_salesman
	 */
	private int esEmplSalesman;
	
	/**
	 * 紧急联系人
	 * es_empl_emergency
	 */
	private String esEmplEmergency;
	
	/**
	 * 紧急联系人电话
	 * es_empl_emergencyphone
	 */
	private String esEmplEmergencyPhone;
	/**
	 * 职业证号姓名
	 * es_empl_professionname
	 */
	private String esEmplProfessionName;
	
	/**
	 * 职业证号码
	 * es_empl_professioncard
	 */
	private String esEmplProfessionCard; 
	
	/**
	 * 离职时间
	 * es_empl_dimissiondate
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd") 
	private Date esEmplDimissionDate;
	
	/**
	 * 备注信息
	 * es_empl_remark
	 */
	private String esEmplRemark;
	
	/**
	 *使用公司
	 * es_company_id
	 */
	private String esCompanyId;
	
	
	/**
	 * es_placedo_micile
	 * 户籍地址
	 */
	private String esPlacedoMicile;
	
	/**
	 * es_actual_residence
	 * 现住
	 */
	private String esActualResidence;

	public String getEsEmplId() {
		return esEmplId;
	}

	public void setEsEmplId(String esEmplId) {
		this.esEmplId = esEmplId;
	}

	public String getEsEmplName() {
		return esEmplName;
	}

	public void setEsEmplName(String esEmplName) {
		this.esEmplName = esEmplName;
	}

	public String getEsDeptId() {
		return esDeptId;
	}

	public void setEsDeptId(String esDeptId) {
		this.esDeptId = esDeptId;
	}

	public String getEsTeamId() {
		return esTeamId;
	}

	public void setEsTeamId(String esTeamId) {
		this.esTeamId = esTeamId;
	}

	public int getEsEmplSex() {
		return esEmplSex;
	}

	public void setEsEmplSex(int esEmplSex) {
		this.esEmplSex = esEmplSex;
	}

	public String getEsEmplCard() {
		return esEmplCard;
	}

	public void setEsEmplCard(String esEmplCard) {
		this.esEmplCard = esEmplCard;
	}

	public Date getEsEmplBirthdate() {
		return esEmplBirthdate;
	}

	public void setEsEmplBirthdate(Date esEmplBirthdate) {
		this.esEmplBirthdate = esEmplBirthdate;
	}

	public int getEsEmplMarry() {
		return esEmplMarry;
	}

	public void setEsEmplMarry(int esEmplMarry) {
		this.esEmplMarry = esEmplMarry;
	}

	public int getEsEmplEducation() {
		return esEmplEducation;
	}

	public void setEsEmplEducation(int esEmplEducation) {
		this.esEmplEducation = esEmplEducation;
	}

	public Date getEsEmplHireEate() {
		return esEmplHireEate;
	}

	public void setEsEmplHireEate(Date esEmplHireEate) {
		this.esEmplHireEate = esEmplHireEate;
	}

	public int getEsEmplPosition() {
		return esEmplPosition;
	}

	public void setEsEmplPosition(int esEmplPosition) {
		this.esEmplPosition = esEmplPosition;
	}

	public String getEsEmplPhone() {
		return esEmplPhone;
	}

	public void setEsEmplPhone(String esEmplPhone) {
		this.esEmplPhone = esEmplPhone;
	}

	public int getEsEmplJob() {
		return esEmplJob;
	}

	public void setEsEmplJob(int esEmplJob) {
		this.esEmplJob = esEmplJob;
	}

	public int getEsEmplSalesman() {
		return esEmplSalesman;
	}

	public void setEsEmplSalesman(int esEmplSalesman) {
		this.esEmplSalesman = esEmplSalesman;
	}

	public String getEsEmplEmergency() {
		return esEmplEmergency;
	}

	public void setEsEmplEmergency(String esEmplEmergency) {
		this.esEmplEmergency = esEmplEmergency;
	}

	public String getEsEmplEmergencyPhone() {
		return esEmplEmergencyPhone;
	}

	public void setEsEmplEmergencyPhone(String esEmplEmergencyPhone) {
		this.esEmplEmergencyPhone = esEmplEmergencyPhone;
	}

	public String getEsEmplProfessionName() {
		return esEmplProfessionName;
	}

	public void setEsEmplProfessionName(String esEmplProfessionName) {
		this.esEmplProfessionName = esEmplProfessionName;
	}

	public String getEsEmplProfessionCard() {
		return esEmplProfessionCard;
	}

	public void setEsEmplProfessionCard(String esEmplProfessionCard) {
		this.esEmplProfessionCard = esEmplProfessionCard;
	}

	public Date getEsEmplDimissionDate() {
		return esEmplDimissionDate;
	}

	public void setEsEmplDimissionDate(Date esEmplDimissionDate) {
		this.esEmplDimissionDate = esEmplDimissionDate;
	}

	public String getEsEmplRemark() {
		return esEmplRemark;
	}

	public void setEsEmplRemark(String esEmplRemark) {
		this.esEmplRemark = esEmplRemark;
	}

	public String getEsCompanyId() {
		return esCompanyId;
	}

	public void setEsCompanyId(String esCompanyId) {
		this.esCompanyId = esCompanyId;
	}

	public String getEsPlacedoMicile() {
		return esPlacedoMicile;
	}

	public void setEsPlacedoMicile(String esPlacedoMicile) {
		this.esPlacedoMicile = esPlacedoMicile;
	}

	public String getEsActualResidence() {
		return esActualResidence;
	}

	public void setEsActualResidence(String esActualResidence) {
		this.esActualResidence = esActualResidence;
	}
	
}
