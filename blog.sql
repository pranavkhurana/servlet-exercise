create database abc;
use abc;
create table blog
(
	blogid int(5) auto_increment primary key,
	content varchar(1000) null
)
;

create table user
(
	userid int(4) auto_increment primary key,
	username varchar(50) null,
	name varchar(50) null,
	password varchar(50) null
)
;
insert into user(username,name,password) values("test","Pranav","pass");

