SELECT * FROM students
WHERE YEAR(birth_day) BETWEEN 2003 AND 2005;

SELECT * FROM students
WHERE gender IN('Nam','Nu');

SELECT * FROM students
WHERE student_id IN('SV001','SV004','SV005');

SELECT student_id, full_name, birth_day FROM students;