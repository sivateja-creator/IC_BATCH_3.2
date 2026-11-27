USE company_management;

CREATE TABLE sales (
    sale_id INT PRIMARY KEY,
    product_name VARCHAR(100),
    category VARCHAR(50),
    quantity INT,
    price DECIMAL(10,2),
    sale_date DATE
);

INSERT INTO sales
(sale_id, product_name, category, quantity, price, sale_date)
VALUES
(1, 'Laptop', 'Electronics', 5, 55000, '2025-01-01'),
(2, 'Mobile', 'Electronics', 10, 25000, '2025-01-02'),
(3, 'Headphones', 'Electronics', 20, 2000, '2025-01-03'),
(4, 'Office Chair', 'Furniture', 8, 7500, '2025-01-04'),
(5, 'Table', 'Furniture', 5, 12000, '2025-01-05'),
(6, 'Keyboard', 'Electronics', 15, 1500, '2025-01-06'),
(7, 'Mouse', 'Electronics', 25, 800, '2025-01-07'),
(8, 'Sofa', 'Furniture', 4, 30000, '2025-01-08'),
(9, 'Smart Watch', 'Electronics', 12, 5000, '2025-01-09'),
(10, 'Bed', 'Furniture', 3, 40000, '2025-01-10'),
(11, 'Backpack', 'Accessories', 20, 1800, '2025-01-11'),
(12, 'Water Bottle', 'Accessories', 30, 500, '2025-01-12'),
(13, 'Monitor', 'Electronics', 6, 15000, '2025-01-13'),
(14, 'Dining Table', 'Furniture', 4, 18000, '2025-01-14'),
(15, 'Printer', 'Electronics', 7, 12000, '2025-01-15');

SELECT COUNT(*) AS total_sales
FROM sales;

SELECT SUM(quantity) AS total_quantity_sold
FROM sales;

SELECT AVG(price) AS average_product_price
FROM sales;

SELECT MAX(price) AS highest_price,
       MIN(price) AS lowest_price
FROM sales;

SELECT category,
       SUM(quantity * price) AS total_sales_amount
FROM sales
GROUP BY category;

SELECT category,
       COUNT(*) AS total_sales
FROM sales
GROUP BY category;

SELECT category,
       SUM(quantity * price) AS total_sales_amount
FROM sales
GROUP BY category
HAVING SUM(quantity * price) > 50000;