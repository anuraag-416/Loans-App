package com.auth.Bodies;

import org.springframework.stereotype.Component;

@Component
public class ValidateTokenRequest {
	private String authToken;
	private String deviceId;
	public ValidateTokenRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ValidateTokenRequest(String authToken, String deviceId) {
		super();
		this.authToken = authToken;
		this.deviceId = deviceId;
	}

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
}
