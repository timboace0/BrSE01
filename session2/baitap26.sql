CREATE TABLE orders(
	orderId INT PRIMARY KEY NOT NULL,
    orderDate DATE NOT NULL,
    `status` ENUM('NEW','PAID') NOT NULL
);

CREATE TABLE products(
	productId INT PRIMARY KEY NOT NULL,
    productName VARCHAR(100) NOT NULL,
    price DECIMAL(19,4) DEFAULT 0.0000 NOT NULL
);

CREATE TABLE order_items(
	orderId INT NOT NULL,
    productId INT NOT NULL,
    quantity INT NOT NULL CHECK (quantity >= 1),
    PRIMARY KEY (orderId,productId),
    FOREIGN KEY (orderId) REFERENCES orders(orderId),
	FOREIGN KEY (productId) REFERENCES products(productId)
);