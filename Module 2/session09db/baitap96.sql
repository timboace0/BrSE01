DELIMITER $$
CREATE PROCEDURE add_order(
	IN _customer_id INT,
    IN _product_id INT,
    IN _quantity INT,
    OUT _message VARCHAR(100)
)
BEGIN
	DECLARE p_stock INT;
	DECLARE	p_price FLOAT;
    
    SELECT stock INTO p_stock 
    FROM products
    WHERE product_id = _product_id;
    
    SELECT price INTO p_price 
    FROM products
    WHERE product_id = _product_id;
    
    IF _quantity <= p_stock THEN
    INSERT INTO orders(customer_id, product_id, quantity, total_amount, status)
    VALUES(_customer_id, _product_id, _quantity,p_price * _quantity, "Success");
    
    UPDATE products
    SET stock = stock - _quantity
    WHERE product_id = _product_id;
    
	SET _message = "Thêm đơn hàng thành công!";
    ELSE 
    SET _message = "Không đủ số lượng sản phẩm để đặt hàng";
    END IF;
END $$ 
DELIMITER ;

SET @message = '';
CALL add_order(1,1,5,@message);
SELECT @message AS result_message;