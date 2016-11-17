package me.shaobin.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import me.shaobin.bean.Page;
import me.shaobin.dao.CustomerDao;
import me.shaobin.entity.CustomerEntity;

public class CustomerServlet implements Servlet {
	
	private CustomerDao customerDao;

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
		customerDao = new CustomerDao();
	}

	@Override
	public void service(ServletRequest srequest, ServletResponse arg1)
			throws ServletException, IOException {
		HttpServletRequest request = (HttpServletRequest) srequest;
		String requestPage = request.getParameter("page");
		if(requestPage==null) requestPage = "1";
		int page;
		try{
			page = Integer.valueOf(requestPage);
		}catch(NumberFormatException e){
			page = 1;
		}
		Page<CustomerEntity> res = customerDao.queryCustomer(page);
		request.setAttribute("page",res);
		request.getRequestDispatcher("/Customer/index.jsp").forward(request, arg1);;
	}

}
