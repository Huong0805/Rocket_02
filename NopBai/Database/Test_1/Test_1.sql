-- Cau 1: 
DROP DATABASE IF EXISTS OrderCar;
CREATE DATABASE IF NOT EXISTS OrderCar;
USE OrderCar;

DROP TABLE IF EXISTS Customer;
CREATE TABLE Customer
(
	CustomerID			CHAR(5) PRIMARY KEY,
    Name				VARCHAR(30) NOT NULL,
    Phone				CHAR(10),
    Email				VARCHAR(40),
    Address				VARCHAR(20),
    Note				VARCHAR(30)
);

DROP TABLE IF EXISTS Car;
CREATE TABLE Car
(
	CarID				CHAR(5) PRIMARY KEY,
    Maker				ENUM('Honda', 'Toyota', 'Nissan'),
    Model				VARCHAR(15),
    Year				SMALLINT,
    Color				VARCHAR(10),
    Note				VARCHAR(30)
);

DROP TABLE IF EXISTS CarOrder;
CREATE TABLE CarOrder
(
	OrderID				CHAR(5) PRIMARY KEY,
    CustomerID			CHAR(5),
    CarID				CHAR(5),
    Amount				TINYINT DEFAULT 1,
    SalePrice			FLOAT,
    OrderDate			DATE,
    DeliveryDate		DATE,
    DeliveryAddress		VARCHAR(30),
    Status				ENUM('0', '1', '2') DEFAULT '0',
	Note				VARCHAR(30),
     FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID),
     FOREIGN KEY (CarID) REFERENCES Car(CarID)
);

-- Insert du lieu
INSERT INTO Customer (CustomerID, 		Name	 , 		Phone  , 		Email	  	 , Address	   , 	Note  	)
VALUES 				 ('cm01'	, 'Le Thu Huong' , '0972099925', 'huong@gmail.com'	 , 'Ha Noi'	   , 'Khach quen'),
					 ('cm02'	, 'Le Thu Hang'  , '0972099935', 'huongthu@gmail.com', 'Ha Noi'	   , 'Khach moi'),
                     ('cm03'	, 'Le Viet Thang', '0872099925', 'thang@gmail.com'	 , 'Quang Ninh', 'Khach quen');


INSERT INTO Car		 (CarID		, 	Maker	, 	Model  , 	Year	  	 , Color	   , 	Note  )
VALUES 				 ('cr01'	, 'Honda' 	, 'Grant'  , 	2015		 , 'Red'	   , 'Ban moi'),
					 ('cr02'	, 'Toyota' 	, 'Vious'  , 	2018		 , 'Blue'	   , 'Ban moi'),
					 ('cr03'	, 'Nissan' 	, 'Nissan' , 	2019		 , 'Blue'	   , 'Ban moi'),
					 ('cr04'	, 'Honda' 	, 'Granti'  , 	2015		 , 'Red'	   , 'Ban moi');                 
INSERT INTO CarOrder (OrderID	, CustomerID, CarID	  , 	Amount	 , SalePrice, OrderDate   , DeliveryDate, DeliveryAddress, Status, 	Note 	   )
VALUES 				 ('od01'	, 'cm01' 	, 'cr01'  , 	2		 , 12000    , '2019-12-19', '2019-12-20', 'Cau Giay'	 , 	'0'	 , 'Giao nhanh'),
					 ('od02'	, 'cm02' 	, 'cr02'  , 	1		 , 15000    , '2019-12-19', '2019-12-20', 'Cau Giay'	 , 	'1'	 , 'Giao nhanh'),
					 ('od03'	, 'cm02' 	, 'cr03'  , 	1		 , 20000    , '2018-11-19', '2018-12-20', 'Cau Giay'	 , 	'0'	 , 'Giao nhanh'),
					 ('od04'	, 'cm03' 	, 'cr01'  , 	2		 , 12000    , '2019-12-19', '2019-12-20', 'Cau Giay'	 , 	'2'	 , 'Giao nhanh'),
                     ('od05'	, 'cm03' 	, 'cr03'  , 	2		 , 12000    , '2019-12-19', '2020-01-01', 'Cau Giay'	 , 	'0'	 , 'Giao nhanh'),
                     ('od06'	, 'cm03' 	, 'cr04'  , 	2		 , 12000    , '2019-12-19', '2020-01-01', 'Cau Giay'	 , 	'0'	 , 'Giao nhanh');
		
  -- Cau b: lấy ra thông tin của khách hàng: tên, số lượng oto khách hàng đã mua va sap xep
  
  SELECT cm.Name, SUM(Amount)
  FROM Customer cm 
  JOIN CarOrder od ON cm.CustomerID=od.CustomerID
  GROUP BY (cm.CustomerID)
  ORDER BY  SUM(Amount);
  
  -- Cau c: Viết hàm trả về tên hãng sản xuất đã bán được nhiều oto nhất trong năm nay.
  
 DROP FUNCTION IF EXISTS f_Hang;
 DELIMITER $$
CREATE FUNCTION f_Hang() RETURNS VARCHAR(20)
BEGIN
	DECLARE v_ten VARCHAR(20);
    DECLARE v_max INT;
    DROP TEMPORARY TABLE IF EXISTS f_XeBanNhieuNhat;
	CREATE TEMPORARY TABLE f_XeBanNhieuNhat
	(
		maker			 VARCHAR(20),
		soluong			 TINYINT
	);				
	INSERT INTO f_XeBanNhieuNhat 
	SELECT cr.Maker, SUM(Amount)
    FROM Car cr 
    JOIN CarOrder od ON cr.CarID= od.CarID  
	WHERE od.Status !='2' AND YEAR(OrderDate)=YEAR(CURRENT_DATE())
    GROUP BY(cr.Maker);       
	
    SELECT MAX(soluong) INTO v_max  FROM f_XeBanNhieuNhat;
    
	SELECT maker INTO v_ten  FROM f_XeBanNhieuNhat
	WHERE soluong =v_max;    
    
RETURN  v_ten;
END $$
DELIMITER ;

SELECT f_Hang();

-- Cau d: Viết 1 thủ tục  để xóa các đơn hàng đã bị hủy của những năm trước. In ra số lượng bản ghi đã bị xóa.

DROP PROCEDURE IF EXISTS sp_Xoa;
DELIMITER $$
CREATE PROCEDURE sp_Xoa()
BEGIN
	DROP TEMPORARY TABLE IF EXISTS BiHuy;
	CREATE TEMPORARY TABLE BiHuy
	(
		OrderID			 CHAR(5)
	);				

	INSERT INTO BiHuy 
	SELECT OrderID
	FROM CarOrder
	WHERE Status ='2';

	SELECT COUNT(OrderID) AS num_order FROM BiHuy ;
    
    DELETE FROM CarOrder WHERE OrderID IN (SELECT * FROM BiHuy);
    DROP TEMPORARY TABLE BiHuy;
END $$
DELIMITER ;
  
CALL  sp_Xoa();

-- Cau e: Viết 1 thủ tục (có CustomerID parameter) để in ra thông tin của các đơn hàng đã đặt hàng bao gồm: 

DROP PROCEDURE IF EXISTS sp_ThongTin;
DELIMITER $$
CREATE PROCEDURE sp_ThongTin(IN p_CustomerID CHAR(5))
BEGIN
	SELECT cm.Name, od.OrderID, od.Amount, cr.Maker
    FROM CarOrder od 
    JOIN Customer cm ON od.CustomerID=cm.CustomerID
    JOIN Car cr ON od.CarID=cr.CarID
    WHERE cm.CustomerID=p_CustomerID
    AND od.Status='0';
END $$
DELIMITER ;

CALL  sp_ThongTin('cm03');
                     
-- Cau f: Viết trigger để tránh trường hợp người dụng nhập thông tin không hợp lệ vào database (DeliveryDate < OrderDate + 15).

DROP TRIGGER IF EXISTS before_insert;
DELIMITER $$
CREATE TRIGGER before_insert
BEFORE INSERT ON CarOrder
FOR EACH ROW
BEGIN 
	IF DATEDIFF(NEW.DeliveryDate, NEW.OrderDate) > 15 THEN SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'Thong tin khong hop le';
	 END IF; 
END $$
DELIMITER ;
                     
INSERT INTO CarOrder (OrderID	, CustomerID, CarID	  , 	Amount	 , SalePrice, OrderDate   , DeliveryDate, DeliveryAddress, Status, 	Note 	   )
VALUES 				 ('od07'	, 'cm03' 	, 'cr04'  , 	2		 , 12000    , '2020-1-05', '2020-01-06', 'Cau Giay'	 , 	'0'	 , 'Giao nhanh');
