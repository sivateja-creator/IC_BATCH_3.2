USE company_management;

CREATE TABLE products (
    product_id INT PRIMARY KEY,
    product_name VARCHAR(100),
    category VARCHAR(50),
    price DECIMAL(10,2),
    stock_quantity INT
);

INSERT INTO products
(product_id, product_name, category, price, stock_quantity)
VALUES
(1, 'Laptop', 'Electronics', 55000, 8),
(2, 'Mobile', 'Electronics', 25000, 15),
(3, 'Headphones', 'Electronics', 2000, 25),
(4, 'Keyboard', 'Electronics', 1500, 5),
(5, 'Mouse', 'Electronics', 800, 30),
(6, 'Office Chair', 'Furniture', 7500, 7),
(7, 'Table', 'Furniture', 12000, 12),
(8, 'Backpack', 'Accessories', 1800, 9),
(9, 'Smart Watch', 'Electronics', 5000, 6),
(10, 'Water Bottle', 'Accessories', 500, 40);

SELECT *
FROM products
ORDER BY price ASC;

SELECT *
FROM products
ORDER BY price DESC;

SELECT *
FROM products
ORDER BY price DESC
LIMIT 5;

SELECT *
FROM products
WHERE stock_quantity < 10;

SELECT *
FROM products
ORDER BY price ASC
LIMIT 3;

SELECT *
FROM products
WHERE category = 'Electronics'
ORDER BY price ASC;