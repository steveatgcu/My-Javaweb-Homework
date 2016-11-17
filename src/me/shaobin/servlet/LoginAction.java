package me.shaobin.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.shaobin.dao.UserDao;
import me.shaobin.entity.UserEntity;

public class LoginAction implements Servlet {
	
	private UserDao userDao;

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
		userDao = new UserDao();
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		String userName = request.getParameter("usr");
		String password = request.getParameter("pwd");
		if(userName != null && password != null){
			UserEntity user = new UserEntity();
			user.setPassword(password);
			user.setUserName(userName);
			boolean isComfirm = userDao.comfirm(user);
			if(isComfirm){
				String path = request.getContextPath();
				request.getSession().setAttribute("userEntity", user);
				response.sendRedirect(path+"/Customer/main");
			}else{
				request.setAttribute("reason", "登录失败，请重试");
				request.getRequestDispatcher("/Customer/login.jsp").forward(request, response);
			}
		}else{
			request.getRequestDispatcher("/Customer/login.jsp").forward(request, response);
		}
	}

}
