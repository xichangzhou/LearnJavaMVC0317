package com.cn.xi.dao;

import java.util.List;

import com.cn.xi.domain.User;


public interface CustomerDao {
	public void createTable();
	
	public void add(User u);

	public void update(User u);

	public void delete(Integer id);

	public User getCustomerById(Integer id);

	public List<User> query();
}
