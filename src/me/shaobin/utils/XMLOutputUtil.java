package me.shaobin.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;

import me.shaobin.entity.StudentEntity;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class XMLOutputUtil {
	
	private static File outputFile;
	
	public XMLOutputUtil(String path){
		outputFile = new File(path+"output.xml");
	}

	public void doOutput(List<StudentEntity> students){
		  	Element root = new Element("students");  
	        Document document = new Document(root);  
	        Iterator<StudentEntity> iter = students.iterator();
	        while(iter.hasNext()){
	        	StudentEntity student = iter.next();
	        	Element studentEl = new Element("student");
	        	studentEl.addContent(new Element("studentnumber").setText(student.getStudentNumber()));
	        	studentEl.addContent(new Element("studentname").setText(student.getStudentName()));
	        	studentEl.addContent(new Element("major").setText(student.getMajor()));
	        	studentEl.addContent(new Element("grade").setText(student.getGrade()));
	        	studentEl.addContent(new Element("classname").setText(student.getClassName()));
	        	studentEl.addContent(new Element("gender").setText(student.getGender()));
	        	root.addContent(studentEl);
	        }
	        try {
		        XMLOutputter out = new XMLOutputter();  
	            Format f = Format.getPrettyFormat();  
	            f.setEncoding("UTF-8");
	            out.setFormat(f);  
	            out.output(document, new FileOutputStream(outputFile)); 
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	}
}
