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
	
	/**
	 * 分页显示需要出库的单证信息
	 * @param date1 时间
	 * @param date2
	 * @param dgBranchId 分支机构
	 * @param dgDocumentType 类型
	 * @param pageNow 当前页
	 * @param pageSize 每页条数
	 * @return
	 */
	public List<DocumentInfo> loadDocmentPage(String date1,String date2,String dgBranchId,int dgDocumentType,int pageNow,int pageSize);
	
	/**
	 * 查询需要出库单证总条数
	 * @param date1 时间
	 * @param date2
	 * @param dgBranchId 分支机构
	 * @param dgDocumentType 类型
	 * @return
	 */
	public int loadDocumentCount(String date1,String date2,String dgBranchId,int dgDocumentType);
	
	
	
	
	
}
