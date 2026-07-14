DELIMITER $$
CREATE PROCEDURE sp_check_employee_income
		(
        IN emp_full_name_IN VARCHAR(100),
        IN salary_IN DECIMAL(12,2)
        )
BEGIN
	DECLARE note VARCHAR(50);
    IF salary_IN >= 15000000 THEN
		SET note = 'Thu nhập cao';
	ELSEIF salary_IN >= 8000000 AND salary_IN < 15000000 THEN
		SET note = 'Thu nhập trung bình';
	ELSE 
	SET note = 'Thu nhập thấp';
    END IF;
    
    SELECT emp_full_name_IN AS 'Tên NV',
		   note AS 'Mức Lương';
END $$ 
DELIMITER ;

CALL sp_check_employee_income('Bui Thi Lan',2000000.00);
CALL sp_check_employee_income('Hoang Van Tien',10000000.00);
CALL sp_check_employee_income('Truong Viet Hung',18000000.00);