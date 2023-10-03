package com.whizdm.payment_service.controller;


import com.whizdm.payment_service.entity.PaymentScheduleLos;
import com.whizdm.payment_service.entity.UserEmiDetails;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public interface ControllerService {
    public ResponseEntity<String> loanSaveSchedule (PaymentScheduleLos paymentSchedule);
    public ResponseEntity<String> loanPayEmi (UserEmiDetails details) throws IOException, InterruptedException;
}
