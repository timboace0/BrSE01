-- Hiển thị mã sv, họ tên (viết hoa)
SELECT student_id AS 'Mã SV', upper(full_name)  AS 'Họ Và Tên' FROM students;

-- Hiển thị họ tên, số tuổi dựa vào năm hiện tại
SELECT full_name AS 'Họ Và Tên', 
YEAR(CURDATE()) - birth_year AS 'Tuổi'FROM students;

-- Điểm tb làm tròn 1 chữ số thập phân
SELECT ROUND(score, 1) AS 'Điểm TB' FROM students;

-- hiển thị  tổng số sv, điểm cao nhất, điểm thấp nhất
SELECT
(SELECT COUNT(*) FROM students) AS 'Tổng số SV', 
(SELECT full_name
FROM students
ORDER BY score DESC LIMIT 1) AS 'SV điểm cao nhất',
(SELECT MAX(score) FROM students) AS 'Điểm cao nhất',
(SELECT full_name 
FROM students 
ORDER BY score ASC LIMIT 1) AS 'SV điểm thấp nhất',
(SELECT MIN(score) FROM students) AS 'Điểm thấp nhất';

