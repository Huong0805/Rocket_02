DROP DATABASE IF EXISTS Fresher;
CREATE DATABASE IF NOT EXISTS Fresher;
use Fresher;
-- Tao bang
DROP TABLE IF EXISTS Trainee;
CREATE TABLE Trainee
(
	traineeID			SMALLINT AUTO_INCREMENT PRIMARY KEY,
	Full_Name			VARCHAR(30) NOT NULL,
	Birth_Date			DATE,
	Gender				ENUM('Male','Female','Unknow'),
	ET_IQ				TINYINT CHECK (ET_IQ>=0 and ET_IQ<=20),
	ET_Gmath			TINYINT CHECK (ET_Gmath>=0 and ET_Gmath<=20),
	ET_English			TINYINT CHECK (ET_English>=0 and ET_English<=50),
	Training_Class		CHAR(6),
    Evaluation_Notes	TEXT
);
-- Them cot VTI_Account
ALTER TABLE trainee 
ADD COLUMN VTI_Account CHAR(10) UNIQUE NOT NULL;


-- Ex2: Bảng bên dưới sẽ có ít nhất 1 triệu bản ghi, có chứa các thông tin 
DROP DATABASE IF EXISTS AS2_2;
CREATE DATABASE IF NOT EXISTS AS2_2;
use AS2_2;

DROP TABLE IF EXISTS Ex2;
CREATE TABLE Ex2
(
	ID					MEDIUMINT AUTO_INCREMENT PRIMARY KEY,
	Name				VARCHAR(30) NOT NULL,
	Code				CHAR(5) NOT NULL,
    ModifiedDate 		DATETIME
);

-- EX3: Bảng bên dưới sẽ có ít nhất 1 triệu bản ghi, có chứa các thông tin sau

DROP DATABASE IF EXISTS AS2_3;
CREATE DATABASE IF NOT EXISTS AS2_3;
use AS2_3;

DROP TABLE IF EXISTS Ex3;
CREATE TABLE Ex3
(
	ID					MEDIUMINT AUTO_INCREMENT PRIMARY KEY,
	Name				VARCHAR(30) NOT NULL,
	Birth_Date			DATE,
	Gender				ENUM('Male','Female'),
    IsDeletedFlag 		BIT
);