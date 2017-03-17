package com.cn.xi.domain;

public class Picture {

	private Integer id;
	private String picName;
	private String fileName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPicName() {
		return picName;
	}

	public void setPicName(String picName) {
		this.picName = picName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Picture(Integer id, String picName, String fileName) {
		super();
		this.id = id;
		this.picName = picName;
		this.fileName = fileName;
	}

	public Picture() {
	}

}
