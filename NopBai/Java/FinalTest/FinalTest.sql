DROP DATABASE IF EXISTS user ;
CREATE DATABASE IF NOT EXISTS user;

USE user;

CREATE TABLE IF NOT EXISTS Manager
(
	Id 			INT AUTO_INCREMENT PRIMARY KEY,
    FirstName 	VARCHAR(255),
    LastName 	VARCHAR(255),
    Phone		VARCHAR(20),
    Email 		VARCHAR(255),
	PassWord 	VARCHAR(255),
    Year		TINYINT
);

CREATE TABLE IF NOT EXISTS 	Employee
(
	Id 				INT AUTO_INCREMENT PRIMARY KEY,
    FirstName 		VARCHAR(255),
    LastName 		VARCHAR(255),
    Phone			VARCHAR(20),
    Email 			VARCHAR(255),
	PassWord 		VARCHAR(255),
    ProjectName		VARCHAR(255),
    Skill			VARCHAR(255)
);

INSERT INTO Manager(FirstName, LastName, Phone, Email, PassWord, Year)
values ('Huong','Le','0972099925', 'lethuhuong@gmail.com','12345',2);

INSERT INTO Employee(FirstName, LastName, Phone, Email, PassWord, ProjectName,Skill)
values ('Huong','Le','0972099925', 'lethuhuong@gmail.com','12345','abc','java');