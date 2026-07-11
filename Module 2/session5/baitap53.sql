-- HIỂN THỊ SP CÓ GIÁ CAO HƠN GIÁ TB TẤT CẢ SP
SELECT product_name, price FROM products
WHERE price > (
 SELECT AVG(price) FROM products
);

-- HIỂN THỊ SP GIÁ CAO NHẤT TRONG TỪNG LOẠI SP
SELECT product_name, category, price
FROM products AS p1
WHERE price = (
	SELECT max(price)
    FROM products AS p2
    WHERE p2.category = p1.category
);

-- SP THUỘC LOẠI CÓ ÍT NHẤT 1 SP GIÁ TRÊN 20TR

SELECT *
FROM products 
WHERE category IN (
	SELECT category
    FROM products
    GROUP BY category
    HAVING MAX(price) > 20000000
);
