package me.shaobin.framework.mysql;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import me.shaobin.framework.annotation.Column;
import me.shaobin.framework.annotation.Constraints;
import me.shaobin.framework.annotation.Table;
import me.shaobin.framework.exception.ColumnHandlerException;
import me.shaobin.framework.exception.TableCheckException;

public class TableManager {

	/**
	 * 根据约束注解生成SQL约束语句
	 * 
	 * @param constraints
	 *            约束注解
	 * @return
	 */
	private static String getConstraints(Constraints constraints) {
		String constraintsResult = "";
		if (constraints.notnull()) {
			constraintsResult += " NOT NULL";
		}
		if (constraints.primarykey()) {
			constraintsResult += " PRIMARY KEY";
		}
		return constraintsResult;
	}

	/**
	 * 根据列名注解生成SQL语句
	 * 
	 * @param column
	 *            列名注解
	 * @param field
	 *            成员变量
	 * @return
	 */
	private static String getColumnDef(Column column, Field field) {
		String columnResult = "";
		columnResult = (column.name().length() < 1) ? field.getName()
				.toUpperCase() : column.name();
		columnResult += " "+column.type();
		return columnResult;
	}

	private static String generate(Class<?> reflectObject)
			throws ClassNotFoundException, TableCheckException,
			ColumnHandlerException {
		Table table = reflectObject.getAnnotation(Table.class);
		if (table == null) {
			throw new TableCheckException();
		}
		String tableName = (table.name().length() < 1) ? reflectObject
				.getName() : table.name();
		List<String> columnDefs = new ArrayList<String>();
		for (Field field : reflectObject.getDeclaredFields()) {
			Annotation[] annotations = field.getDeclaredAnnotations();
			String columnDefine = "";
			boolean hasConstraints = false;
			boolean hasSQLDefine = false;
			for (int i = 0; i < annotations.length; i++) {
				if (annotations[i] instanceof Column) {
					if (!hasSQLDefine) {
						Column column = (Column) annotations[i];
						if (!hasConstraints) {
							columnDefine += getColumnDef(column, field);
						} else {
							columnDefine = getColumnDef(column, field)
									+ columnDefine;
						}
						hasSQLDefine = true;
					} else {
						throw new ColumnHandlerException();
					}
				} else if (annotations[i] instanceof Constraints) {
					if (!hasConstraints) {
						Constraints constraints = (Constraints) annotations[i];
						columnDefine += getConstraints(constraints);
						hasConstraints = true;
					} else {
						throw new ColumnHandlerException();
					}
				}
			}
			columnDefs.add(columnDefine);
		}
		StringBuilder createCommand = new StringBuilder(
				"CREATE TABLE IF NOT EXISTS " + tableName + "(");
		for (String columnDef : columnDefs) {
			createCommand.append("\n    " + columnDef + ",");
		}
		String tableCreate = createCommand.substring(0,
				createCommand.length() - 1) + "\n);";
		return tableCreate;
	}
	
	public static void checkTable(ConnectionManager cm,Class<?> entity){
		Connection connection = cm.getCon();
		String sql = "";
		try {
			sql = generate(entity);
		} catch (TableCheckException | ColumnHandlerException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
			statement.executeUpdate(sql);
			statement.close();
			connection.close();
			System.out.println("Finish table check and create. ["+entity.getName()+"]");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
