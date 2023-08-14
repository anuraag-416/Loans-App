package com.auth.Bodies;




public class ApiResponseCheckUser {
	
	private long userId; // make long 
	private int status;
	private String message;
	public long getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public ApiResponseCheckUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ApiResponseCheckUser(int userId, int status, String message) {
		super();
		this.userId = userId;
		this.status = status;
		this.message = message;
	}
	
	
	
}
