drop table Persons if exists;

    CREATE TABLE Persons
    (
    Id_P int primary key,
    LastName varchar(255),
    FirstName varchar(255),
    Address varchar(255),
    City varchar(255) ,
    Money int
    );

DROP TABLE IF EXISTS CONTACT;
    CREATE TABLE CONTACT (
    ID INT NOT NULL IDENTITY
    , FIRST_NAME VARCHAR(60) NOT NULL
    , LAST_NAME VARCHAR(40) NOT NULL
    , BIRTH_DATE DATE
    );