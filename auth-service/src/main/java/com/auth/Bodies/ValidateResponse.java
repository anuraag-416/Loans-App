package com.auth.Bodies;

public class ValidateResponse {
    private boolean isvalid;
    private int status;

    public ValidateResponse() {
        super();
    }

    public ValidateResponse(boolean isvalid, int status) {
        this.isvalid = isvalid;
        this.status = status;
    }

    public boolean isIsvalid() {
        return isvalid;
    }

    public void setIsvalid(boolean isvalid) {
        this.isvalid = isvalid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
