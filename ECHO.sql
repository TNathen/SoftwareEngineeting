drop table if exists USERS;
drop table if exists ADMINS;
drop table if exists FLIGHTS;
drop table if exists TICKETS;
drop table if exists COUPONS;

create table USERS(
EMAIL varchar(30) primary key,
PASS varchar(30),
FIRST_NAME varchar(25),
LAST_NAME varchar(30),
PHONE varchar(10),
DOB date,
MONEYSPENT decimal (9,2),
SECURITY_QUESTION varchar(40),
ANSWER varchar(30)
);

create table ADMINS(
EMAIL varchar(30) primary key,
PASS varchar(30)
);


create table FLIGHTS(
PLANE_ID varchar(10),
FLIGHT_NUM varchar(10) primary key,
START_LOC varchar(30),
END_LOC varchar(30),
BASE_PRICE decimal(9,2),
PLANE_TYPE INT,
FLIGHT_TIME DATETIME(0)
);

create table TICKETS(
FLIGHT_NUM varchar(10),
U_EMAIL varchar(30),
PLANE_TYPE INT,
TICKET_NUMBER int,
TICKET_VALUE decimal (9,2),
CREDIT_CARD varchar(20),
ADDRESS varchar(60),
DATE_PURCHASED date,
FOOD text,
BAGGAGE_NUM	int,
HANDICAP text(1),
constraint FLIGHT foreign key (FLIGHT_NUM, PLANE_TYPE) references FLIGHTS (FLIGHT_NUM, PLANE_TYPE),
constraint USER_EMAIL foreign key (U_EMAIL) references USERS (EMAIL),
constraint pk_TICKETS primary key (FLIGHT_NUM, TICKET_NUMBER)
);

create table COUPONS(
CODE varchar(15) primary key,
EMAIL varchar(10) ,
EXPIRATION_DATE date,
PERCENT decimal(2,2),

constraint COUPON_EMAIL foreign key (EMAIL) references USERS (EMAIL)
);

insert into USERS values("u@ser.mail","asdf","john","doe","4455458785",'1999-01-01',23.20,"What is your dogs name?","dog");
insert into ADMINS values("a@ser.mail","asdf");
insert into FLIGHTS values("plane1","flight1","ATL","NEW YORK", 500, 2, '20120618 103409');
insert into TICKETS values("flight1","u@ser.mail",2,10,500.00,"CNUMBER16","ADDRESS", '20150101','c',1,'y');
insert into COUPONS values("CODE","EMAIL","20160101",.05);

