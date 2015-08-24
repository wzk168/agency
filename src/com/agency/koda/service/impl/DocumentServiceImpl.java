package com.agency.koda.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agency.koda.dao.DocumentDao;
import com.agency.koda.model.DocumentInfo;
import com.agency.koda.service.DocumentService;
/**
 * 单证service
 * @author meng
 *
 */

@Service
public class DocumentServiceImpl implements DocumentService 
{
	@Autowired
	private DocumentDao documdao;
	
	//添加单证信息
	@Override
	public int addDocumentInfo(List<DocumentInfo> documlist) {
	
		return documdao.addDocumentInfo(documlist);
	}
	//分页查询需要出库的单证

	@Override
	public List<DocumentInfo> loadDocmentPage(String date1, String date2,
			String dgBranchId, int dgDocumentType, int pageNow, int pageSize) {
		return documdao.loadDocmentPage(date1, date2, dgBranchId, dgDocumentType, pageNow, pageSize);
	}
	//查询需要出库单证条数
	@Override
	public int loadDocumentCount(String date1, String date2, String dgBranchId,
			int dgDocumentType) {
		return documdao.loadDocumentCount(date1, date2, dgBranchId, dgDocumentType);
	}


}
