package me.shaobin.unittest;

import me.shaobin.entity.StudentEntity;
import me.shaobin.framework.mysql.ConnectionManager;
import me.shaobin.framework.mysql.MysqlTemplate;

public class SqlTest {

   public static void main(String[] args) {
	   ConnectionManager cm = new ConnectionManager("localhost","student");
	   cm.setPassword("");
	   cm.setUsername("root");
	   MysqlTemplate mt = new MysqlTemplate(cm);
	   StudentEntity studentEntity = new StudentEntity();
	   studentEntity.setStudentNumber("201510098097");
	   studentEntity.setStudentName("区绍彬");
	   studentEntity.setMajor("软件工程");
	   mt.update(studentEntity);
//	   mt.excute("Select count(*) from tb_student;");
   }
}
