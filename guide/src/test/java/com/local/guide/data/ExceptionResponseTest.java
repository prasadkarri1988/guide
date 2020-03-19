package com.local.guide.data;

import java.util.Date;

public class ExceptionResponseTest {
	private Date timestamp;
	private String details;
	private String message;
	private int status;
	
	public ExceptionResponseTest(Date timestamp, String details, String message, int status) {
		super();
		this.timestamp = timestamp;
		this.details = details;
		this.message = message;
		this.status = status;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
	
	
}
