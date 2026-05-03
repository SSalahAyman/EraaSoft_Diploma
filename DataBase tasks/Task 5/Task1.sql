/* 1.
 * create Player table with
 * id name age
- make id not null
- make id unique
- make name unique
 */
CREATE TABLE Player (
	id       NUMBER NOT NULL UNIQUE,
	name     VARCHAR2(50) UNIQUE,
	age		 NUMBER
);

/* 2.
 * create Manger with
 * id name salary
-id must be not null
-id and name must be unique together
*/
CREATE TABLE Manger (
	id 			NUMBER NOT NULL,
	name		VARCHAR2(50),
	salary		NUMBER(10,2),
	
	CONSTRAINT uq_manager_id_name UNIQUE (id,name)
);

/* 3.
 * create Manger with
 * id name age
make id not null and unique (Primary Key)
*/
CREATE TABLE Manger (
	id 			NUMBER PRIMARY KEY,
	name		VARCHAR2(50),
	salary		NUMBER(10,2)
);





DROP TABLE player;
DROP TABLE Manger;