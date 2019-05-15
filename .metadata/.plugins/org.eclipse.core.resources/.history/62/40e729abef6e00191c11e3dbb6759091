--login: sys as sysdba
--pwd: sys
--
--create user project identified by project;

--Grant Create Session to project;
--Grant unlimited Tablespace to project;
--Grant Create table to project;
--Grant Create sequence to project;

DROP TABLE EMPLOYEE;


CREATE Table EMPLOYEE(
EMPID numeric(20) primary key,	
EMP_FNAME varchar2(20),
EMP_LNAME varchar2(20),
EMP_TYPE varchar2(20),
USERID VARCHAR2(20)
);


DROP sequence EMPLOYEE_seq;

create sequence EMPLOYEE_seq start with 10 increment by 1;


DROP TABLE TICKET;


CREATE Table TICKET(
TICKET_NUMBER numeric(10) primary key,
TICKET_DESCRIPTION varchar2(30),
TICKET_STATUS varchar2(20),
EMPID numeric(20),
CUST_ID NUMBER(20)
);


DROP sequence TICKET_seq;

create sequence TICKET_seq start with 10 increment by 1;


DROP TABLE CUSTOMER;
create table CUSTOMER (
CUST_ID NUMBER(9),
CUST_FNAME VARCHAR2(20),
CUST_LNAME VARCHAR2(20),
CUST_DOB DATE,
CUST_GENDER VARCHAR2(10),
ADDRESS_LINE1 varchar2(30),
ADDRESS_LINE2 varchar2(30),
CITY varchar2(20),
STATE varchar2(20),
ZIPCODE varchar2(20),
COUNTRY varchar2(20),
CUST_MOB_NUMBER VARCHAR2(15),
CUST_EMAIL VARCHAR2(20),
BLOODGROUP VARCHAR2(10),
ID_TYPE VARCHAR2(10),
ID_NUMBER VARCHAR2(20),
USERID VARCHAR2(20),
PASSWORD VARCHAR2(20),
CUST_MARITAL_STATUS VARCHAR2(10),
Constraint CUST_ID_Pk primary key(CUST_ID)
);


DROP sequence CUSTOMER_seq;

create sequence CUSTOMER_seq start with 10 increment by 1;


DROP TABLE NOMINEE;

CREATE Table NOMINEE(
NOMINEE_ID numeric(10) primary key,
CUST_ID NUMBER(9),
NOMINEE_NAME varchar(20),
NOMINEE_DATE DATE,
NOMINEE_RELATION varchar(20),
NOMINEE_IDTYPE varchar(10),
NOMINEE_IDNUMBER varchar(20),
NOMINEE_PHONENUMBER numeric(20)
);


DROP sequence NOMINEE_seq;

create sequence NOMINEE_seq start with 10 increment by 1;


DROP TABLE CLAIM;


Create Table CLAIM
(
CLAIM_ID Number(9),
CUST_ID Number(9),
POLICY_NUMBER Number(9),
CLAIM_AMOUNT Number(9,2),
DAMAGE_TYPE VARCHAR2(20),
DATE_OF_CLAIM DATE,
DATE_SETTLED DATE,
AMOUNT_PAID NUMBER(9,2),
CLAIM_STATUS VARCHAR2(20),Constraint CLAIM_ID_Pk primary key(CLAIM_ID)
);

DROP sequence CLAIM_seq;

create sequence CLAIM_seq start with 10 increment by 1;

DROP TABLE PRODUCT;


Create Table PRODUCT
(
PRODUCT_NUMBER Number(9),
PRODUCT_NAME VARCHAR2(20),
PRODUCT_PRICE NUMBER(9,2),
PRODUCT_TYPE VARCHAR2(20),Constraint PRODUCT_NUMBER_Pk primary key(PRODUCT_NUMBER)
);

DROP sequence PRODUCT_seq;

create sequence PRODUCT_seq start with 10 increment by 1;

DROP TABLE RECEIPT;


Create Table RECEIPT
(
RECEIPT_ID Number(9),
PREMIUM_PAYMENT_ID  Number(9),
CUST_ID Number(9),
COST NUMBER(9,2),
TIME DATE,Constraint RECEIPT_ID_Pk primary key(RECEIPT_ID)
);
DROP sequence RECEIPT_seq;

create sequence RECEIPT_seq start with 10 increment by 1;

DROP TABLE INCIDENT;


Create Table INCIDENT
(
INCIDENT_ID Number(9),
INCIDENT_TYPE  VARCHAR2(30)	,
INCIDENT_DATE DATE,
INCIDENT_DESCRIPTION VARCHAR2(100)
);
DROP sequence INCIDENT_seq;

create sequence INCIDENT_seq start with 10 increment by 1;



-----------------------------------------------------------------------
DROP TABLE VEHICLE;
create table VEHICLE(
VEHICLE_ID NUMBER(10) primary key,
CUST_ID NUMBER(9),
VEHICLE_TYPE varchar2(20),
VEHICLE_REG_NUMBER varchar2(20),
VEHICLE_CHASIS_NUMBER NUMBER(20),
VEHICLE_ENGINE_NUMBER NUMBER(20),
VEHICLE_MANUFACTURER varchar2(20),
VEHICLE_MODEL_NUMBER NUMBER(20),
VEHICLE_MFG_MMYYYY varchar2(6),
VEHICLE_IDV_VALUE NUMBER(9,2)
);

DROP sequence VEHICLE_seq;
create sequence VEHICLE_seq start with 10 increment by 1;

DROP TABLE PAYMENT;
create table PAYMENT(
PAYMENT_ID NUMBER(10) primary key,
CUST_ID NUMBER(9),
AMOUNT NUMBER(10,2),
PAYMENT_DATE date,
PAYMENT_MODE_TYPE varchar2(20),
STATUS varchar2(20)
);

DROP sequence PAYMENT_seq;
create sequence PAYMENT_seq start with 10 increment by 1;

DROP TABLE ADDRESS;
create table ADDRESS(
CUST_ID NUMBER(9),
ADDRESS_REF_NO NUMBER(10) primary key,
ADDRESS_LINE1 varchar2(30),
ADDRESS_LINE2 varchar2(30),
CITY varchar2(20),
STATE varchar2(20),
ZIPCODE NUMBER(20),
COUNTRY varchar2(20)
);


DROP sequence ADDRESS_seq;
create sequence ADDRESS_seq start with 10 increment by 1;

DROP TABLE IDV;
create table IDV(
IDV_NO NUMBER(10) primary key,
VEHICLE_ID NUMBER(20),
VEHICLE_IDV NUMBER(10,2),
NON_ELECTRICAL_ACCESSORIES NUMBER(10,2),
ELECTRIC_ACCESSORIES NUMBER(10,2),
ELECTRONIC_ACCESSORIES NUMBER(10,2),
TOTAL_IDV NUMBER(10,2)
);

DROP sequence IDV_seq;
create sequence IDV_seq start with 10 increment by 1;

DROP TABLE PAYMENT_REF;
create table PAYMENT_REF(
PAYMENT_MODE_TYPE varchar2(20),
PAYMENT_MODE_DESC varchar2(30),
ENABLE_DISABLE_FLAG varchar2(20)
);

DROP sequence PAYMENT_REF_seq;
create sequence PAYMENT_REF_seq start with 10 increment by 1;

DROP TABLE POLICY;
create table POLICY(
POLICY_NUMBER NUMBER(8) primary key,
POLICY_ISSUE_DATE Date,
POLICY_EXPIRY_DATE Date,
POLICY_TYPE Number(9),
POLICY_SUM_ASSURED number(9,2),
VEHICLE_REG_ID varchar2(20),
POLICY_STATUS varchar2(20),
TOTAL_PREMIUM number(9,2),
RENUAL_DATE Date,
NCB number(9,2),
DISCOUNT number(9,2),
APPLICATION_ID Number(9),
CUST_ID Number(9),
NOMINEE_ID NUMBER(10),
VEHICLE_ID NUMBER(10)
);

DROP sequence POLICY_seq;
create sequence POLICY_seq start with 10 increment by 1;

