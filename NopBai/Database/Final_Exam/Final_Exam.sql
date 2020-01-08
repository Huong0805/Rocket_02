-- Cau a: Tao CSDL

DROP DATABASE IF EXISTS ManagerStudent;
CREATE DATABASE IF NOT EXISTS ManagerStudent;
USE ManagerStudent;

DROP TABLE IF EXISTS Student;
CREATE TABLE Student
(
	RN			CHAR(5) PRIMARY KEY,
    Name		VARCHAR(30) NOT NULL,
    Age			TINYINT,
    Gender		BIT
);

DROP TABLE IF EXISTS Subject;
CREATE TABLE Subject
(
	sID			CHAR(5) PRIMARY KEY,
    sName		VARCHAR(30) NOT NULL
);

DROP TABLE IF EXISTS StudentSubject;
CREATE TABLE StudentSubject
(
	RN			CHAR(5) NOT NULL,
	sID			CHAR(5) NOT NULL,
    Mark		DECIMAL(4,2),
    Date		DATE,
    PRIMARY KEY (RN, sID),
    FOREIGN KEY (RN) REFERENCES Student(RN),
    FOREIGN KEY (sID) REFERENCES Subject(sID)
);

-- Insert du lieu
INSERT INTO Student	  (RN	  , 	Name			  ,		Age,  	  Gender)
VALUES  			  ('st01' , 	'Le Thu Huong'	  , 	21 ,		1),
					  ('st02' , 	'Le Viet Thang'	  , 	22 ,		0),
                      ('st03' , 	'Nguyen Manh Hung', 	20 ,		NULL);


INSERT INTO Subject	  (sID	  , 	sName			 )
VALUES  			  ('sj01' , 	'Co so lap trinh'),
					  ('sj02' , 	'Co so du lieu'  ),
                      ('sj03' , 	'Quan tri mang'	 );

INSERT INTO StudentSubject	  (RN     ,		 sID  ,	Mark,	Date	 )
VALUES  			 		  ('st01' , 	'sj01',	 9	,'2019-11-12'),
							  ('st01' , 	'sj02',	 8	,'2019-11-13'),
							  ('st02' , 	'sj01',	 10	,'2019-10-12'),
							  ('st03' , 	'sj01',	 9.5,'2019-11-12');
-- Cau b: Lấy tất cả các môn học không có bất kì điểm nào 
SELECT sID, sName FROM Subject 
WHERE sID NOT IN (SELECT sID FROM StudentSubject );

-- Lấy danh sách các môn học có ít nhất 2 điểm 

SELECT 
    sj.sID, sj.sName
FROM
    Subject sj
        JOIN
    StudentSubject ss ON sj.sID = ss.sID
GROUP BY (sID)
HAVING COUNT(Mark) >= 2;

-- Cau c:  Tao view có các thông tin về học sinh, cột Gender show Male để thay thế cho 0, Female thay thế cho 1 và Unknow thay thế cho null. 
DROP VIEW IF EXISTS StudentInfo;
CREATE VIEW StudentInfo AS
    SELECT 
        st.RN,
        sj.sID,
        st.Name,
        st.Age,
        CASE Gender
            WHEN 1 THEN 'Female'
            WHEN 0 THEN 'Male'
            ELSE 'Unknow'
        END AS Gender,
        sj.sName,
        ss.Mark,
        ss.Date
    FROM
        StudentSubject ss
            JOIN
        Student st ON ss.RN = st.RN
            JOIN
        Subject sj ON ss.sID = sJ.sID;

SELECT * FROM StudentInfo;

-- Cau d: Tao trigger: khi thay đổi data của cột sID, thì giá trị của cột sID của table StudentSubject cũng thay đổi theo 

DROP TRIGGER IF EXISTS CasUpdate;
DELIMITER $$
CREATE TRIGGER CasUpdate
BEFORE UPDATE ON Subject
FOR EACH ROW
BEGIN
	DECLARE NewID, OldID CHAR(5) ;
    DECLARE NewName VARCHAR(30) ;
    SELECT OLD.sID INTO OldID;
    SELECT New.sID INTO NewID;
    -- UPDATE StudentSubject SET sID=NewID WHERE sID=OldID;
END $$
DELIMITER ;

UPDATE Subject SET sID='sj04' WHERE sID='sj01';

-- Trigger casDel: Khi xóa 1 student, các dữ liệu của table StudentSubject cũng sẽ bị xóa theo 

DROP TRIGGER IF EXISTS casDel;
DELIMITER $$
CREATE TRIGGER casDel
BEFORE DELETE ON Subject
FOR EACH ROW
BEGIN 
	DECLARE OldID CHAR(5) ;
    SELECT OLD.sID INTO OldID;
	DELETE FROM StudentSubject WHERE sID=OldID;
END $$
DELIMITER ;

DELETE FROM Subject WHERE sID='sj02';

-- Cau e: Viết 1 thủ tục (có 2 parameters: student name, mark). 
-- Thủ tục sẽ xóa tất cả các thông tin liên quan tới học sinh có cùng tên như parameter và tất cả các điểm nhỏ hơn của các học sinh đó

DROP PROCEDURE IF EXISTS sp_DelInfo;
DELIMITER $$
CREATE PROCEDURE sp_DelInfo(IN st_name VARCHAR(30), st_mark DECIMAL(4,2))
BEGIN
	DROP TEMPORARY TABLE IF EXISTS DelStudent;
	CREATE TEMPORARY TABLE DelStudent
		(
			StudentID			 CHAR(5)
		);

	INSERT INTO DelStudent 
	SELECT RN
	FROM   Student
    WHERE  Name = st_name;
    
    DELETE FROM StudentSubject WHERE Mark < st_mark;
	DELETE FROM StudentSubject WHERE RN IN (SELECT StudentID FROM DelStudent);
    DELETE FROM Student WHERE RN IN (SELECT StudentID FROM DelStudent);
    
END $$
DELIMITER ;

CALL sp_DelInfo('Nguyen Manh Hung', 9);







