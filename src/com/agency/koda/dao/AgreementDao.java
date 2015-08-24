package com.agency.koda.dao;

import java.util.List;

import com.agency.koda.model.Agreement;

/**
 * 协议接口实现
 * @author meng
 *
 */
public interface AgreementDao {

	/**
	 * 批量添加协议信息
	 * @param agree 协议
	 * @return
	 */
	public int addAgreementInfo(List<Agreement> agree);
	
	
	
	
	
	
	
	
	
}
