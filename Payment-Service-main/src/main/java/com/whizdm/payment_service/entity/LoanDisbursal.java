package com.whizdm.payment_service.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="loan_disbursal")
public class LoanDisbursal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "loan_application_id")
    private String loanApplicationId;

    @Column(name = "partner_id")
    private int partnerId;

    @Column(name = "bank_account_number")
    private String bankAccountNumber;

    @Column(name = "amount")
    private int amount;

    @Column(name = "disbursal_date")
    private Date disbursalDate;

    @Column(name = "disbursal_utr_id")
    private String disbursalUtrId;

    @Column(name = "date_created")
    private Date dateCreated;

    @Column(name = "date_modified")
    private Date dateModified;

    public LoanDisbursal(){

    }

    public LoanDisbursal(String loanApplicationId, int partnerId, String bankAccountNumber, int amount, Date disbursalDate, String disbursalUtrId, Date dateCreated, Date dateModified) {
        this.loanApplicationId = loanApplicationId;
        this.partnerId = partnerId;
        this.bankAccountNumber = bankAccountNumber;
        this.amount = amount;
        this.disbursalDate = disbursalDate;
        this.disbursalUtrId = disbursalUtrId;
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

    public int getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(int partnerId) {
        this.partnerId = partnerId;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getDisbursalDate() {
        return disbursalDate;
    }

    public void setDisbursalDate(Date disbursalDate) {
        this.disbursalDate = disbursalDate;
    }

    public String getDisbursalUtrId() {
        return disbursalUtrId;
    }

    public void setDisbursalUtrId(String disbursalUtrId) {
        this.disbursalUtrId = disbursalUtrId;
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
        return "LoanDisbursal{" +
                "id=" + id +
                ", loanApplicationId='" + loanApplicationId + '\'' +
                ", partnerId=" + partnerId +
                ", bankAccountNumber='" + bankAccountNumber + '\'' +
                ", amount=" + amount +
                ", disbursalDate=" + disbursalDate +
                ", disbursalUtrId='" + disbursalUtrId + '\'' +
                ", dateCreated=" + dateCreated +
                ", dateModified=" + dateModified +
                '}';
    }
}
