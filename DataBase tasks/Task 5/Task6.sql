/*
 * Pls create this tables with relation
	----------------------------------------
	create Teacher with 
	id name salary
	
	create Language with
	id name 
	
	Teacher has only Language
	Language has many Teacher
 */
CREATE TABLE Teacher (
	id 			NUMBER PRIMARY KEY,
	name		VARCHAR2(50) NOT NULL,
	salary		NUMBER(10,2) NOT NULL	
);

CREATE TABLE Language (
	id 			NUMBER PRIMARY KEY,
	name		VARCHAR2(50) NOT NULL,
	Teacher_ID		NUMBER,
	CONSTRAINT teacher_id_fk FOREIGN KEY (Teacher_ID) REFERENCES Teacher (id)
);


DROP TABLE Teacher;
DROP TABLE Language;