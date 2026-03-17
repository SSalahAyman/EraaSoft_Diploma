-- create table Manager contain (id, name , age , birth_date , address)
CREATE TABLE Manager(
  id                NUMBER(3),
  name              VARCHAR2(100),
  age               NUMBER(3),
  address           VARCHAR2(255),
  birth_date        DATE
);

-- alter table manger drop address column
ALTER TABLE Manager DROP COLUMN address;

-- alter table manger add column (city_address, street)
ALTER TABLE Manager ADD (city_address VARCHAR2(10), street VARCHAR2(50));

-- modify column name to full_name
ALTER TABLE Manager RENAME COLUMN name TO full_name;

-- make this table(Manager) just for read
ALTER TABLE Manager READ ONLY;

-- create table same as Manger with name Owner just has colum id, name, birth_date 
CREATE TABLE Owner AS SELECT id, full_name name, birth_date FROM Manager;

-- rename manger table name to Master
ALTER TABLE Manager RENAME TO Master;

SELECT * FROM Manager;
SELECT * FROM Owner;
