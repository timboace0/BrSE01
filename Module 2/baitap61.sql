-- Thêm 3 sản phẩm mới vào bảng products
INSERT INTO products(product_id, product_name, product_price, category_id)
VALUES ('P5005', 'Laptop Asus Zenbook 14', 1350, 2),
		('P5006', 'Xiaomi mi 8', 990, 1),
        ('P5007', 'Laptop Zepherus 16', 2000, 2);
  
-- Cập nhật giá của một sản phẩm đã có
UPDATE products
SET product_price = 1150 
WHERE product_id = 'P5006';

-- Xóa một sản phẩm
DELETE FROM products 
WHERE product_id = 'P5005';

-- Hiển thị tất cả sản phẩm, sắp xếp theo giá
SELECT * FROM products p 
ORDER BY p.product_price ;

-- Thống kê số lượng sản phẩm cho từng danh mục
SELECT c.category_id AS 'MÃ DANH MỤC', c.category_name AS 'TÊN DANH MỤC', COUNT(product_id) AS 'SỐ LƯỢNG' 
FROM products p 
INNER JOIN categories c
ON p.category_id = c.category_id
GROUP BY c.category_id,c.category_name;

