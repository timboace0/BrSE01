CREATE TABLE products(
	product_id VARCHAR(50) PRIMARY KEY NOT NULL,
    product_name VARCHAR(50) NOT NULL,
    category VARCHAR(50) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    quantity INT NOT NULL CHECK(quantity >= 0)
);

INSERT INTO products
VALUES
('PR001', 'Dell Inspiron 15', 'Laptop', 12500000.00, 12),
('PR002', 'MacBook Air M3', 'Laptop', 28990000.00, 8),
('PR003', 'iPhone 15', 'Phone', 13990000.00, 20),
('PR004', 'Samsung Galaxy S24', 'Phone', 19990000.00, 15),
('PR005', 'Tablet Xiaomi Pro 6', 'Tablet', 10500000.00, 10),
('PR006', 'Logitech MX Master 3S', 'Accessory', 2490000.00, 30);

-- Hiển thị sản phẩm có giá từ 5.000.000 đến 15.000.000
SELECT * FROM products
WHERE price >= 5000000 AND price <= 15000000;

-- Hiển thị sản phẩm thuộc loại Laptop hoặc Tablet
SELECT * FROM products
WHERE category IN('Laptop','Tablet');

-- Hiển thị sản phẩm có tên bắt đầu bằng “Sam”
SELECT * FROM products
WHERE product_name LIKE 'Sam%';

-- Hiển thị sản phẩm không thuộc loại Phone
SELECT * FROM products
WHERE category NOT IN('Phone');

-- Giảm giá 5% cho các sản phẩm thuộc loại Laptop
UPDATE products
SET price = price - price * 0.05
WHERE category = 'Laptop';
SELECT * FROM products;

-- Xóa các sản phẩm có số lượng tồn kho bằng 0
DELETE FROM products
WHERE quantity = 0;
SELECT * FROM products