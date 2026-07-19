CREATE TABLE employees(
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    salary DECIMAL(10,2),
    email VARCHAR(100) UNIQUE,
    phone_number VARCHAR(15)
);

CREATE TABLE salary_log(
    log_id INT PRIMARY KEY AUTO_INCREMENT,
    employee_id INT,
    old_salary DECIMAL(10,2),
    new_salary DECIMAL(10,2),
    change_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (employee_id) REFERENCES employees(id)
);


INSERT INTO employees(first_name, last_name, salary, email, phone_number)
VALUES
('Nguyen', 'An', 12000000.00, 'an.nguyen@gmail.com', '0901234567'),
('Tran', 'Binh', 15000000.00, 'binh.tran@gmail.com', '0901234568'),
('Le', 'Cuong', 18000000.00, 'cuong.le@gmail.com', '0901234569'),
('Pham', 'Dung', 10000000.00, 'dung.pham@gmail.com', '0901234570'),
('Hoang', 'Giang', 22000000.00, 'giang.hoang@gmail.com', '0901234571'),
('Vo', 'Huy', 14000000.00, 'huy.vo@gmail.com', '0901234572'),
('Do', 'Khanh', 16000000.00, 'khanh.do@gmail.com', '0901234573'),
('Bui', 'Linh', 20000000.00, 'linh.bui@gmail.com', '0901234574'),
('Dang', 'Minh', 25000000.00, 'minh.dang@gmail.com', '0901234575'),
('Phan', 'Trang', 13000000.00, 'trang.phan@gmail.com', '0901234576');


-- trigger ghi log thay đổi lương
DELIMITER $$
CREATE TRIGGER trg_after_update_salary
AFTER UPDATE
ON employees
FOR EACH ROW
BEGIN 
	INSERT INTO salary_log(employee_id, old_salary, new_salary, change_date)
    VALUES(OLD.id, OLD.salary, NEW.salary, current_timestamp());
END $$
	DELIMITER ;

-- kiểm tra
UPDATE employees
SET salary = 15000000
WHERE id = 10;

SELECT * FROM employees;
SELECT * FROM salary_log;

