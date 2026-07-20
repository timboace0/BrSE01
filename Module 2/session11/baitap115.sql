DELIMITER $$
CREATE PROCEDURE place_order(
		p_product_id INT,
        p_quantity INT
)

BEGIN
	DECLARE stock_product INT;
	DECLARE	product_price DECIMAL(10,2);
    
    DECLARE EXIT HANDLER FOR SQLEXCEPTION 
	BEGIN
		ROLLBACK;
		SELECT 'Xử lý thất bại' AS Message;
	END;
    
    START TRANSACTION;
    
    SELECT stock INTO stock_product FROM products
    WHERE id = p_product_id;
    
    SELECT price INTO product_price FROM products
    WHERE id = p_product_id;
		
	IF stock_product >= p_quantity THEN
		UPDATE products 
		SET stock = stock - p_quantity;
		
		INSERT INTO orders(product_id,quantity,total_price,order_date)
		VALUES(p_product_id,p_quantity,product_price * p_quantity, current_timestamp());
		
		COMMIT;
		SELECT 'Giao dịch thành công' AS Message;
    
    ELSE 
		ROLLBACK;
        SELECT 'Số lượng hàng không đủ' AS Message;
	END IF;
	
END $$
	DELIMITER ;
    
SELECT * FROM products;

CALL place_order(1,2);

CALL place_order(1,20);