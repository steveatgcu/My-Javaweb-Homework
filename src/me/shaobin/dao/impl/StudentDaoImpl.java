package me.shaobin.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import me.shaobin.bean.Page;
import me.shaobin.dao.StudentDao;
import me.shaobin.entity.StudentEntity;
import me.shaobin.framework.mysql.ConnectionManager;
import me.shaobin.framework.mysql.MysqlTemplate;

public class StudentDaoImpl implements StudentDao {
	
	private ConnectionManager cm;
	private MysqlTemplate mt;

	public StudentDaoImpl(ConnectionManager cm) {
		super();
		this.cm = cm;
		mt = new MysqlTemplate(cm);
	}

	@Override
	public void addStudent(StudentEntity student) {
		mt.save(student);
	}

	@Override
	public void deleteStudent(StudentEntity student) {
		mt.delete(student);
	}

	@Override
	public void updateStudent(StudentEntity student) {
		mt.update(student);
	}

	@Override
	public int getCount() {
		String sql = "SELECT count(*) FROM tb_student";
		ResultSet result = mt.excute(sql);
		try {
			result.next();
			return result.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<StudentEntity> queryAll() {
		String sql = "SELECT * FROM tb_student";
		try {
			ResultSet result = mt.excute(sql);
			List<StudentEntity> data  = new ArrayList<StudentEntity>();
			while(result.next()){
				StudentEntity student = new StudentEntity();
				student.setClassName(result.getString("f_class_name"));
				student.setGender(result.getString("f_gender"));
				student.setGrade(result.getString("f_grade"));
				student.setMajor(result.getString("f_major"));
				student.setStudentName(result.getString("f_student_name"));
				student.setStudentNumber(result.getString("f_student_number"));
				data.add(student);
			}
			return data;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public StudentEntity queryByNumber(String studentNumber) {
		String sql = "SELECT * FROM tb_student WHERE f_student_number = '"+ studentNumber + "'";
		ResultSet result = mt.excute(sql);
		try {
			StudentEntity student = new StudentEntity();
			result.next();
			student.setClassName(result.getString("f_class_name"));
			student.setGender(result.getString("f_gender"));
			student.setGrade(result.getString("f_grade"));
			student.setMajor(result.getString("f_major"));
			student.setStudentName(result.getString("f_student_name"));
			student.setStudentNumber(result.getString("f_student_number"));
			return student;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Page<StudentEntity> queryByPage(Page<StudentEntity> page) {
		String sql = "SELECT * FROM tb_student LIMIT "+page.getStartNum()+","+page.getItemPrePage()+"";
		try {
			ResultSet result = mt.excute(sql);
			List<StudentEntity> data  = new ArrayList<StudentEntity>();
			while(result.next()){
				StudentEntity student = new StudentEntity();
				student.setClassName(result.getString("f_class_name"));
				student.setGender(result.getString("f_gender"));
				student.setGrade(result.getString("f_grade"));
				student.setMajor(result.getString("f_major"));
				student.setStudentName(result.getString("f_student_name"));
				student.setStudentNumber(result.getString("f_student_number"));
				data.add(student);
			}
			page.setData(data);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return page;
	}

}
