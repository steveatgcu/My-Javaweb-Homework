package me.shaobin.controller;

import javax.servlet.http.HttpServletRequest;

import me.shaobin.bean.Page;
import me.shaobin.entity.StudentEntity;
import me.shaobin.framework.annotation.RequestMapping;
import me.shaobin.framework.mysql.ConnectionManager;
import me.shaobin.service.StudentService;
import me.shaobin.service.impl.StudentServiceImpl;
import me.shaobin.utils.XMLOutputUtil;

@SuppressWarnings("unused")
public class StudentController {

	public StudentService studentService;
	private ConnectionManager cm;

	public StudentController(ConnectionManager cm) {
		super();
		this.cm = cm;
		studentService = new StudentServiceImpl(cm);
	}

	@RequestMapping(value = "student")
	public String hadlerQuery(HttpServletRequest request) {
		String queryPage = request.getParameter("page");
		if (queryPage == null) {
			queryPage = "1";
		}
		Page<StudentEntity> page = studentService.queryByPage(Integer
				.valueOf(queryPage));
		request.setAttribute("page", page);
		request.getSession().setAttribute("currentPage", page.getCurrentPage());
		return "index.jsp";
	}

	@RequestMapping(value = "updateStudent")
	public String updateStudent(HttpServletRequest request) {
		String studentNumber = request.getParameter("studentNumber");
		if (studentNumber != null) {
			StudentEntity student = studentService.queryByNumber(studentNumber);
			student.setClassName(request.getParameter("className"));
			student.setGender(request.getParameter("gender"));
			student.setGrade(request.getParameter("grade"));
			student.setMajor(request.getParameter("major"));
			student.setStudentName(request.getParameter("studentName"));
			request.setAttribute("detail", student);
			studentService.updateStudent(student);
		}
		return "detail.jsp";
	}

	@RequestMapping(value = "removeStudent")
	public String removeStudent(HttpServletRequest request) {
		String studentNumber = request.getParameter("studentNumber");
		if (studentNumber != null) {
			StudentEntity student = studentService.queryByNumber(studentNumber);
			if (student != null) {
				studentService.deleteStudent(student);
			}
		}
		Page<StudentEntity> page = studentService.queryByPage(1);
		request.setAttribute("page", page);
		return "index.jsp";
	}

	@RequestMapping(value = "addStudent")
	public String addStudent(HttpServletRequest request) {
		String studentNumber = request.getParameter("studentNumber");
		if (studentNumber != null) {
			StudentEntity student = studentService.queryByNumber(studentNumber);
			if (student != null) {
				request.setAttribute("reason", "创建失败，存在同学号用户");
				return "add.jsp";
			} else {
				student = new StudentEntity();
				student.setStudentNumber(studentNumber);
				student.setClassName(request.getParameter("className"));
				student.setGender(request.getParameter("gender"));
				student.setGrade(request.getParameter("grade"));
				student.setMajor(request.getParameter("major"));
				student.setStudentName(request.getParameter("studentName"));
				request.setAttribute("detail", student);
				studentService.addStudent(student);
			}
		}
		Page<StudentEntity> page = studentService.queryByPage(1);
		request.setAttribute("page", page);
		return "index.jsp";
	}

	@RequestMapping(value = "detail")
	public String queryById(HttpServletRequest request) {
		String studentNumber = request.getParameter("studentNumber");
		if (studentNumber != null) {
			StudentEntity student = studentService.queryByNumber(studentNumber);
			request.setAttribute("detail", student);
			return "detail.jsp";
		} else {
			Page<StudentEntity> page = studentService.queryByPage(1);
			request.setAttribute("page", page);
			return "index.jsp";
		}
	}
	
	@RequestMapping(value="downloadXML")
	public String downloadHandler(HttpServletRequest request){
		String path = request.getServletContext().getRealPath("/");
		XMLOutputUtil xml = new XMLOutputUtil(path);
		xml.doOutput(studentService.queryAll());
		return "download.jsp";
	}
	
	@RequestMapping(value="add")
	public String addPage(HttpServletRequest request){
		return "add.jsp";
	}

}