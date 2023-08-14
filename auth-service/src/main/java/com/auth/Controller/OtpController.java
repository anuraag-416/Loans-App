package com.auth.Controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Component
@RestController
public class OtpController {
	private int userOtp;
	
	public int getUserOtp() {
		return userOtp;
	}

	public void setUserOtp(int userOtp) {
		this.userOtp = userOtp;
	}

	@PostMapping("/EnterOtp")
	public String Enterotp(@RequestBody int otp) throws IOException { //HttpMessageNotReadableException
		this.setUserOtp(otp);
		return otp+"Entered otp";
	}

	public OtpController(int userOtp) {
		super();
		this.userOtp = userOtp;
	}

	public OtpController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
