package com.cn.xi.action;

import com.cn.xi.domain.User;
import com.cn.xi.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginProAction extends ActionSupport {
	
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
			System.out.println("---------------------------------");
			//保存数据到session
			ActionContext.getContext().getSession().put("userId", user.getId());
			//addActionMessage("登录成功");
			return SUCCESS;
		} else {
			//addActionMessage("用户名 或 密码错误");
			return ERROR;
		}
		
	}
	
	public String regist() {
		UserService us = new UserService();
		us.addUser(user);
		return SUCCESS;
	}

}
