-- SINH VIÊN CHƯA CÓ EMAIL
SELECT * FROM students
WHERE email IS NULL;

-- SINH VIÊN ĐÃ CÓ EMAIL
SELECT * FROM students
WHERE email IS NOT NULL;

-- SINH VIÊN HỌ TÊN BẮT ĐẦU BẰNG "Ng"
SELECT * FROM students
WHERE full_name LIKE 'Ng%';

-- KHÔNG PHẢI GIỚI TÍNH NAM
SELECT * FROM students
WHERE gender <> 'Nam' ;