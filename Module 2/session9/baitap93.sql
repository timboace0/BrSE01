DELIMITER $$
CREATE TRIGGER beforeInsertProduct
BEFORE INSERT 
ON products
FOR EACH ROW 
BEGIN
	IF (NEW.quantity < 0) THEN
		SIGNAL SQLSTATE '45000' SET message_text = 'Không thể INSERT với số lượng < 0';
    END IF;
END $$
	DELIMITER ;
    
INSERT INTO products(productName, quantity)
VALUES('Noi Com Dien', -2);