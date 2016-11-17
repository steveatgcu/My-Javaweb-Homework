package me.shaobin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import me.shaobin.bean.Page;
import me.shaobin.entity.CustomerEntity;
import me.shaobin.utils.PageUtils;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class CustomerDao extends BaseDao {
	
	public int itemsNumber = 10;
	
	public Page<CustomerEntity>  queryCustomer(int pageNumber){
		int count = count();
		PageUtils<CustomerEntity> pageUtils = new PageUtils<CustomerEntity>();
		Page<CustomerEntity> page = pageUtils.generatePage(count, pageNumber, itemsNumber);
		String sql = "SELECT * FROM tb_customer LIMIT ?,?";
		try {
			Connection con = getCon();
			PreparedStatement statement = (PreparedStatement) con.prepareStatement(sql);
			statement.setInt(1, page.getStartNum());
			statement.setInt(2, page.getItemPrePage());
			ResultSet result = statement.executeQuery();
			List<CustomerEntity> data  = new ArrayList<CustomerEntity>();
			while(result.next()){
				CustomerEntity entity = new CustomerEntity();
				entity.setBirthday(result.getString("F_birthday"));
				entity.setName(result.getString("F_name"));
				entity.setPhone(result.getString("F_phone"));
				data.add(entity);
			}
			page.setData(data);
			statement.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return page;
	}
	
	public int count(){
		String sql = "SELECT count(*) FROM tb_customer";
		try {
			Connection con = getCon();
			PreparedStatement statement = (PreparedStatement) con.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			result.next();
			return result.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * 自动建表
	 */
	public static void checkTable() {
		String sql = "CREATE TABLE IF NOT EXISTS tb_customer ("
				+ "F_name VARCHAR (255) NOT NULL,	"
				+ "F_birthday VARCHAR (255) NOT NULL,"
				+ "F_phone VARCHAR(255) NOT NULL);";
		try {
			Connection connection = getCon();
			PreparedStatement statement = (PreparedStatement) connection
					.prepareStatement(sql);
			statement.executeUpdate(sql);
			statement.close();
			connection.close();
			System.out.println("Finish CUSTOMER table check and create.");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
