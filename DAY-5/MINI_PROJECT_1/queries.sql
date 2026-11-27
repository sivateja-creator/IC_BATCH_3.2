CREATE DATABASE shopping_management;

USE shopping_management;

CREATE TABLE products (
    product_id INT PRIMARY KEY,
    product_name VARCHAR(100) NOT NULL,
    category VARCHAR(50) NOT NULL,
    price DECIMAL(10,2) NOT NULL CHECK (price >= 0),
    stock_quantity INT NOT NULL CHECK (stock_quantity >= 0),
    supplier VARCHAR(150),
    created_date DATE,
    discount_percentage DECIMAL(5,2) DEFAULT 0
);

CREATE TABLE customers (
    customer_id INT PRIMARY KEY,
    customer_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    city VARCHAR(50),
    age INT CHECK (age >= 18),
    registration_date DATE,
    mobile_number VARCHAR(15)
);

CREATE TABLE sales (
    sale_id INT PRIMARY KEY,
    customer_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL CHECK (quantity > 0),
    total_amount DECIMAL(10,2) NOT NULL CHECK (total_amount >= 0),
    payment_mode VARCHAR(30) DEFAULT 'UPI',
    sale_date DATE,
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id),
    FOREIGN KEY (product_id) REFERENCES products(product_id)
);

SHOW DATABASES;

USE shopping_management;

SHOW TABLES;

DESC products;
DESC customers;
DESC sales;

INSERT INTO products
(product_id, product_name, category, price, stock_quantity, supplier, created_date)
VALUES
(1, 'Samsung Phone', 'Electronics', 25000, 15, 'Samsung Tech', '2025-01-01'),
(2, 'iPhone', 'Electronics', 65000, 8, 'Apple Tech', '2025-01-02'),
(3, 'Laptop', 'Electronics', 55000, 12, 'Dell Technologies', '2025-01-03'),
(4, 'Headphones', 'Electronics', 2500, 25, 'Sony Tech', '2025-01-04'),
(5, 'Smart Watch', 'Electronics', 5000, 9, 'Boat Tech', '2025-01-05'),
(6, 'Office Chair', 'Furniture', 7500, 10, 'WoodCraft', '2025-01-06'),
(7, 'Dining Table', 'Furniture', 15000, 5, 'HomeStyle', '2025-01-07'),
(8, 'T-Shirt', 'Clothing', 800, 40, 'Fashion Hub', '2025-01-08'),
(9, 'Jeans', 'Clothing', 1800, 20, 'Denim World', '2025-01-09'),
(10, 'Shoes', 'Footwear', 3000, 18, 'Nike Store', '2025-01-10'),
(11, 'Backpack', 'Accessories', 1200, 30, 'Bag World', '2025-01-11'),
(12, 'Keyboard', 'Electronics', 1500, 7, 'Logitech Tech', '2025-01-12'),
(13, 'Monitor', 'Electronics', 12000, 6, 'HP Tech', '2025-01-13'),
(14, 'Water Bottle', 'Accessories', 500, 50, 'Aqua Products', '2025-01-14'),
(15, 'Sofa', 'Furniture', 35000, 4, 'Royal Furniture', '2025-01-15');

INSERT INTO customers
(customer_id, customer_name, email, city, age, registration_date)
VALUES
(1, 'Arun', 'arun@gmail.com', 'Bangalore', 24, '2025-01-01'),
(2, 'Priya', 'priya@gmail.com', 'Chennai', 25, '2025-01-02'),
(3, 'Rahul', 'rahul@gmail.com', 'Mysore', 28, '2025-01-03'),
(4, 'Sneha', 'sneha@gmail.com', 'Hyderabad', 22, '2025-01-04'),
(5, 'Kiran', 'kiran@gmail.com', 'Bangalore', 29, '2025-01-05'),
(6, 'Divya', 'divya@gmail.com', 'Chennai', 26, '2025-01-06'),
(7, 'Anil', 'anil@gmail.com', 'Mysore', 23, '2025-01-07'),
(8, 'Meena', 'meena@gmail.com', 'Mumbai', 27, '2025-01-08'),
(9, 'Varun', 'varun@gmail.com', 'Delhi', 30, '2025-01-09'),
(10, 'Suresh', 'suresh@gmail.com', 'Bangalore', 31, '2025-01-10'),
(11, 'Ananya', 'ananya@gmail.com', 'Chennai', 24, '2025-01-11'),
(12, 'Vijay', 'vijay@gmail.com', 'Hyderabad', 28, '2025-01-12'),
(13, 'Kavya', 'kavya@gmail.com', 'Mysore', 21, '2025-01-13'),
(14, 'Ramesh', 'ramesh@gmail.com', 'Mumbai', 32, '2025-01-14'),
(15, 'Swathi', 'swathi@gmail.com', 'Bangalore', 25, '2025-01-15');

INSERT INTO sales
(sale_id, customer_id, product_id, quantity, total_amount, payment_mode, sale_date)
VALUES
(1, 1, 1, 1, 25000, 'UPI', '2025-01-05'),
(2, 2, 2, 1, 65000, 'Card', '2025-01-06'),
(3, 3, 3, 1, 55000, 'UPI', '2025-01-07'),
(4, 4, 4, 2, 5000, 'Cash', '2025-01-08'),
(5, 5, 5, 1, 5000, 'Card', '2025-01-09'),
(6, 6, 6, 2, 15000, 'UPI', '2025-01-10'),
(7, 7, 7, 1, 15000, 'Card', '2025-01-11'),
(8, 8, 8, 3, 2400, 'Cash', '2025-01-12'),
(9, 9, 9, 2, 3600, 'UPI', '2025-01-13'),
(10, 10, 10, 1, 3000, 'Card', '2025-01-14'),
(11, 11, 11, 2, 2400, 'UPI', '2025-02-01'),
(12, 12, 12, 2, 3000, 'Cash', '2025-02-02'),
(13, 13, 13, 1, 12000, 'Card', '2025-02-03'),
(14, 14, 14, 4, 2000, 'UPI', '2025-02-04'),
(15, 15, 15, 1, 35000, 'Card', '2025-02-05'),
(16, 1, 3, 1, 55000, 'UPI', '2025-02-06'),
(17, 2, 4, 2, 5000, 'Cash', '2025-02-07'),
(18, 3, 1, 1, 25000, 'Card', '2025-02-08'),
(19, 4, 5, 1, 5000, 'UPI', '2025-02-09'),
(20, 5, 6, 1, 7500, 'Cash', '2025-02-10'),
(21, 6, 9, 3, 5400, 'UPI', '2025-03-01'),
(22, 7, 10, 2, 6000, 'Card', '2025-03-02'),
(23, 8, 11, 1, 1200, 'Cash', '2025-03-03'),
(24, 9, 13, 1, 12000, 'UPI', '2025-03-04'),
(25, 10, 1, 2, 50000, 'Card', '2025-03-05');

SELECT * FROM products;
SELECT * FROM customers;
SELECT * FROM sales;

SELECT * FROM products;

SELECT product_name, price FROM products;

SELECT DISTINCT category FROM products;

SELECT * FROM products WHERE price > 5000;

SELECT * FROM products WHERE price < 2000;

SELECT * FROM products WHERE category = 'Electronics';

SELECT * FROM products WHERE stock_quantity < 10;

SELECT * FROM products
WHERE category = 'Electronics' AND price > 10000;

SELECT * FROM products
WHERE category = 'Electronics' OR category = 'Furniture';

SELECT * FROM products
WHERE NOT category = 'Clothing';

SELECT * FROM products WHERE product_name LIKE 'S%';

SELECT * FROM products WHERE product_name LIKE '%e';

SELECT * FROM products WHERE product_name LIKE '%Phone%';

SELECT * FROM customers WHERE customer_name LIKE 'A%';

SELECT * FROM customers
WHERE city IN ('Bangalore', 'Chennai', 'Mysore');

SELECT * FROM products
WHERE price BETWEEN 1000 AND 10000;

SELECT * FROM customers
WHERE age BETWEEN 20 AND 30;

SELECT * FROM products
WHERE supplier LIKE '%Tech%';

SELECT * FROM products ORDER BY price ASC;

SELECT * FROM products ORDER BY price DESC;

SELECT * FROM products ORDER BY price DESC LIMIT 5;

SELECT * FROM products ORDER BY price ASC LIMIT 5;

SELECT * FROM customers ORDER BY customer_name ASC;

SELECT * FROM sales ORDER BY sale_date DESC LIMIT 10;

SELECT * FROM products ORDER BY stock_quantity ASC;

UPDATE products
SET price = 27000
WHERE product_id = 1;

UPDATE products
SET price = price * 1.10
WHERE category = 'Electronics';

UPDATE products
SET stock_quantity = 20
WHERE product_id = 2;

UPDATE customers
SET city = 'Tirupati'
WHERE customer_id = 1;

UPDATE customers
SET email = 'arun_updated@gmail.com'
WHERE customer_id = 1;

UPDATE sales
SET payment_mode = 'UPI'
WHERE sale_id = 1;

START TRANSACTION;

DELETE FROM sales WHERE product_id = 15;
DELETE FROM products WHERE product_id = 15;

ROLLBACK;

START TRANSACTION;

DELETE FROM sales WHERE customer_id = 15;
DELETE FROM customers WHERE customer_id = 15;

ROLLBACK;

START TRANSACTION;

DELETE FROM sales
WHERE sale_date < '2025-02-01';

ROLLBACK;

ALTER TABLE products
ADD discount_percentage DECIMAL(5,2) DEFAULT 0;

ALTER TABLE customers
ADD mobile_number VARCHAR(15);

ALTER TABLE products
MODIFY supplier VARCHAR(150);

ALTER TABLE products
RENAME COLUMN created_date TO product_added_date;

ALTER TABLE products
ADD product_status VARCHAR(20) DEFAULT 'Available';

ALTER TABLE products
DROP COLUMN discount_percentage;

DESC products;
DESC customers;
DESC sales;

SELECT COUNT(*) AS total_products FROM products;

SELECT COUNT(*) AS total_customers FROM customers;

SELECT COUNT(*) AS total_sales FROM sales;

SELECT SUM(total_amount) AS total_revenue FROM sales;

SELECT AVG(price) AS average_product_price FROM products;

SELECT MAX(price) AS highest_product_price FROM products;

SELECT MIN(price) AS lowest_product_price FROM products;

SELECT MAX(total_amount) AS highest_sales_transaction FROM sales;

SELECT SUM(quantity) AS total_quantity_sold FROM sales;

SELECT AVG(total_amount) AS average_sales_value FROM sales;

SELECT category, COUNT(*) AS total_products
FROM products
GROUP BY category;

SELECT category, AVG(price) AS average_price
FROM products
GROUP BY category;

SELECT category, SUM(stock_quantity) AS total_stock
FROM products
GROUP BY category;

SELECT p.category, SUM(s.total_amount) AS total_revenue
FROM products p
INNER JOIN sales s ON p.product_id = s.product_id
GROUP BY p.category;

SELECT payment_mode, COUNT(*) AS total_transactions
FROM sales
GROUP BY payment_mode;

SELECT p.product_name, SUM(s.quantity) AS total_quantity_sold
FROM products p
INNER JOIN sales s ON p.product_id = s.product_id
GROUP BY p.product_id, p.product_name;

SELECT category, COUNT(*) AS total_products
FROM products
GROUP BY category
HAVING COUNT(*) > 3;

SELECT p.product_name, SUM(s.quantity) AS total_sold
FROM products p
INNER JOIN sales s ON p.product_id = s.product_id
GROUP BY p.product_id, p.product_name
HAVING SUM(s.quantity) > 5;

SELECT payment_mode, COUNT(*) AS total_transactions
FROM sales
GROUP BY payment_mode
HAVING COUNT(*) > 5;

SELECT c.customer_name, s.sale_id, s.total_amount, s.sale_date
FROM customers c
INNER JOIN sales s ON c.customer_id = s.customer_id;

SELECT p.product_name, s.quantity
FROM products p
INNER JOIN sales s ON p.product_id = s.product_id;

SELECT c.customer_name, p.product_name, s.total_amount
FROM sales s
INNER JOIN customers c ON s.customer_id = c.customer_id
INNER JOIN products p ON s.product_id = p.product_id;

SELECT c.customer_name, p.product_name
FROM sales s
INNER JOIN customers c ON s.customer_id = c.customer_id
INNER JOIN products p ON s.product_id = p.product_id;

SELECT c.customer_name, s.sale_id, s.total_amount
FROM customers c
LEFT JOIN sales s ON c.customer_id = s.customer_id;

SELECT p.product_name, s.sale_id, s.quantity
FROM products p
LEFT JOIN sales s ON p.product_id = s.product_id;

SELECT s.sale_id, c.customer_name, s.total_amount, s.payment_mode
FROM sales s
RIGHT JOIN customers c ON s.customer_id = c.customer_id;

SELECT c.customer_name, p.product_name, p.category,
       s.quantity, s.payment_mode, s.total_amount
FROM sales s
INNER JOIN customers c ON s.customer_id = c.customer_id
INNER JOIN products p ON s.product_id = p.product_id;

SELECT * FROM products;

SELECT * FROM products WHERE stock_quantity < 10;

SELECT category, COUNT(*) AS total_products
FROM products
GROUP BY category;

SELECT product_name, price
FROM products
WHERE price = (SELECT MAX(price) FROM products)
OR price = (SELECT MIN(price) FROM products);

SELECT * FROM customers;

SELECT s.sale_id, c.customer_name, p.product_name,
       s.quantity, s.total_amount, s.payment_mode, s.sale_date
FROM sales s
INNER JOIN customers c ON s.customer_id = c.customer_id
INNER JOIN products p ON s.product_id = p.product_id;

SELECT SUM(total_amount) AS total_revenue FROM sales;

SELECT payment_mode, SUM(total_amount) AS revenue
FROM sales
GROUP BY payment_mode;

SELECT p.product_name, SUM(s.quantity) AS total_sold
FROM products p
LEFT JOIN sales s ON p.product_id = s.product_id
GROUP BY p.product_id, p.product_name
ORDER BY total_sold DESC;

SELECT c.customer_name, SUM(s.total_amount) AS total_purchases
FROM customers c
INNER JOIN sales s ON c.customer_id = s.customer_id
GROUP BY c.customer_id, c.customer_name;

SELECT p.product_name, SUM(s.total_amount) AS total_revenue
FROM products p
INNER JOIN sales s ON p.product_id = s.product_id
GROUP BY p.product_id, p.product_name
ORDER BY total_revenue DESC
LIMIT 1;

SELECT c.customer_name, s.sale_id, s.total_amount
FROM customers c
INNER JOIN sales s ON c.customer_id = s.customer_id
ORDER BY s.total_amount DESC
LIMIT 1;

SELECT p.product_id, p.product_name
FROM products p
LEFT JOIN sales s ON p.product_id = s.product_id
WHERE s.sale_id IS NULL;

SELECT c.customer_id, c.customer_name
FROM customers c
LEFT JOIN sales s ON c.customer_id = s.customer_id
WHERE s.sale_id IS NULL;

SELECT p.category, SUM(s.total_amount) AS total_revenue
FROM products p
INNER JOIN sales s ON p.product_id = s.product_id
GROUP BY p.category
ORDER BY total_revenue DESC
LIMIT 1;

SELECT * FROM products
WHERE stock_quantity < 5;

SELECT payment_mode, SUM(total_amount) AS total_revenue
FROM sales
GROUP BY payment_mode;

SELECT p.product_name, SUM(s.quantity) AS total_quantity_sold
FROM products p
INNER JOIN sales s ON p.product_id = s.product_id
GROUP BY p.product_id, p.product_name
ORDER BY total_quantity_sold DESC
LIMIT 5;

SELECT c.customer_name, COUNT(DISTINCT s.product_id) AS product_types
FROM customers c
INNER JOIN sales s ON c.customer_id = s.customer_id
GROUP BY c.customer_id, c.customer_name
HAVING COUNT(DISTINCT s.product_id) > 1;

SELECT DATE_FORMAT(sale_date, '%Y-%m') AS sales_month,
       COUNT(*) AS total_transactions,
       SUM(quantity) AS total_quantity,
       SUM(total_amount) AS monthly_revenue,
       AVG(total_amount) AS average_transaction
FROM sales
GROUP BY DATE_FORMAT(sale_date, '%Y-%m')
ORDER BY sales_month;