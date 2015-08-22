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

}
