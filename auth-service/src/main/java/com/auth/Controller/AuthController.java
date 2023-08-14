package com.auth.Controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Optional;

import com.auth.Bodies.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.auth.Service.AuthService;


@RestController
public class AuthController {
	private String userMobileNumber;
	private String userDeviceID;
	private String userDeviceModel;
	private long user_Id;
	
	@Autowired 
	AuthService authService;

	@Autowired
	loginResponse login_Response;
	
	@Autowired
	OtpController otp;
	
	@Autowired
	ComRequestBody requestBody;

	@Autowired
	RequestEntityCheckUser identityRequest;

	RestTemplate restTemplate=new RestTemplate();

	// Login Endpoint
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UserLoginDetailInput userInput) throws IOException
	{
		// HttpMessageNotReadableException
		if(!this.authService.ChecknumberValidity(userInput.getUser_name(),userInput.getDevice_id(),userInput.getDevice_model())){
			return ResponseEntity.of(Optional.of("Invalid Username. Please enter valid phone number !!"));

		}
		userMobileNumber=userInput.getUser_name();
		userDeviceModel = userInput.getDevice_model();
		userDeviceID = userInput.getDevice_id();
		if(this.authService.checkUserExists(userMobileNumber+"-"+userDeviceModel+"-"+userDeviceID)==1) {
			
			if(this.authService.verifyTokenExpiry(userMobileNumber+"-"+userDeviceModel+"-"+userDeviceID)==1) {
				// return here AuthToken
				login_Response.setAuthToken(this.authService.getValidAuthToken(userMobileNumber+"-"+userDeviceModel+"-"+userDeviceID));
				login_Response.setDeviceId(userDeviceID);
				return ResponseEntity.of(Optional.of(login_Response));
			}
			user_Id=this.authService.getByUserId(userMobileNumber+"-"+userDeviceModel+"-"+userDeviceID);
			int generatedOtp = this.authService.generateOTP();			
			requestBody.setRequestType("LOTP");
			HashMap<String,String> temp=new HashMap<String,String>();
			temp.put("mobileNumber",userMobileNumber);
			temp.put("otp",String.valueOf(generatedOtp));
			requestBody.setDetails(temp);

				final String otpurl="http://172.31.15.239:8080/sendSMS";
				RestTemplate restTemplate=new RestTemplate();
				ComResponseBody isResponse=restTemplate.postForObject(otpurl,requestBody,ComResponseBody.class);

			//System.out.println(isResponse.isStatus());
			
			if(isResponse.isStatus()) {
				Timestamp otpexpiry = this.authService.getOtpExpiryTime();
				System.out.println(generatedOtp+" is sent to "+userMobileNumber+"and otp expires at "+this.authService.getOtpExpiryTime());
				
				System.out.println(this.authService.checkOtpExpiry(otpexpiry));
				while(this.authService.checkOtpExpiry(otpexpiry)==1) {
					if(this.otp.getUserOtp()!=0) {
						System.out.println("User Entered OTP");
						if(this.authService.verifyOtp(generatedOtp, this.otp.getUserOtp())) {
							System.out.println("login success");
							this.otp.setUserOtp(0);
							login_Response.setAuthToken(this.authService.saveUser(userMobileNumber+"-"+userDeviceModel+"-"+userDeviceID,user_Id,this.authService.generateAuthToken(),userDeviceID));
							login_Response.setDeviceId(userDeviceID);
							return ResponseEntity.of(Optional.of(login_Response));
						}
						return ResponseEntity.status(HttpStatus.NON_AUTHORITATIVE_INFORMATION).build();
					}
				}
				System.out.println("OTP Expired. So, please login again :)");
			}
			return ResponseEntity.status(HttpStatus.NON_AUTHORITATIVE_INFORMATION).build();
			
		}
		// call identity service to check its New user or New Device
		identityRequest.setMobile(userMobileNumber);
		identityRequest.setDeviceModel(userDeviceModel);
		identityRequest.setDeviceId(String.valueOf(userDeviceID));
		System.out.println("Hello this is IS");
		try {
			String isUrl="http://192.168.171.210:8080/api/user/checkUserExists";
			ApiResponseCheckUser identityResponse= restTemplate.postForObject(isUrl, identityRequest, ApiResponseCheckUser.class);
			System.out.println(identityResponse.getMessage());
			user_Id=identityResponse.getUserId();
			System.out.println(user_Id);
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.of(Optional.of("Invalid Authentivation"));
		}
		if(user_Id<0) {
			return ResponseEntity.of(Optional.of("Go to Signup"));
		}

		int generatedOtp = this.authService.generateOTP();
		requestBody.setRequestType("LOTP");
		HashMap<String,String> temp=new HashMap<String,String>();
		temp.put("mobileNumber",userMobileNumber);
		temp.put("otp",String.valueOf(generatedOtp));
		requestBody.setDetails(temp);		//call comm API
		final String otpurl="http://172.31.15.239:8080/sendSMS";
		RestTemplate restTemplate=new RestTemplate();
		ComResponseBody isResponse=restTemplate.postForObject(otpurl,requestBody,ComResponseBody.class);
		System.out.println(isResponse.isStatus()+"otp sent by communication Api");
		
		if(isResponse.isStatus()) {
		    Timestamp otpexpiry = this.authService.getOtpExpiryTime();
			System.out.println(generatedOtp+" is sent to "+userMobileNumber+" and otp expires at "+this.authService.getOtpExpiryTime());
			
			System.out.println(this.authService.checkOtpExpiry(otpexpiry));
			while(this.authService.checkOtpExpiry(otpexpiry)==1) {
				if(this.otp.getUserOtp()!=0) {
					System.out.println("User Entered OTP");
					if(this.authService.verifyOtp(generatedOtp, this.otp.getUserOtp())) {
						this.otp.setUserOtp(0);
						System.out.println("login success");
						login_Response.setAuthToken(this.authService.saveUser(userMobileNumber+"-"+userDeviceModel+"-"+userDeviceID,user_Id,this.authService.generateAuthToken(),userDeviceID));
						login_Response.setDeviceId(userDeviceID);
						return ResponseEntity.of(Optional.of(login_Response));

					}
					System.out.println("OTP incorrect");
					return ResponseEntity.status(HttpStatus.NON_AUTHORITATIVE_INFORMATION).build();
				}
			}
			System.out.println("OTP Expired. So, please login again :)");
			
		}
		return ResponseEntity.status(HttpStatus.NON_AUTHORITATIVE_INFORMATION).build();

	}

	//API will be called by LOS and PS
	@RequestMapping(value="/validateToken", method=RequestMethod.POST)
	public HashMap<String,Integer> validateToken(@RequestBody HashMap<String,String> validateTokenRequest) {
		System.out.println("hello, u called me!!");
		HashMap<String,Integer> h = new HashMap<>();
		try{
			if(authService.validateToken(validateTokenRequest.get("auth_token"),validateTokenRequest.get("user_id"))==1) // if token is
			{
				h.put("Status",HttpStatus.OK.value());
				return h;
			}
		}catch (Exception e){
			System.out.println("its invalid token !!");

		}
		h.put("Status",HttpStatus.UNAUTHORIZED.value());
		return h;
	}
}
