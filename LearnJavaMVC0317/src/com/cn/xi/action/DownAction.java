package com.cn.xi.action;

import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

//此处是一个通过的下载文件的action
public class DownAction extends ActionSupport {

	private String res;// 下载的资源
	private String resType;// 下载文件类型
	private String resName;// 下载文件名字

	public String getRes() {
		return res;
	}

	public void setRes(String res) throws Exception{
		//可能是中文的处理
		this.res = new String(res.getBytes("iso-8859-1"),"utf-8");
	}

	public String getResType() {
		return resType;
	}

	public void setResType(String resType) {
		this.resType = resType;
	}

	public String getResName() {
		return resName;
	}

	public void setResName(String resName) {
		this.resName = resName;
	}
	
	//该方法代表了文件下载的入口，他就是需要下载的输入流
	public InputStream getTarget() throws Exception{
		//该方法返回res资源对应的输入流
		return new FileInputStream(ServletActionContext.getServletContext().getRealPath("/") + res);
	}

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

}
