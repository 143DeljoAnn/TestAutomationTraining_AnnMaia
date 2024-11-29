package com.ecommerce.controller;

public class CustomProperties {
	private String iexcelpath;
	private String oexcelpath;

	public String getOexcelpath() {
		return oexcelpath;
	}

	public void setOexcelpath(String oexcelpath) {
		this.oexcelpath = oexcelpath;
	}

	private CustomProperties() {

	}

	public CustomProperties(String iexcelpath,String oexcelpath) {
		super();
		this.iexcelpath = iexcelpath;
		this.oexcelpath = oexcelpath;
	}

	public String getIexcelpath() {
		return iexcelpath;
	}

	public void setIexcelpath(String iexcelpath) {
		this.iexcelpath = iexcelpath;
	}

}
