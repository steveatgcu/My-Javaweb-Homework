package me.shaobin.entity;

import me.shaobin.framework.annotation.Column;
import me.shaobin.framework.annotation.Constraints;
import me.shaobin.framework.annotation.Table;

@Table(name = "tb_student")
public class StudentEntity {

	@Column(name = "f_student_number")
	@Constraints(primarykey = true)
	private String studentNumber; // 学号（主键）
	
	@Column(name = "f_student_name")
	@Constraints(notnull = true)
	private String studentName; // 姓名
	
	@Column(name = "f_gender")
	@Constraints(notnull = true)
	private String gender; // 性别
	
	@Column(name = "f_major")
	@Constraints(notnull = true)
	private String major;// 专业
	
	@Column(name = "f_grade")
	@Constraints(notnull = true)
	private String grade;// 年级
	
	@Column(name = "f_class_name")
	@Constraints(notnull = true)
	private String className;// 班级

	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

}
