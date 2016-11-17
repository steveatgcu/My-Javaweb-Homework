package me.shaobin.framework.mysql;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class ConnectionManager {

	public static final String DEFAULT_PROTOCOL = "mysql";
	public static final String DEFAULT_PORT="3306";
	public static final String DEFAULT_CHARSET = "UTF-8";
	public static final String DEFAULT_DRIVER = "com.mysql.jdbc.Driver";
	private String protocol = DEFAULT_PROTOCOL;
	private String host;
	private String port = DEFAULT_PORT;
	private String dbName;
	private String charset=DEFAULT_CHARSET;
	private String driver = DEFAULT_DRIVER;
	private String username;
	private String password;
	
	public ConnectionManager(String host, String dbName) {
		super();
		this.host = host;
		this.dbName = dbName;
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Connection getCon() {
		String url = "jdbc:"+protocol+"://"+host+":"+port+"/"+dbName+"?characterEncoding="+charset;
		try {
			Connection con = (Connection) DriverManager.getConnection(url,username, password);
			return con;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
