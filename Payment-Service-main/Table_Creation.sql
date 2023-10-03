CREATE DATABASE payment_service;

USE payment_service;

CREATE TABLE loan_payment_schedule
(
    id INT PRIMARY KEY,
    loan_application_id VARCHAR(50) NOT NULL,
    emi INT,
    due_date DATE,
    payment_status  VARCHAR(20),
    due_amount INT,
    principal_amount FLOAT(10),
    interest_amount FLOAT(10)
);


CREATE TABLE loan_payment
(
    id INT PRIMARY KEY,
    loan_application_id VARCHAR(50) NOT NULL,
    paid_amount INT,  
    payment_utr_id VARCHAR(15),
    payment_mode VARCHAR(10),
    payment_date TIMESTAMP, 
    payment_status  VARCHAR(10),
    failure_reason VARCHAR(10)
);

CREATE TABLE loan_disbursal
(
    id INT PRIMARY KEY,
    loan_application_id VARCHAR(50) NOT NULL,
    partner_id INT,  
    bank_account_number VARCHAR(50),
    amount INT,
    disbursal_date TIMESTAMP, 
    disbursal_utr_id  VARCHAR(20) 
);

CREATE TABLE log_payment_service
(
    id INT PRIMARY KEY,
    loan_application_id VARCHAR(50) ,
    operation VARCHAR(10),
    operation_time TIMESTAMP,
    entity_name  VARCHAR(10)
);

