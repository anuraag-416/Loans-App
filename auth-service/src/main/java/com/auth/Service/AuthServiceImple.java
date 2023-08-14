package com.auth.Service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.auth.exception.EmptyInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth.Doa.AuthUserRepositoryDoa;
import com.auth.Entity.UserAuth;

@Service
public class AuthServiceImple implements AuthService{
	@Autowired
    AuthUserRepositoryDoa userRepo;
	@Autowired
	UserAuth user;

	@Override
	public int generateOTP() {
		// TODO Auto-generated method stub
		String numbers = "1234567890";
	      Random random = new Random();
	      char[] otp = new char[6];

	      for(int i = 0; i< 6 ; i++) {
	         otp[i] = numbers.charAt(random.nextInt(numbers.length()));
	      }
	      return Integer.parseInt(String.valueOf(otp));
	}

	@Override
	public boolean verifyOtp(int generatedOtp, int UserGivenOtp) {
		// TODO Auto-generated method stub
		return generatedOtp==UserGivenOtp;
	}

	@Override
	public String generateAuthToken() {
		// TODO Auto-generated method stub
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}

	@Override
	public int checkUserExists(String UserDeviceDetails) {
		// TODO Auto-generated method stub
		return userRepo.existsByUserDeviceDetails(UserDeviceDetails);	
    }

	@Override
	public int verifyTokenExpiry(String UserDeviceDetails) {
		// TODO Auto-generated method stub
		return userRepo.verifyAuthTokenExpiry(UserDeviceDetails);
	}

	@Override
	public int validateToken(String AuthToken, String deviceId) {
		// TODO Auto-generated method stub
		return userRepo.validateAuthTokenExpiry(AuthToken, deviceId);
	}

	@Override
	public String saveUser(String UserDeviceDetails, long UserId, String AuthToken,String deviceId) {
		// TODO Auto-generated method stub
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
	    calendar.add(Calendar.HOUR, 2);
	    user.setUserDeviceDetails(UserDeviceDetails);
	    user.setUserId(UserId);
	    user.setAuthToken(AuthToken);
	    user.setExpiryTime(new Timestamp(calendar.getTimeInMillis()));
		user.setDeviceId(deviceId);
	    userRepo.save(user);
	    return user.getAuthToken();
	}

	@Override
	public int generateDeviceID() {
		// TODO Auto-generated method stub
		int min=1;
		int max=3;
		return ThreadLocalRandom.current().nextInt(min, max) + min;
	}

	@Override
	public String getValidAuthToken(String UserDeviceDetails) {
		// TODO Auto-generated method stub
		return userRepo.getValidAuthToken(UserDeviceDetails);
	}

	@Override
	public Timestamp getCurrentTime() {
		// TODO Auto-generated method stub
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		return new Timestamp(calendar.getTimeInMillis());
	}

	@Override
	public Timestamp getOtpExpiryTime() {
		// TODO Auto-generated method stub
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.MINUTE, 10);
		return new Timestamp(calendar.getTimeInMillis());
	}

	@Override
	public int checkOtpExpiry(Timestamp OtpExpiry) {
		// TODO Auto-generated method stub
		return userRepo.CheckOtpExpiry(OtpExpiry);
	}

	@Override
	public int getByUserId(String userDeviceDetails) {
		// TODO Auto-generated method stub
		return userRepo.getUserId(userDeviceDetails);
	}

	@Override
	public boolean ChecknumberValidity(String number,String device_model,String device_id)
	{
		if(number.length()==0||device_id.length()==0||device_model.length()==0)
		{
			throw  new EmptyInputException("400","please Dont leave any input fields empty");
		}
		// TODO Auto-generated method stub
		Pattern p = Pattern.compile("[6-9][0-9]{9}");
		  
	    Matcher m = p.matcher(number);
	    return (m.find() && m.group().equals(number));	
	    }



}
