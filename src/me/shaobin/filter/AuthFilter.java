package me.shaobin.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.shaobin.entity.UserEntity;

public class AuthFilter implements Filter,
		com.sun.org.apache.xalan.internal.xsltc.dom.Filter {

	@Override
	public boolean test(int node) {
		return false;
	}

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		UserEntity user = (UserEntity) request.getSession().getAttribute("userEntity");
		if(user!=null){
			chain.doFilter(servletRequest, servletResponse);
		}else{
			request.getRequestDispatcher("/Customer/login.jsp").forward(servletRequest, servletResponse);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
