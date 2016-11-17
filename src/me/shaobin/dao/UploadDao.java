package me.shaobin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import me.shaobin.entity.UploadEntity;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class UploadDao extends BaseDao {
	
	public boolean create(UploadEntity upload){
		String sql = "INSERT INTO tb_upload (F_file_name,F_filePath) VALUES (?,?);";
		try {
			Connection connection = getCon();
			PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
			statement.setString(1, upload.getFileName());
			statement.setString(2, upload.getFilePath());
			if(statement.execute()){
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
		String sql = "CREATE TABLE IF NOT EXISTS tb_upload ("
				+ "F_file_name VARCHAR (255),	"
				+ "F_filePath VARCHAR (255) NOT NULL);";
		try {
			Connection connection = getCon();
			PreparedStatement statement = (PreparedStatement) connection
					.prepareStatement(sql);
			statement.executeUpdate(sql);
			statement.close();
			connection.close();
			System.out.println("Finish UPLOAD table check and create.");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
