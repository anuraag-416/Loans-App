package com.auth.Service;

import java.sql.Timestamp;

public interface AuthService {
	
	public static String genrateDeviceModel = "OppO";
	
    public int generateOTP();
    
    public boolean verifyOtp(int generatedOtp, int UserGivenOtp);
	
	public String generateAuthToken();
	
	public int checkUserExists(String UserDeviceDetails);
	
	public int verifyTokenExpiry(String UserDeviceDetails);
	
	public int validateToken(String AuthToken,String deviceId);
	
	public String saveUser(String UserDeviceDetails,long UserId,String AuthToken,String deviceId);
	
	public int generateDeviceID();
	
	public String getValidAuthToken(String UserDeviceDetails);
	
	public Timestamp getCurrentTime();
	
	public Timestamp getOtpExpiryTime();
	
	public int checkOtpExpiry(Timestamp OtpExpiry);
	
	public int getByUserId(String userDeviceDetails);
	
	public boolean ChecknumberValidity(String number,String device_model,String device_id);
}
