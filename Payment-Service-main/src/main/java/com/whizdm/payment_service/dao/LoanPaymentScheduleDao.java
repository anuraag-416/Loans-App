package com.whizdm.payment_service.dao;

import com.whizdm.payment_service.entity.LoanPaymentSchedule;

import java.util.List;

public interface LoanPaymentScheduleDao {

    public void saveInitialSchedule(List<LoanPaymentSchedule> loanPaymentSchedule);

    public void updateLoanPaymentSchedule(List<LoanPaymentSchedule> theLoanPaymentSchedule);

    public List<LoanPaymentSchedule> retrieveLoanPayment(String theLoanApplicationId);
}
