DROP DATABASE IF EXISTS user ;
-- Create database
CREATE DATABASE IF NOT EXISTS user;

USE user;
-- Create table User
DROP TABLE IF EXISTS Users;
CREATE TABLE  Users
(
	Id 			SMALLINT AUTO_INCREMENT PRIMARY KEY,
    FirstName 	VARCHAR(255) NOT NULL,
    LastName 	VARCHAR(255) NOT NULL,
    Phone		VARCHAR(12) NOT NULL,
    Email 		VARCHAR(255) UNIQUE NOT NULL,
	Password 	VARCHAR(255) NOT NULL
);
-- Create table manager
CREATE TABLE IF NOT EXISTS Manager
(
	Id 				SMALLINT AUTO_INCREMENT PRIMARY KEY,
    ExpInYear		TINYINT NOT NULL,
    IdUser			SMALLINT NOT NULL,
    FOREIGN KEY (IdUser) REFERENCES Users(Id)
);

CREATE TABLE IF NOT EXISTS 	Employee
(
	Id 				SMALLINT AUTO_INCREMENT PRIMARY KEY,
    IdUser			SMALLINT NOT NULL,
    ProjectName		VARCHAR(255) NOT NULL,
    Skill			VARCHAR(255) NOT NULL,
	FOREIGN KEY 	(IdUser) REFERENCES Users(Id)
);

INSERT INTO   Users		  (Email					,	Password, 	 	FirstName,				LastName,		Phone		)
VALUES					  ('huong.lethu@vti.com.vn',	'Huong12',		'Thu Huong',			'Le',			'0972099925'),
						  ('an.nguyen@vti.com.vn',		'Admin123',		'An '	   ,			'Nguyen',		'0971133264');
                          