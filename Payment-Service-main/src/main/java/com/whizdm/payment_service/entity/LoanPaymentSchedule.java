package com.whizdm.payment_service.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "loan_payment_schedule")
public class LoanPaymentSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id ;

    @Column(name = "loan_application_id")
    private String loanApplicationId ;

    @Column(name = "payment_utr_id")
    private String paymentUtrId;

    @Column(name = "emi")
    private int emi ;

    @Column(name = "due_date")
    private Date dueDate ;

    @Column(name = "payment_status")
    private String status;

    @Column(name = "due_amount")
    private int dueAmount ;

    @Column(name = "principle_amount")
    private float principleAmount ;

    @Column(name = "interest_amount")
    private float interestAmount ;

    @Column(name = "date_created")
    private Date dateCreated;

    @Column(name = "date_modified")
    private Date dateModified;

    public LoanPaymentSchedule(){

    }

    public LoanPaymentSchedule(String loanApplicationId, int emi, Date dueDate, int dueAmount, float principleAmount, float interestAmount, Date dateCreated, Date dateModified) {
        this.loanApplicationId = loanApplicationId;
        this.emi = emi;
        this.dueDate = dueDate;
        this.dueAmount = dueAmount;
        this.principleAmount = principleAmount;
        this.interestAmount = interestAmount;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoanApplicationId() {
        return loanApplicationId;
    }

    public void setLoanApplicationId(String loanApplicationId) {
        this.loanApplicationId = loanApplicationId;
    }

    public String getPaymentUtrId() {
        return paymentUtrId;
    }

    public void setPaymentUtrId(String paymentUtrId) {
        this.paymentUtrId = paymentUtrId;
    }

    public int getEmi() {
        return emi;
    }

    public void setEmi(int emi) {
        this.emi = emi;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getDueAmount() {
        return dueAmount;
    }

    public void setDueAmount(int dueAmount) {
        this.dueAmount = dueAmount;
    }

    public float getPrincipleAmount() {
        return principleAmount;
    }

    public void setPrincipleAmount(float principleAmount) {
        this.principleAmount = principleAmount;
    }

    public float getInterestAmount() {
        return interestAmount;
    }

    public void setInterestAmount(float interestAmount) {
        this.interestAmount = interestAmount;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    @Override
    public String toString() {
        return "LoanPaymentSchedule{" +
                "id=" + id +
                ", loanApplicationId='" + loanApplicationId + '\'' +
                ", paymentUtrId='" + paymentUtrId + '\'' +
                ", emi=" + emi +
                ", dueDate=" + dueDate +
                ", status='" + status + '\'' +
                ", dueAmount=" + dueAmount +
                ", principleAmount=" + principleAmount +
                ", interestAmount=" + interestAmount +
                ", dateCreated=" + dateCreated +
                ", dateModified=" + dateModified +
                '}';
    }
}
