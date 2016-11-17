package com.steve.service.impl;

import java.util.Iterator;
import java.util.List;

import com.steve.dao.StudentDao;
import com.steve.dao.impl.StudentDaoImpl;
import com.steve.entity.StudentEntity;
import com.steve.service.StudentService;

public class StudentServiceImpl implements StudentService {
	
	public StudentServiceImpl(){
		super();
		studentDao = new StudentDaoImpl();
	}
	
	private StudentDao studentDao;

	@Override
	public void addStudentList(List<StudentEntity> addList) {
		Iterator<StudentEntity> iter = addList.iterator();
		System.out.println("Processing List Add");
		while(iter.hasNext()){
			studentDao.createStudent(iter.next());		
		}
		System.out.println("Finish Processing");
	}

	@Override
	public void createStudent(StudentEntity student) {
		studentDao.createStudent(student);		
	}

	@Override
	public void deleteStudent(String studentNumber) {
		studentDao.deleteStudent(studentNumber);
	}

	@Override
	public StudentEntity readStudent(String studentNumber) {
		return studentDao.readStudent(studentNumber);
	}

	@Override
	public void updateStudent(StudentEntity student) {
		studentDao.updateStudent(student);
	}

	@Override
	public List<StudentEntity> queryAll() {
		return studentDao.queryAll();
	}
	
}
