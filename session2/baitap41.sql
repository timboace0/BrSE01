CREATE SCHEMA dml_session4;

USE dml_session4;

CREATE TABLE students(
	student_id VARCHAR(10) PRIMARY KEY NOT NULL,
    full_name VARCHAR(50) NOT NULL,
    birth_day DATE NOT NULL,
    gender ENUM('Nam','Nu','Khac') NOT NULL,
    email VARCHAR(100)
);

INSERT INTO students
VALUES
('SV001', 'Nguyen Van A', '2002-01-19', 'Nam', 'nguyenvana@gmail.com'),
(2, 'Le Thi B', '1998-05-11', 'Nu',NULL),
(3, 'Tran Van C', '2000-02-03', 'Nam', 'tranvanc@gmail.com'),
(4, 'Lo Van D', '2006-08-13', 'Nam', 'lovand@gmail.com'),
(5, 'Tran Thi E', '2004-07-10', 'Nu', 'tranthie@gmail.com');

SELECT * FROM students;

SELECT student_id, full_name, email FROM students;