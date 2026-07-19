CREATE TABLE cart_items(
    id INT PRIMARY KEY AUTO_INCREMENT,
    product_id INT NOT NULL,
    quantity INT NOT NULL CHECK(quantity > 0),

	FOREIGN KEY (product_id) REFERENCES products(productID)
);

DELIMITER $$
CREATE TRIGGER before_cart_add
BEFORE INSERT
ON cart_items
FOR EACH ROW
BEGIN 
	DECLARE stock_quantity INT;
    
    SELECT quantity INTO stock_quantity FROM products
    WHERE productID = NEW.product_id;
    
	IF (NEW.quantity > stock_quantity) THEN
    SIGNAL SQLSTATE '45000' SET message_text = 'Số lượng hàng trong kho không đủ';
    END IF;
END $$
	DELIMITER ; 
    
-- Kiểm thử
INSERT INTO products(productName, quantity)
VALUES
('iPhone 15', 5);
SELECT * FROM products;

-- Case 1: Mua 2 cái (Kho có 5) -> Thành công
INSERT INTO cart_items(product_id, quantity)
VALUES (1, 2);

SELECT * FROM cart_items;

-- Case 2: Mua 10 cái (Kho có 5) -> Báo lỗi
INSERT INTO cart_items(product_id, quantity)
VALUES (1, 10);



