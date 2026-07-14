CREATE VIEW v_order_info
AS
SELECT o.order_id, o.order_date, c.customer_name
FROM orders o
INNER JOIN customers c
ON o.customer_id = c.customer_id;

