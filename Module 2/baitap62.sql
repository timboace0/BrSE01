-- Thêm 2 khách hàng mới vào bảng customers
INSERT INTO customers(customer_name, email)
VALUES
('Nguyễn Văn A','a@gmail.com'),
('Trần Thị B','b@gmail.com');

-- Liệt kê những khách hàng đã có ít nhất một đơn hàng
SELECT c.customer_name AS 'TÊN KH', COUNT(o.order_id) 'SỐ ĐƠN HÀNG'
FROM customers c
INNER JOIN orders o
ON c.customer_id = o.customer_id
GROUP BY c.customer_id, c.customer_name;

-- Tìm những khách hàng chưa từng đặt đơn hàng nào
SELECT c.customer_name AS 'TÊN KH'
FROM customers c
LEFT JOIN orders o
ON c.customer_id = o.customer_id
WHERE o.order_id IS NULL;

-- Tính toán tổng doanh thu mà mỗi khách hàng đã mang lại
SELECT c.customer_name AS 'TÊN KH', 
		SUM(od.quantity * od.price) AS 'DOANH THU'
FROM customers c
INNER JOIN orders o
ON o.customer_id = c.customer_id
INNER JOIN order_details od
ON od.order_id = o.order_id
GROUP BY c.customer_name,c.customer_id;

-- Xác định khách hàng đã mua sản phẩm có giá cao nhất
SELECT DISTINCT c.customer_name AS 'TÊN KH' 
FROM customers c
JOIN orders o
ON c.customer_id = o.customer_id
JOIN order_details od
ON o.order_id = od.order_id
JOIN products p
ON od.product_id = p.product_id
WHERE p.product_price =
(SELECT MAX(product_price) FROM products);
