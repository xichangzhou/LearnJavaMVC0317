package com.cn.xi.action;

import java.util.List;

import com.cn.xi.domain.User;
import com.cn.xi.service.UserService;
import com.opensymphony.xwork2.Action;

public class ViewUserAction implements Action {

	private List<User> users;

	@Override
	public String execute() throws Exception {
		UserService us = new UserService();
		setUsers(us.getAllUsers());
		return SUCCESS;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
