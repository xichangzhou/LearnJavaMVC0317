//package com.xi.database;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.sql.Types;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.mysql.jdbc.CallableStatement;
//import com.sun.xml.internal.ws.org.objectweb.asm.Type;
//import com.xi.entity.Users;
//
//public class ConnectedMySQL {
//
//	public static void main(String[] args) {
//
//		// query();
//
//		// queryTwo();
//
//		// createTable();
//
//		// insert();
//
//		// update();
//
//		// delete();
//
//		// queryThree();
//
//		// insert("aa", "abc@qq.com");
//
////		insert(new Users("asdf", "adsdf@qq.com"));
//
////		query();
//		
////		queryFour();
//		
////		insertTwo();
//		
//		queryFour();
//		
////		queryFive();
//	}
//	
//	static void queryFive(){
//		Connection connection = DBUtil.open();
//		try {
//			// 调用存储过程
//			CallableStatement callableStatement = (CallableStatement) connection.prepareCall("{call getnamebyid(?,?)}");
//			callableStatement.setInt(1, 1);
//			//注册输入参数
//			callableStatement.registerOutParameter(2, Types.CHAR);
//			callableStatement.execute();
//			String email = callableStatement.getString(2);
//			callableStatement.executeQuery();
//			System.out.println(email);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			DBUtil.close(connection);
//		}
//	}
//
//	static List<Users> queryFour() {
//		Connection connection = DBUtil.open();
//		try {
//			// 调用存储过程
//			CallableStatement callableStatement = (CallableStatement) connection.prepareCall("{call all_customers()}");
//			ResultSet resultSet = callableStatement.executeQuery();
//			List<Users> list = new ArrayList<Users>();
//			while (resultSet.next()) {
//				String name = resultSet.getString(1);
//				String email = resultSet.getString(2);
//				// 用类封装起来
//				Users u = new Users(name, email);
//				list.add(u);
//				System.out.println(u);
//			}
//			return list;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			DBUtil.close(connection);
//		}
//		return null;
//	}
//
//	static List<Users> queryThree() {
//		Connection connection = DBUtil.open();
//
//		String sql = "select name,email from CustomerTbl";
//
//		try {
//			Statement statement = connection.createStatement();
//			ResultSet resultSet = statement.executeQuery(sql);
//			List<Users> list = new ArrayList<Users>();
//
//			while (resultSet.next()) {
//				String name = resultSet.getString(1);
//				String email = resultSet.getString(2);
//				// 用类封装起来
//				Users u = new Users(name, email);
//				list.add(u);
//				System.out.println(u);
//			}
//			return list;
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DBUtil.close(connection);
//		}
//		return null;
//	}
//
//	static void queryTwo() {
//		Connection connection = DBUtil.open();
//
//		String sql = "select * from CustomerTbl";
//
//		try {
//			Statement statement = connection.createStatement();
//			ResultSet resultSet = statement.executeQuery(sql);
//
//			while (resultSet.next()) {
//				int id = resultSet.getInt(1);
//				String name = resultSet.getString(2);
//				String email = resultSet.getString(3);
//				System.out.println(id + "," + name + "," + email);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DBUtil.close(connection);
//		}
//
//	}
//
//	static void query() {
//
//		Connection connection = null;
//
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//
//			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/xcz", "root", "123456");
//
//			String sql = "select * from CustomerTbl";
//
//			Statement statement = connection.createStatement();
//
//			ResultSet resultSet = statement.executeQuery(sql);
//
//			while (resultSet.next()) {
//				int id = resultSet.getInt(1);
//				String name = resultSet.getString(2);
//				String email = resultSet.getString(3);
//
//				System.out.println(id + "," + name + "," + email);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if (connection != null) {
//				try {
//					connection.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//
//	}
//
//	/*
//	 * 创建表
//	 */
//	static void createTable() {
//		Connection connection = DBUtil.open();
//		String sql = "create table UserTbl(" + "id int primary key auto_increment" + ",name varchar(20))";
//		try {
//			Statement statement = connection.createStatement();
//			statement.execute(sql);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DBUtil.close(connection);
//		}
//	}
//
//	/*
//	 * 向表中插入数据
//	 */
//	static void insert() {
//		Connection connection = DBUtil.open();
//		String sql = "insert into UserTbl(name) values('abc')";
//		try {
//			Statement statement = connection.createStatement();
//			statement.executeUpdate(sql);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DBUtil.close(connection);
//		}
//	}
//
//	static void insert(String name, String email) {
//		String sql = "insert into CustomerTbl(name,email) values(?,?)";
//		Connection connection = DBUtil.open();
//		try {
//			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
//			preparedStatement.setString(1, name);
//			preparedStatement.setString(2, email);
//			preparedStatement.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DBUtil.close(connection);
//		}
//
//	}
//
//	static void insert(Users u) {
//		String sql = "insert into CustomerTbl(name,email) values(?,?)";
//		Connection connection = DBUtil.open();
//		try {
//			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
//			preparedStatement.setString(1, u.getUsername());
//			preparedStatement.setString(2, u.getEmail());
//			preparedStatement.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DBUtil.close(connection);
//		}
//
//	}
//	
//	static void insertTwo() {
//		Connection connection = DBUtil.open();
//		try {
//			// 调用存储过程
//			CallableStatement callableStatement = (CallableStatement) connection.prepareCall("{call insert_customer(?,?)}");
//			callableStatement.setString(1, "qwert");
//			callableStatement.setString(2, "qwert@qq.com");
//			callableStatement.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DBUtil.close(connection);
//		}
//
//	}
//
//	/*
//	 * 向表中更新数据
//	 */
//	static void update() {
//		Connection connection = DBUtil.open();
//		String sql = "update UserTbl set name='nihao' where id = 1";
//		try {
//			Statement statement = connection.createStatement();
//			statement.executeUpdate(sql);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DBUtil.close(connection);
//		}
//	}
//
//	/*
//	 * 向表中更新数据
//	 */
//	static void delete() {
//		Connection connection = DBUtil.open();
//		String sql = "delete from UserTbl where id = 1";
//		try {
//			Statement statement = connection.createStatement();
//			statement.executeUpdate(sql);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DBUtil.close(connection);
//		}
//	}
//
//}
