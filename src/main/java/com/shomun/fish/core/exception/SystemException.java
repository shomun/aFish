package com.shomun.fish.core.exception;

public class SystemException extends FishException {

	public SystemException(String message) {
		super(message);
		
	}
	
	public SystemException( Throwable cause) {
		super(cause);
	}
	public SystemException(String message, Throwable cause) {
		super(message,cause);
	}

}
