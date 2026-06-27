CREATE TABLE classes(
	classId INT PRIMARY KEY NOT NULL,
    className VARCHAR(50) NOT NULL,
    classYear VARCHAR(50) NOT NULL
);

CREATE TABLE students(
	studentId INT PRIMARY KEY NOT NULL,
    studentName VARCHAR(50) NOT NULL,
    dob DATE NOT NULL,
    gender ENUM('Nam','Nu') NOT NULL,
    classId INT NOT NULL,
	FOREIGN KEY(classId) REFERENCES classes(classId)
);