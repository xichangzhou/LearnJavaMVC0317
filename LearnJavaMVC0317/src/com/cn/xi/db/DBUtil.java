package com.cn.xi.db;

import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

public class DBUtil {
	
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	
	static {
		ResourceBundle resource = ResourceBundle.getBundle("config");
		driver = resource.getString("driver");
		url = resource.getString("url");
		username = resource.getString("username");
		password = resource.getString("password");
		
		
//		Properties properties = new Properties();
//		Reader reader;
//		try {
//			reader = new FileReader("src//config.properties");
//			properties.load(reader);
//			driver = properties.getProperty("driver");
//			url = properties.getProperty("url");
//			username = properties.getProperty("username");
//			password = properties.getProperty("password");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		
//		driver = "com.mysql.jdbc.Driver";
//		url = "jdbc:mysql://localhost:3306/xcz";
//		username = "root";
//		password = "123456";
	}
	

	public static Connection open(){
		try {
			Class.forName(driver);
			return DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public static void close(Connection connection) {
		if(connection!=null){
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
