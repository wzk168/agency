package com.agency.koda.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agency.koda.dao.MenuDao;
import com.agency.koda.model.MenuInfo;
import com.agency.koda.model.SubmenuInfo;
import com.agency.koda.service.MenuService;

/**
 * 系统菜单service层
 * 
 * @author Waco
 *
 */
@Service
public class MenuImpl implements MenuService {
	@Autowired
	private MenuDao menuDao;

	@Override
	public List<MenuInfo> loadMu(String userId, String companyId, int pageSize,
			int pageNow) {
		if (userId != null && companyId != null) {
			return menuDao.loadMu(userId, companyId, pageSize, pageNow);
		}
		return null;
	}

	@Override
	public List<SubmenuInfo> loadSu(String userId, String companyId,
			int pageSize, int pageNow) {
		if (userId != null && companyId != null) {
			return menuDao.loadSu(userId, companyId, pageSize, pageNow);
		}
		return null;
	}

	@Override
	public int count(String userId, String companyId, int countWhich) {
		if (userId != null && companyId != null) {
			return menuDao.count(userId, companyId, countWhich);
		}
		return 0;
	}

	@Override
	public int add(MenuInfo menuInfo) {
		if (null != menuInfo) {
			return menuDao.add(menuInfo);
		}
		return 0;
	}

	@Override
	public int update(MenuInfo menuInfo) {
		if (null != menuInfo) {
			return menuDao.update(menuInfo);
		}
		return 0;
	}

	@Override
	public int delete(int menuId) {
		if (menuId != 0) {
			return menuDao.delete(menuId);
		}
		return 0;
	}

	@Override
	public List<MenuInfo> loadMu(int pageSize, int pageNow) {
		return menuDao.loadMu(pageSize, pageNow);
	}

	@Override
	public List<SubmenuInfo> loadSu(int pageSize, int pageNow) {
		return menuDao.loadSu(pageSize, pageNow);
	}

	@Override
	public int count(int countWhich) {
		return menuDao.count(countWhich);
	}

	@Override
	public MenuInfo loadMu(String menuId) {
		if (menuId != null) {
			return menuDao.loadMu(menuId);
		}
		return null;
	}
}
