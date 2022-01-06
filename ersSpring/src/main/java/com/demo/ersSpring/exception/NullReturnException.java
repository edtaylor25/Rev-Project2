package com.demo.ersSpring.exception;

public class NullReturnException extends Exception {

	String msg;
	
	public NullReturnException(String msg) {
		this.msg=msg;
	}
	
	@Override
	public String getMessage() {
		return this.msg;
	}
	
}
