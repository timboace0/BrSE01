DELIMITER $$
	CREATE PROCEDURE sp_get_products_by_category
				(IN category_IN VARCHAR(50))
BEGIN
	SELECT * FROM products
    WHERE category = category_IN;
END $$ 
DELIMITER ;

CALL sp_get_products_by_category('Laptop');
