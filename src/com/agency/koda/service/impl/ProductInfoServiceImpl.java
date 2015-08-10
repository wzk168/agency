package com.agency.koda.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agency.koda.dao.ProductInfoDao;
import com.agency.koda.model.Product;
import com.agency.koda.model.ProductClass;
import com.agency.koda.model.ProductType;
import com.agency.koda.service.ProductInfoService;
/**
 * 产品险种大类ServiceImpl实现
 * @author meng
 * 2015-08-06
 */
@Service
public class ProductInfoServiceImpl implements ProductInfoService
{
	@Autowired
	private ProductInfoDao prodClasDao;//险种产品大类dao接口

	//添加保险险种大类
	@Override
	public int addProductClass(ProductClass prodclass) {
		return prodClasDao.addProductClass(prodclass);
	}
	//险种大类列表
	@Override
	public List<ProductClass> loadProdClassList() {
		return prodClasDao.loadProdClassList();
	}
	//选中产品对象
	@Override
	public ProductClass loadProduct(String pcgProdclassId) {
		return prodClasDao.loadProduct(pcgProdclassId);
	}
	//修改 保险产品
	@Override
	public int updarwProduct(ProductClass prodclass) {
		return prodClasDao.updarwProduct(prodclass);
	}

	//以下是产品子类接口
	//添加子产品信息
	@Override
	public int addProduct(Product product) {
		return prodClasDao.addProduct(product);
	}
	//修改子产品信息
	@Override
	public int upProduct(Product product) {
		return prodClasDao.upProduct(product);
	}


	//保险产品父类
	//添加保险产品父类
	@Override
	public int addProductType(ProductType productType) {
		return prodClasDao.addProductType(productType);
	}

	/**
	 * 查询保险产品树
	 * @return
	 */
	@Override
	public String selProductTree() {
		return prodClasDao.selProductTree();
	}
	
	//险种类型
	@Override
	public Product loadProductEntity(String pgProdId) {
		return prodClasDao.loadProductEntity(pgProdId);
	}
	//险种子类
	@Override
	public ProductType loadProductTypeEntity(String ptgProdtypeId) {
		return prodClasDao.loadProductTypeEntity(ptgProdtypeId);
	}
	
}
