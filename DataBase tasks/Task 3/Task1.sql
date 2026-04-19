-- 1. Find all employee where the emp_id is within a certain range  100  and  105.
SELECT * FROM employees WHERE EMPLOYEE_ID  BETWEEN 100 AND 105;

-- 2. Find all employee that belong to a specific set of emp_id  151 , 152, 153, 154 , 155.
SELECT * FROM employees WHERE EMPLOYEE_ID IN (151 , 152, 153, 154 , 155);

-- 3. Retrieve all employee where the employee first_name starts with the letter 'P' OR 'p'
SELECT * FROM employees WHERE FIRST_NAME LIKE 'P%' OR FIRST_NAME LIKE 'p%' ;

-- 4. Retrieve all employee where the employee first_name end with the letter 'A' OR 'a'
SELECT * FROM employees WHERE FIRST_NAME LIKE '%A' OR FIRST_NAME LIKE '%a';

-- 5. Retrieve all employee where the employee first_name with the letter 'A' OR 'a'
SELECT * FROM employees WHERE FIRST_NAME LIKE '%A%' OR FIRST_NAME LIKE '%a%';

-- 6. Retrieve all employee where the employee first_name  third char with the letter 'e' OR 'E'
SELECT * FROM employees WHERE FIRST_NAME LIKE '__e%' OR FIRST_NAME LIKE '__E%';

-- 7. Retrieve all employees who don't have a manager assigned (i.e., manager_id is NULL).
SELECT * FROM employees WHERE MANAGER_ID IS NULL;

-- 8. Find all employees who have a manager assigned.
SELECT * FROM employees WHERE MANAGER_ID IS NOT NULL;

-- 9. Insert a new employee without assigning a manager (NULL value for manager_id).

-- 10. Find all employees who work either in the 'AD_VP' JOB_ID or the 'IT_PROG' JOB_ID.
SELECT * FROM employees WHERE JOB_ID = 'AD_VP' OR JOB_ID = 'IT_PROG';

-- 11. Retrieve all employees sorted by their last_name in ascending order.
SELECT * FROM employees ORDER BY last_name ASC;

-- 12. Retrieve all employees sorted by their hire_date in descending order.
SELECT * FROM employees ORDER BY hire_date DESC;

-- 13. Sort employees first by department in ascending order and then by salary in descending order within each department_id.
SELECT * FROM employees ORDER BY DEPARTMENT_ID ASC , SALARY DESC;

-- 14. Retrieve all employees with their last_name in lowercase
SELECT EMPLOYEE_ID , FIRST_NAME, LOWER(LAST_NAME) AS LAST_NAME_LOWER , EMAIL FROM employees ;

-- 15. Retrieve all employees with their first_name in uppercase.
SELECT EMPLOYEE_ID , UPPER(FIRST_NAME) AS FIRST_NAME_UPPER , LAST_NAME , EMAIL FROM employees;

-- 16. Retrieve all employees with their first_name and last_name in title case (first letter capitalized).


-- 17. Find employees whose last_name is 'smith', regardless of the case.







