package com.whizdm.payment_service.customexceptions;

public class InvalidDueAmount extends Exception{
    public InvalidDueAmount(String message){
        super(message);
    }
}
