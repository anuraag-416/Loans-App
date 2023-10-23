Bibhu Bhushan

Yasin Shahid Ikram Shaik

Amisha Sawlani

Anuraag Ramineni

Flow Diagram



Class Diagram





Database Entities

Table name (Entity) -> User_auth





API Endpoints

To  be called by User to login  

/UserLogin

Request : POST

Request Body:

{
    "user_name":"9636487511",
    "device_model":"One Plus",
    "device_id":"1st"
}



Response Body:

{
    "authToken": "491b19d6-0495-489f-9c17-56e29554db43",
    "deviceId": "1st"
}



We will have login requests with the specified parameters if user enters with wrong parameters, then we will ask the user to  enter correct input.

We will return authToken and deviceId to user so that they can proceed other services.

 

2/ValidateToken





Request: POST

Request Body:

{
    "authToken": "491b19d6-0495-489f-9c17-56e29554db43",
    "deviceId": "1st"
}

Responce Body:

{
    "Status": 500
}

LOS and PAYMENT will call this API with authToken and deviceId to validate the user.

We will check the given parameters with our database and send the response accordingly.

To be called by user to enter OTP

3. /EnterOtp

Request: POST

Request Body:

{
    "otp":172432
}

Response Body:

{
    "AuthResponse": "Login successful !!"
}



Exception Response Body

{
    "HttpException": "INTERNAL_SERVER_ERROR",
    "Status":"500"
}



 API’s URL

1)http://13.233.162.61:8080/login- User login

2)http://13.233.162.61:8080/EnterOtp -Enter Otp

3)http://192.168.171.206:8080/validateToken-Validate Token



Bitbucket Repository Link

https://bitbucket.org/ikram_shaik/auth-service/src/main/
