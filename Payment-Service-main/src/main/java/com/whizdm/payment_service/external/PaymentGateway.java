package com.whizdm.payment_service.external;

public class PaymentGateway {

    public boolean makePayment(int amount,String method){
        System.out.println("Connected to MoneyView Gateway");
        System.out.println("Amount "+ amount +" paid through "+method+" successfully");
        return true;
    }
    public boolean disburseLoan(double amount){
        System.out.println("Connected to MoneyView Gateway");
        System.out.println("Amount "+ amount +" disbursed successfully");
        return true;
    }

}
