package com.cn.xi.action;

import com.cn.xi.domain.User;
import com.cn.xi.service.UserService;
import com.opensymphony.xwork2.Action;

public class LoginProAction implements Action {
	
	private User user;
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String execute() throws Exception {
		UserService us = new UserService();
		Integer id = us.validateLogin(user);
		if(id>0) {
			return SUCCESS;
		} else {
			return ERROR;
		}
		
	}
	
	public String regist() {
		UserService us = new UserService();
		us.addUser(user);
		return SUCCESS;
	}

}