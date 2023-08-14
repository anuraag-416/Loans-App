package com.auth.Bodies;

public class UserLoginDetailInput {
    private String user_name;
    private String device_model;
    private String device_id;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getDevice_model() {
        return device_model;
    }

    public void setDevice_model(String device_model) {
        this.device_model = device_model;
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public UserLoginDetailInput(String user_name, String device_model, String device_id) {
        this.user_name = user_name;
        this.device_model = device_model;
        this.device_id = device_id;
    }

    public UserLoginDetailInput() {
        super();
    }
}
