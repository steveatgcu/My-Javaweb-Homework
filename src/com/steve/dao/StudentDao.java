package com.steve.dao;

import java.util.List;

import com.steve.entity.StudentEntity;
/**
 * Data Access Object Interface
 * 数据访问层接口
 * @author Ou Shaobin
 * @since 2016.09.24 15.11
 */
public interface StudentDao {

	
	/**
	 * 创建单个学生的记录
	 * @param student
	 */
	public void createStudent(StudentEntity student);
	
	/**
	 * 删除单个学生的记录
	 * @param studentNumber
	 */
	public void deleteStudent(String studentNumber);

	/**
	 * 读取某个学生的记录 [根据学号]
	 * @param studentNumber
	 * @return 
	 */
	public StudentEntity readStudent(String studentNumber);
	
	/**
	 * 查询整个数据表中所有的记录
	 */
	public List<StudentEntity> queryAll();
	
	/**
	 * 更新某个学生的数据
	 * @param student
	 */
	public void updateStudent(StudentEntity student);
}
