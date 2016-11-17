package me.shaobin.dao;

import java.util.List;

import me.shaobin.bean.Page;
import me.shaobin.entity.StudentEntity;

public interface StudentDao {
	
	public void addStudent(StudentEntity student);
	public void deleteStudent(StudentEntity student);
	public void updateStudent(StudentEntity student);
	public int getCount();
	public List<StudentEntity> queryAll();
	public StudentEntity queryByNumber(String studentNumber);
	public Page<StudentEntity> queryByPage(Page<StudentEntity> page);

}
