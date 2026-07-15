-- Tìm các sản phẩm có giá nằm trong một khoảng cụ thể
SELECT * FROM products
WHERE product_price BETWEEN 1000 AND 2000;

-- Tìm các sản phẩm có tên chứa một chuỗi ký tự nhất định
SELECT * FROM products
WHERE product_name LIKE 'Lap%';

-- Tính giá trung bình của sản phẩm cho mỗi danh mục
SELECT c.category_name AS 'DANH MỤC', AVG(product_price) AS 'GIÁ TB'
FROM categories c
INNER JOIN products p
ON c.category_id = p.category_id
GROUP BY c.category_name, c.category_id;

-- Tìm những sản phẩm có giá cao hơn mức giá trung bình của toàn bộ sản phẩm
SELECT * FROM products p 
WHERE p.product_price > (SELECT AVG(p.product_price) FROM products p);

-- Tìm sản phẩm có giá thấp nhất cho từng danh mục
SELECT c.category_name AS 'DANH MỤC',p.product_name AS 'SẢN PHẨM', p.product_price AS 'GIÁ THẤP NHẤT'
FROM categories c
INNER JOIN products p
ON c.category_id = p.category_id
WHERE p.product_price = (
	SELECT MIN(p2.product_price)
    FROM products p2
    WHERE p2.category_id = p.category_id
);
