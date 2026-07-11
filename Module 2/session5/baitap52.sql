-- THỐNG KÊ 1 PHÒNG CÓ BAO NHIÊU NV
SELECT department, COUNT(*) AS 'Số nhân viên'
FROM employees
WHERE department IS NOT NULL AND department <> ''
GROUP BY department;

-- MỨC LƯƠNG TRUNG BÌNH TỪNG PHÒNG BAN
SELECT department, ROUND(AVG(salary), 2) AS 'Lương TB'
FROM employees
WHERE department IS NOT NULL AND department <> ''
GROUP BY department;

-- 	HIỂN THỊ PHÒNG BAN CÓ TRÊN 3 NHÂN VIÊN
SELECT department, COUNT(*) AS 'Số nhân viên'
FROM employees
WHERE department IS NOT NULL AND department <> ''
GROUP BY department
HAVING COUNT(*) > 3;

-- HIỂN THỊ PHÒNG BAN CÓ LƯƠNG TB > 12TR
SELECT department, ROUND(AVG(salary), 2) AS 'Lương TB'
FROM employees
WHERE department IS NOT NULL AND department <> ''
GROUP BY department
HAVING ROUND(AVG(salary), 2) > 12000000;