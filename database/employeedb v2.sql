CREATE DATABASE employeedb;

DROP TABLE  IF EXISTS employee;
CREATE TABLE employee (
    employee_id SERIAL PRIMARY KEY,
    first_name VARCHAR(25) NOT NULL,
    last_name VARCHAR(25) NOT NULL,
    department_id INT NOT NULL,
    job_title VARCHAR(25) NOT NULL,
    gender VARCHAR(10) NOT NULL);

INSERT INTO
    employee(first_name, last_name, department_id, job_title, gender)
VALUES
( 'John', 'Smith', 100, 'CEO', 'MALE' ),
( 'Jack', 'Williams', 100, 'CTO', 'MALE' ),
( 'Mark', 'Davis', 101, 'Senior engineer', 'MALE' ),
( 'Mary', 'Anderson', 101, 'Engineer', 'FEMALE' ),
( 'Helen', 'Harris', 102, 'QA engineer', 'FEMALE' );

