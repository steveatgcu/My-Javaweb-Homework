package me.shaobin.framework.exception;

public class TableCheckException extends Throwable {

	private static final long serialVersionUID = 1660217355449345914L;

	public TableCheckException() {
		super("Failed to handle the annotation of your fields.");
	}

}
