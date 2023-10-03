package com.whizdm.payment_service.manager;

import com.whizdm.payment_service.customexceptions.InvalidDueAmount;
import com.whizdm.payment_service.entity.PaymentScheduleLos;
import com.whizdm.payment_service.entity.UserEmiDetails;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public interface ManagerInterface {

    public void disbursal(PaymentScheduleLos paymentScheduleLos);

    public int amountRoundOff(double amount);

    public void saveRepaymentSchedule(PaymentScheduleLos paymentScheduleLos);

    public boolean  dueAmountValidation(UserEmiDetails userEmiDetails) throws InvalidDueAmount;

    public void acceptPayment(UserEmiDetails userEmiDetails) throws InvalidDueAmount, IOException;

    public boolean check(String loanId);

    public String disbursePayment(int emi_amount, String payment_mode);

    String payment(UserEmiDetails emiDetails) throws IOException, InterruptedException;
}
