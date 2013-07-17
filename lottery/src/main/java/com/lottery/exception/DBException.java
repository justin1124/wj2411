package com.lottery.exception;

public class DBException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DBException(Throwable t) {
		super(t);
	}
}
