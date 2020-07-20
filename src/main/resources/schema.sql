DROP TABLE  IF EXISTS employee;
CREATE TABLE employee (
    employee_id SERIAL PRIMARY KEY,
    first_name VARCHAR(25) NOT NULL,
    last_name VARCHAR(25) NOT NULL,
    department_id INT NOT NULL,
    job_title VARCHAR(25) NOT NULL,
    gender VARCHAR(10) NOT NULL);