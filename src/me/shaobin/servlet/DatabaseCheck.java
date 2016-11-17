package me.shaobin.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import me.shaobin.dao.CustomerDao;
import me.shaobin.dao.UploadDao;
import me.shaobin.dao.UserDao;

public class DatabaseCheck implements Servlet{

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
		UserDao.checkTable();
		UploadDao.checkTable();
		CustomerDao.checkTable();
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		
	}

}
