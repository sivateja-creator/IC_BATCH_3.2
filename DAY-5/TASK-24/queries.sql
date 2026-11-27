-- 1. Create database
CREATE DATABASE company_management;

USE company_management;


-- 2. Create employees table
CREATE TABLE employees (
    employee_id INT PRIMARY KEY,
    employee_name VARCHAR(100),
    age INT,
    gender VARCHAR(10),
    department VARCHAR(50),
    salary DECIMAL(10,2),
    city VARCHAR(50)
);


-- 3. Insert 10 employee records
INSERT INTO employees
(employee_id, employee_name, age, gender, department, salary, city)
VALUES
(1, 'Arun', 25, 'Male', 'IT', 35000, 'Bangalore'),
(2, 'Priya', 24, 'Female', 'HR', 30000, 'Chennai'),
(3, 'Rahul', 28, 'Male', 'IT', 45000, 'Hyderabad'),
(4, 'Sneha', 26, 'Female', 'Finance', 40000, 'Tirupati'),
(5, 'Kiran', 30, 'Male', 'Sales', 32000, 'Bangalore'),
(6, 'Divya', 25, 'Female', 'IT', 50000, 'Chennai'),
(7, 'Anil', 29, 'Male', 'HR', 38000, 'Hyderabad'),
(8, 'Meena', 27, 'Female', 'Finance', 42000, 'Mumbai'),
(9, 'Varun', 26, 'Male', 'IT', 37000, 'Delhi'),
(10, 'Suresh', 31, 'Male', 'Sales', 33000, 'Palamaner');


-- 4. Display all employee records
SELECT * FROM employees;


-- 5. Display employee names and salaries
SELECT employee_name, salary
FROM employees;


-- 6. Display unique department names
SELECT DISTINCT department
FROM employees;


-- 7. Display employees working in IT department
SELECT *
FROM employees
WHERE department = 'IT';