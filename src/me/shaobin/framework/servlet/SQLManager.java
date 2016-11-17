package me.shaobin.framework.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import me.shaobin.entity.StudentEntity;
import me.shaobin.framework.mysql.ConnectionManager;
import me.shaobin.framework.mysql.TableManager;

/**
 * 做数据表检查
 * 
 * @author sheobin
 */
public class SQLManager extends HttpServlet {

	private static final long serialVersionUID = 4571810522003386127L;

	private ServletConfig config;
	private ConnectionManager cm;

	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		ServletContext context = config.getServletContext();
		generateConnectionManager();
		TableManager.checkTable(cm, StudentEntity.class);
		context.setAttribute("ConnectionManager", cm);
	}
	
	public void generateConnectionManager(){
		String username = config.getInitParameter("username");
		String password = config.getInitParameter("password");
		String dbName = config.getInitParameter("dbName");
		String host = config.getInitParameter("host");
		cm = new ConnectionManager(host, dbName);
		cm.setUsername(username);
		cm.setPassword(password);
	}

}
