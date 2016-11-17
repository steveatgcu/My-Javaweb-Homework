package me.shaobin.framework.servlet;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.shaobin.controller.StudentController;
import me.shaobin.framework.core.ControllerMapping;
import me.shaobin.framework.mysql.ConnectionManager;

public class RequestDispatcher implements Servlet {
	
	Map<String,String> requestMap;

	@Override
	public void destroy() {
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		requestMap = ControllerMapping.scanMappingInfo(StudentController.class);
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		request.setCharacterEncoding("UTF-8");
		String mappingMethod = getMappingInfo(request);
		Object targetObject;
		if(mappingMethod==null){
			System.out.println("Mapping Not Found:"+request.getRequestURI());
			response.sendError(404);
		}else{
			try {
				Class<?> targetClass = StudentController.class;
				Constructor<?> construtor = targetClass.getConstructor(ConnectionManager.class);
				Method method = targetClass.getMethod(mappingMethod, HttpServletRequest.class);
				ConnectionManager cm = (ConnectionManager) request.getServletContext().getAttribute("ConnectionManager");
				targetObject = construtor.newInstance(cm);
				String index = (String) method.invoke(targetObject, request);
				request.getRequestDispatcher(index).forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				response.sendError(404);
			}
		}
	}
	
	private String getMappingInfo(HttpServletRequest request){
		String projectName = request.getServletContext().getContextPath();
		String uri = request.getRequestURI();
		int subindex = uri.lastIndexOf('.');
		uri = uri.substring(0,subindex).replace(projectName+"/", "");
		String method = requestMap.get(uri);
		return method;
	}

}
