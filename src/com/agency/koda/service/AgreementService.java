package com.agency.koda.service;

import java.util.List;

import com.agency.koda.model.Agreement;

/**
 * 协议service
 * @author meng
 *
 */
public interface AgreementService {

	/**
	 * 批量添加协议信息
	 * @param agree 协议
	 * @return
	 */
	public int addAgreementInfo(List<Agreement> agree);
	
	
	
	
	
}
