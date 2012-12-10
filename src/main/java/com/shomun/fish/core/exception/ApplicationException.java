package com.shomun.fish.core.exception;

public class ApplicationException extends FishException {

	public ApplicationException(String message) {
		super(message);
		
	}
	
	public ApplicationException( Throwable cause) {
		super(cause);
	}
	public ApplicationException(String message, Throwable cause) {
		super(message,cause);
	}

}
