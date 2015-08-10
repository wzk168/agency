package com.agency.koda.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.agency.koda.dao.ProductInfoDao;
import com.agency.koda.model.Product;
import com.agency.koda.model.ProductClass;
import com.agency.koda.model.ProductTree;
import com.agency.koda.model.ProductType;
import com.agency.koda.utils.BaseDaoImpl;

@Repository
public class ProductInfoDaoImpl extends BaseDaoImpl implements ProductInfoDao
{
	//添加险种大类
	@Override
	public int addProductClass(ProductClass prodclass) 
	{
		String addProClaSql="INSERT INTO ay_product_class_msg (pcg_prodclass_id,pcg_prodclass_name) VALUES(?,?)";
		try {
			return this.getJdbcTemplate().update(addProClaSql, prodclass.getPcgProdclassId(),prodclass.getPcgProdclassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	//查询所有险种大类
	@SuppressWarnings({ "unchecked"})
	@Override
	public List<ProductClass> loadProdClassList() 
	{
		String selProdClaSql="SELECT pcg_prodclass_id,pcg_prodclass_name FROM ay_product_class_msg";
		try {
			List<ProductClass> pclist=this.getJdbcTemplate().query(selProdClaSql,new ProdClasSet());
			return (null!=pclist&&pclist.size()>0?pclist:null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//循环列表
	@SuppressWarnings("rawtypes")
	public class ProdClasSet implements RowMapper
	{
		@Override
		public Object mapRow(ResultSet rs, int index) throws SQLException {
			ProductClass prodc=new ProductClass();
			prodc.setPcgProdclassId(rs.getString("pcg_prodclass_id"));
			prodc.setPcgProdclassName(rs.getString("pcg_prodclass_name"));
			return prodc;
		}

	}
	//查询产品对象
	@Override
	public ProductClass loadProduct(String pcgProdclassId) {
		String selpcByIdSql="SELECT pcg_prodclass_id,pcg_prodclass_name FROM ay_product_class_msg WHERE pcg_prodclass_id=?";
		try {
			List<ProductClass> pclist= this.getJdbcTemplate().query(selpcByIdSql,new Object[]{pcgProdclassId},new int[]{Types.VARCHAR},new RowMapper<ProductClass>() {

				@Override
				public ProductClass mapRow(ResultSet rs, int index)
						throws SQLException {
					ProductClass prodc=new ProductClass();
					prodc.setPcgProdclassId(rs.getString("pcg_prodclass_id"));
					prodc.setPcgProdclassName(rs.getString("pcg_prodclass_name"));
					return prodc;
				}
			});
			if (null!=pclist&&pclist.size()>0)
			{
				return pclist.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//修改保险产品
	@Override
	public int updarwProduct(ProductClass prodclass) {
		String upSql="UPDATE ay_product_class_msg SET pcg_prodclass_name=? WHERE pcg_prodclass_id=?";
		try {
			return this.getJdbcTemplate().update(upSql, prodclass.getPcgProdclassName(),prodclass.getPcgProdclassId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	//保险产品子类接口
	//添加保险子类信息
	@Override
	public int addProduct(Product product) {
		String addprodSql="INSERT INTO ay_product_msg(pg_prod_id,pg_prod_name,pg_prodtype_id,pg_prod_flagmain) VALUES(?,?,?,?)";
		try {
			return this.getJdbcTemplate().update(addprodSql, product.getPgProdId(),product.getPgProdName(),
					product.getPgProdtypeId(),product.getPgProdFlagmain());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	//修改保险子类信息
	@Override
	public int upProduct(Product product) {
		String upSql="UPDATE ay_product_msg SET pg_prod_name=?,pg_prodtype_id=?,pg_prod_flagmain=? WHERE pg_prod_id=?";
		try {
			return this.getJdbcTemplate().update(upSql, product.getPgProdName(),product.getPgProdtypeId(),product.getPgProdFlagmain(),product.getPgProdId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	//保险产品父类
	//添加保险父类
	@Override
	public int addProductType(ProductType productType) {
		String addptSql="INSERT INTO ay_product_type_msg( ptg_prodtype_id,ptg_prodtype_name,ptg_prodclass_id) VALUES(?,?,?)";
		try {
			return this.getJdbcTemplate().update(addptSql, productType.getPtgProdtypeId(),productType.getPtgProdtypeName(),productType.getPtgProdclassId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}


	//保险产品树
	@SuppressWarnings("unchecked")
	@Override
	public String selProductTree() {

		String selproductSql="SELECT pcg_prodclass_id AS id,pcg_prodclass_name AS name, 0 AS uid,'PCG' AS prodtype  FROM ay_product_class_msg UNION ALL"+
				" SELECT pg_prod_id AS id,pg_prod_name AS name,pg_prodtype_id AS uid,'PG' AS prodtype FROM ay_product_msg UNION ALL"+
				" SELECT ptg_prodtype_id AS id,ptg_prodtype_name AS name,ptg_prodclass_id AS uid,'PTG' AS prodtype FROM ay_product_type_msg";
		try {
			String tree="";
			List<ProductTree> prodtree=this.getJdbcTemplate().query(selproductSql,new ProductTreeSet());
			if(null!=prodtree && prodtree.size()>0)
			{
				tree="d = new dTree('d',true);\r\n d.add(0,-1,'险种产品');\r\n";
				for (int i = 0; i < prodtree.size(); i++) 
				{
					tree+="d.add('"+prodtree.get(i).getProductId()+"','"+prodtree.get(i).getProductUid()+"','"+prodtree.get(i).getProductName()+"',\"javascript:getid('"+prodtree.get(i).getProductId()+"','"+prodtree.get(i).getProdType()+"')\");\r\n";
				}
				tree+="document.write(d)";
			}
			return tree;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	//tree列表
	@SuppressWarnings("rawtypes")
	public class ProductTreeSet implements RowMapper
	{
		@Override
		public Object mapRow(ResultSet rs, int index) throws SQLException {
			ProductTree tree=new ProductTree();
			tree.setProductId(rs.getString("id"));//险种ID
			tree.setProductName(rs.getString("name"));//险种名称
			tree.setProductUid(rs.getString("uid"));//副ID
			tree.setProdType(rs.getString("prodtype"));//险种产品类型
			return tree;
		}
	}
	//险种子类型
	@Override
	public Product loadProductEntity(String pgProdId) {
		String selSql="SELECT pg_prod_id,pg_prod_name,pg_prodtype_id,pg_prod_flagmain FROM ay_product_msg WHERE pg_prod_id=?";
		try {
			List<Product> prodlist= this.getJdbcTemplate().query(selSql, new Object[]{pgProdId},new int[]{Types.VARCHAR},new RowMapper<Product>() {
				@Override
				public Product mapRow(ResultSet rs, int index)
						throws SQLException {
					Product product=new Product();
					product.setPgProdFlagmain(rs.getInt("pg_prod_flagmain"));//是否主险
					product.setPgProdId(rs.getString("pg_prod_id"));//子险种ID
					product.setPgProdtypeId(rs.getString("pg_prodtype_id"));//副ID
					product.setPgProdName(rs.getString("pg_prod_name"));//险种名称
					return product;
				}
			});
			if(null!=prodlist&&prodlist.size()>0)
			{
				return prodlist.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	//险种类型
	@Override
	public ProductType loadProductTypeEntity(String ptgProdtypeId) {
		String selprodTypeSql="SELECT ptg_prodtype_id,ptg_prodtype_name,ptg_prodclass_id FROM ay_product_type_msg WHERE ptg_prodtype_id=?";
		try {
			List<ProductType> prodtypelist=this.getJdbcTemplate().query(selprodTypeSql, new Object[]{ptgProdtypeId},new RowMapper<ProductType>(){
				@Override
				public ProductType mapRow(ResultSet rs, int index)
						throws SQLException {
					ProductType productType=new ProductType();
					productType.setPtgProdclassId(rs.getString("ptg_prodclass_id"));
					productType.setPtgProdtypeId(rs.getString("ptg_prodtype_id"));
					productType.setPtgProdtypeName(rs.getString("ptg_prodtype_name"));
					return productType;
				}});
			if(null!=prodtypelist&&prodtypelist.size()>0)
			{
				return prodtypelist.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
