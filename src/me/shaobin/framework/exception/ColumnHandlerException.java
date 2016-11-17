package me.shaobin.framework.exception;

public class ColumnHandlerException extends Throwable {

	private static final long serialVersionUID = 1660217355449345914L;

	public ColumnHandlerException() {
		super("Cannot find the information of the table entity");
	}

}
