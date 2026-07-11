-- TÍNH ĐIỂM TB MỖI SV
SELECT student_name AS 'Tên SV',
ROUND(AVG(score),2) AS 'Điểm tb các môn'
FROM scores 
GROUP BY student_name;

-- HIỂN THỊ SV CÓ ĐIỂM TB >= 7.0
SELECT student_name AS 'Tên SV',
ROUND(AVG(score),2) AS 'Điểm tb các môn'
FROM scores 
GROUP BY student_name
HAVING ROUND(AVG(score),2) > 7.0;

-- ĐIỂM TB CAO NHẤT 
SELECT student_name AS 'Tên SV',
ROUND(AVG(score),2) AS 'Điểm tb các môn'  
FROM scores 
GROUP BY student_name 
ORDER BY ROUND(AVG(score),2) DESC LIMIT 1;

-- ĐIỂM TB CAO HƠN TB CHUNG CỦA TẤT CẢ SV
SELECT student_name AS 'Tên SV',
ROUND(AVG(score),2) AS 'Điểm tb các môn'
FROM scores
GROUP BY student_name
HAVING AVG(score) > (
	SELECT AVG(score)
    FROM scores
);


