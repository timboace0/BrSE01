-- Thêm một đơn hàng mới vào bảng orders và chi tiết của đơn hàng đó vào bảng order_details.
INSERT INTO orders(customer_id, order_date)
VALUES (2, '2026-07-15');

INSERT INTO order_details(order_id, product_id, quantity, price)
VALUES
(7, 'P0004', 1, 1520),
(7, 'P0013', 2, 4000);
-- Tính tổng doanh thu của toàn bộ cửa hàng.
SELECT SUM(quantity * price) AS 'TỔNG DOANH THU'
FROM order_details;
-- Tính doanh thu trung bình của mỗi đơn hàng.
SELECT AVG(total_amount) AS 'DOANH THU TB'
FROM (
    SELECT
        order_id,
        SUM(quantity * price) AS total_amount
    FROM order_details
    GROUP BY order_id
) as avg_table;
-- Tìm và hiển thị thông tin của đơn hàng có doanh thu cao nhất.
SELECT
    o.order_id,
    o.customer_id,
    o.order_date,
    SUM(od.quantity * od.price) AS total_amount
FROM orders o
JOIN order_details od
ON o.order_id = od.order_id
GROUP BY o.order_id, o.customer_id, o.order_date
ORDER BY total_amount DESC
LIMIT 1;
-- Tìm và hiển thị danh sách 3 sản phẩm bán chạy nhất dựa trên tổng số lượng đã bán.
SELECT
    p.product_name AS 'SẢN PHẨM',
    SUM(od.quantity) AS 'TỔNG ĐÃ BÁN'
FROM products p
INNER JOIN order_details od
ON p.product_id = od.product_id
GROUP BY p.product_id, p.product_name
ORDER BY SUM(od.quantity) DESC
LIMIT 3;