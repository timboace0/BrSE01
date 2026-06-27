CREATE TABLE students_constraint(
	studentId INT PRIMARY KEY NOT NULL,
    fullName VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE,
	age INT NOT NULL CHECK (age >= 18)
);