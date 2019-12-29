DROP DATABASE IF EXISTS EMPLOY;
CREATE DATABASE IF NOT EXISTS EMPLOY;
USE EMPLOY;
DROP TABLE IF EXISTS Department;
CREATE TABLE Department
(
	Department_Number 	CHAR(5) PRIMARY KEY,
	Department_Name	 	VARCHAR(30) NOT NULL
);

DROP TABLE IF EXISTS Employee_Table;
CREATE TABLE Employee_Table
(
	Employee_Number		CHAR(5) PRIMARY KEY,
    Employee_Name 		VARCHAR(30) NOT NULL,
    Department_Number 	CHAR(5),
    FOREIGN KEY(Department_Number) REFERENCES Department(Department_Number)
);

DROP TABLE IF EXISTS Employee_Skill_Table;
CREATE TABLE Employee_Skill_Table
(
	Employee_Number		CHAR(5) NOT NULL,
    Skill_Code 			VARCHAR(30) NOT NULL,
    Date_Registered		Date,
    FOREIGN KEY(Employee_Number) REFERENCES Employee_Table(Employee_Number)
);

-- cau 2: them 10 ban ghi vao csdl
INSERT INTO Department
	   (Department_Number, Department_Name)
VALUES  ('dpt01',  'Hanh chinh'	  ),
		('dpt02',  'Tong hop'	  ),
        ('dpt03',  'Ke toan'	  ),
        ('dpt04',  'Kinh doanh'	  ),
        ('dpt05',  'Nhan su'	  );

INSERT INTO Employee_Table
		(Employee_Number,Employee_Name, Department_Number)
VALUES  ('001', 'Le Thu Huong', 'dpt01'),
		('002', 'Le Viet Thang', 'dpt01'),
        ('003', 'Le Thu Mai', 'dpt02'),
		('004', 'Dinh Viet Dung', 'dpt01');
        
INSERT INTO Employee_Skill_Table 
		(Employee_Number, Skill_Code, Date_Registered)
VALUES 	('001', 'PHP','2019-12-03'),
		('001', 'Java', '2019-11-03'),
        ('002', 'C', '2019-12-04');
        
-- cau 3: lay ra nhan vien co ky nang java

SELECT 
    E.Employee_Name 
FROM
    Employee_Table E  
JOIN 
	Employee_Skill_Table S ON E.Employee_Number= S.Employee_Number
WHERE Skill_Code='Java';

    
 -- cau 4: danh sach phong ban co 3 nv
 SELECT 
    D.Department_Number, D.Department_Name
FROM
    Department D
JOIN
    Employee_Table E ON D.Department_Number = E.Department_Number
GROUP BY (D.Department_Number)
HAVING COUNT(E.Department_Number) >= 3;


-- cau 5: danh sach nhan vien moi phong ban

SELECT D.Department_Number, D.Department_Name,
	  GROUP_CONCAT(E.Employee_Name SEPARATOR ' - ') AS TEN
FROM Department D
JOIN 
	Employee_Table E  ON  D.Department_Number=E.Department_Number
GROUP BY(D.Department_Number);

-- cau 6: danh sach nhan vien co hon 1 skill 

SELECT E.Employee_Name
FROM Employee_Table E
JOIN 
	Employee_Skill_Table S ON E.Employee_Number=S.Employee_Number
GROUP BY S.Employee_Number
HAVING COUNT(S.Employee_Number)>1
	








        
