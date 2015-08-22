package com.agency.koda.service;

import java.util.List;

import com.agency.koda.model.DocumentInfo;
/**
 * 单证接口Service
 * @author meng
 *
 */
public interface DocumentService 
{
	/**
	 * 添加单证信息
	 * @param documlist 单证泛型集合
	 * @return
	 */
	public int addDocumentInfo(List<DocumentInfo> documlist);

}
