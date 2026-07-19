DELIMITER $$
CREATE TRIGGER beforeProductDelete
BEFORE DELETE
ON products
FOR EACH ROW
BEGIN
	IF (OLD.quantity > 10) THEN 
		SIGNAL SQLSTATE '45000' SET message_text = 'Số lượng sp lớn hơn 10 không được xóa';
    END IF;
END $$
	DELIMITER ;
    
DELETE FROM products
WHERE productID = 1;