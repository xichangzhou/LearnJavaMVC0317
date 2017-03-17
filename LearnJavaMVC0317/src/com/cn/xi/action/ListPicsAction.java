package com.cn.xi.action;

import java.util.List;

import com.cn.xi.domain.Picture;
import com.cn.xi.service.PicService;
import com.opensymphony.xwork2.ActionSupport;

public class ListPicsAction extends ActionSupport {

	private List<Picture> picts;

	public List<Picture> getPicts() {
		return picts;
	}

	public void setPicts(List<Picture> picts) {
		this.picts = picts;
	}
	
	@Override
	public String execute() throws Exception {
		PicService ps = new PicService();
		setPicts(ps.getAllPicts());
		return SUCCESS;
	}
}
