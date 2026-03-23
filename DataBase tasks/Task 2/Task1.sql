-- create table Doctor contain (id, name , salary , address)
CREATE TABLE Doctar (
id         NUMBER(3),
name       VARCHAR2(100),
salary     NUMBER(8),
address    VARCHAR2(255)
);

-- please insert 10 row with Data as you like 
INSERT INTO Doctar (id, name, salary, address) VALUES(1, 'Ahmed Ali', 1000, 'Cairo');
INSERT INTO Doctar (id, name , salary, address) VALUES (2,'Sara Mohamed', 2000, 'Giza');
INSERT INTO Doctar (id, name, salary, address) VALUES (3, 'Omar Hassan', 3000, 'Alexandria');
INSERT INTO Doctar (id, name, salary, address) VALUES (4, 'Mona Samir', 4000, 'Mansoura');
INSERT INTO Doctar (id, name, salary, address) VALUES (5, 'Khaled Ibrahim', 5000, 'Tanta');
INSERT INTO Doctar (id, name, salary, address) VALUES (6, 'Nour ElDin', 2000, 'Aswan');
INSERT INTO Doctar (id, name, salary, address) VALUES (7, 'Youssef Adel', 7000, 'Luxor');
INSERT INTO Doctar (id, name, salary, address) VALUES (8, 'Hala Mahmoud', 8000, 'Zagazig');
INSERT INTO Doctar (id, name, salary, address) VALUES (9, 'Mahmoud Fathy', 9000, 'Fayoum');
INSERT INTO Doctar (id, name, salary, address) VALUES (10, 'Dina Tarek', 10000, 'Suez');

-- update record number 3 with salary 20000
UPDATE Doctar SET salary = 20000 WHERE id = '3';

-- delete record number 9
DELETE Doctar WHERE id ='9';

-- please Concatenation all name with salary of all rows
SELECT id, name ||' - '|| salary AS name_with_salary, address FROM Doctar

-- display all record with salary * 2
SELECT id, name, salary*2 AS double_salary, address FROM Doctar;

-- select all data with salary  1000 , 2000 , 3000 
SELECT * FROM Doctar WHERE Salary IN (1000, 2000, 3000);

-- rename table Doctor to PRD_DOCTOR
ALTER TABLE Doctar RENAME TO PRD_DOCTOR;



---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- used it only to view the two tables after every change
SELECT * FROM Doctar;
SELECT * FROM PRD_DOCTOR;

-- -- drop all tables     
DROP TABLE Doctar;
DROP TABLE PRD_DOCTOR;