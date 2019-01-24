package com.pinyougou.common;

import java.io.Serializable;

public class Result implements Serializable{

	private static final long serialVersionUID = 6703961231970170457L;

	private boolean success;
	
	private String message;
	

	public Result(boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
	}

	public Result() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
