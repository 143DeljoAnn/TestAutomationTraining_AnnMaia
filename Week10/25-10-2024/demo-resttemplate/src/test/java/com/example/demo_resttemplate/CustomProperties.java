package com.example.demo_resttemplate;

public class CustomProperties {
	private String iexcelpath;

	private CustomProperties() {

	}

	public CustomProperties(String iexcelpath) {
		super();
		this.iexcelpath = iexcelpath;
	}

	public String getIexcelpath() {
		return iexcelpath;
	}

	public void setIexcelpath(String iexcelpath) {
		this.iexcelpath = iexcelpath;
	}

}
