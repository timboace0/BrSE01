DELIMITER $$
CREATE PROCEDURE sp_get_avg_salary()
BEGIN
	DECLARE avg_salary DECIMAL(10,2);
	SELECT AVG(salary) 
    INTO avg_salary 
    FROM employees;
    SELECT avg_salary;
END $$
	DELIMITER ;
    
CALL sp_get_avg_salary();




