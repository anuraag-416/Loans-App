package com.auth.Bodies;

import java.util.HashMap;

import org.springframework.stereotype.Component;

@Component
public class ComRequestBody {

	private String requestType;
	private HashMap<String,String> details;
	public String getRequestType() {
		return requestType;
	}
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}
	public HashMap<String, String> getDetails() {
		return details;
	}
	public void setDetails(HashMap<String, String> details) {
		this.details = details;
	}
//	public void setDetails(Object o) {
//		this.details = (HashMap<String,String>)details;
//	}
	public ComRequestBody() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ComRequestBody(String requestType, HashMap<String, String> details) {
		super();
		this.requestType = requestType;
		this.details = details;
	}
	@Override
	public String toString() {
		return "ComRequestBody [requestType=" + requestType + ", details=" + details + "]";
	}
	
	
	
}
