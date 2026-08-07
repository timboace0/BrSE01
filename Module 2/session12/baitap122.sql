-- 1
DELIMITER $$
CREATE PROCEDURE sp_create_order(
	IN p_customer_id INT,
    IN p_product_id INT,
    IN p_quantity INT,
    IN p_price DECIMAL(10,2)
)
BEGIN
DECLARE p_stock, p_order_id INT;
SELECT stock_quantity INTO p_stock
FROM inventory
WHERE product_id = p_product_id;
START TRANSACTION;
IF p_quantity > p_stock THEN
ROLLBACK;
SIGNAL SQLSTATE '45000' SET message_text =  'Không đủ số lượng tồn kho';
ELSE 
INSERT INTO orders(customer_id, total_amount, status)
VALUES(p_customer_id, p_quantity * p_price, 'Pending');
SET p_order_id = LAST_INSERT_ID();
INSERT INTO order_items(order_id, product_id, quantity, price)
VALUES(p_order_id,p_product_id, p_quantity, p_price);
UPDATE inventory
SET stock_quantity = stock_quantity - p_quantity
WHERE product_id = p_product_id;
COMMIT;
END IF;
END $$ 
DELIMITER ;
-- 2
DELIMITER $$
CREATE PROCEDURE sp_pay_order(
	IN p_order_id INT,
    IN p_payment_method VARCHAR(30)
)
BEGIN
DECLARE p_status ENUM('Pending', 'Completed', 'Cancelled') DEFAULT 'Pending';
DECLARE p_amount DECIMAL(10,2) DEFAULT 0;
SELECT status INTO p_status
FROM orders
WHERE order_id = p_order_id;
SELECT total_amount INTO p_amount
FROM orders
WHERE order_id = p_order_id;
START TRANSACTION;
IF p_status <> 'Pending' THEN
ROLLBACK;
SELECT 'Lỗi trạng thái đơn hàng' AS Message;
ELSE 
INSERT INTO payments(order_id, amount, payment_method)
VALUES(p_order_id, p_amount, p_payment_method);
UPDATE orders
SET status = 'Completed'
WHERE order_id = p_order_id;
COMMIT;
END IF;
END $$ 
DELIMITER ;

-- 3

DELIMITER $$

CREATE PROCEDURE sp_cancel_order(
    IN p_order_id INT
)
BEGIN
    DECLARE p_status VARCHAR(20);
    DECLARE p_product_id INT;
    DECLARE p_quantity INT;

    START TRANSACTION;

    SELECT status
    INTO p_status
    FROM orders
    WHERE order_id = p_order_id;

    IF p_status <> 'Pending' THEN
        ROLLBACK;
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Đơn hàng không thể hủy!';
    ELSE
        SELECT product_id, quantity
        INTO p_product_id, p_quantity
        FROM order_items
        WHERE order_id = p_order_id;
        UPDATE inventory
        SET stock_quantity = stock_quantity + p_quantity
        WHERE product_id = p_product_id;
        DELETE FROM order_items
        WHERE order_id = p_order_id;
        UPDATE orders
        SET status = 'Cancelled'
        WHERE order_id = p_order_id;
        COMMIT;
    END IF;
END $$

DELIMITER ;

-- xóa procedure vừa tạo
DROP PROCEDURE sp_create_order;
DROP PROCEDURE sp_pay_order;
DROP PROCEDURE sp_cancel_order;