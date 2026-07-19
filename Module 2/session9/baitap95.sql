CREATE TABLE orders(
    id INT PRIMARY KEY AUTO_INCREMENT,
    customer_name VARCHAR(100),
    total_amount DECIMAL(10,2),
    order_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(50)
);

CREATE TABLE order_logs(
    log_id INT PRIMARY KEY AUTO_INCREMENT,
    order_id INT,
    old_status VARCHAR(50),
    new_status VARCHAR(50),
    log_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (order_id) REFERENCES orders(id)
);

INSERT INTO orders(customer_name, total_amount, status)
VALUES
('Nguyen Van A', 250000.00, 'Pending'),
('Tran Thi B', 780000.00, 'Shipping'),
('Le Van C', 1200000.00, 'Completed'),
('Pham Thi D', 450000.00, 'Pending'),
('Hoang Van E', 990000.00, 'Cancelled');

DELIMITER $$
CREATE TRIGGER after_order_status_update 
AFTER UPDATE
ON orders
FOR EACH ROW
BEGIN
	IF (OLD.status <> NEW.status) THEN
    INSERT INTO order_logs(order_id, old_status, new_status, log_date)
    VALUES(OLD.id, OLD.status, NEW.status, current_timestamp());
    END IF;
END $$
	DELIMITER ;
    
-- case 1: ĐỔI TRẠNG THÁI (ĐC GHI LOG)
UPDATE orders SET status = 'Shipping' WHERE id = 1;

-- case 2: ĐỔI TÊN (KHÔNG GHI LOG)alter
UPDATE orders SET customer_name = 'Nguyen Van B' WHERE id = 1;

SELECT * FROM order_logs;