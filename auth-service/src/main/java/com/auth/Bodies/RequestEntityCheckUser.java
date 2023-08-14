package com.auth.Bodies;

import org.springframework.stereotype.Component;

@Component
public class RequestEntityCheckUser 
{
	private String mobile;
	private String deviceModel;
	private String deviceId;
	
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getDeviceModel() {
		return deviceModel;
	}
	public void setDeviceModel(String deviceModel) {
		this.deviceModel = deviceModel;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	
	
	  
	

}
