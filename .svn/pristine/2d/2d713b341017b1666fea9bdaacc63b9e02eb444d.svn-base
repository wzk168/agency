package com.agency.koda.service;

import java.util.List;

import com.agency.koda.model.MenuInfo;
import com.agency.koda.model.SubmenuInfo;

/**
 * 系统菜单服务接口
 * 
 * @author Waco
 *
 */
public interface MenuService {
	/**
	 * 加载菜单信息
	 * 
	 * @param menuId
	 * @return
	 */
	public MenuInfo loadMu(String menuId);

	/**
	 * 平台超级管理员加载菜单
	 * 
	 * @param pageSize
	 * @param pageNow
	 * @return
	 */
	public List<MenuInfo> loadMu(int pageSize, int pageNow);

	/**
	 * 加载父级菜单
	 * 
	 * @param userId
	 * @param companyId
	 * @param pageSize
	 * @param pageNow
	 * @return
	 */
	public List<MenuInfo> loadMu(String userId, String companyId, int pageSize,
			int pageNow);

	/**
	 * 平台超级管理员加载子菜单
	 * 
	 * @param pageSize
	 * @param pageNow
	 * @return
	 */
	public List<SubmenuInfo> loadSu(int pageSize, int pageNow);

	/**
	 * 加载子菜单
	 * 
	 * @param userId
	 * @param companyId
	 * @param pageSize
	 * @param pageNow
	 * @return
	 */
	public List<SubmenuInfo> loadSu(String userId, String companyId,
			int pageSize, int pageNow);

	/**
	 * 统计菜单数量
	 * 
	 * @param userId
	 * @param companyId
	 * @param countWhich
	 *            标识是统计父级菜单还是子菜单
	 * @return
	 */
	public int count(String userId, String companyId, int countWhich);

	/**
	 * 超级管理员统计菜单书
	 * 
	 * @param countWhich标识是统计父级菜单还是子菜单
	 * @return
	 */
	public int count(int countWhich);

	/**
	 * 添加菜单信息
	 * 
	 * @param menuInfo
	 * @return
	 */
	public int add(MenuInfo menuInfo);

	/**
	 * 修改菜单信息
	 * 
	 * @param menuInfo
	 * @return
	 */
	public int update(MenuInfo menuInfo);

	/**
	 * 删除菜单信息
	 * 
	 * @param menuId
	 * @return
	 */
	public int delete(int menuId);
}
