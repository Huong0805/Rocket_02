-- Cau 1: Viết triggers để tránh trường hợp người dùng nhập thông tin module Project không hợp lệ  
USE Project;
DROP TRIGGER IF EXISTS before_insert_project;
DELIMITER $$
CREATE TRIGGER before_insert_project
BEFORE INSERT ON Project_Modules
FOR EACH ROW
BEGIN 
	 DECLARE ngaybd, ngaykt DATE;
SELECT 
    ProjectStartDate, ProjectCompletedOn
INTO ngaybd , ngaykt FROM
    Projects
WHERE
    ProjectID = NEW.ProjectID;
	 IF ngaybd > NEW.ProjectModulesDate THEN SIGNAL SQLSTATE '45000'
     SET MESSAGE_TEXT = 'ProjectModulesDate < ProjectStartDate';
     END IF;
     IF NEW.ProjectModulesCompledOn > ngaykt  THEN SIGNAL SQLSTATE '45000'
     SET MESSAGE_TEXT = 'ProjectModulesCompletedOn > ProjectCompletedOn';
    END IF;
END $$
DELIMITER ;
INSERT INTO Project_Modules (ModuleID, ProjectID, EmployeeID, ProjectModulesDate, ProjectModulesCompledOn, ProjectModulesDescription)
VALUES 				 	   ('mdl6'   ,'prj1'   , 'emp1'		, '2018-12-23'	    , '2020-12-25'	  		, 'Phan tich' );



-- Cau 2: , Tạo 1 VIEW để lấy ra tất cả các thực tập sinh là ET

USE Fresher;
DROP VIEW IF EXISTS v_ET;
CREATE VIEW v_ET
AS
SELECT * FROM Trainee
WHERE 	ET_IQ >= 8 
    AND ((ET_IQ+ET_Gmath)>=20)
    AND ET_Gmath >= 8
	AND ET_English >= 18;
    
SELECT * FROM v_ET;