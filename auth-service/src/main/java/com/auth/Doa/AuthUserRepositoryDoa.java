package com.auth.Doa;

import java.sql.Timestamp;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.auth.Entity.UserAuth;

@Component
public interface AuthUserRepositoryDoa extends CrudRepository<UserAuth,String>{
	
	@Query(value="SELECT CASE WHEN count(*)=1 THEN true ELSE false END FROM user_auth where user_device_details=:e",nativeQuery=true)
    int existsByUserDeviceDetails(@Param("e") String UserDeviceDetails);
	
	@Query(value="select CASE WHEN expiry_time > current_timestamp() THEN true ELSE false END FROM user_auth where user_device_details=:e",nativeQuery=true)
	int verifyAuthTokenExpiry(@Param("e") String UserDeviceDetails);
	
	@Query(value="select CASE WHEN expiry_time > current_timestamp() THEN true ELSE false END FROM user_auth where auth_token=:e and device_id=:f",nativeQuery=true)
	int validateAuthTokenExpiry(@Param("e") String AuthToken, @Param("f") String deviceId);
	
	@Query(value="select auth_token from user_auth where user_device_details=:udd",nativeQuery=true)
	String getValidAuthToken(@Param("udd") String UserDeviceDetails);
	
	@Query(value="select CASE WHEN current_timestamp() < :c THEN true ELSE false END",nativeQuery=true)
	int CheckOtpExpiry(@Param("c") Timestamp time);
	
	@Query(value="select user_id from user_auth where user_device_details=:udd",nativeQuery=true)
	int getUserId(@Param("udd") String userDeviceDetails);

}
