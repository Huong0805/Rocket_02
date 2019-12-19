DROP DATABASE IF EXISTS fresher;
CREATE DATABASE IF NOT EXISTS fresher;
use fresher;
-- Tao bang
DROP TABLE IF EXISTS trainee;
CREATE TABLE trainee
(
	traineeID			SMALLINT AUTO_INCREMENT PRIMARY KEY,
	Full_Name			VARCHAR(30) NOT NULL,
	Birth_Date			DATE,
	Gender				ENUM('Male','Female','Unknow'),
	ET_IQ				TINYINT,
	ET_Gmath			TINYINT,
	ET_English			TINYINT,
	Training_Class		CHAR(6),
    Evaluation_Notes	TEXT
);
-- Them cot VTI_Acount
ALTER TABLE trainee 
ADD COLUMN VTI_Acount CHAR(10) UNIQUE NOT NULL;
