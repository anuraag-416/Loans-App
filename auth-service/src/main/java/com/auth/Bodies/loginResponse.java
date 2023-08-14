package com.auth.Bodies;

import org.springframework.stereotype.Component;

@Component
public class loginResponse {
    private String authToken;
    private String deviceId;

    public loginResponse() {
        super();
    }

    public loginResponse(String authToken, String deviceId) {
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
