package com.auth.Entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class UserAuth {
	@Id
    private String UserDeviceDetails;
	private long UserId;
	private String AuthToken;
	private Timestamp ExpiryTime;
	private String deviceId;

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public UserAuth() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserAuth(String userDeviceDetails, int userId, String authToken, Timestamp expiryTime) {
		super();
		UserDeviceDetails = userDeviceDetails;
		UserId = userId;
		AuthToken = authToken;
		ExpiryTime = expiryTime;
	}

	public long getUserId() {
		return UserId;
	}
	public void setUserId(long userId) {
		UserId = userId;
	}
	public String getUserDeviceDetails() {
		return UserDeviceDetails;
	}
	public void setUserDeviceDetails(String userDeviceDetails) {
		UserDeviceDetails = userDeviceDetails;
	}
	public String getAuthToken() {
		return AuthToken;
	}
	public void setAuthToken(String authToken) {
		AuthToken = authToken;
	}
	public Timestamp getExpiryTime() {
		return ExpiryTime;
	}
	public void setExpiryTime(Timestamp expiryTime) {
		ExpiryTime = expiryTime;
	}

	@Override
	public String toString() {
		return "UserAuth{" +
				"UserDeviceDetails='" + UserDeviceDetails + '\'' +
				", UserId=" + UserId +
				", AuthToken='" + AuthToken + '\'' +
				", ExpiryTime=" + ExpiryTime +
				", deviceId='" + deviceId + '\'' +
				'}';
	}
}
