-- HIỂN THỊ MÃ ĐH, TÊN KH, TỔNG TIỀN MỖI ĐƠN
SELECT o.order_id AS 'Mã ĐH',
c.customer_name AS 'Tên KH', 
SUM(oi.price * oi.quantity) AS 'Tổng Tiền'
FROM orders o
INNER JOIN customers c
ON o.customer_id = c.customer_id
INNER JOIN order_items oi
ON o.order_id = oi.order_id
GROUP BY o.order_id, c.customer_name;

-- TỔNG DOANH THU MỖI KH
SELECT c.customer_name AS 'Tên KH',
SUM(oi.price * oi.quantity) AS 'Doanh Thu'
FROM customers c
JOIN orders o 
ON c.customer_id = o.customer_id
JOIN order_items oi
ON o.order_id = oi.order_id
GROUP BY c.customer_name;

-- TỔNG DOANH THU > 20TR
SELECT c.customer_name AS 'Tên KH',
SUM(oi.price * oi.quantity) AS 'Doanh Thu'
FROM customers c
JOIN orders o 
ON c.customer_id = o.customer_id
JOIN order_items oi
ON o.order_id = oi.order_id
GROUP BY c.customer_name
HAVING SUM(oi.price * oi.quantity) > 20000000;

-- KHÁCH HÀNG DOANH THU CAO NHẤT
SELECT c.customer_name AS 'Tên KH',
SUM(oi.price * oi.quantity) AS 'Doanh Thu'
FROM customers c
JOIN orders o 
ON c.customer_id = o.customer_id
JOIN order_items oi
ON o.order_id = oi.order_id
GROUP BY c.customer_name
ORDER BY SUM(oi.price * oi.quantity) DESC LIMIT 1;
