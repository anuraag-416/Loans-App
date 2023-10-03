package com.whizdm.payment_service.dao;

import com.whizdm.payment_service.entity.LoanPayment;

public interface LoanPaymentDao {
    public void saveLoanPayment(LoanPayment loanPayment);
}
