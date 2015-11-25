/*This files contains the all create table queries for the project*/

create table Movie(
movie_id int primary key,
title varchar(100) not null,
year varchar(5) not null,
genre varchar(15),
description varchar2(500) not null,
director varchar(100) not null,
now_showing number(1) not null,
rating float,
movie_length int not null
);

create table StarIn(
movie_id int,
name varchar(50),
foreign key (movie_id) references Movie(movie_id),
foreign key (name) references MovieStar(name)
);

create table MovieStar(
name varchar(50) primary key,
gender varchar(10) not null,
dob date not null,
image blob
);

create table Theatre(
theatre_id int primary key,
name varchar(50) not null,
location varchar(255) not null
);

create table Screen(
screen_id int primary key,
screen_number int not null,
movie_id int,
theatre_id int,
capacity int,
foreign key (theatre_id) references Theatre(theatre_id)
);

create table Schedule(
schedule_time varchar(15) not null,
availability int not null,
schedule_id int primary key,
price int not null,
screen_id int,
day varchar(10) not null,
foreign key (screen_id) references Screen(screen_id)
);

create table Review(
review_id int primary key,
review_content varchar2(255) not null,
member_id int,
like_count int not null,
credit_given number(1) not null,
foreign key (member_id) references UserRegistration
);
select * from ORDERDETAILS
/*Queries 8 to 16*/

create table MovieReview
(
movie_id int ,
review_id int ,
foreign key (movie_id) references Movie(movie_id),
foreign key (review_id) references Review(review_id)
);

create table TheatreReview
(
theatre_id int ,
review_id int ,
foreign key (theatre_id) references Theatre(theatre_id),
foreign key (review_id) references Review(review_id)
);

create table ReviewReply
(
review_id int,
member_id int,
reply_content varchar2(400) not null,
foreign key (review_id) references Review(review_id),
foreign key (member_id) references UserRegistration(member_id)
);

create table UserRegistration
(
member_id int primary key,
name varchar(100) not null,
phone varchar(50) not null,
address varchar(255) not null,
date_of_birth date not null,
email varchar(100) unique not null,
gender varchar(10) not null
);

create table MemberLogin
(
email varchar(100) not null,
password varchar(100) not null
);

create table Membership
(
member_id int,
credit_points int not null,
member_points int not null,
status varchar(100) not null,
role varchar(100) not null,
Foreign key (member_id) references UserRegistration(member_id)
);

create table Credit_Card_Details
(
member_id int,
card_number VARCHAR2(512) primary key,
type varchar(100) not null,
expiry varchar(50) not null,
name_on_card varchar(255) not null
);

CREATE TABLE OrderDetails
(
  order_id INT PRIMARY KEY,
  quantity INT not null,
  card_no VARCHAR(20) not null,
  schedule_id INT,
  movie_id INT,
  FOREIGN KEY (schedule_id) REFERENCES Schedule (schedule_id),
  FOREIGN KEY (movie_id) REFERENCES Movie (movie_id)
);

CREATE TABLE Purchase
(
  member_id INT,
  order_id INT,
  FOREIGN KEY (member_id) REFERENCES UserRegistration (member_id),
  FOREIGN KEY (order_id) REFERENCES OrderDetails (order_id)  
);

CREATE TABLE GuestOrder
(
  order_id INT,
  email VARCHAR(30) not null,
  phone VARCHAR(16) not null,
  FOREIGN KEY (order_id) REFERENCES OrderDetails (order_id)  
);

CREATE TABLE Staff_Description
(
  description_id int primary key,
  description VARCHAR(100) not null,
  staff_role VARCHAR(20) not null
);
 
CREATE TABLE StaffDetails
(
  staff_id INT PRIMARY KEY,
  name VARCHAR(40) not null,
  phone VARCHAR(16) not null,
  ssn VARCHAR2(512) unique not null,
  doj DATE not null,
  description_id INT,
  address VARCHAR(100) not null,
  email VARCHAR(30) unique not null,
  theatre_id INT,
  FOREIGN KEY (theatre_id) REFERENCES Theatre (theatre_id),
  FOREIGN KEY (description_id) REFERENCES Staff_Description (description_id)
);

CREATE TABLE StaffSchedule
(
  staff_id INT,
  day DATE not null,
  timing VARCHAR(20),
  FOREIGN KEY (staff_id) REFERENCES StaffDetails (staff_id)
);