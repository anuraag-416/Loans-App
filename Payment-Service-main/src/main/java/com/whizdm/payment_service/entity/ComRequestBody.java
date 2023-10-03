package com.whizdm.payment_service.entity;

import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class ComRequestBody {
    private String requestType;
    private HashMap<String,String> details;

    public ComRequestBody() {

    }

    public String getRequestType() {
        return requestType;
    }

    public HashMap<String, String> getDetails() {
        return details;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public void setDetails(HashMap<String, String> details) {
        this.details = details;
    }


}
