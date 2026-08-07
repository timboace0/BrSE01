/* Tạo Trigger kiểm tra số lượng tồn kho trước khi thêm 
sản phẩm vào order_items. Nếu không đủ, 
báo lỗi SQLSTATE '45000'.
*/
DELIMITER $$
CREATE TRIGGER before_insert_order_items 
BEFORE INSERT
ON order_items
FOR EACH ROW
BEGIN
DECLARE p_stock INT;
SELECT stock_quantity INTO p_stock
FROM inventory
WHERE product_id = NEW.product_id; 
IF p_stock IS NULL OR p_stock < NEW.quantity THEN 
SIGNAL SQLSTATE '45000' 
SET message_text = 'số lượng không đủ!';
END IF;
END $$ 
DELIMITER ;

/* 
Tạo Trigger cập nhật total_amount trong bảng orders 
sau khi thêm một sản phẩm mới vào order_items.
*/
DELIMITER $$
CREATE TRIGGER after_insert_order_items 
AFTER INSERT
ON order_items
FOR EACH ROW
BEGIN

UPDATE orders
SET total_amount =
(
SELECT SUM(quantity*price)
FROM order_items
WHERE order_id=NEW.order_id
)
WHERE order_id=NEW.order_id;

END $$ 
DELIMITER ;

/* 
Tạo Trigger kiểm tra số lượng tồn kho trước khi cập nhật
số lượng sản phẩm trong order_items. 
Nếu không đủ, báo lỗi SQLSTATE '45000'.
*/

DELIMITER $$
CREATE TRIGGER before_update_order_items 
BEFORE UPDATE
ON order_items
FOR EACH ROW
BEGIN

DECLARE p_stock INT;
SELECT stock_quantity INTO p_stock
FROM inventory
WHERE product_id = NEW.product_id; 
IF p_stock < NEW.quantity THEN 
SIGNAL SQLSTATE '45000' SET message_text = 'số lượng không đủ!';
END IF;

END $$ 
DELIMITER ;

/* 
Tạo Trigger cập nhật lại total_amount trong bảng orders 
khi số lượng hoặc giá của một sản phẩm trong order_items
thay đổi.
*/

DELIMITER $$
CREATE TRIGGER after_update_order_items 
AFTER UPDATE
ON order_items
FOR EACH ROW
BEGIN

UPDATE orders
SET total_amount=
(
SELECT SUM(quantity*price)
FROM order_items
WHERE order_id=NEW.order_id
)
WHERE order_id=NEW.order_id;

END $$ 
DELIMITER ;

/*
Tạo Trigger ngăn chặn việc xóa một đơn hàng có trạng thái
Completed trong bảng orders. Nếu cố gắng xóa, báo lỗi 
SQLSTATE '45000'.
*/
DELIMITER $$
CREATE TRIGGER before_delete_orders
BEFORE DELETE
ON orders
FOR EACH ROW
BEGIN

IF OLD.status = 'Completed' THEN
SIGNAL SQLSTATE '45000' SET message_text = 'Không thể xóa đơn hàng đã hoàn thành!';
END IF;
END $$ 
DELIMITER ;

/*
Tạo Trigger hoàn trả số lượng sản phẩm vào kho 
(inventory) sau khi một sản phẩm trong order_items 
bị xóa.
*/
DELIMITER $$
CREATE TRIGGER after_delete_order_items
AFTER DELETE
ON order_items
FOR EACH ROW
BEGIN

UPDATE inventory 
SET stock_quantity = stock_quantity + OLD.quantity
WHERE product_id = OLD.product_id;

END $$ 
DELIMITER ;

-- xóa trigger vừa tạo
DROP TRIGGER before_insert_order_items;
DROP TRIGGER after_insert_order_items;
DROP TRIGGER before_update_order_items; 
DROP TRIGGER after_update_order_items; 
DROP TRIGGER before_delete_orders;
DROP TRIGGER after_delete_order_items;