drop table person if exists;

create table person (emplid bigint generated by default as identity (start with 1), first_name varchar(255), 
last_name varchar(255),  primary key (emplid))
