package com.upog.tennis.exception;

import java.util.Date;

import com.upog.tennis.util.Constant;

public class ResponeException extends Exception {
	
	private Date timestamp;
	private String message;
	private String details;
	
	public ResponeException( String message) {
		super();
		this.timestamp = new Date();
		this.message = message;
		this.details = Constant.N_A;
	}
	
	public ResponeException( Exception e) {
		super();
	
		this.timestamp = new Date();
		
		this.message = 	e.getMessage()==null ? ((e.getLocalizedMessage()==null) ? Constant.ERR_DATA_NOT_AVAILABLE: e.getLocalizedMessage()) : e.getMessage(); 
		this.details = Constant.N_A; 
		
	} 
	
	
	public ResponeException(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}
	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}


}
