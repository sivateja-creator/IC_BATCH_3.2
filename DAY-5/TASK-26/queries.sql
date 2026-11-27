USE company_management;

CREATE TABLE customers (
    customer_id INT PRIMARY KEY,
    customer_name VARCHAR(100),
    age INT,
    city VARCHAR(50),
    registration_date DATE
);

INSERT INTO customers
(customer_id, customer_name, age, city, registration_date)
VALUES
(1, 'Arun', 22, 'Bangalore', '2025-01-10'),
(2, 'Ananya', 25, 'Chennai', '2025-02-15'),
(3, 'Kiran', 28, 'Mysore', '2025-03-20'),
(4, 'Sneha', 24, 'Mumbai', '2025-04-05'),
(5, 'Rahul', 30, 'Delhi', '2025-05-12'),
(6, 'Priya', 21, 'Bangalore', '2025-06-18'),
(7, 'Varun', 27, 'Mysore', '2025-07-22'),
(8, 'Meena', 23, 'Chennai', '2025-08-14'),
(9, 'Anil', 26, 'Mumbai', '2025-09-09'),
(10, 'Divya', 29, 'Hyderabad', '2025-10-11');

SELECT *
FROM customers
WHERE customer_name LIKE 'A%';

SELECT *
FROM customers
WHERE customer_name LIKE '%a';

SELECT *
FROM customers
WHERE customer_name LIKE '%an%';

SELECT *
FROM customers
WHERE city IN ('Bangalore', 'Mysore', 'Chennai');

SELECT *
FROM customers
WHERE age BETWEEN 20 AND 30;

SELECT *
FROM customers
WHERE city LIKE 'M%';