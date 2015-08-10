package com.agency.koda.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agency.koda.dao.UserDao;
import com.agency.koda.model.UserInfo;
import com.agency.koda.service.UserService;

/**
 * 用户接口实现serviec
 * 
 * @author Waco
 *
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public UserInfo load(UserInfo userInfo) {
		return userDao.load(userInfo);
	}

}
