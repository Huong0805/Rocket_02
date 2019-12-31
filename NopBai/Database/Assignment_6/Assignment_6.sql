-- Cau 1: Tao co so du lieu

DROP DATABASE IF EXISTS Project;
CREATE DATABASE IF NOT EXISTS Project;
USE Project;

DROP TABLE IF EXISTS Employee;
CREATE TABLE Employee
(
	EmployeeID 					CHAR(5) PRIMARY KEY,
    EmployeeLastName 			VARCHAR(10) NOT NULL,
    EmployeeFistName 			VARCHAR(10) NOT NULL,
    EmployeeHireDate 			DATE NOT NULL,
    EmployeeStatus 				BIT NOT NULL,
    SupervisorID 				CHAR(5), 
    SocialSecurityNumber		CHAR(12) NOT NULL,
    FOREIGN KEY(SupervisorID) 	REFERENCES Employee(EmployeeID)
);

DROP TABLE IF EXISTS Projects;
CREATE TABLE Projects
(
	ProjectID 					CHAR(5) PRIMARY KEY,
    EmployeeID 					CHAR(5) NOT NULL,
    ProjectName 				VARCHAR(30) NOT NULL,
    ProjectStartDate 			DATE NOT NULL,
    ProjectDescription 			VARCHAR(30),
    ProjectDetailt 				VARCHAR(30),
    ProjectCompletedOn 			DATE,
    FOREIGN KEY(EmployeeID) 	REFERENCES Employee(EmployeeID)
);

DROP TABLE IF EXISTS Project_Modules;
CREATE TABLE Project_Modules
(
	ModuleID 					CHAR(5) PRIMARY KEY,
    ProjectID 					CHAR(5) NOT NULL ,
    EmployeeID 					CHAR(5) NOT NULL,
    ProjectModulesDate 			DATE,
    ProjectModulesCompledOn 	DATE,
    ProjectModulesDescription	VARCHAR(30),
    FOREIGN KEY(EmployeeID) 	REFERENCES Employee(EmployeeID),
    FOREIGN KEY(ProjectID) 		REFERENCES Projects(ProjectID)
);

DROP TABLE IF EXISTS Work_Done;
CREATE TABLE Work_Done
(
	WorkDoneID 					CHAR(5) PRIMARY KEY,
    EmployeeID 					CHAR(5) NOT NULL,
    ModuleID 					CHAR(5) NOT NULL,
    WorkDoneDate 				DATE,
    WorkDoneDescription 		VARCHAR(30),
    WorkDoneStatus				BIT NOT NULL,
    FOREIGN KEY(EmployeeID) 	REFERENCES Employee(EmployeeID),
    FOREIGN KEY(ModuleID) 		REFERENCES Project_Modules(ModuleID)
);
-- Insert du lieu
INSERT INTO Employee (EmployeeID, EmployeeLastName, EmployeeFistName, EmployeeHireDate, EmployeeStatus, SupervisorID, SocialSecurityNumber)
VALUES 				 ('emp1'	,'Le'			  , 'Thu Huong'		, '2019-02-08'	  , 1			  , NULL 		, 'LTH09979878'		),
					 ('emp2'	,'Le'			  , 'Thu Mai'		, '2019-03-07'	  , 1			  ,	'emp1'		, 'LTH09979999'		),
					 ('emp3'	,'Le'			  , 'Minh Hang'		, '2018-02-08'	  , 1			  ,	'emp1'		, 'LTH09977778'		);
                     
INSERT INTO Projects (ProjectID, EmployeeID, ProjectName, ProjectStartDate, ProjectDescription, ProjectDetailt, ProjectCompletedOn)
VALUES 				 ('prj1'   ,'emp1'	   , 'QLNS'		, '2019-12-01'	  , 'Quan trong'	  ,	'3 modules'	  ,	'2020-12-01'	  ),
					 ('prj2'   ,'emp2'	   , 'QLDA'		, '2019-12-02'	  , 'Quan trong'	  ,	'3 modules'	  ,	'2020-02-03'	  ),
					 ('prj3'   ,'emp1'	   , 'QLVP'		, '2019-12-01'	  , 'Quan trong'	  ,	'3 modules'	  ,	'2020-05-05'	  ),
					 ('prj4'   ,'emp1'	   , 'QLNS'		, '2019-05-01'	  , 'Quan trong'	  ,	'3 modules'	  ,	'2020-12-01'	  ),	
					 ('prj5'   ,'emp1'	   , 'QLNS'		, '2019-06-01'	  , 'Quan trong'	  ,	'3 modules'	  ,	'2019-07-01'	  );
INSERT INTO Project_Modules (ModuleID, ProjectID, EmployeeID, ProjectModulesDate, ProjectModulesCompledOn, ProjectModulesDescription)
VALUES 				 	   ('mdl1'   ,'prj1'   , 'emp1'		, '2019-12-23'	    , '2019-12-25'	  		, 'Phan tich' ),
						   ('mdl2'   ,'prj1'   , 'emp1'		, '2019-12-24'	    , '2019-12-30'	  		, 'Lap trinh' ),
                           ('mdl3'   ,'prj2'   , 'emp2'		, '2019-12-25'	    , '2019-12-31'	  		, 'Kiem thu'  ),
						   ('mdl4'   ,'prj2'   , 'emp1'		, '2019-12-23'	    , NULL	  				, 'Lap trinh'),                   
						   ('mdl5'   ,'prj5'   , 'emp2'		, '2019-05-31'	    , '2019-06-01'	  		, 'Phan tich' );
INSERT INTO Work_Done (WorkDoneID, EmployeeID, ModuleID, WorkDoneDate, WorkDoneDescription, WorkDoneStatus)
VALUES 				   ('wkd1'   ,'emp1'      , 'mdl1'	, '2019-12-23', 'Phan tich'	  	  , 1),
					   ('wkd2'   ,'emp1'      , 'mdl1'	, '2019-12-24', 'PT tong hop' 	  , 1),
					   ('wkd3'   ,'emp3'      , 'mdl2'	, '2019-12-25', 'Lap trinh'	  	  , 1);
                       
-- Cau 2: 
DROP PROCEDURE IF EXISTS sp_completed3months;
DELIMITER $$
CREATE PROCEDURE sp_completed3months()
BEGIN

-- Tao bang tam chua project hoan thanh > 3 thang
	DROP TEMPORARY TABLE IF EXISTS Project;
	CREATE TEMPORARY TABLE Project
		(
			ProjectID			 CHAR(5)
		);

	INSERT INTO Project 
	SELECT ProjectID
	FROM   Projects
	WHERE ProjectID IN (SELECT ProjectID FROM  Projects 
						WHERE SUBDATE(CURDATE(), INTERVAL 90 DAY) >= ProjectCompletedOn);
                    
-- Tao bang tam chua modules cua project hoan thanh > 3 thang

	DROP TEMPORARY TABLE IF EXISTS Module;
	CREATE TEMPORARY TABLE Module
	(
		ModuleID			 CHAR(5)
	);				

	INSERT INTO Module 
	SELECT ModuleID
	FROM Project_Modules
	WHERE ProjectID IN (SELECT * FROM Project);
    
-- Tao bang tam chua working_done cua project hoan thanh > 3 thang

	DROP TEMPORARY TABLE IF EXISTS WorkDone;
	CREATE TEMPORARY TABLE WorkDone
	(
		WorkDoneID			 CHAR(5)
	);				

	INSERT INTO WorkDone 
	SELECT WorkDoneID
	FROM Work_Done
	WHERE ModuleID IN (SELECT * FROM Module);

-- Dem cac truong lien quan

SELECT 
	(SELECT COUNT(projectid) FROM Project) AS num_pro,
	(SELECT COUNT(moduleID) FROM Module) AS num_mod, 
	(SELECT count(WorkDoneID) FROM WorkDone) as num_work;
    
-- Xoa cac project hoan thanh >3 thang

DELETE FROM Work_Done WHERE WorkDoneID IN (SELECT * FROM WorkD);
DELETE FROM Project_Modules WHERE ModuleID IN (SELECT * FROM Module);
DELETE FROM Projects WHERE ProjectID IN (SELECT * FROM Project);

END $$
DELIMITER ;

-- Call 
CALL sp_completed3months();


-- Cau 3: Viết stored procedure để in ra các module đang được thực hiện

DROP PROCEDURE IF EXISTS sp_modules_working;
DELIMITER $$
CREATE PROCEDURE sp_modules_working()
BEGIN
	SELECT ModuleID, ProjectID, EmployeeID, ProjectModulesDescription
    FROM   Project_Modules
    WHERE ProjectModulesCompledOn IS NULL;
END $$
DELIMITER ;

-- Call
CALL sp_modules_working();

-- Cau 4: Thông tin 1 nhân viên đã tham gia làm mặc dù không ai giao việc cho nhân viên đó (trong bảng Works) 
DROP PROCEDURE IF EXISTS sp_emp;
DELIMITER $$
CREATE PROCEDURE sp_emp()
BEGIN
	SELECT 
		e.EmployeeLastName, e.EmployeeFistName, e.EmployeeHireDate, e.EmployeeStatus, e.SupervisorID, e. SocialSecurityNumber
	FROM
		employee e
	WHERE
		e.EmployeeID NOT IN (SELECT EmployeeID
							 FROM work_done)
		AND EmployeeStatus=1;
END $$
DELIMITER ;

-- Call
CALL sp_emp();
