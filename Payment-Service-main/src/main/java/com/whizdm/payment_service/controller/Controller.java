package com.whizdm.payment_service.controller;

import com.whizdm.payment_service.customexceptions.InvalidDueAmount;
import com.whizdm.payment_service.entity.PaymentScheduleLos;
import com.whizdm.payment_service.entity.UserEmiDetails;
import com.whizdm.payment_service.manager.Manager;
import com.whizdm.payment_service.utils.APICaller.APICaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;


@RestController
@RequestMapping("/payments/api")
public class Controller implements ControllerService {


    private Manager manager;
    private APICaller caller;

    @Autowired
    public Controller(Manager theManager){
        this.manager = theManager;
        this.caller = APICaller.getInstance();
    }

    @PostMapping("/loanDisbursal")
    public ResponseEntity<String> loanSaveSchedule(@RequestBody PaymentScheduleLos paymentSchedule) {


        //Save Repayment Schedule
        try {
            manager.saveRepaymentSchedule(paymentSchedule);
            System.out.println("Payment Schedule Saved");

        }catch (Exception e){
            System.out.println("Saving Failed");
            return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
        }



        //Disburse Loan
        try {
            manager.disbursal(paymentSchedule);
        }catch (Exception e){
            System.out.println("Loan Disbursal Failed");
            return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        System.out.println("Loan Disbursed");



        //Communication service API call to notify user
        try{
            caller.postAPICallComm("http://3.110.107.24:8080/sendSMS","SD",paymentSchedule.getUser_id(),paymentSchedule.getLoan_id(),paymentSchedule.getBank_account_no(),Double.toString(paymentSchedule.getDisbursal_amount()),"Loan Amount has been disbursed");
            caller.postAPICallComm("http://3.110.107.24:8080/sendEmail","SD",paymentSchedule.getUser_id(),paymentSchedule.getLoan_id(),paymentSchedule.getBank_account_no(),Double.toString(paymentSchedule.getDisbursal_amount()),"Loan Amount has been disbursed");//Communication Service API EndPoint
        }catch(Exception e){
            System.out.println("Communication API for Loan Disbursal Failed");
//            return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
        }


        return new ResponseEntity<String>("Loan Disbursal Process Completed Successfully",HttpStatus.OK);
    }





    @PostMapping(path = "/emiPayment", consumes = "application/json")
    public ResponseEntity<String> loanPayEmi(@RequestBody UserEmiDetails emiDetails) throws IOException, InterruptedException {
        //AuthToken Validation API Call
        int result;
        try{
            var valid = caller.postAPICallAuth("http://13.233.162.61:8080/validateToken","1st","90329838-0832-4686-9d7e-948e7bffee8a"); //Auth Service API EndPoint
            result = (int)valid.get("Status");
            System.out.println(result);
        }catch(Exception e){
            System.out.println("Auth service API call failed");
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if(result!=200){
            System.out.println("Authentication Failed");
            return new ResponseEntity<String>("Authentication Failed",HttpStatus.FORBIDDEN);
        }

        System.out.println("Authentication Successs");


        //LOS API call to check if loan is open
        //LOS API call to check if loan is open
        int losRes;
        try{
            HashMap losResult = caller.postAPICallLos("http://172.31.33.155:8080/checkLoanStatus",emiDetails.getLoan_id(),"LoanVerification");
            System.out.println(losResult);
            losRes = (int) losResult.get("httpStatusCode");
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("LOS Service API Call failed for validation");
            return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if(losRes!=200){
           var ressms=  caller.postAPICallComm("http://3.110.107.24:8080/sendSMS","MEMIF",emiDetails.getUser_id(),emiDetails.getLoan_id(),"",null,"Loan Application Is Already Closed");
            var resemail=  caller.postAPICallComm("http://3.110.107.24:8080/sendEMAIL","MEMIF",emiDetails.getUser_id(),emiDetails.getLoan_id(),"",null,"Loan Application Is Already Closed");

            System.out.println("Loan Application Closed");
            System.out.println(ressms);
            return new ResponseEntity<String>("Loan Application Closed",HttpStatus.NOT_ACCEPTABLE);
        }

//        Accept payment if amount is valid


        try{
            manager.acceptPayment(emiDetails);
        }catch (InvalidDueAmount e1) {
            System.out.println("Payment Acceptance Failed");
            caller.postAPICallComm("http://3.110.107.24:8080/sendSMS","MEMIS",emiDetails.getUser_id(),emiDetails.getLoan_id(),"",Integer.toString(emiDetails.getEmi_amount()),"Invalid Amount Entered");
            caller.postAPICallComm("http://3.110.107.24:8080/sendEmail","MEMIS",emiDetails.getUser_id(),emiDetails.getLoan_id(),"",Integer.toString(emiDetails.getEmi_amount()),"Invalid Amount Entered");
            return new ResponseEntity<String>(e1.getMessage(), HttpStatus.BAD_REQUEST);
        }catch (IOException e2){
            System.out.println("IOException Encountered");
            return new ResponseEntity<String>("Server error (IOException)", HttpStatus.INTERNAL_SERVER_ERROR);
        }





//        Communication service API call to notify user
        try{
            caller.postAPICallComm("http://3.110.107.24:8080/sendSMS","MEMIS",emiDetails.getUser_id(),emiDetails.getLoan_id(),"",Integer.toString(emiDetails.getEmi_amount()),"EMI Payment Processed Successfully");//Communication Service API EndPoint
            caller.postAPICallComm("http://3.110.107.24:8080/sendEmail","MEMIS",emiDetails.getUser_id(),emiDetails.getLoan_id(),"",Integer.toString(emiDetails.getEmi_amount()),"EMI Payment Processed Successfully");
        }catch(Exception e){
            System.out.println("Communication service API call for EMI Payment failed");
//            return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        //LOS API call to close loan application if 12th months emi paid
//
        if(manager.check(emiDetails.getLoan_id())){
            caller.postAPICallLos("http://172.31.33.155:8080/closeLoanApplication",emiDetails.getLoan_id(),"CloseApplication");
        }
//
        System.out.println("EMI Payment Successful");
        return new ResponseEntity<String>("EMI Payment Successfully Completed",HttpStatus.OK);
 }

    //Payment Receiving
    @GetMapping("/receivePayment")
    public void sendPayment() {
        System.out.println("Inside receive payment");

    }
}

