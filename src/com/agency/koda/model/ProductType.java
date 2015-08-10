package com.agency.koda.model;

import java.io.Serializable;

/**
 *保险产品类型
 *@author meng
 *2015-08-05 
 */
@SuppressWarnings("serial")
public class ProductType implements Serializable{

	/**
	 * 保险产品类型ID
	 * ptg_prodtype_id
	 */
	private String ptgProdtypeId;

	/**
	 * 产品类型名称
	 * ptg_prodtype_name
	 */
	private String ptgProdtypeName;

	/**
	 * 产品ID
	 * ptg_prodclass_id
	 */
	private String ptgProdclassId;

	public String getPtgProdtypeId() {
		return ptgProdtypeId;
	}

	public void setPtgProdtypeId(String ptgProdtypeId) {
		this.ptgProdtypeId = ptgProdtypeId;
	}

	public String getPtgProdtypeName() {
		return ptgProdtypeName;
	}

	public void setPtgProdtypeName(String ptgProdtypeName) {
		this.ptgProdtypeName = ptgProdtypeName;
	}

	public String getPtgProdclassId() {
		return ptgProdclassId;
	}

	public void setPtgProdclassId(String ptgProdclassId) {
		this.ptgProdclassId = ptgProdclassId;
	}



}
