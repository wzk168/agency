package com.agency.koda.utils;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;

/**
 * 数据层公共类
 * @author Waco
 */
public class BaseDaoImpl {
	@Resource
	private JdbcTemplate jdbcTemplate;
	/**
	 * 代表了当前的事务，可以提交，回滚
	 */
	private TransactionStatus status = null;
	/**
	 * 这个是spring提供的用于管理事务的基础接口，其下有一个实现的抽象类AbstractPlatformTransactionManager,
	 * 我们使用的事务管理类例如DataSourceTransactionManager等都是这个类的子类
	 */
	private PlatformTransactionManager pm;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void transaction() {
		pm = new DataSourceTransactionManager(jdbcTemplate.getDataSource());
		status = pm.getTransaction(null);
	}

	public TransactionStatus getStatus() {
		return status;
	}

	public PlatformTransactionManager getPm() {
		return pm;
	}

	

}
