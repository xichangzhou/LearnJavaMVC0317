package com.cn.xi.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cn.xi.db.DBUtil;
import com.cn.xi.domain.User;
import com.mysql.jdbc.PreparedStatement;


public class CustomerDaoImpl implements CustomerDao {
	

	//创建表
	public void createTable() {
		String sql = "CREATE TABLE db_user ("
				+ "id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,"
				+ "name VARCHAR(100) NOT NULL,"
				+ "pass VARCHAR(100) NOT NULL,"
				+ "weight DOUBLE,"
				+ "birth DATE)";
		Connection connection = DBUtil.open();
		
		try {
			Statement statement = connection.createStatement();
			statement.execute(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection);
		}
	}

	@Override
	public void add(User u) {
		String sql = "insert into db_user(name,pass,weight,birth) values(?,?,?,?)";
		Connection connection = DBUtil.open();
		try {
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			preparedStatement.setString(1, u.getName());
			preparedStatement.setString(2, u.getPass());
			preparedStatement.setDouble(3, u.getWeight());
			Date birth = (Date) u.getBirth();
			if(birth == null) {
				preparedStatement.setDate(4, new Date(0));
			} else {
				preparedStatement.setDate(4, (Date) u.getBirth());
			}
			
			
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection);
		}
	}

	@Override
	public void update(User u) {
		String sql = "update db_user set name=?,pass=? where id = ?";
		Connection connection = DBUtil.open();
		try {
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			preparedStatement.setString(1, u.getName());
			preparedStatement.setString(2, u.getPass());
			preparedStatement.setInt(3, u.getId());
			
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection);
		}
	}

	@Override
	public void delete(Integer id) {
		String sql = "delete from db_user where id = ?";
		Connection connection = DBUtil.open();
		try {
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection);
		}
	}

	@Override
	public User getCustomerById(Integer id) {
		String sql = "select * from db_user where id = ?";
		Connection connection = DBUtil.open();
		try {
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				User u = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),resultSet.getDouble(4),resultSet.getDate(5));
				return u;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection);
		}
		return null;
	}

	@Override
	public List<User> query() {
		String sql = "select * from db_user";
		Connection connection = DBUtil.open();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			List<User> list = new ArrayList<User>();
			while(resultSet.next()){
				User u = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),resultSet.getDouble(4),resultSet.getDate(5));
				list.add(u);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection);
		}
		return null;
	}

}