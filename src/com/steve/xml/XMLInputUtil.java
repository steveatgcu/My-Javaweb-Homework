package com.steve.xml;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import com.steve.entity.StudentEntity;

public class XMLInputUtil {
	
	private String inputPath ="bin/input.xml";

	public List<StudentEntity> getData(){
		List<StudentEntity> students = new ArrayList<StudentEntity>();
	    SAXBuilder builder = new SAXBuilder();
        try {
			Document doc = builder.build(new File(inputPath));
			Element rootEl = doc.getRootElement();
		    List<Element> list = rootEl.getChildren("student");
		    for (Element el : list) {
		    	StudentEntity student = new StudentEntity();
		    	student.setClassName(el.getChildText("classname"));
		    	student.setGender(el.getChildText("gender"));
		    	student.setGrade(el.getChildText("grade"));
		    	student.setMajor(el.getChildText("major"));
		    	student.setStudentName(el.getChildText("studentname"));
		    	student.setStudentNumber(el.getChildText("studentnumber"));
		    	students.add(student);
		    }
		} catch (JDOMException | IOException e) {
			e.printStackTrace();
		}
		return students;
	}
	
}
