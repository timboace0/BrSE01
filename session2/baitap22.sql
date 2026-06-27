CREATE TABLE products(
	productId INT PRIMARY KEY NOT NULL,
    productName VARCHAR(100) NOT NULL,
    price DECIMAL(19,4) NOT NULL DEFAULT 0.0000,
    quantity INT NOT NULL DEFAULT 0 CHECK(quantity >= 0)
);