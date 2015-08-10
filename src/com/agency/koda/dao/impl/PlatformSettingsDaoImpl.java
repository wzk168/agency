package com.agency.koda.dao.impl;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.agency.koda.dao.PlatformSettingsDao;
import com.agency.koda.model.UserCompany;
import com.agency.koda.utils.BaseDaoImpl;

/**
 * 平台接口daoimpl
 * @author meng
 * 2015-07-29 
 */
@Repository
public class PlatformSettingsDaoImpl extends BaseDaoImpl implements PlatformSettingsDao
{

	//添加使用公司信息接口实现
	@Override
	public int addUserCompany(UserCompany userCompany) 
	{
		String addUserCompanySql="INSERT INTO ay_user_company_sys("
				+ "ucs_company_id,ucs_company_name,ucs_company_number,"
				+ "ucs_company_state,ucs_company_address,ucs_company_phone,"
				+ "ucs_company_linkman) VALUES(?,?,?,?,?,?,?)";
		try {
			return this.getJdbcTemplate().update(addUserCompanySql, userCompany.getUcsCompanyId(),
					userCompany.getUcsCompanyName(),userCompany.getUcsCompanyNumber(),
					userCompany.getUcsCompanyState(),userCompany.getUcsCompanyAddress(),userCompany.getUcsCompanyPhone(),
					userCompany.getUcsCompanyLinkman());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	//加载使用公司条数
	@SuppressWarnings({ "unchecked", "rawtypes", "deprecation" })
	@Override
	public int loadUserCompanyCount(String ucsCompanyName, int ucsCompanyState) {
		Object[] param=null;
		List list=new ArrayList();
		StringBuffer buffer=new StringBuffer("SELECT COUNT(1) FROM ay_user_company_sys WHERE 1=1");
		//使用公司名称
		if(null!=ucsCompanyName && !ucsCompanyName.equals(""))
		{
			buffer.append(" AND ucs_company_name LIKE ?");
			list.add("%"+ucsCompanyName+"%");
		}
		//菜单显示状态
		if(ucsCompanyState!=0)
		{
			buffer.append(" AND ucs_company_state=?");
			list.add(ucsCompanyState);
		}
		param=list.toArray();
		try {
			return this.getJdbcTemplate().queryForInt(buffer.toString(),param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	//加载使用公司列表
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<UserCompany> loadUserCompanyList(int pageSize, int pageNow,
			String ucsCompanyName, int ucsCompanyState) {
		Object[] param=null;
		List list=new ArrayList();
		StringBuffer buffer=new StringBuffer("SELECT ucs_company_id,ucs_company_name,ucs_company_number,ucs_company_state,ucs_company_address,ucs_company_phone,ucs_company_linkman FROM ay_user_company_sys WHERE 1=1");
		//使用公司名称
		if(null!=ucsCompanyName && !ucsCompanyName.equals(""))
		{
			buffer.append(" AND ucs_company_name LIKE ?");
			list.add("%"+ucsCompanyName+"%");
		}
		//菜单显示状态
		if(ucsCompanyState!=0)
		{
			buffer.append(" AND ucs_company_state=?");
			list.add(ucsCompanyState);
		}
		buffer.append("  LIMIT ?,?");
		list.add((pageNow-1)*pageSize);
		list.add(pageSize);
		param=list.toArray();
		try {
			List<UserCompany> uylist=this.getJdbcTemplate().query(buffer.toString(),param,new UserCompanySet());
			return (null!=uylist && uylist.size()>0 ? uylist:null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	//公司集合
	@SuppressWarnings("rawtypes")
	public class UserCompanySet implements RowMapper
	{
		@Override
		public Object mapRow(ResultSet rs, int index) throws SQLException {
			UserCompany uy=new UserCompany();
			uy.setUcsCompanyId(rs.getString("ucs_company_id"));//主键编号
			uy.setUcsCompanyName(rs.getString("ucs_company_name"));//名称
			uy.setUcsCompanyNumber(rs.getString("ucs_company_number"));//编号
			uy.setUcsCompanyState(rs.getInt("ucs_company_state"));//状态
			uy.setUcsCompanyAddress(rs.getString("ucs_company_address"));//公司地址
			uy.setUcsCompanyLinkman(rs.getString("ucs_company_linkman"));//联系人
			uy.setUcsCompanyPhone(rs.getString("ucs_company_phone"));//公司电话
			return uy;
		}
	}
	//查询使用公司对象
	@Override
	public UserCompany loadUserCompanyEntity(String ucsCompanyId) {
		String selUyEntitySql="SELECT ucs_company_id,ucs_company_name,"
				+ "ucs_company_number,ucs_company_state,ucs_company_address,"
				+ "ucs_company_phone,ucs_company_linkman FROM ay_user_company_sys WHERE ucs_company_id=?";
		try {
			List<UserCompany> uylist=this.getJdbcTemplate().query(selUyEntitySql, new Object[]{ucsCompanyId},new int[]{Types.VARCHAR},new RowMapper<UserCompany>() {

				@Override
				public UserCompany mapRow(ResultSet rs, int index)
						throws SQLException {
					UserCompany uy=new UserCompany();
					uy.setUcsCompanyId(rs.getString("ucs_company_id"));//主键编号
					uy.setUcsCompanyName(rs.getString("ucs_company_name"));//名称
					uy.setUcsCompanyNumber(rs.getString("ucs_company_number"));//编号
					uy.setUcsCompanyState(rs.getInt("ucs_company_state"));//状态
					uy.setUcsCompanyAddress(rs.getString("ucs_company_address"));//公司地址
					uy.setUcsCompanyLinkman(rs.getString("ucs_company_linkman"));//联系人
					uy.setUcsCompanyPhone(rs.getString("ucs_company_phone"));//公司电话
					return uy;
				}
			});
			if(null!=uylist&&uylist.size()>0)
			{
				return uylist.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	//修改使用公司
	@Override
	public int upUserCompany(UserCompany uy) {
		String upUySql="UPDATE ay_user_company_sys SET ucs_company_name=?,"
				+ "ucs_company_number=?,ucs_company_state=?,ucs_company_address=?,"
				+ "ucs_company_phone=?,ucs_company_linkman=? WHERE ucs_company_id=?";
		try {
			return this.getJdbcTemplate().update(upUySql, uy.getUcsCompanyName(),uy.getUcsCompanyNumber(),
					uy.getUcsCompanyState(),uy.getUcsCompanyAddress(),
					uy.getUcsCompanyPhone(),uy.getUcsCompanyLinkman(),uy.getUcsCompanyId());
		} catch (Exception e) {
		e.printStackTrace();
		}
		return 0;
	}


}
