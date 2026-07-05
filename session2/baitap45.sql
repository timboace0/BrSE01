USE dml_session4;

CREATE TABLE employees(
	emp_id VARCHAR(10) PRIMARY KEY NOT NULL,
    full_name VARCHAR(50) NOT NULL,
    birth_year YEAR NOT NULL,
    department VARCHAR(50) NOT NULL,
    salary DECIMAL(10,2) NOT NULL,
    phone VARCHAR(20)
);

INSERT INTO employees
VALUES
('EM001', 'Nguyen Van An', 1999, 'Human Resources', 12000000.00, '0901234567'),
('EM002', 'Tran Thi Binh', 1998, 'Finance', 18000000.00, '0912345678'),
('EM003', 'Le Van Cuong', 2000, 'Information Technology', 25000000.00, NULL),
('EM004', 'Pham Thi Dung', 1997, 'Marketing', 16000000.00, '0934567890'),
('EM005', 'Hoang Van Em', 1995, 'Sales', 14500000.00, '0945678901'),
('EM006', 'Vo Thi Giang', 2001, 'Customer Service', 11000000.00, NULL),
('EM007', 'Dang Minh Hai', 1996, 'Finance', 22000000.00, '0967890123'),
('EM008', 'Bui Thi Hoa', 2002, 'Human Resources', 13000000.00, '0978901234'),
('EM009', 'Nguyen Quoc Khanh', 1994, 'Information Technology', 30000000.00, '0989012345'),
('EM010', 'Do Thi Lan', 2003, 'Marketing', 12500000.00, NULL);

-- HIỂN THỊ MỨC LƯƠNG 10 - 20 TRIỆU
SELECT * FROM employees
WHERE salary BETWEEN 10000000 AND 20000000;

-- HIỂN THỊ THUỘC PHÒNG BAN IT HOẶC HR
SELECT * FROM employees
WHERE department IN('IT','HR');

-- HỌ TÊN CHỨA CHỮ 'ANH'
SELECT * FROM employees
WHERE full_name LIKE '%Anh%';

-- CHƯA CÓ SĐT
SELECT * FROM employees
WHERE phone IS NULL;

-- TĂNG LƯƠNG IT 10%
UPDATE employees 
SET salary = salary + salary * 0.10
WHERE department = 'IT';

-- CẬP NHẬT SĐT
SELECT * FROM employees 
WHERE phone IS NULL;

UPDATE employees
SET phone = '0984756185'
WHERE emp_id = 'EM003';

UPDATE employees
SET phone = '0938128053'
WHERE emp_id = 'EM006';

UPDATE employees
SET phone = '0931762819'
WHERE emp_id = 'EM010';

-- XÓA NHÂN VIÊN LƯƠNG < 5 TRIỆU
DELETE FROM employees 
WHERE salary < 5000000