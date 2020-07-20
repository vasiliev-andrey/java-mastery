CREATE DATABASE employeedb;

CREATE TABLE `employeedb`.`employee` (
  `employee_id` INT AUTO_INCREMENT,
  `first_name` VARCHAR(25),
  `last_name` VARCHAR(25),
  `department_id` INT,
  `job_title` VARCHAR(25),
  `gender` VARCHAR(10),
  PRIMARY KEY (`employee_id`));


INSERT INTO
    `employeedb`.`employee`(employee_id, first_name, last_name, department_id, job_title, gender)
VALUES
    ( 1 , 'John', 'Smith', 100, 'CEO', 'MALE' ),
    ( 2 , 'Jack', 'Williams', 100, 'CTO', 'MALE' ),
    ( 3 , 'Mark', 'Davis', 101, 'Senior engineer', 'MALE' ),
    ( 4 , 'Mary', 'Anderson', 101, 'Engineer', 'FEMALE' ),
    ( 5 , 'Helen', 'Harris', 102, 'QA engineer', 'FEMALE' );
  
