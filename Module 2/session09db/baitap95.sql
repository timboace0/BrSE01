CREATE TABLE orders(
    order_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_id INT,
    product_id INT,
    quantity INT NOT NULL CHECK(quantity > 0),
    total_amount FLOAT NOT NULL CHECK(total_amount > 0),
    status ENUM('Pending','Success','Cancel') DEFAULT 'Pending',

    FOREIGN KEY(customer_id) REFERENCES customers(customer_id),
    FOREIGN KEY(product_id) REFERENCES products(product_id)
);


INSERT INTO orders(customer_id, product_id, quantity, total_amount, status)
VALUES
(1, 1, 1, 18500000, 'Success'),
(1, 2, 2, 34400000, 'Pending'),
(1, 3, 1, 19800000, 'Success'),
(1, 4, 3, 1050000, 'Cancel'),
(1, 5, 5, 1250000, 'Success'),
(1, 6, 2, 6400000, 'Pending'),
(1, 7, 1, 4800000, 'Success'),
(1, 8, 2, 2400000, 'Pending'),
(1, 9, 4, 3800000, 'Success'),
(1, 10, 5, 1100000, 'Cancel'),
(1, 11, 2, 2200000, 'Success'),
(1, 12, 1, 1450000, 'Pending'),
(1, 13, 3, 5250000, 'Success'),
(1, 14, 1, 3200000, 'Success'),
(1, 15, 2, 3200000, 'Cancel'),
(1, 16, 3, 1650000, 'Pending'),
(1, 17, 4, 480000, 'Success'),
(1, 18, 2, 3300000, 'Pending'),
(1, 19, 1, 990000, 'Success'),
(1, 20, 2, 4200000, 'Success');

CREATE VIEW view_customer_spending
AS 
SELECT c.customer_id, c.customer_name, COUNT(od.order_id) AS 'Total Order', SUM(od.total_amount) AS total_spent
FROM customers c
JOIN orders od
ON c.customer_id = od.customer_id
GROUP BY c.customer_id, c.customer_name;

SELECT * FROM view_customer_spending;