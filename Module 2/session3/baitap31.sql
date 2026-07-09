
CREATE TABLE classes(
	class_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    class_name VARCHAR(100) NOT NULL,
    room VARCHAR(10) NOT NULL,
	start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    max_students INT NOT NULL CHECK(max_students > 0)
);

CREATE TABLE students(
	student_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    full_name VARCHAR(100) NOT NULL,
    gender CHAR(1),
	date_of_birth DATE NOT NULL,
    email VARCHAR(100),
    phone VARCHAR(15) NOT NULL,
    address VARCHAR(255) NOT NULL,
    `status` BIT DEFAULT(1),
    class_id INT NOT NULL,
    FOREIGN KEY (class_id) REFERENCES classes(class_id)
);