USE dml_session4;

UPDATE students 
SET email = 'lethib@gmail.com' WHERE student_id = 'SV002';
	
SELECT * FROM students;
    
UPDATE students
SET gender = 'Khac' WHERE student_id = 'SV005';

SELECT * FROM students;

DELETE FROM students
WHERE student_id = 'SV003';

SELECT * FROM students;