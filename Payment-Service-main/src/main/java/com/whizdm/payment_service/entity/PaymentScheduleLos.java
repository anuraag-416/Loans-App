package com.whizdm.payment_service.entity;

import java.util.Date;

public class PaymentScheduleLos {
    private String loan_id;
    private String user_id;
    private double disbursal_amount;
    private double first_emi;
    private double last_emi;
    private double principal_amount;
    private float interest_component;
    private Date due_date;
    private int partner_id;
    private String bank_account_no;

    public PaymentScheduleLos(String loan_id, String user_id, double disbursal_amount, double first_emi, double last_emi, double principal_amount, float interest_component, Date due_date, int partner_id, String bank_account_no) {
        this.loan_id = loan_id;
        this.user_id = user_id;
        this.disbursal_amount = disbursal_amount;
        this.first_emi = first_emi;
        this.last_emi = last_emi;
        this.principal_amount = principal_amount;
        this.interest_component = interest_component;
        this.due_date = due_date;
        this.partner_id = partner_id;
        this.bank_account_no = bank_account_no;
    }

    public String getLoan_id() {
        return loan_id;
    }

    public void setLoan_id(String loan_id) {
        this.loan_id = loan_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public double getDisbursal_amount() {
        return disbursal_amount;
    }

    public void setDisbursal_amount(double disbursal_amount) {
        this.disbursal_amount = disbursal_amount;
    }

    public double getFirst_emi() {
        return first_emi;
    }

    public void setFirst_emi(double first_emi) {
        this.first_emi = first_emi;
    }

    public double getLast_emi() {
        return last_emi;
    }

    public void setLast_emi(double last_emi) {
        this.last_emi = last_emi;
    }

    public double getPrincipal_amount() {
        return principal_amount;
    }

    public void setPrincipal_amount(double principal_amount) {
        this.principal_amount = principal_amount;
    }

    public float getInterest_component() {
        return interest_component;
    }

    public void setInterest_component(float interest_component) {
        this.interest_component = interest_component;
    }

    public Date getDue_date() {
        return due_date;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }

    public int getPartner_id() {
        return partner_id;
    }

    public void setPartner_id(int partner_id) {
        this.partner_id = partner_id;
    }

    public String getBank_account_no() {
        return bank_account_no;
    }

    public void setBank_account_no(String bank_account_no) {
        this.bank_account_no = bank_account_no;
    }

    @Override
    public String toString() {
        return "PaymentScheduleLos{" +
                "loan_id='" + loan_id + '\'' +
                ", user_id=" + user_id +
                ", disbursal_amount=" + disbursal_amount +
                ", first_emi=" + first_emi +
                ", last_emi=" + last_emi +
                ", principal_amount=" + principal_amount +
                ", interest_component=" + interest_component +
                ", due_date=" + due_date +
                ", partner_id=" + partner_id +
                ", bank_account_no=" + bank_account_no +
                '}';
    }
}
