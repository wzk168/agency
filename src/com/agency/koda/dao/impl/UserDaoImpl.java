package com.agency.koda.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.agency.koda.dao.UserDao;
import com.agency.koda.model.UserInfo;
import com.agency.koda.utils.BaseDaoImpl;

/**
 * 用户数据层实现
 * 
 * @author Waco
 *
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
@Repository
public class UserDaoImpl extends BaseDaoImpl implements UserDao {

	@Override
	public UserInfo load(UserInfo userInfo) {
		Object[] paraes = null;
		ArrayList<Object> listParaes = new ArrayList<Object>();
		StringBuffer stringBuffer = new StringBuffer(
				"SELECT uos_userinfo_id,uos_userinfo_name,"
						+ "uos_userinfo_pwd,uos_userinfo_state,"
						+ "uos_company_id,uos_employee_id "
						+ "FROM ay_userinfo_sys WHERE 1=1");
		if (userInfo.getUosUserinfoId() != null) {
			stringBuffer.append(" AND uos_userinfo_id=?");
			listParaes.add(userInfo.getUosUserinfoId());
		}
		if (userInfo.getUosUserinfoName() != null) {
			stringBuffer.append(" AND uos_userinfo_name=?");
			listParaes.add(userInfo.getUosUserinfoName());
		}
		if (userInfo.getUosUserinfoPwd() != null) {
			stringBuffer.append(" AND uos_userinfo_pwd=?");
			listParaes.add(userInfo.getUosUserinfoPwd());
		}
		if (userInfo.getUosCompanyId() != null) {
			stringBuffer.append(" AND uos_company_id=?");
			listParaes.add(userInfo.getUosCompanyId());
		}
		paraes = listParaes.toArray();
		try {
			List<UserInfo> userInfos = this.getJdbcTemplate().query(
					stringBuffer.toString(), paraes, new RowMapper() {
						@Override
						public Object mapRow(ResultSet rt, int index)
								throws SQLException {
							UserInfo info = new UserInfo();
							info.setUosUserinfoId(rt
									.getString("uos_userinfo_id"));
							info.setUosUserinfoName(rt
									.getString("uos_userinfo_name"));
							info.setUosUserinfoPwd(rt
									.getString("uos_userinfo_pwd"));
							info.setUosUserinfoState(rt
									.getInt("uos_userinfo_state"));
							info.setUosCompanyId(rt.getString("uos_company_id"));
							info.setUosEmployeeId(rt
									.getString("uos_employee_id"));
							return info;
						}
					});
			if (null != userInfos && userInfos.size() > 0) {
				return userInfos.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
