package com.agency.koda.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.agency.koda.model.BranchBaseClass;
import com.agency.koda.model.DocumentInfo;
import com.agency.koda.model.UserInfo;
import com.agency.koda.service.DocumentService;
import com.agency.koda.utils.BaseController;
import com.agency.koda.utils.Page;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 单证控制层实现
 * 
 * @author meng
 */

@Controller
@RequestMapping(value = "/document")
public class DocumentController extends BaseController {

	@Autowired
	private DocumentService documService;// 单证service

	/**
	 * 进入单证入库界面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/beforPutDcouemt", method = RequestMethod.GET)
	public ModelAndView beforPutDcouemt(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		List<BranchBaseClass> branchlist = this.branchList(this
				.getUserFromSession(request).getUosCompanyId());
		mav.setViewName("sys/addDocument");
		mav.addObject("branchlist", branchlist);

		return mav;
	}

	/***
	 * 添加单证信息单证入库
	 * 
	 * @param documentInfo
	 *            单证对象
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/addDocumentInfo", method = RequestMethod.POST)
	@ResponseBody
	public void addDocumentInfo(DocumentInfo info, HttpServletRequest request,
			HttpServletResponse response) {
		Calendar c = Calendar.getInstance();// 可以对每个时间域单独修改
		String dates = String.valueOf(c.get(Calendar.DATE));
		String bathNum = suijishu(dates);// 批号
		UserInfo userInfo = this.getUserFromSession(request);
		List<DocumentInfo> doclist = new ArrayList<DocumentInfo>();
		int numSeria = info.getSeria3() - info.getSeria2();
		String dgDocumentSerial = "";
		if (numSeria > 0) {
			for (int i = 0; i <= numSeria; i++) {
				DocumentInfo documentInfo = new DocumentInfo();
				documentInfo.setDgBranchId(info.getDgBranchId());// 分支机构
				documentInfo.setDgDocumentType(info.getDgDocumentType());// 单证类型
				documentInfo.setDgDocumentRemark(info.getDgDocumentRemark());// 备注信息
				documentInfo.setDgCompanyId(userInfo.getUosCompanyId());// 使用公司
				documentInfo.setDgDocumentBatchNumber(bathNum);// 批号
				documentInfo.setDgDocumentEnterTime(new Date());// 入库时间
				documentInfo
						.setDgDocumentOperation(userInfo.getUosEmployeeId());// 操作人
				documentInfo.setDgDocumentState(DocumentInfo.enter);// 入库状态
				dgDocumentSerial = info.getSerial()
						+ String.valueOf(info.getSeria2() + i);
				documentInfo.setDgDocumentSerial(dgDocumentSerial);
				documentInfo.setDgDocumentId(getUUID("DG"));// 主键
				doclist.add(documentInfo);
			}
		}
		if (null != doclist && doclist.size() > 0) {
			result = this.documService.addDocumentInfo(doclist);
		}
		this.writeMsg(response, result);
	}

	/**
	 * 进入单证出库界面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/beforloadDocument", method = RequestMethod.GET)
	public ModelAndView beforloadDocument(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("sys/putDocument");
		List<BranchBaseClass> bralist = this.branchList(this
				.getUserFromSession(request).getUosCompanyId());
		mav.addObject("bralist", bralist);
		return mav;
	}

	/**
	 * 分页查询需要出库的单证信息
	 * 
	 * @param dgDocumentType
	 * @param dgBranchId
	 * @param date1
	 * @param date2
	 * @param pageNow
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "/loadDocumentPage", method = RequestMethod.POST)
	@ResponseBody
	public void loadDocumentPage(
			HttpServletResponse response,
			@RequestParam(value = "dgDocumentType", required = false, defaultValue = "0") int dgDocumentType,
			@RequestParam(value = "dgBranchId", required = false) String dgBranchId,
			@RequestParam(value = "date1", required = false) String date1,
			@RequestParam(value = "date2", required = false) String date2,
			@RequestParam(value = "pageNow", required = false, defaultValue = "1") int pageNow,
			@RequestParam(value = "pageSize", required = false, defaultValue = "15") int pageSize) {

		Page page = new Page(pageNow, pageSize,
				this.documService.loadDocumentCount(date1, date2, dgBranchId,
						dgDocumentType));
		List<DocumentInfo> doculist = this.documService.loadDocmentPage(date1,
				date2, dgBranchId, dgDocumentType, page.getPageNow(),
				page.getPageSize());

		Object resultPage = JSON.parse(JSON.toJSONString(page));
		JSONArray json = new JSONArray();
		for (int i = 0; i < doculist.size(); i++) {
			Object info=JSON.parse(JSON.toJSONString(doculist.get(i)));
			json.add(info);
			
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("doculist", json);
		jsonObject.put("page", resultPage);
		
		System.out.println(jsonObject);
		this.writeMsg(response, jsonObject);
	}

}
