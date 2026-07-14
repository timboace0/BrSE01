DELIMITER $$
CREATE PROCEDURE sp_check_order_value
		(IN total_amount_IN decimal(12,2))
BEGIN
	DECLARE note VARCHAR(50);
    IF total_amount_IN > 5000000 THEN
		SET note = 'Đơn hàng giá trị cao';
	ELSE 
		SET note = 'Đơn hàng bình thường';
    END IF;
    
    SELECT note;
END $$ 
DELIMITER ;

CALL sp_check_order_value(2000000.00);
CALL sp_check_order_value(7000000.00);