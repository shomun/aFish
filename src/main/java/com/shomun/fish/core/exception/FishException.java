package com.shomun.fish.core.exception;

public class FishException extends Exception {

	public FishException(String message){
		super(message);
	}
	
	public FishException(Throwable cause){
		super(cause);
	}
	
	public FishException(String message,Throwable cause){
		super(message,cause);
	}
	
}
