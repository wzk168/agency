package com.agency.koda.service;

import java.util.List;

import com.agency.koda.model.Product;
import com.agency.koda.model.ProductClass;
import com.agency.koda.model.ProductType;

public interface ProductInfoService 
{

	/**
	 * 添加保险险种大类
	 * @param prodclass
	 * @return
	 */
	public int addProductClass(ProductClass prodclass);

	/**
	 * 查询所有险种大类
	 * @return
	 */
	public List<ProductClass> loadProdClassList();

	/**
	 * 查询险种产品信息对象
	 * @param pcgProdclassId
	 * @return
	 */
	public ProductClass loadProduct(String pcgProdclassId);

	/**
	 * 修改保险产品
	 * @param prodclass
	 * @return
	 */
	public int updarwProduct(ProductClass prodclass);

	//保险产品子类
	/**
	 * 添加保险产品子类
	 * @param product
	 * @return
	 */
	public int addProduct(Product 子);

	/**
	 * 修改产品子类信息
	 * @param product
	 * @return
	 */
	public int upProduct(Product product);

	//保险产品父类
	/**
	 * 添加保险产品父类信息
	 * @param productType
	 * @return
	 */
	public int addProductType(ProductType productType);
	
	/**
	 * 查询保险产品树
	 * @return
	 */
	public String selProductTree();
	
	
	/**
	 * 保险产品类型(对象)
	 * @param ptgProdtypeId
	 * @return
	 */
	public ProductType loadProductTypeEntity(String ptgProdtypeId); 
	
	/**
	 * 查询保险分类对象
	 * @param pgProdId
	 * @return
	 */
	public Product loadProductEntity(String pgProdId);
	
	/**
	 * 保险险种子类
	 * @return
	 */
	public List<Product> loadProductList();

	/**
	 * 保险险种父类
	 * @return
	 */
	public List<ProductType> loadProductTypeList();
}
