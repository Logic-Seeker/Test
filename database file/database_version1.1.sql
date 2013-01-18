create database if not exists brick_inventory;
use brick_inventory;

-- table for username and password
create table user (
user_id int PRIMARY KEY auto_increment,
username varchar(20) not null,
password varchar(30) not null
);

-- table for vehicle,vehicle_id is PRIMARY KEY since int as PRIAMRY KEY is best 
create table vehicle (
vechile_id int PRIMARY KEY auto_increment,
vehicle_no nvarchar(25) not null,
Vechile_desc nvarchar(25)
);

-- table to store LABOUR data 
CREATE TABLE labour(
labour_tanscation int PRIMARY KEY,
labour_name nvarchar(30) not null,
labour_type_id int not null, -- patheri,bokaniya,madesi
no_of_bricks int not null -- this is the default no of bricks a labour can carry which is rarely changed
);

create table labour_type(
labour_type_id int PRIMARY key,
labour_type_desc nvarchar(30) not null
);

alter table labour
add constraint fk_labour_type FOREIGN KEY(labour_type_id) references labour_type(labour_type_id);


CREATE TABLE brick (
brick_id int PRIMARY KEY auto_increment,
brick_type nvarchar(30) not null,
brick_desc nvarchar(50),
brick_amount numeric(9,2) DEFAULT 0 -- Maybe there is a certain amount for certain type of 1000 BRICK 
);

-- this is for the labour form
-- Since every distance based Amount Calcutation is Done in 1000 BRICKS i have created this table to record 
-- Distance VS Brick Type -- amount Calclitation for 1000 BRICKS
CREATE table brick_distance(
bd_id int PRIMARY KEY ,
Distance_Type nvarchar(30) not null, -- this refers to distance a,b,c // coins iGuess MAY need another table DISCUSS 
brick_id int not null,
brick_distance_amount numeric(9,2) default 0 -- fixed amount for fixed distance i guess 
);

alter table brick_distance 
add constraint fk_brick_type FOREIGN KEY(brick_id) REFERENCES BRICK(brick_id);
-- THis table is for Transcation here Number represents the no of Distance coin
-- and AMOUNT represents the Calculated amount ie (no of coins* default carrying capacity of labour) as compared 
-- to amount in BRICK_Distance table 

CREATE table labour_tanscation (
l_id int NOT NULL,
bd_id int ,
Number int not null,
Amount numeric(9,2) not null,
transcation_date DATE not null
);

alter table labour_tanscation
add constraint pk_labour_transcation PRIMARY KEY (l_id,bd_id,transcation_date);

-- from this labour_transcation table we can calculate the Amount for each bd_id(brick distance) for each date
-- According to date and Labour Id we can sum up the Total Amount which may be more than one transcation per data


alter table labour_tanscation
add constraint fk_labour_t_id FOREIGN KEY(l_id) REFERENCES labour(labour_tanscation);


alter table labour_tanscation
add constraint fk_distance_id FOREIGN KEY(bd_id) REFERENCES brick_distance(bd_id);

CREATE TABLE EMPLOYEE(
E_id int PRIMARY KEY auto_increment,
E_Name nvarchar(30) not null,
E_Type nvarchar(30) not null -- Type of Employe like Driver Needs to be disccuss as it will be fixed or not unknown
);


create database if not exists brick_inventory;
use brick_inventory;

-- table for username and password
create table user (
user_id int PRIMARY KEY auto_increment,
username varchar(20) not null,
password varchar(30) not null
);

-- table for vehicle,vehicle_id is PRIMARY KEY since int as PRIAMRY KEY is best 
create table vehicle (
vechile_id int PRIMARY KEY auto_increment,
vehicle_no nvarchar(25) not null,
Vechile_desc nvarchar(25)
);

-- table to store LABOUR data 
CREATE TABLE labour(
labour_tanscation int PRIMARY KEY,
labour_name nvarchar(30) not null,
labour_type_id int not null, -- patheri,bokaniya,madesi
no_of_bricks int not null -- this is the default no of bricks a labour can carry which is rarely changed
);

create table labour_type(
labour_type_id int PRIMARY key,
labour_type_desc nvarchar(30) not null
);

alter table labour
add constraint fk_labour_type FOREIGN KEY(labour_type_id) references labour_type(labour_type_id);


CREATE TABLE brick (
brick_id int PRIMARY KEY auto_increment,
brick_type nvarchar(30) not null,
brick_desc nvarchar(50),
brick_amount numeric(9,2) DEFAULT 0 -- Maybe there is a certain amount for certain type of 1000 BRICK 
);

-- this is for the labour form
-- Since every distance based Amount Calcutation is Done in 1000 BRICKS i have created this table to record 
-- Distance VS Brick Type -- amount Calclitation for 1000 BRICKS
CREATE table brick_distance(
bd_id int PRIMARY KEY ,
Distance_Type nvarchar(30) not null, -- this refers to distance a,b,c // coins iGuess MAY need another table DISCUSS 
brick_id int not null,
brick_distance_amount numeric(9,2) default 0 -- fixed amount for fixed distance i guess 
);

alter table brick_distance 
add constraint fk_brick_type FOREIGN KEY(brick_id) REFERENCES BRICK(brick_id);
-- THis table is for Transcation here Number represents the no of Distance coin
-- and AMOUNT represents the Calculated amount ie (no of coins* default carrying capacity of labour) as compared 
-- to amount in BRICK_Distance table 

CREATE table labour_tanscation (
l_id int NOT NULL,
bd_id int ,
Number int not null,
Amount numeric(9,2) not null,
transcation_date DATE not null
);

alter table labour_tanscation
add constraint pk_labour_transcation PRIMARY KEY (l_id,bd_id,transcation_date);

-- from this labour_transcation table we can calculate the Amount for each bd_id(brick distance) for each date
-- According to date and Labour Id we can sum up the Total Amount which may be more than one transcation per data


alter table labour_tanscation
add constraint fk_labour_t_id FOREIGN KEY(l_id) REFERENCES labour(labour_tanscation);


alter table labour_tanscation
add constraint fk_distance_id FOREIGN KEY(bd_id) REFERENCES brick_distance(bd_id);

CREATE TABLE EMPLOYEE(
E_id int PRIMARY KEY auto_increment,
E_Name nvarchar(30) not null,
E_Type nvarchar(30) not null -- Type of Employe like Driver Needs to be disccuss as it will be fixed or not unknown
);


-- for_order form fullfilment
-- multiple bricks type entry entry
CREATE TABLE VOUCHER_TRANSCATION(
v_id INT PRIMARY KEY auto_increment,
br_id int not null,
no_bricks int not null,
order_id int not null,
amount numeric(9,2)
);

create table order_tab(
order_id  int primary key auto_increment,
vechile_no nvarchar(25),
driver_name nvarchar(30),
Customer_name nvarchar(20),
Total numeric(9,2) not null,
Discount numeric(9,2) default 0,
Advance numeric(9,2) default 0,
Remainder numeric(9,2) default 0
);

alter table voucher_transcation
add constraint fk_order_transcation foreign key(order_id) references order_tab(order_id);

