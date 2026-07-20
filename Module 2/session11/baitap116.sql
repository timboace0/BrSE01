DELIMITER $$
CREATE PROCEDURE cancel_order(
	p_order_id INT
)
BEGIN 
	DECLARE order_id INT;
    DECLARE order_status ENUM('Pending', 'Completed', 'Cancelled');
    DECLARE product_order_id INT;
    DECLARE order_quantity INT;
    
    
    SELECT id INTO order_id FROM orders
    WHERE id = p_order_id;
    
    SELECT status INTO order_status FROM orders
    WHERE id = p_order_id;
    
    SELECT product_id INTO product_order_id FROM orders
    WHERE id = p_order_id;
    
    SELECT quantity INTO order_quantity FROM orders
    WHERE id = p_order_id;
    
    START TRANSACTION;
    
    IF order_id IS NULL 
		OR order_status = 'Cancelled'THEN
        ROLLBACK;
        SELECT 'Hủy đơn thất bại' AS Message;
	ELSE
        UPDATE products SET 
		stock = stock + order_quantity
        WHERE id = product_order_id;
        
        UPDATE orders SET 
        status = 'Cancelled'
        WHERE id = p_order_id;
        
		COMMIT;
        SELECT 'Hủy đơn thành công! Đã hoàn tồn kho' AS Message;
    END IF;
    
END $$ 
	DELIMITER ;
    
CALL cancel_order(3);
SELECT * FROM orders;


DROP PROCEDURE cancel_order;
