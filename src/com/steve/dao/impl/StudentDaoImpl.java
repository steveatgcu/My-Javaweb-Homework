package com.steve.dao.impl;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.steve.dao.StudentDao;
import com.steve.entity.StudentEntity;

/**
 * Student Data Access Object Implements
 * @author Ou Shaobin
 */
public class StudentDaoImpl implements StudentDao {

	public StudentDaoImpl() {
		// 实例化时自动建表
		checkTable();
	}

	private static Connection getCon() {
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

	@Override
	public void createStudent(StudentEntity student) {
		int i = 0;
		String sql = "insert into tb_student "
				+ "(F_name,F_student_number,F_major,F_grade,F_class_info,F_gender)"
				+ " values(?,?,?,?,?,?)";
		try {
			Connection connection = getCon();
			connection.setAutoCommit(true); // 自动提交事务
			PreparedStatement statement = (PreparedStatement) connection
					.prepareStatement(sql);
			statement.setString(1, student.getStudentName());
			statement.setString(2, student.getStudentNumber());
			statement.setString(3, student.getMajor());
			statement.setString(4, student.getGrade());
			statement.setString(5, student.getClassName());
			statement.setString(6, student.getGender());
			statement.executeUpdate();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteStudent(String studentNumber) {
		String sql = "DELETE FROM tb_student WHERE F_student_number=\""
				+ studentNumber + "\"";
		Connection connection = getCon();
		try {
			PreparedStatement statement = (PreparedStatement) connection
					.prepareStatement(sql);
			connection.setAutoCommit(true);
			statement.executeUpdate(sql);
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public StudentEntity readStudent(String studentNumber) {
		String sql = "SELECT * FROM tb_student WHERE F_student_number = ? ";
		Connection connection = getCon();
		try {
			PreparedStatement statement = (PreparedStatement) connection
					.prepareStatement(sql);
			statement.setString(1, studentNumber);
			ResultSet result = statement.executeQuery();
			StudentEntity student = new StudentEntity();
			result.next();
			student.setClassName(result.getString("F_class_info"));
			student.setGender(result.getString("F_gender"));
			student.setGrade(result.getString("F_grade"));
			student.setMajor(result.getString("F_major"));
			student.setStudentName(result.getString("F_name"));
			student.setStudentNumber(result.getString("F_student_number"));
			return student;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<StudentEntity> queryAll() {
		String sql = "SELECT * FROM tb_student";
		Connection connection = getCon();
		List<StudentEntity> studentList = new ArrayList<StudentEntity>();
		try {
			PreparedStatement statement = (PreparedStatement) connection
					.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				StudentEntity student = new StudentEntity();
				student.setClassName(result.getString("F_class_info"));
				student.setGender(result.getString("F_gender"));
				student.setGrade(result.getString("F_grade"));
				student.setMajor(result.getString("F_major"));
				student.setStudentName(result.getString("F_name"));
				student.setStudentNumber(result.getString("F_student_number"));
				studentList.add(student);
			}
			statement.close();
			connection.close();
			return studentList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void updateStudent(StudentEntity student) {
		String sql = "update tb_student set F_name =\""
				+ student.getStudentName() + "\" ,F_major =\""
				+ student.getMajor() + "\" ,F_grade =\"" + student.getGrade()
				+ "\" ,F_class_info= \"" + student.getClassName()
				+ "\",F_gender=\"" + student.getGender()
				+ "\" where F_student_number =\"" + student.getStudentNumber()
				+ "\"";
		try {
			Connection connection = getCon();
			connection.setAutoCommit(true); // 自动提交事务
			PreparedStatement statement = (PreparedStatement) connection
					.prepareStatement(sql);
			statement.executeUpdate(sql);
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 自动建表
	 */
	private static void checkTable() {
		String sql = "CREATE TABLE IF NOT EXISTS tb_student ("
				+ "F_student_number VARCHAR (12) PRIMARY KEY,	"
				+ "F_name VARCHAR (10) NOT NULL,"
				+ "F_major VARCHAR (15) NOT NULL,"
				+ "F_grade VARCHAR (15) NOT NULL,"
				+ "F_gender VARCHAR (15) NOT NULL,"
				+ "F_class_info VARCHAR (15) NOT NULL);";
		try {
			Connection connection = getCon();
			PreparedStatement statement = (PreparedStatement) connection
					.prepareStatement(sql);
			statement.executeUpdate(sql);
			statement.close();
			connection.close();
			System.out.println("Finish table check and create.");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
