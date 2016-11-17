package com.steve.test;

import com.steve.entity.StudentEntity;
import com.steve.service.StudentService;
import com.steve.service.impl.StudentServiceImpl;
import com.steve.xml.XMLInputUtil;
import com.steve.xml.XMLOutputUtil;

public class MainEntance {
	
	private static StudentService studentService;
	
	static{
		studentService = new StudentServiceImpl();
	}

	public static void main(String[] args) {
		testXMLAdd();
		testUpdate();
		testDelete();
		testXMLOutput();
	}
	
	private static void testXMLAdd(){
		XMLInputUtil xml = new XMLInputUtil();
		studentService.addStudentList(xml.getData());
	}
	
	private static void testUpdate(){
		StudentEntity student = studentService.readStudent("201510098997");
		student.setGender("Ů");
		student.setStudentName("Hermindni");
		System.out.println("Testing update...");
		studentService.updateStudent(student);
	}
	
	private static void testDelete(){
		System.out.println("Testing delete...");
		studentService.deleteStudent("201510098995");
	}
	
	private static void testXMLOutput(){
		XMLOutputUtil xml = new XMLOutputUtil();
		xml.doOutput(studentService.queryAll());
	}

}
