package com.agency.koda.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.agency.koda.dao.TeamInfoDao;
import com.agency.koda.model.TeamBaseClass;
import com.agency.koda.model.TeamInfo;
import com.agency.koda.utils.BaseDaoImpl;

/**
 * 团队接口实现
 * 
 * @author meng
 */
@Repository
public class TeamInfoDaoImpl extends BaseDaoImpl implements TeamInfoDao {

	// 添加团队
	@Override
	public int addTeamInfo(TeamInfo teamInfo) {
		String addTeamSql = "INSERT INTO ay_teaminfo_msg (ts_team_id,ts_team_name,ts_team_principal,ts_dept_id,ts_team_type,ts_company_id,ts_team_state) VALUES(?,?,?,?,?,?,?)";
		try {
			return this.getJdbcTemplate().update(addTeamSql,
					teamInfo.getTsTeamId(), teamInfo.getTsTeamName(),
					teamInfo.getTsTeamPrincipal(), teamInfo.getTsDeptId(),
					teamInfo.getTsTeamType(), teamInfo.getTsCompanyId(),teamInfo.getTsTeamState());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	// 团队列表筛选
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<TeamInfo> loadTeamList(String teamName, int teamType,
			String teamPrincipal) {
		List list = new ArrayList();
		Object[] pares = null;
		StringBuffer strbuf = new StringBuffer(
				"SELECT ts_team_id,ts_team_name,ts_team_principal,ts_dept_id,ts_team_type,ts_company_id,ts_team_state FROM ay_teaminfo_msg WHERE 1=1 ");
		if (null != teamName && !teamName.equals("")) {
			strbuf.append(" AND ts_team_name LIKE ?");
			list.add("%" + teamName + "%");
		}
		if (null != teamPrincipal && !teamPrincipal.equals("")) {
			strbuf.append(" AND ts_team_principal LIKE ?");
			list.add("%" + teamPrincipal + "%");
		}
		if (teamType != 0) {
			strbuf.append(" AND ts_team_type=?");
			list.add(teamType);
		}
		pares = list.toArray();// 集合转换

		try {
			List<TeamInfo> teamlist = this.getJdbcTemplate().query(
					strbuf.toString(), pares, new TeamInfoSet());
			return (null != teamlist && teamlist.size() > 0 ? teamlist : null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 团队列表集合
	@SuppressWarnings("rawtypes")
	public class TeamInfoSet implements RowMapper {
		@Override
		public Object mapRow(ResultSet rs, int index) throws SQLException {
			TeamInfo team = new TeamInfo();
			team.setTsTeamId(rs.getString("ts_team_id"));
			team.setTsTeamName(rs.getString("ts_team_name"));
			team.setTsTeamPrincipal(rs.getString("ts_team_principal"));
			team.setTsDeptId(rs.getString("ts_dept_id"));
			team.setTsTeamType(rs.getInt("ts_team_type"));
			team.setTsCompanyId(rs.getString("ts_company_id"));
			team.setTsTeamState(rs.getInt("ts_team_state"));
			return team;
		}

	}

	// 修改团队信息
	@Override
	public int updateTeamInfo(TeamInfo teamInfo) {
		String selTeamSql = "UPDATE ay_teaminfo_msg SET ts_team_name=?,ts_team_principal=?,"
				+ "ts_dept_id=?,ts_team_type=?,ts_company_id=?,ts_team_state=? WHERE ts_team_id=?";
		try {
			return this.getJdbcTemplate().update(selTeamSql,
					teamInfo.getTsTeamName(), teamInfo.getTsTeamPrincipal(),
					teamInfo.getTsDeptId(), teamInfo.getTsTeamType(),
					teamInfo.getTsCompanyId(),teamInfo.getTsTeamState(),teamInfo.getTsTeamId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	// 根据团队ID查询对象
	@Override
	public TeamInfo loadTeamEntity(String tsTeamId) {
		String selTeamEntitySql = "SELECT ts_team_id,ts_team_name,ts_team_principal,"
				+ "ts_dept_id,ts_team_type,ts_company_id,ts_team_state FROM ay_teaminfo_msg WHERE ts_team_id=?";
		try {
			List<TeamInfo> teamlist = this.getJdbcTemplate().query(
					selTeamEntitySql, new Object[] { tsTeamId },
					new int[] { Types.VARCHAR }, new RowMapper<TeamInfo>() {

						@Override
						public TeamInfo mapRow(ResultSet rs, int index)
								throws SQLException {
							TeamInfo team = new TeamInfo();
							team.setTsTeamId(rs.getString("ts_team_id"));
							team.setTsTeamName(rs.getString("ts_team_name"));
							team.setTsTeamPrincipal(rs
									.getString("ts_team_principal"));
							team.setTsDeptId(rs.getString("ts_dept_id"));
							team.setTsTeamType(rs.getInt("ts_team_type"));
							team.setTsCompanyId(rs.getString("ts_company_id"));
							team.setTsTeamState(rs.getInt("ts_team_state"));
							return team;
						}
					});

			if (null != teamlist && teamlist.size() > 0) {
				return teamlist.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	//根据部门ID查询在出单状态中的团队信息
	@SuppressWarnings("unchecked")
	@Override
	public List<TeamBaseClass> loadTeamByDeptId(String tsDeptId) {
		String selSql="SELECT ts_team_id,ts_team_name FROM ay_teaminfo_msg WHERE ts_team_state=1 AND ts_dept_id=?";
		try {
			List<TeamBaseClass> teamlist=this.getJdbcTemplate().query(selSql, new Object[]{tsDeptId},new int[]{Types.VARCHAR},new TeamSet());
		 return (null!=teamlist && teamlist.size()>0?teamlist:null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@SuppressWarnings("rawtypes")
	public class TeamSet implements RowMapper
	{
		@Override
		public Object mapRow(ResultSet rs, int index) throws SQLException {
			TeamBaseClass team=new TeamBaseClass();
			team.setTeamId(rs.getString("ts_team_id"));
			team.setTeamName(rs.getString("ts_team_name"));
			return team;
		}
	}

}
