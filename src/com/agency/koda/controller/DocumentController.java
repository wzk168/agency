package com.agency.koda.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.agency.koda.model.BranchBaseClass;
import com.agency.koda.utils.BaseController;
/**
 * 单证控制层实现
 * @author meng
 */

@Controller
@RequestMapping(value="/document")
public class DocumentController extends BaseController
{
	
	/**
	 * 进入单证入库界面
	 * @return
	 */
	@RequestMapping(value="/beforPutDcouemt" ,method=RequestMethod.GET)
	public ModelAndView beforPutDcouemt(HttpServletRequest request)
	{
		ModelAndView mav=new ModelAndView();
		List<BranchBaseClass> branchlist=this.branchList(this.getUserFromSession(request)
				.getUosCompanyId());
		mav.setViewName("sys/addDocument");
		mav.addObject("branchlist",branchlist);
		return mav;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
