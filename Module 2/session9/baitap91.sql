CREATE DATABASE InventoryManagement;

USE InventoryManagement;

CREATE TABLE products(
	productID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    productName VARCHAR(100) NOT NULL,
    quantity INT CHECK(quantity > 0)
);

CREATE TABLE inventoryChanges(
	changeID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    productID INT,
    FOREIGN KEY (productID) REFERENCES products(productID),
    oldQuantity INT,
    newQuantity INT,
    changeDate DATETIME
);

DELIMITER $$
CREATE TRIGGER afterProductUpdate 
AFTER UPDATE
ON products 
FOR EACH ROW
BEGIN
	INSERT INTO inventoryChanges(productID, oldQuantity, newQuantity, changeDate)
    VALUES(NEW.productID, OLD.quantity, NEW.quantity, NOW());
END $$
	DELIMITER ;
	
INSERT INTO products(productName, quantity)
VALUES
('Laptop', 10);

UPDATE products
SET quantity = 20
WHERE productID = 1;

SELECT *
FROM inventoryChanges;