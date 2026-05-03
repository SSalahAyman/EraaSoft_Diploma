/*
 * Pls create this tables with relation
	----------------------------------------
	create Employee with 
	id name age
	
	create Phone with
	id phoneNumber 
	
	Employee has only Phone
	Phone has only Employee
 */
CREATE TABLE Employee (
	id 			NUMBER PRIMARY KEY,
	name		VARCHAR2(50) NOT NULL,
	age			NUMBER NOT NULL
);

CREATE TABLE Phone (
	id 				NUMBER PRIMARY KEY,
	phoneNumber		VARCHAR2(255) NOT NULL,
	EMPLOYEE_ID		NUMBER UNIQUE, 
	CONSTRAINT EMPLOYEE_id_fk FOREIGN KEY (EMPLOYEE_ID) REFERENCES Employee(id)
);


DROP TABLE Phone;
DROP TABLE Employee;