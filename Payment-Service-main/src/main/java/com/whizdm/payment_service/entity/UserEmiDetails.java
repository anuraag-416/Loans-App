package com.whizdm.payment_service.entity;

public class UserEmiDetails {
    private String user_id;
    private String auth_token;
    private String loan_id;
    private int emi_amount;
    private String payment_mode;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getAuth_token() {
        return auth_token;
    }

    public void setAuth_token(String auth_token) {
        this.auth_token = auth_token;
    }

    public String getLoan_id() {
        return loan_id;
    }

    public void setLoan_id(String loan_id) {
        this.loan_id = loan_id;
    }

    public int getEmi_amount() {
        return emi_amount;
    }

    public void setEmi_amount(int emi_amount) {
        this.emi_amount = emi_amount;
    }

    public String getPayment_mode() {
        return payment_mode;
    }

    public void setPayment_mode(String payment_mode) {
        this.payment_mode = payment_mode;
    }

    @Override
    public String toString() {
        return "UserEmiDetails{" +
                "user_id=" + user_id +
                ", auth_token='" + auth_token + '\'' +
                ", loan_id='" + loan_id + '\'' +
                ", emi_amount=" + emi_amount +
                ", payment_mode='" + payment_mode + '\'' +
                '}';
    }
}
