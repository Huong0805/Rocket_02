DROP DATABASE IF EXISTS trainee ;
CREATE DATABASE IF NOT EXISTS trainee;

USE trainee;

CREATE TABLE IF NOT EXISTS Trainee
(
	Id 			INT AUTO_INCREMENT PRIMARY KEY,
    UserName 	VARCHAR(255),
    PassWord 	VARCHAR(255),
    FirstName 	VARCHAR(255),
    LastName 	VARCHAR(255),
    Email 		VARCHAR(255)
);

INSERT INTO Trainee(UserName, PassWord, FirstName, LastName, Email)
values ('huong','12345','Huong','Le', 'lethuhuong@gmail.com'),
	   ('hien','23456','Hien','Ho', 'hienho@gmail.com');