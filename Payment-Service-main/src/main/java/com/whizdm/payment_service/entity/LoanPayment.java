package com.whizdm.payment_service.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "loan_payment")
public class LoanPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "loan_application_id")
    private String loanApplicationId;

    @Column(name = "paid_amount")
    private int paidAmount;

    @Column(name = "payment_utr_id")
    private String paymentUtrId;

    @Column(name = "payment_mode")
    private String paymentMode;

    @Column(name = "payment_date")
    private Date paymentDate;

    @Column(name = "payment_status")
    private String paymentStatus;

    @Column(name = "failure_reason")
    private String failureReason;

    @Column(name = "date_created")
    private Date dateCreated;

    @Column(name = "date_modified")
    private Date dateModified;


    public LoanPayment(){

    }

    public LoanPayment(String loanApplicationId, int paidAmount, String paymentUtrId, String paymentMode, Date paymentDate, String paymentStatus, String failureReason, Date dateCreated, Date dateModified) {
        this.loanApplicationId = loanApplicationId;
        this.paidAmount = paidAmount;
        this.paymentUtrId = paymentUtrId;
        this.paymentMode = paymentMode;
        this.paymentDate = paymentDate;
        this.paymentStatus = paymentStatus;
        this.failureReason = failureReason;
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

    public int getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(int paidAmount) {
        this.paidAmount = paidAmount;
    }

    public String getPaymentUtrId() {
        return paymentUtrId;
    }

    public void setPaymentUtrId(String paymentUtrId) {
        this.paymentUtrId = paymentUtrId;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
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
        return "LoanPayment{" +
                "id=" + id +
                ", loanApplicationId='" + loanApplicationId + '\'' +
                ", paidAmount=" + paidAmount +
                ", paymentUtrId='" + paymentUtrId + '\'' +
                ", paymentMode='" + paymentMode + '\'' +
                ", paymentDate=" + paymentDate +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", failureReason='" + failureReason + '\'' +
                ", dateCreated=" + dateCreated +
                ", dateModified=" + dateModified +
                '}';
    }
}
