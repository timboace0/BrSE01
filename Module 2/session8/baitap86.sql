DELIMITER $$
CREATE PROCEDURE sp_classify_student
		(
        IN avg_score_IN decimal(4,2),
        OUT study_level VARCHAR(50)
        )
BEGIN
	DECLARE stu_level VARCHAR(50);
    SET stu_level = 
    CASE
		WHEN avg_score_IN >= 8.0 THEN 'Giỏi'
        WHEN avg_score_IN >= 6.5 AND 
        avg_score_IN < 8 THEN 'Khá'
        WHEN avg_score_IN >= 5.0 AND 
        avg_score_IN < 6.5 THEN 'Trung bình'
        ELSE 'Yếu'
	END;
    
    SET study_level = stu_level;
END $$ 
DELIMITER ;

CALL sp_classify_student(9.0, @note);
SELECT @note AS 'Học Lực';
CALL sp_classify_student(7.0, @note);
SELECT @note AS 'Học Lực';
CALL sp_classify_student(3.0, @note);
SELECT @note AS 'Học Lực';

