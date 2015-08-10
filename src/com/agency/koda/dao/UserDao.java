package com.agency.koda.dao;

import com.agency.koda.model.UserInfo;

/**
 * 用戶数据层接口
 * 
 * @author Waco
 *
 */
public interface UserDao {
	/**
	 * 用戶登录
	 * 
	 * @param userInfo
	 * @return
	 */
	public UserInfo load(UserInfo userInfo);
}
