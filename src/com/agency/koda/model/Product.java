package com.agency.koda.model;

import java.io.Serializable;

/**
 *保险产品实体类
 *@author meng
 *2015-08-05
 */
@SuppressWarnings("serial")
public class Product implements Serializable
{
	/**
	 * 险种子产品ID
	 * pg_prod_id
	 */
	private String pgProdId;
	/**
	 * 险种子产品名称
	 * pg_prod_name
	 */
	private String pgProdName;

	/**
	 *产品类型ID
	 *pg_prodtype_id 
	 */
	private String pgProdtypeId;

	/**
	 * 是否是主险
	 * pg_prod_flagmain 1主险0默认不是
	 */
	private int pgProdFlagmain;

	public String getPgProdId() {
		return pgProdId;
	}

	public void setPgProdId(String pgProdId) {
		this.pgProdId = pgProdId;
	}

	public String getPgProdName() {
		return pgProdName;
	}

	public void setPgProdName(String pgProdName) {
		this.pgProdName = pgProdName;
	}

	public String getPgProdtypeId() {
		return pgProdtypeId;
	}

	public void setPgProdtypeId(String pgProdtypeId) {
		this.pgProdtypeId = pgProdtypeId;
	}

	public int getPgProdFlagmain() {
		return pgProdFlagmain;
	}

	public void setPgProdFlagmain(int pgProdFlagmain) {
		this.pgProdFlagmain = pgProdFlagmain;
	}




}
