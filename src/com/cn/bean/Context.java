package com.cn.bean;

public class Context {
  /**
   * 员工信息管理URL
   */
	private String employeeMUrl;
	
	/**
	 * 商品信息管理URL
	 */
	private String goodsMUrl;
	
	/**
	 * 商品采购管理URL
	 */
	private String goodsPUrl;
	
	/**
	 * 商品销售管理URL
	 */
	private String goodsSUrl;
	
	/**
	 * 库存管理
	 */
	private String stock;
	
	/**
	 * 系统管理
	 */
	private String system;

	public String getEmployeeMUrl() {
		return employeeMUrl;
	}

	public void setEmployeeMUrl(String employeeMUrl) {
		this.employeeMUrl = employeeMUrl;
	}

	public String getGoodsMUrl() {
		return goodsMUrl;
	}

	public void setGoodsMUrl(String goodsMUrl) {
		this.goodsMUrl = goodsMUrl;
	}

	public String getGoodsPUrl() {
		return goodsPUrl;
	}

	public void setGoodsPUrl(String goodsPUrl) {
		this.goodsPUrl = goodsPUrl;
	}

	public String getGoodsSUrl() {
		return goodsSUrl;
	}

	public void setGoodsSUrl(String goodsSUrl) {
		this.goodsSUrl = goodsSUrl;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	@Override
	public String toString() {
		return "Context [employeeMUrl=" + employeeMUrl + ", goodsMUrl="
				+ goodsMUrl + ", goodsPUrl=" + goodsPUrl + ", goodsSUrl="
				+ goodsSUrl + ", stock=" + stock + ", system=" + system + "]";
	}

	public Context() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Context(String employeeMUrl, String goodsMUrl, String goodsPUrl,
			String goodsSUrl, String stock, String system) {
		super();
		this.employeeMUrl = employeeMUrl;
		this.goodsMUrl = goodsMUrl;
		this.goodsPUrl = goodsPUrl;
		this.goodsSUrl = goodsSUrl;
		this.stock = stock;
		this.system = system;
	}
	
	
	
}
