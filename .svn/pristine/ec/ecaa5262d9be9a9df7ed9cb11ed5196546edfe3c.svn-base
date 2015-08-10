package com.agency.koda.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.agency.koda.dao.CompanyDao;
import com.agency.koda.model.CompanyInfo;
import com.agency.koda.utils.BaseDaoImpl;

/**
 * 公司数据层接口实现
 * 
 * @author Waco
 *
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
@Repository
public class CompanyDaoImpl extends BaseDaoImpl implements CompanyDao {

	@Override
	public CompanyInfo load(CompanyInfo companyInfo) {
		Object[] paraes = null;
		ArrayList<Object> listParaes = new ArrayList<Object>();
		StringBuffer stringBuffer = new StringBuffer(
				"SELECT ucs_company_id,ucs_company_name,"
						+ "ucs_company_number,ucs_company_state,"
						+ "ucs_company_address,ucs_company_phone,"
						+ "ucs_company_linkman FROM ay_user_company_sys WHERE 1=1");
		if (companyInfo.getUcsCompanyId() != null) {
			stringBuffer.append(" AND ucs_company_id=?");
			listParaes.add(companyInfo.getUcsCompanyId());
		}
		if (companyInfo.getUcsCompanyName() != null) {
			stringBuffer.append(" AND ucs_company_name=?");
			listParaes.add(companyInfo.getUcsCompanyName());
		}
		if (companyInfo.getUcsCompanyNumber() != null) {
			stringBuffer.append(" AND ucs_company_number=?");
			listParaes.add(companyInfo.getUcsCompanyNumber());
		}
		paraes = listParaes.toArray();
		try {
			List<CompanyInfo> companyInfos = this.getJdbcTemplate().query(
					stringBuffer.toString(), paraes, new RowMapper() {
						@Override
						public Object mapRow(ResultSet rt, int index)
								throws SQLException {
							CompanyInfo info = new CompanyInfo();
							info.setUcsCompanyId(rt.getString("ucs_company_id"));
							info.setUcsCompanyName(rt
									.getString("ucs_company_name"));
							info.setUcsCompanyNumber(rt
									.getString("ucs_company_number"));
							info.setUcsCompanyAddress(rt
									.getString("ucs_company_address"));
							info.setUcsCompanyLinkman(rt
									.getString("ucs_company_linkman"));
							info.setUcsCompanyPhone(rt
									.getString("ucs_company_phone"));
							info.setUcsCompanyState(rt
									.getInt("ucs_company_state"));
							return info;
						}
					});
			if (null != companyInfos && companyInfos.size() > 0) {
				return companyInfos.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
