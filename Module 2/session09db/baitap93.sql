CREATE TABLE products(
    product_id INT PRIMARY KEY AUTO_INCREMENT,
    product_name VARCHAR(50) NOT NULL,
    price FLOAT NOT NULL CHECK(price > 0),
    stock INT NOT NULL CHECK(stock > 0)
);

INSERT INTO products(product_name, price, stock)
VALUES
('Laptop Dell Inspiron', 18500000, 15),
('Laptop Asus Vivobook', 17200000, 20),
('Laptop HP Pavilion', 19800000, 12),
('Chuot Logitech M331', 350000, 80),
('Ban phim Logitech K120', 250000, 60),
('Man hinh LG 24 inch', 3200000, 18),
('Man hinh Samsung 27 inch', 4800000, 10),
('Tai nghe Sony WH-CH520', 1200000, 25),
('Loa Bluetooth JBL Go 3', 950000, 30),
('USB SanDisk 64GB', 220000, 100),
('SSD Kingston 512GB', 1100000, 35),
('O cung WD 1TB', 1450000, 22),
('Webcam Logitech C920', 1750000, 14),
('May in Canon LBP2900', 3200000, 8),
('Router TP-Link AX1800', 1600000, 16),
('Sac du phong Xiaomi 10000mAh', 550000, 45),
('Cap HDMI 2m', 120000, 70),
('Ban phim co Akko 3087', 1650000, 20),
('Chuot Gaming Razer DeathAdder', 990000, 28),
('Tai nghe Gaming HyperX Cloud II', 2100000, 17);


-- procedure lấy danh sách giá > 1.000.000 vnđ
DELIMITER $$
CREATE PROCEDURE get_high_value_products()
BEGIN
	SELECT *
	FROM products
    WHERE price > 1000000;
END $$ 
DELIMITER ;

CALL get_high_value_products();