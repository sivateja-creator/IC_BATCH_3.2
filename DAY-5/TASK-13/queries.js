USE college_management;

CREATE TABLE departments (
    department_id INT PRIMARY KEY,
    department_name VARCHAR(100)
);

INSERT INTO departments VALUES
(101, 'CSE'),
(102, 'ECE'),
(103, 'IT');

CREATE TABLE employees (
    employee_id INT PRIMARY KEY,
    employee_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE,
    age INT CHECK (age >= 18),
    salary DECIMAL(10,2) DEFAULT 15000,
    department_id INT,
    FOREIGN KEY (department_id) REFERENCES departments(department_id)
);

INSERT INTO employees VALUES
(1, 'Arun', 'arun@gmail.com', 22, 25000, 101),
(2, 'Priya', 'priya@gmail.com', 23, 30000, 102),
(3, 'Rahul', 'rahul@gmail.com', 21, 20000, 103);

INSERT INTO employees
(employee_id, employee_name, email, age, department_id)
VALUES
(4, 'Sneha', 'sneha@gmail.com', 22, 101);

SELECT * FROM employees;

INSERT INTO employees VALUES
(1, 'Kiran', 'kiran@gmail.com', 22, 25000, 101);

INSERT INTO employees VALUES
(5, 'Varun', 'rahul@gmail.com', 22, 25000, 101);

INSERT INTO employees VALUES
(6, NULL, 'test@gmail.com', 22, 25000, 101);

INSERT INTO employees VALUES
(7, 'Meena', 'meena@gmail.com', 16, 25000, 101);