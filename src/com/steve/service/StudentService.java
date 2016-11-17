package com.steve.service;

import java.util.List;

import com.steve.entity.StudentEntity;
/**
 * Service Interface
 * 数据服务层接口
 * @author Ou Shaobin
 * @since 2016.09.24 14.53
 */
public interface StudentService {
	/**
	 * 添加学生列表
	 * @param addList 学生实体的列表
	 */
	public void addStudentList(List<StudentEntity> addList);
	
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
	 * @param student
	 * @return 
	 */
	public StudentEntity readStudent(String studentNumber);
	
	/**
	 * 更新某个学生的数据
	 * @param student
	 */
	public void updateStudent(StudentEntity student);
	
	/**
	 * 查询整个数据表中所有的记录
	 */
	public List<StudentEntity> queryAll();
}
