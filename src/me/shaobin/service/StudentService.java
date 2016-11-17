package me.shaobin.service;

import java.util.List;

import me.shaobin.bean.Page;
import me.shaobin.entity.StudentEntity;

public interface StudentService {

	public void addStudent(StudentEntity student);
	public void deleteStudent(StudentEntity student);
	public void updateStudent(StudentEntity student);
	public StudentEntity queryByNumber(String studentNumber);
	public Page<StudentEntity> queryByPage(int page);
	public 	List<StudentEntity> queryAll();
}
