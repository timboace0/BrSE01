-- PHAN 1 DDL 
CREATE DATABASE db_final_test;

USE db_final_test;

CREATE TABLE courses(
	course_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    course_name VARCHAR(100) NOT NULL,
    course_code VARCHAR(20) NOT NULL UNIQUE,
    department VARCHAR(100) NOT NULL,
    creation_date DATE NOT NULL
);

CREATE TABLE students(
	student_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    full_name VARCHAR(100) NOT NULL,
    major VARCHAR(100) NOT NULL,
    phone_number VARCHAR(15) NOT NULL UNIQUE,
    gpa DECIMAL(3,1) DEFAULT 4.0 CHECK(gpa BETWEEN 0.0 AND 4.0)
);

CREATE TABLE enrollments(
	enrollment_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    course_id INT,
    student_id INT, 
    enroll_time DATETIME NOT NULL,
    credits INT CHECK(credits > 0),
    status VARCHAR(50) CHECK(status IN ('Pending','Completed','Dropped')),
    
    FOREIGN KEY (course_id) REFERENCES courses(course_id),
    FOREIGN KEY (student_id) REFERENCES students(student_id)
);

CREATE TABLE enrollment_details(
	detail_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    enrollment_id INT,
    attendance_check VARCHAR(150) NOT NULL,
	detail_date DATETIME DEFAULT current_timestamp,
    
    FOREIGN KEY (enrollment_id) REFERENCES enrollments(enrollment_id)
);

CREATE TABLE academic_logs(
	log_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    enrollment_id INT,
    student_id INT,
    log_time DATETIME NOT NULL,
    note TEXT,
    
    FOREIGN KEY (enrollment_id) REFERENCES enrollments(enrollment_id),
    FOREIGN KEY (student_id) REFERENCES students(student_id)
);

-- PHAN 2 DML

INSERT INTO courses(course_name, course_code, department, creation_date)
VALUES('Lập trình Java', 'JAVA01', 'CNTT', '2023-12-03'),
('Cấu trúc dữ liệu', 'DSA02', 'Khoa học máy tính', '1996-11-25'),
('Cơ sở dữ liệu', 'SQL03', 'CNTT', '2001-07-08'),
('Mạng máy tính', 'NET04', 'Truyền thông', '1998-01-19'),
('Trí tuệ nhân tạo', 'AI05', 'Khoa học máy tính', '2000-09-30');

INSERT INTO students(full_name, major, phone_number, gpa)
VALUES('Nguyễn Văn Hải', 'Hệ thống TT', '0931112223', 3.8),
('Trần Thu Hà', 'Kỹ thuật PM', '0932223334', 4.0),
('Lê Quốc Tuấn', 'An toàn TT', '0933334445', 3.6),
('Phạm Minh Châu', 'Dữ liệu lớn', '0934445556', 3.9),
('Hoàng Gia Bảo ', 'Kỹ thuật PM', '0935556667', 3.7);

INSERT INTO enrollments(enrollment_id, course_id, student_id, enroll_time, credits, status)
VALUES(7001, 1, 1, '2024-05-20 08:00', 3 , 'Pending'),
(7002, 2, 2, '2024-05-20 09:30', 4 , 'Completed'),
(7003, 3, 3, '2024-05-20 10:15', 3 , 'Pending'),
(7004, 4, 5, '2024-05-21 07:00', 3 , 'Completed'),
(7005, 5, 4, '2024-05-21 08:45', 4 , 'Dropped'); 

INSERT INTO enrollment_details(detail_id, enrollment_id, attendance_check, detail_date)
VALUES(8001, 7002, 'Đủ điều kiện thi', '2024-05-20 10:00'),
(8002, 7004, 'Vắng 1 buổi', '2024-05-21 08:00'),
(8003, 7001, 'Đang học', '2024-05-20 09:00'),
(8004, 7003, 'Nghỉ phép', '2024-05-20 11:00'),
(8005, 7005, 'Không đi học', '2024-05-21 09:00');

INSERT INTO academic_logs(enrollment_id, student_id, log_time, note)
VALUES(7001, 1, '2024-05-20 09:05', 'Bắt đầu lớp học'),
(7002, 2, '2024-05-20 10:05', 'Hoàn tất môn học'),
(7003, 3, '2024-05-20 11:10', 'Đang sắp xếp lịch bù'),
(7004, 5, '2024-05-21 08:10', 'Chờ phê duyệt điểm'),
(7005, 4, '2024-05-21 09:05', 'Hủy do vắng quá số buổi');


-- UPDATE & DELETE
/* 1. Viết câu lệnh tăng thêm 1 tín chỉ (credits) 
cho các bản ghi đăng ký học thỏa mãn đồng thời:
Có trạng thái “Completed”.
Thuộc môn học có năm tạo (creation_date) < 2000.
*/
UPDATE enrollments e
JOIN courses c
ON e.course_id = c.course_id
SET e.credits = e.credits + 1
WHERE status = 'Completed' 
AND YEAR(c.creation_date) < 2000;

/* 2. Viết câu lệnh xóa các bản ghi trong academic_logs
thỏa mãn:
Có log_time trước ngày 20/05/2024
*/
DELETE FROM academic_logs
WHERE log_time < '2024-05-20';

-- PHẦN 3: TRUY VẤN CƠ BẢN
/*
Câu 1 (5 điểm): Liệt kê các thông tin sinh viên gồm 
full_name, major và gpa của những sinh viên
có điểm GPA lớn hơn 3.8 hoặc thuộc chuyên ngành “Kỹ thuật PM”.
*/
SELECT full_name, major, gpa 
FROM students
WHERE gpa > 3.8 OR major IN ('Kỹ thuật PM');

/*
Câu 2 (5 điểm): Liệt kê các thông tin môn học gồm 
course_name và course_code của những môn học có 
ngày tạo trong khoảng từ 1998-01-01 đến 2001-12-31 và 
mã học phần bắt đầu bằng“A”.
*/

SELECT course_name, course_code 
FROM courses
WHERE creation_date BETWEEN '1998-01-01' AND '2001-12-31'
AND course_code LIKE 'A%';

/*
Câu 3 (5 điểm): Liệt kê các bản ghi đăng ký 
học gồm enrollment_id, enroll_time và credits,
trong đó danh sách được sắp xếp theo số tín chỉ 
(credits) giảm dần và chỉ hiển thị 2 bản ghi ở
trang thứ hai.
*/

SELECT enrollment_id, enroll_time, credits 
FROM enrollments
ORDER BY credits DESC 
LIMIT 2 OFFSET 2;

-- PHẦN 4: TRUY VẤN NÂNG CAO (15 ĐIỂM)
/*
Câu 1 (5 điểm): Liệt kê các thông tin xử lý học vụ gồm tên môn học, 
họ tên sinh viên, chuyên ngành, số tín chỉ và thời gian đăng ký, 
với dữ liệu được lấy từ các bảng liên quan trong hệ thống.
*/
SELECT c.course_name, s.full_name, s.major, e.credits, e.enroll_time
FROM students s
JOIN enrollments e
ON s.student_id = e.student_id
JOIN courses c
ON c.course_id = e.course_id;

/*
Câu 2 (5 điểm): Liệt kê các thông tin sinh viên gồm họ tên sinh 
viên và tổng số tín chỉ mà sinh viên đó đã tích lũy 
(chỉ tính các đăng ký trạng thái Completed), chỉ hiển thị 
những sinh viên có tổng số tín chỉ lớn hơn 120.
*/
SELECT s.full_name, SUM(e.credits)
FROM students s
JOIN enrollments e
ON s.student_id = e.student_id
WHERE e.status = 'Completed'
GROUP BY s.student_id, s.full_name
HAVING SUM(e.credits) > 120;

/*
Câu 3 (5 điểm): Liệt kê các thông tin sinh viên gồm 
student_id, full_name và gpa của những sinh
viên có điểm trung bình (GPA) cao nhất.
*/
SELECT student_id, full_name, gpa 
FROM students 
WHERE gpa = (
SELECT MAX(gpa) FROM students
);

-- PHẦN 5: INDEX & VIEW (10 ĐIỂM)
/* 
Câu 1 (5 điểm): Tạo một chỉ mục (index) trên bảng 
enrollments dựa trên hai thông tin là trạng
thái học và số tín chỉ nhằm phục vụ việc tối ưu truy vấn.
*/
CREATE INDEX idx_status_credits
ON enrollments(status,credits);

/*
Câu 2 (5 điểm): Tạo một khung nhìn (view) dữ liệu hiển thị
họ tên sinh viên, tổng số môn học đã đăng ký và tổng số tín 
chỉ mà sinh viên đó đã tích lũy, trong đó không tính các môn bị 
hủy (Dropped).
*/

CREATE VIEW vw_studentEnrollDetail
AS
SELECT s.full_name, COUNT(e.course_id) AS 'Tổng số môn đã đăng ký',
SUM(e.credits) AS 'Tổng số tín chỉ'
FROM enrollments e
JOIN students s
ON s.student_id = e.student_id
WHERE e.status <> 'Dropped'
GROUP BY s.student_id;

SELECT * FROM vw_studentEnrollDetail;

-- PHẦN 6: TRIGGER (10 ĐIỂM)
/*
Câu 1 (5 điểm): Viết một trigger sao cho khi trạng thái của 
một bản ghi đăng ký trong bảng enrollments được cập nhật sang 
giá trị Completed thì hệ thống tự động thêm một bản ghi
mới vào bảng academic_logs với các thông tin sau:
enrollment_id : mã bản ghi đăng ký vừa được cập nhật.
student_id : sinh viên phụ trách bản ghi.
note : 'Course completed'.
log_time : thời gian hiện tại của hệ thống.
*/
DELIMITER $$
CREATE TRIGGER after_update_academics_log
AFTER UPDATE
ON enrollments
FOR EACH ROW
BEGIN 
	IF NEW.status = 'Completed' AND OLD.status <> 'Completed' THEN
		INSERT INTO academic_logs(enrollment_id, student_id, log_time, note)
		VALUES(NEW.enrollment_id, NEW.student_id, current_timestamp(), 'Course completed');
	END IF ;
END $$
DELIMITER ;

/*
Câu 2 (5 điểm): Viết một trigger sao cho khi thêm mới một bản 
ghi vào bảng enrollments có trạng thái Completed thì hệ thống 
tự động tăng điểm trung bình GPA của sinh viên tương ứng
trong bảng students thêm 0.1, nhưng đảm bảo điểm GPA không 
vượt quá 4.0.
*/

DELIMITER $$
CREATE TRIGGER after_insert_increaseGPA
AFTER INSERT 
ON enrollments
FOR EACH ROW
BEGIN
	IF NEW.status = 'Completed' THEN
    UPDATE students 
    SET gpa = gpa + 0.1
    WHERE student_id = NEW.student_id;
    END IF;
END $$
DELIMITER ;

-- PHẦN 7: STORED PROCEDURE (10 ĐIỂM)
/* 
Câu 1 (5 điểm): Viết một stored procedure nhận vào mã 
sinh viên và trả về một thông báo kết quả, trong đó:
Nếu tổng số tín chỉ Completed của sinh viên > 100 thì trả về 'Excellent progress'.
Nếu bằng 100 thì trả về 'Target met'.
Nếu nhỏ hơn 100 thì trả về 'Normal progress'.
*/
DELIMITER $$
CREATE PROCEDURE rate_students(
	IN in_student_id INT
)
BEGIN 
	DECLARE total_credit INT;
	SELECT SUM(credits) INTO total_credit
    FROM enrollments
    WHERE student_id = in_student_id AND status= 'Completed';
    
    IF total_credit > 100 THEN
    SELECT 'Excellent progress' AS Message;
    ELSEIF total_credit = 100 THEN
    SELECT 'Target met' AS Message;
    ELSE 
    SELECT 'Normal progress' AS Message;
	END IF;
END $$
DELIMITER ;

CALL rate_students(1);

/* 
Câu 2 (5 điểm): Viết một stored procedure để thực hiện việc chuyển nhượng quyền tham gia lớp
học (đổi sinh viên) cho một mã đăng ký, gồm các bước sau:
Bước 1: Bắt đầu quá trình xử lý (Transaction).
Bước 2: Cập nhật mã sinh viên mới cho bản ghi đăng ký trong bảng enrollments.
Bước 3: Ghi một bản ghi mới vào bảng academic_logs với ghi chú 'Student reassigned'.
Bước 4: Nếu toàn bộ quá trình thành công thì hoàn tất (Commit), nếu xảy ra lỗi ở bất kỳ bước
nào thì hủy toàn bộ thao tác (Rollback).
*/

DELIMITER $$
CREATE PROCEDURE delegate_class_student(
	IN p_enrollment_id INT,
    IN p_student_id INT
)
BEGIN
DECLARE EXIT HANDLER FOR SQLEXCEPTION
BEGIN
	ROLLBACK;
    SELECT 'Xử lý thất bại' AS Message;
END;
START TRANSACTION;
	UPDATE enrollments 
	SET student_id = p_student_id 
	WHERE enrollment_id = p_enrollment_id;
    
    INSERT INTO academic_logs(enrollment_id, student_id, log_time, note)
    VALUES(p_enrollment_id, p_student_id, current_timestamp(), 'Student reassigned');
    
    COMMIT;
END $$
DELIMITER ;
