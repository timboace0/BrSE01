-- HIỂN THỊ MÃ ĐƠN, NGÀY ĐẶT, TÊN KH
SELECT o.order_id, o.order_date, c.customer_name
FROM orders o
INNER JOIN customers c
ON o.customer_id = c.customer_id;

-- DANH SÁCH SẢN PHẨM TRONG MỖI ĐƠN HÀNG
SELECT o.order_id AS 'Đơn Hàng', oi.product_name
FROM orders o 
INNER JOIN order_items oi
ON o.order_id = oi.order_id;

-- TỔNG TIỀN MỖI ĐƠN HÀNG
SELECT o.order_id AS 'Đơn Hàng', 
SUM(oi.quantity * oi.price) AS 'Tổng Tiền'
FROM orders o 
INNER JOIN order_items oi
ON o.order_id = oi.order_id
GROUP BY o.order_id;

-- ĐƠN HÀNG CÓ TỔNG TIỀN > 10TR
SELECT o.order_id AS 'Đơn Hàng', 
SUM(oi.quantity * oi.price) AS 'Tổng Tiền'
FROM orders o 
INNER JOIN order_items oi
ON o.order_id = oi.order_id
GROUP BY o.order_id
HAVING SUM(oi.quantity * oi.price) > 10000000;