USE company_management;

-- 1. Employees whose salary is greater than ₹30,000
SELECT *
FROM employees
WHERE salary > 30000;


-- 2. Employees whose salary is less than ₹50,000
SELECT *
FROM employees
WHERE salary < 50000;


-- 3. Employees whose salary is exactly ₹40,000
SELECT *
FROM employees
WHERE salary = 40000;


-- 4. IT employees with salary above ₹35,000
SELECT *
FROM employees
WHERE department = 'IT'
AND salary > 35000;


-- 5. Employees working in HR or Finance
SELECT *
FROM employees
WHERE department = 'HR'
OR department = 'Finance';


-- 6. Employees who are not working in IT
SELECT *
FROM employees
WHERE NOT department = 'IT';


-- 7. Employees whose age is between 22 and 30
SELECT *
FROM employees
WHERE age BETWEEN 22 AND 30;