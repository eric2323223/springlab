drop table Persons if exists;

        CREATE TABLE Persons
        (
        Id_P int primary key,
        LastName varchar(255),
        FirstName varchar(255),
        Address varchar(255),
        City varchar(255)
        );