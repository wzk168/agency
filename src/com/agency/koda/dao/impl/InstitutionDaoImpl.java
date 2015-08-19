package com.agency.koda.dao.impl;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.agency.koda.dao.InstitutionDao;
import com.agency.koda.model.BranchCompany;
import com.agency.koda.model.InsuranceCompany;
import com.agency.koda.utils.BaseDaoImpl;

/**
 * 机构dao接口实现（包含保险公司，保险公司分支机构）
 * @author meng
 *
 */
@Repository
public class InstitutionDaoImpl extends BaseDaoImpl implements InstitutionDao 
{

	//添加分支机构
	@Override
	public int addBranchCompany(BranchCompany branchcy) {
		String addBranchSql="INSERT INTO ay_branch_company_msg(bcg_branch_id,bcg_branch_name,"
				+ "bcg_branch_short,bcg_branch_adress,"
				+ "bcg_branch_type,bcg_branch_situation,bcg_branch_phone,"
				+ "bcg_branch_email,bcg_branch_man,bcg_branch_remark,"
				+ "bcg_company_id,bcg_inscompany_id) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			return this.getJdbcTemplate().update(addBranchSql, branchcy.getBcgBranchId(),branchcy.getBcgBranchName(),branchcy.getBcgBranchShort(),branchcy.getBcgBranchAdress(),
					branchcy.getBcgBranchType(),branchcy.getBcgBranchSituation(),branchcy.getBcgBranchPhone(),
					branchcy.getBcgBranchEmail(),branchcy.getBcgBranchMan(),branchcy.getBcgBranchRemark(),branchcy.getBcgInscompanyId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	//添加保险公司
	@Override
	public int addInsurCompany(InsuranceCompany insuCompany) {
		String addInsurSql="INSERT INTO ay_insurance_company_msg(icg_inscompany_id,icg_inscompany_name,"
				+ "icg_inscompany_short,icg_inscompany_address,icg_inscompany_type,icg_inscompany_situation,"
				+ "icg_inscompany_phone,icg_inscompany_email,icg_inscompany_fax,"
				+ "icg_inscompany_man,icg_inscompany_website,icg_inscompany_bank,"
				+ "icg_inscompany_account,icg_inscompany_remark,icg_company_id) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			return this.getJdbcTemplate().update(addInsurSql, insuCompany.getIcgInscompanyId(),insuCompany.getIcgInscompanyName(),
					insuCompany.getIcgInscompanyShort(),insuCompany.getIcgInscompanyAddress(),insuCompany.getIcgInscompanyType(),insuCompany.getIcgInscompanySituation(),
					insuCompany.getIcgInscompanyPhone(),insuCompany.getIcgInscompanyEmail(),insuCompany.getIcgInscompanyFax(),
					insuCompany.getIcgInscompanyMan(),insuCompany.getIcgInscompanyWebsite(),insuCompany.getIcgInscompanyBank(),
					insuCompany.getIcgInscompanyAccount(),insuCompany.getIcgInscompanyRemark(),insuCompany.getIcgCompanyId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	//加载机构列表
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<BranchCompany> loadBranchCompany(String bcgBranchShort,
			int bcgBranchType) {
		List list=new ArrayList();
		Object[] pares=null;
		StringBuffer strbufr=new StringBuffer("SELECT bcg_branch_id,bcg_branch_short,bcg_branch_type,bcg_branch_situation,bcg_branch_man FROM ay_branch_company_msg WHERE 1=1");
		//简称
		if(null!=bcgBranchShort && !bcgBranchShort.equals(""))
		{
			strbufr.append(" AND bcg_branch_short LIKE ?");
			list.add("%"+bcgBranchShort+"%");
		}
		//类型
		if(bcgBranchType!=0)
		{
			strbufr.append(" AND bcg_branch_type=?");
			list.add(bcgBranchType);
		}
		pares=list.toArray();
		try {
			List<BranchCompany> branchlist=this.getJdbcTemplate().query(strbufr.toString(),pares,new BranchCompanySet());
			return (null!=branchlist && branchlist.size()>0 ? branchlist:null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//分支机构遍历
	@SuppressWarnings("rawtypes")
	public class BranchCompanySet implements RowMapper
	{
		@Override
		public Object mapRow(ResultSet rs, int index) throws SQLException {
			BranchCompany branch=new BranchCompany();
			branch.setBcgBranchId(rs.getString("bcg_branch_id"));
			branch.setBcgBranchShort(rs.getString("bcg_branch_short"));
			branch.setBcgBranchType(rs.getInt("bcg_branch_type"));
			branch.setBcgBranchSituation(rs.getInt("bcg_branch_situation"));
			branch.setBcgBranchMan(rs.getString("bcg_branch_man"));
			return branch;
		}

	}
	//分支机构对象
	@Override
	public BranchCompany loadBranchCompanyEntity(String bcgBranchId) {
		String selBranchSql="SELECT bcg_branch_id,bcg_branch_name,bcg_branch_short,"
				+ "bcg_branch_adress,bcg_branch_type,bcg_branch_situation,"
				+ "bcg_branch_phone,bcg_branch_email,bcg_branch_man,"
				+ "bcg_branch_remark,bcg_company_id,"
				+ "bcg_inscompany_id FROM WHERE bcg_branch_id=?";
		try {
			List<BranchCompany> branchlist=this.getJdbcTemplate().query(selBranchSql, new Object[]{bcgBranchId},new int[]{Types.VARCHAR},new RowMapper<BranchCompany>() {
				@Override
				public BranchCompany mapRow(ResultSet rs, int index)
						throws SQLException {
					BranchCompany branch=new BranchCompany();
					branch.setBcgBranchAdress(rs.getString("bcg_branch_adress"));//公司地址
					branch.setBcgBranchEmail(rs.getString("bcg_branch_email"));//邮箱地址
					branch.setBcgBranchId(rs.getString("bcg_branch_id"));//机构ID
					branch.setBcgBranchMan(rs.getString("bcg_branch_man"));//联系人
					branch.setBcgBranchName(rs.getString("bcg_branch_name"));//机构名称
					branch.setBcgBranchPhone(rs.getString("bcg_branch_phone"));//电话
					branch.setBcgBranchRemark(rs.getString("bcg_branch_remark"));//备注信息
					branch.setBcgBranchShort(rs.getString("bcg_branch_short"));//简称
					branch.setBcgBranchSituation(rs.getInt("bcg_branch_situation"));//出单情况
					branch.setBcgBranchType(rs.getInt("bcg_branch_type"));//机构类型
					branch.setBcgCompanyId(rs.getString("bcg_company_id"));//使用公司ID
					branch.setBcgInscompanyId(rs.getString("bcg_inscompany_id"));// 公司ID
					return branch;
				}
			});
			if(null!=branchlist && branchlist.size()>0)
			{
				return branchlist.get(0);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//保险公司列表查询
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<InsuranceCompany> loadInsurCompany(String icgInscompanyShort,
			int icgInscompanySituation) {
		List list=new ArrayList();
		Object[] pares=null;
		StringBuffer strbuf=new StringBuffer("SELECT icg_inscompany_short,icg_inscompany_situation,icg_inscompany_type,icg_inscompany_man,icg_company_id,icg_inscompany_id FROM ay_insurance_company_msg WHERE 1=1");
		//公司简称
		if(null!=icgInscompanyShort && !icgInscompanyShort.equals(""))
		{
			strbuf.append(" AND icg_inscompany_short LIKE ?");
			list.add("%"+icgInscompanyShort+"%");
		}
		//业务类型
		if(icgInscompanySituation!=0)
		{
			strbuf.append(" AND icg_inscompany_situation=?");
			list.add(icgInscompanySituation);
		}
		pares=list.toArray();
		try {
			List<InsuranceCompany> insuranlist=this.getJdbcTemplate().query(strbuf.toString(), pares,new InsurCompanySet());
			return (null!=insuranlist&&insuranlist.size()>0 ? insuranlist:null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	//保险公司遍历
	@SuppressWarnings("rawtypes")
	public class InsurCompanySet implements RowMapper
	{
		@Override
		public Object mapRow(ResultSet rs, int index) throws SQLException {
			InsuranceCompany insuran=new InsuranceCompany();
			insuran.setIcgInscompanyShort(rs.getString("icg_inscompany_short"));
			insuran.setIcgInscompanySituation(rs.getInt("icg_inscompany_situation"));
			insuran.setIcgInscompanyType(rs.getInt("icg_inscompany_type"));
			insuran.setIcgInscompanyMan(rs.getString("icg_inscompany_man"));
			insuran.setIcgCompanyId(rs.getString("icg_company_id"));
			insuran.setIcgInscompanyId(rs.getString("icg_inscompany_id"));
			return insuran;
		}

	}

	//保险公司对象查询
	@Override
	public InsuranceCompany loadInsurCompanyEntiy(String icgInscompanyId) {
		String selInsuranSql="SELECT icg_inscompany_id,icg_inscompany_name,"
				+ "icg_inscompany_short,icg_inscompany_address,icg_inscompany_type,"
				+ "icg_inscompany_situation,icg_inscompany_phone,icg_inscompany_email,"
				+ "icg_inscompany_fax,icg_inscompany_man,icg_inscompany_website,icg_inscompany_bank,"
				+ "icg_inscompany_account,icg_inscompany_remark,"
				+ "icg_company_id FROM ay_insurance_company_msg WHERE icg_inscompany_id";
		try {
			List<InsuranceCompany> insurlist=this.getJdbcTemplate().query(selInsuranSql, new Object[]{icgInscompanyId},new int[]{Types.VARCHAR},new RowMapper<InsuranceCompany>() {

				@Override
				public InsuranceCompany mapRow(ResultSet rs, int index)
						throws SQLException {
					InsuranceCompany insur=new InsuranceCompany();
					insur.setIcgCompanyId(rs.getString("icg_company_id"));
					insur.setIcgInscompanyAccount(rs.getString("icg_inscompany_account"));
					insur.setIcgInscompanyAddress(rs.getString("icg_inscompany_address"));
					insur.setIcgInscompanyBank(rs.getString("icg_inscompany_bank"));
					insur.setIcgInscompanyEmail(rs.getString("icg_inscompany_email"));
					insur.setIcgInscompanyFax(rs.getString("icg_inscompany_fax"));
					insur.setIcgInscompanyId(rs.getString("icg_inscompany_id"));
					insur.setIcgInscompanyMan(rs.getString("icg_inscompany_man"));
					insur.setIcgInscompanyName(rs.getString("icg_inscompany_name"));
					insur.setIcgInscompanyPhone(rs.getString("icg_inscompany_phone"));
					insur.setIcgInscompanyRemark(rs.getString("icg_inscompany_remark"));
					insur.setIcgInscompanyShort(rs.getString("icg_inscompany_short"));
					insur.setIcgInscompanySituation(rs.getInt("icg_inscompany_situation"));
					insur.setIcgInscompanyType(rs.getInt("icg_inscompany_type"));
					insur.setIcgInscompanyWebsite(rs.getString("icg_inscompany_website"));
					return insur;
				}
			});
			if(null!=insurlist && insurlist.size()>0)
			{
				return insurlist.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	//修改分支机构
	@Override
	public int updateBranchCompany(BranchCompany branchcy) {
		String upBranchSql="UPDATE ay_branch_company_msg SET bcg_branch_name=?,"
				+ "bcg_branch_short=?,bcg_branch_adress=?,bcg_branch_type=?,"
				+ "bcg_branch_situation=?,bcg_branch_phone=?,"
				+ "bcg_branch_email=?,bcg_branch_man=?,bcg_branch_remark=?,"
				+ "bcg_company_id=?,bcg_inscompany_id=? WHERE bcg_branch_id=?";
		try {
			return this.getJdbcTemplate().update(upBranchSql,branchcy.getBcgBranchName(),
					branchcy.getBcgBranchShort(),branchcy.getBcgBranchAdress(),
					branchcy.getBcgBranchType(),branchcy.getBcgBranchSituation(),
					branchcy.getBcgBranchPhone(),branchcy.getBcgBranchEmail(),
					branchcy.getBcgBranchMan(),branchcy.getBcgBranchRemark(),
					branchcy.getBcgInscompanyId(),branchcy.getBcgBranchId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	//修改保险公司
	@Override
	public int updateInsuCompany(InsuranceCompany insuCompany) {
		String updateInsurSql="UPDATE ay_insurance_company_msg SET icg_inscompany_name=?,"
				+ "icg_inscompany_short=?,icg_inscompany_address=?,icg_inscompany_type=?,"
				+ "icg_inscompany_situation=?,icg_inscompany_phone=?,icg_inscompany_email=?,"
				+ "icg_inscompany_fax=?,icg_inscompany_man=?,icg_inscompany_website=?,"
				+ "icg_inscompany_bank=?,icg_inscompany_account=?,icg_inscompany_remark=?,"
				+ "icg_company_id=? WHERE icg_inscompany_id=?";
		try {
			return this.getJdbcTemplate().update(updateInsurSql,insuCompany.getIcgInscompanyName(),
					insuCompany.getIcgInscompanyShort(),insuCompany.getIcgInscompanyAddress(),insuCompany.getIcgInscompanyType(),insuCompany.getIcgInscompanySituation(),
					insuCompany.getIcgInscompanyPhone(),insuCompany.getIcgInscompanyEmail(),insuCompany.getIcgInscompanyFax(),
					insuCompany.getIcgInscompanyMan(),insuCompany.getIcgInscompanyWebsite(),insuCompany.getIcgInscompanyBank(),
					insuCompany.getIcgInscompanyAccount(),insuCompany.getIcgInscompanyRemark(),insuCompany.getIcgCompanyId(),insuCompany.getIcgInscompanyId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}


}
