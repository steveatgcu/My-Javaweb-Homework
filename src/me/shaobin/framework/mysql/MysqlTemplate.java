package me.shaobin.framework.mysql;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import me.shaobin.framework.annotation.Column;
import me.shaobin.framework.annotation.Constraints;
import me.shaobin.framework.annotation.Table;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class MysqlTemplate {

	public ConnectionManager cm;

	public MysqlTemplate(ConnectionManager cm) {
		this.cm = cm;
	}

	public void save(Object entityObject) {
		Class<?> entity = entityObject.getClass();
		String tableName = getTableName(entity);
		Field[] fields = entity.getDeclaredFields();
		StringBuffer sql = new StringBuffer();
		List<String> param = new ArrayList<String>();
		sql.append("INSERT INTO ").append(tableName).append("(");
		for (Field field : fields) {
			if (!Modifier.isStatic(field.getModifiers())) {
				Column column = field.getAnnotation(Column.class);
				sql.append(column.name()).append(",");
				field.setAccessible(true);
				try {
					Object object = field.get(entityObject);
					if (object != null) {
						param.add(object.toString());
					} else {
						param.add("");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		int length = sql.length();
		sql.delete(length - 1, length).append(")values(");
		int size = param.size();
		for (int index = 0; index < size; index++) {
			if (index != 0) {
				sql.append(",");
			}
			String paramDetail = param.get(index);
			if (paramDetail.length() > 0) {
				sql.append("'").append(paramDetail).append("'");
			} else {
				sql.append("''");
			}
		}
		sql.append(");");
		try {
			Connection connection = cm.getCon();
			connection.setAutoCommit(true);
			PreparedStatement statement = (PreparedStatement) connection
					.prepareStatement(sql.toString());
			statement.execute();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(Object entityObject) {
		Class<?> entity = entityObject.getClass();
		String tableName = getTableName(entity);
		Field[] fileds = entity.getDeclaredFields();
		boolean hasConstraints = false;
		StringBuffer sql = new StringBuffer();
		sql.append("DELETE FROM ");
		sql.append(tableName + " WHERE ");
		try {
			for (Field field : fileds) {
				Constraints annotation = field.getAnnotation(Constraints.class);
				if (annotation != null) {
					Column column = field.getAnnotation(Column.class);
					sql.append(column.name());
					sql.append(" = '");
					field.setAccessible(true);
					sql.append(field.get(entityObject) + "'");
					hasConstraints = true;
					break;
				}
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		if (!hasConstraints) {
			throw new NullPointerException();
		}
		sql.append(" ;");
		try {
			Connection connection = cm.getCon();
			connection.setAutoCommit(true);
			PreparedStatement statement = (PreparedStatement) connection
					.prepareStatement(sql.toString());
			statement.execute();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(Object entityObject) {
		Class<?> entity = entityObject.getClass();
		String tableName = getTableName(entity);
		Field[] fields = entity.getDeclaredFields();
		StringBuffer sql = new StringBuffer();
		String primarykey = null;
		String primarykeyValue = null;
		boolean isFirst =true;
		sql.append("UPDATE ").append(tableName).append(" SET ");
		for (Field field : fields) {
			if (!Modifier.isStatic(field.getModifiers())) {
				Constraints constraints = field
						.getAnnotation(Constraints.class);
				Column column = field.getAnnotation(Column.class);
				field.setAccessible(true);
				if (!constraints.primarykey()) {
					Object object = null;
					try {
						object = field.get(entityObject);
					} catch (Exception e) {
						e.printStackTrace();
					} 
					if (object != null) {
						if(!isFirst){
							sql.append(" , ");
						}
						sql.append(column.name()).append("=");
						sql.append("'").append(object.toString()).append("'");
						isFirst = false;
					} else {
						continue;
					}
				} else {
					primarykey = column.name();
					try {
						primarykeyValue = field.get(entityObject).toString();
					} catch (Exception e) {
						e.printStackTrace();
					} 
				}
			}
		}
		if (primarykey == null) {
			throw new RuntimeException("not found of " +entity+ "'s primarykey");
		}
		sql.append(" WHERE ").append(primarykey).append("='").append(primarykeyValue).append("';");
		try {
			Connection connection = cm.getCon();
			connection.setAutoCommit(true);
			PreparedStatement statement = (PreparedStatement) connection
					.prepareStatement(sql.toString());
			statement.execute();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ResultSet excute(String sql) {
		ResultSet result = null;
		try {
			Connection connection = cm.getCon();
			connection.setAutoCommit(true);
			PreparedStatement statement = (PreparedStatement) connection
					.prepareStatement(sql);
			result = statement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public String getTableName(Class<?> entity) {
		Table annotation = entity.getAnnotation(Table.class);
		return annotation.name();
	}
}
