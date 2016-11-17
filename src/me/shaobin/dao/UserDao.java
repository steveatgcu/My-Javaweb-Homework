package me.shaobin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import me.shaobin.entity.UserEntity;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class UserDao extends BaseDao {


	public boolean comfirm(UserEntity user){
		String sql = "SELECT * FROM tb_user WHERE F_username = ? AND F_password = ?";
		try {
			Connection connection = getCon();
			PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
			statement.setString(1, user.getUserName());
			statement.setString(2, user.getPassword());
			ResultSet result = statement.executeQuery();
			if(result.next()){
				return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 自动建表
	 */
	public static void checkTable() {
		String sql = "CREATE TABLE IF NOT EXISTS tb_user ("
				+ "F_username VARCHAR (12) PRIMARY KEY,	"
				+ "F_password VARCHAR (10) NOT NULL);";
		try {
			Connection connection = getCon();
			PreparedStatement statement = (PreparedStatement) connection
					.prepareStatement(sql);
			statement.executeUpdate(sql);
			statement.close();
			connection.close();
			System.out.println("Finish USER table check and create.");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
