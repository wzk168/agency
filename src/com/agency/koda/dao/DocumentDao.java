package com.agency.koda.dao;

import java.util.List;

import com.agency.koda.model.DocumentInfo;

/**
 * 单证管理接口dao
 * @author meng
 *
 */
public interface DocumentDao {

	
	/**
	 * 添加单证信息
	 * @param documlist 单证泛型集合
	 * @return
	 */
	public int addDocumentInfo(List<DocumentInfo> documlist);
	
	
	
	
	
	
	
	
	
	
	
}
