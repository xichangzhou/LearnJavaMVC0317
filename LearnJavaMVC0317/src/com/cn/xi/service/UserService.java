package com.cn.xi.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.cn.xi.dao.CustomerDao;
import com.cn.xi.dao.CustomerDaoImpl;
import com.cn.xi.domain.User;

public class UserService {
	static CustomerDao dao = new CustomerDaoImpl();
	//模拟数据库
	static List<User> userDB;

	static  {
		userDB = new ArrayList<>();
		userDB =  dao.query();
	}
	
	public List<User> getAllUsers() {
		return userDB;
	}

	public Integer validateLogin(User user) {
		for(User u : userDB) {
			if(u.equals(user)) {
				return u.getId();
			}
		}
		return -1;
	}

	public void addUser(User user) {
		dao.add(user);
	}
}
