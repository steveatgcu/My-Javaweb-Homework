package me.shaobin.service.impl;

import java.util.List;

import me.shaobin.bean.Page;
import me.shaobin.dao.StudentDao;
import me.shaobin.dao.impl.StudentDaoImpl;
import me.shaobin.entity.StudentEntity;
import me.shaobin.framework.mysql.ConnectionManager;
import me.shaobin.service.StudentService;
import me.shaobin.utils.PageUtils;

public class StudentServiceImpl implements StudentService{
	
	private ConnectionManager cm;
	private StudentDao studentDao;

	public StudentServiceImpl(ConnectionManager cm) {
		this.cm = cm;
		studentDao = new StudentDaoImpl(cm);
	}

	@Override
	public void addStudent(StudentEntity student) {
		studentDao.addStudent(student);
	}

	@Override
	public void deleteStudent(StudentEntity student) {
		studentDao.deleteStudent(student);
	}

	@Override
	public void updateStudent(StudentEntity student) {
		studentDao.updateStudent(student);
	}

	@Override
	public StudentEntity queryByNumber(String studentNumber) {
		return studentDao.queryByNumber(studentNumber);
	}

	@Override
	public Page<StudentEntity> queryByPage(int page) {
		PageUtils<StudentEntity> pageUtil = new PageUtils<StudentEntity>();
		int count = studentDao.getCount();
		return studentDao.queryByPage(pageUtil.generatePage(count, page, 10));
	}

	@Override
	public List<StudentEntity> queryAll() {
		return studentDao.queryAll();
	}

}
