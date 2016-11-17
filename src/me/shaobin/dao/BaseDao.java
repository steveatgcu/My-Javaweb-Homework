package me.shaobin.dao;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public abstract class BaseDao {
	
	public static Connection getCon() {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/student?characterEncoding=utf-8";
		String username = "root";
		String password = "";
		try {
			Class.forName(driver);
			Connection con = (Connection) DriverManager.getConnection(url,
					username, password);
			return con;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
