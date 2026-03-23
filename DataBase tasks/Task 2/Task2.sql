-- create Employees table wiith column ( EmployeeID, FirstName, LastName, Department, Salary )
CREATE TABLE Employees_copy (
EmployeeID      NUMBER(3),
FirstName       VARCHAR2(100),
LastName        VARCHAR2(100),
Departmant      VARCHAR2(10),
Salary          NUMBER(8)
);


-- Insert a new records into the Employees table.
INSERT INTO Employees_copy VALUES (101, 'John1', 'Doe1', 'HR', 20000);
INSERT INTO Employees_copy VALUES (102, 'John2', 'Doe2', 'IT', 50000);
INSERT INTO Employees_copy VALUES (103, 'John3', 'Doe3', 'CS', 40000);
INSERT INTO Employees_copy VALUES (104, 'John4', 'Doe4', 'IT', 10000);
INSERT INTO Employees_copy VALUES (105, 'John5', 'Doe5', 'ZX', 30000);

-- Update the salary of an employee to 600000 with EmployeeID  101.
UPDATE Employees_copy SET salary = 600000 WHERE EmployeeID = 101;

-- Delete a record of an employee who EmployeeID = '101'
DELETE Employees_copy WHERE EmployeeID = 101;

-- Retrieve all employees in the IT department.
SELECT * FROM employees_copy WHERE Departmant ='IT';

-- select * data from table but conatination  FirstName, LastName as one column
SELECT EmployeeID, FirstName ||'  '||LastName AS FullName , Departmant, Salary FROM employees_copy;





---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- used it only to view the table after every change
SELECT * FROM Employees_copy;

-- -- drop table     
DROP TABLE Employees_copy;