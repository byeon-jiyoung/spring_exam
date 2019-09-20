create database spring_exam;

use spring_exam;

create table member (
   userid varchar(50) not null,
   userpw varchar(50) not null,
   username varchar(50) not null,
   email varchar(100),
   tel varchar(13),
   regdate timestamp default now(),
   primary key(userid)
);

create table board (
   bno int not null auto_increment,
   file varchar(150) not null,
   originfile varchar(20) not null,
   regdate timestamp default now(),
   writer varchar(50),
   primary key(bno)
);

-- drop table board;

show tables;

select * from member;
select * from board order by bno desc;

select count(bno) from board;