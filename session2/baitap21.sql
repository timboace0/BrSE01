CREATE SCHEMA ddl_session2;

USE ddl_session2;

CREATE TABLE students(
	studentId INT PRIMARY KEY NOT NULL,
    studentName VARCHAR(50) NOT NULL,
	dob DATE NOT NULL,
    gender ENUM('Nam','Nu','Khac') NOT NULL
);