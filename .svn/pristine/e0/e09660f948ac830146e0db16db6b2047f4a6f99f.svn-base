package com.agency.koda.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.agency.koda.model.Product;
import com.agency.koda.model.ProductClass;
import com.agency.koda.model.ProductType;
import com.agency.koda.service.ProductInfoService;
import com.agency.koda.utils.BaseController;
import com.agency.koda.utils.JsonUtil;
/***
 * 保险险种产品信息控制类
 * @author meng
 * 2015-08-07
 */
@Controller
@RequestMapping(value="/productInfo")
public class ProductInfoController extends BaseController
{
	@Autowired
	private ProductInfoService productService;//产品大类Service

	/**
	 * 查询所有险种产品大类信息
	 * @return
	 */
	@RequestMapping(value="/loadProductInfo",method=RequestMethod.GET)
	public ModelAndView loadProductInfo()
	{
		ModelAndView mav=new ModelAndView();
		List<ProductClass> prodclist=this.productService.loadProdClassList();
		mav.setViewName("sys/productList");
		mav.addObject("prodclist",prodclist);
		return mav;
	}

	/**
	 * 添加保险险种大类信息
	 * @param prodClas
	 * @return
	 */
	@SuppressWarnings("static-access")
	@RequestMapping(value="/addProductInfo",method=RequestMethod.POST)
	@ResponseBody
	public void addProductInfo(ProductClass prodClas,HttpServletResponse response)
	{
		prodClas.setPcgProdclassId(this.major("PCG"));
		result=this.productService.addProductClass(prodClas);
		this.writeMsg(response, result);
	}

	/**
	 * ajax加载险种产品信息
	 * @param pcgProdclassId
	 * @param response
	 */
	@RequestMapping(value="/loadProductInfo",method=RequestMethod.POST)
	@ResponseBody
	public void beforProductInfo(@RequestParam("pcgProdclassId") String pcgProdclassId,HttpServletResponse response)
	{
		ProductClass prod=this.productService.loadProduct(pcgProdclassId);
		String msg=JsonUtil.beanToJson(prod);
		this.writeMsg(response, msg);
	}
	/**
	 * 修改保险产品信息
	 * @param prodClas
	 * @param response
	 */
	@RequestMapping(value="/updateProductInfo",method=RequestMethod.POST)
	@ResponseBody
	public void updateProductInfo(ProductClass prodClas,HttpServletResponse response)
	{
		result =this.productService.updarwProduct(prodClas);
		this.writeMsg(response, result);
	}

	/**
	 * 保险产品树
	 * @return
	 */
	@RequestMapping(value="/selProdectTree",method=RequestMethod.GET)
	public ModelAndView selProdectTree()
	{
		ModelAndView mav=new ModelAndView();
		String tree=this.productService.selProductTree();//查询所有保险产品信息
		mav.setViewName("sys/productList");
		mav.addObject("tree",tree);
		return mav;
	}
	/**
	 * Ajax加载险种各项信息
	 * @param prodId 险种ID
	 * @param prodType 险种类型
	 * @return
	 */
	@RequestMapping(value="/loadProductInfoAjax",method=RequestMethod.POST)
	@ResponseBody
	public void loadProductInfoAjax(@RequestParam("prodId") String prodId,
			@RequestParam("prodType") String prodType,
			HttpServletResponse response)
	{
		String entityinfo=null;
		if(null!=prodType && !prodType.equals(""))
		{
			if(prodType.equals("PCG"))
			{                                     
				ProductClass pcg=this.productService.loadProduct(prodId);
				entityinfo=JsonUtil.beanToJson(pcg);
				//险种产品大类
			}else if(prodType.equals("PG"))
			{
				Product pg=this.productService.loadProductEntity(prodId);
				entityinfo=JsonUtil.beanToJson(pg);
				//险种产品子类
			}else if(prodType.equals("PTG"))
			{
				//险种产品父类
				ProductType ptg=this.productService.loadProductTypeEntity(prodId);
				entityinfo=JsonUtil.beanToJson(ptg);
			}
		}
		this.writeMsg(response,entityinfo);
	}



}
