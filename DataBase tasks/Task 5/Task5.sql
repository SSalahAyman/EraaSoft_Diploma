/*
 * Pls create this tables with relation
----------------------------------------
	create Doctor with 
	id name salary

	create Patient with
	id name age

	doctor has many patient
	patient has many doctor
 */
CREATE TABLE Doctar (
	id 			NUMBER PRIMARY KEY,
	name		VARCHAR2(50) NOT NULL,
	salary		NUMBER(10,2) NOT NULL
);

CREATE TABLE Patient (
	id 			NUMBER PRIMARY KEY,
	name		VARCHAR2(50) NOT NULL,
	age			NUMBER NOT NULL
);


CREATE TABLE Doctar_Patient(
	Doctar_id	NUMBER NOT NULL,
	Patient_id	NUMBER NOT NULL,
	CONSTRAINT  Doctar_id_fk FOREIGN KEY (Doctar_id) REFERENCES Doctar(id),
	CONSTRAINT  Patient_id_fk FOREIGN KEY (Patient_id) REFERENCES Patient(id),
	CONSTRAINT  comp_un_fk UNIQUE (Doctar_id,Patient_id)
);


DROP TABLE Doctar;
DROP TABLE Patient;
DROP TABLE Doctar_Patient;