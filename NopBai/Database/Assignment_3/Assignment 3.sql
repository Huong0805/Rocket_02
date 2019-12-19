-- Insert 5 ban ghi vao bang trainee

    INSERT INTO trainee
    (Full_Name, 		Birth_Date,		Gender, 	ET_IQ, 	ET_Gmath, 	ET_English, 	Training_Class, 	 Evaluation_Notes,	 VTI_Acount)
    VALUES  
    ('Cao Thu Thao',	'1999/08/08',	'Female',	10,		08,			29,				'CT1234',			'abcdef1234',		'BCD4567'),
	('Nguyen Van Hieu',	'1999/10/08',	'Female',	10,		05,			24,				'CT1234',			'abcdef1234',		'BCD4456'),
	('Cao Thu Tra ',	'1999/09/10',	'Female',	10,		06,			34,				'CT1234',			'abcdef1234',		'BCD456'),
	('Cao Thu Hoa',		'1999/07/08',	'Male',		10,		07,			12,				'CT1234',			'abcdef1234',		'BCD457'),
	('Le Thu Huong',	'1999/05/08',	'Female',	10,		09,			45,				'CT1234',			'abcdef1234',		'BCD467'),
    ('Cao Thu Thao',	'1998/08/08',	'Female',	10,		08,			29,				'CT1234',			'abcdef1234',		'4567'),
	('Nguyen Van Hieu',	'1997/08/08',	'Female',	10,		05,			24,				'CT1234',			'abcdef1234',		'78910'),
	('Cao Thu Tra ',	'1996/09/10',	'Female',	10,		06,			34,				'CT1234',			'abcdef1234',		'12345'),
	('Cao Thu Hoa',		'1994/07/08',	'Male',		10,		07,			12,				'CT1234',			'abcdef1234',		'abcd'),
	('Le Thu Huong',	'1996/05/08',	'Female',	10,		09,			45,				'CT1234',			'abcdef1234',		'77787');
    
    
-- Cac thuc tap sinh vuot qua bai test dau vao

SELECT 
    MONTH(Birth_Date) AS Thang,
    COUNT(traineeID) AS So_Luong,
    GROUP_CONCAT(Full_Name SEPARATOR ' - ') AS TEN
FROM
    trainee
GROUP BY MONTH(Birth_Date);


-- Thuc tap sinh co ten dai nhat

SELECT 
	traineeID, Full_Name
FROM
    trainee
WHERE LENGTH(Full_Name)=(SELECT MAX(LENGTH(Full_Name)) FROM trainee);

-- Lay ra thuc tap sinh la ET

SELECT 
    traineeID, Full_Name, Birth_Date 
FROM
    trainee
WHERE
    ET_IQ >= 8 
    AND ((ET_IQ+ET_Gmath)>=15)
    AND ET_Gmath >= 8
	AND ET_English >= 18;


-- Xoa thuc tap sinh co id=3

DELETE FROM trainee WHERE traineeID=3;

-- chuyen thuc tap sinh co id=5 sang lop 2

UPDATE trainee 
SET 
    Training_Class = '2'
WHERE
    traineeID = 2;
    
    
select * FROM trainee;


