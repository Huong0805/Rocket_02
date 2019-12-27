-- Cau 1: lấy thông tin "Name" từ bảng Production.Product có name của ProductSubcategory là 'Saddles'.

SELECT 
    p.Name
FROM
    Product p
WHERE
    p.ProductSubcategoryID IN (SELECT ProductSubcategoryID
								FROM ProductSubcategory psc
								WHERE psc.Name = 'Saddles');
                                    
                                    
                                    
-- Cau 2: Mệnh đề WHERE trong subquery sẽ sử dụng ký tự wildcard ‘Bo%’ 
    
SELECT 
    p.Name
FROM
    Product p
WHERE
    p.ProductModelID IN (SELECT ProductModelID
								FROM productmodel pm
								WHERE pm.Name LIKE '%Bo%');
                                
-- Cau 3: trả về tất cả các sản phẩm có giá rẻ nhất (lowest ListPrice) và Touring Bikes (nghĩa là ProductSubcategoryID = 3)
SELECT 
    p.Name
FROM
    Product p
WHERE p.ProductSubcategoryID = (SELECT ProductSubcategoryID
								FROM   ProductSubcategory psc
								WHERE  psc.Name = 'Touring Bikes')
AND   ListPrice = 	(SELECT MIN(ListPrice) 
					 FROM Product 
                     WHERE ProductSubcategoryID=3);
                     
                     
-- Exercise 2: Join nhieu bang

-- Q1: lấy danh sách tên country và province

SELECT c.Name AS Country, s.Name AS Province
FROM countryregion c
JOIN stateprovince s ON c.CountryRegionCode=s.CountryRegionCode;

-- Q2: Tiếp tục với câu query trước và thêm điều kiện là chỉ lấy country Germany và Canada
SELECT c.Name AS Country, s.Name AS Province
FROM countryregion c
JOIN stateprovince s ON c.CountryRegionCode=s.CountryRegionCode
WHERE c.Name IN ('Germany', 'Canada');

/* Q3: Lay ra thong tin SalesOrderID, OrderDate and SalesPersonID. 
	Từ bảng SalesPerson, lấy cột BusinessEntityID (là định danh của người sales), Bonus and the SalesYTD*/
SELECT 
    SO.SalesOrderID,
    SO.OrderDate,
    SO.SalesPersonID AS BusinessEntityID,
    SP.SalesPersonID AS BusinessEntityID,
    SP.Bonus,
    SP.SalesYTD
FROM
    SalesPerson SP
        JOIN
    SalesOrderHeader SO ON SP.SalesPersonID = SO.SalesPersonID;
    
-- Q4:  Thêm cột JobTitle and xóa cột SalesPersonID và BusinessEntityID. 
SELECT 
    SO.SalesOrderID,
    SO.OrderDate,
    SP.Bonus,
    SP.SalesYTD,
    E.Title
FROM
    SalesPerson SP
JOIN
    Employee E ON SP.SalesPersonID = E.EmployeeID
JOIN
    SalesOrderHeader SO ON SP.SalesPersonID = SO.SalesPersonID;

