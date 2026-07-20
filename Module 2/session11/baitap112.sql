DELIMITER $$
CREATE PROCEDURE withdraw_money(
			p_account_id INT,
            p_amount DECIMAL
)
BEGIN
	DECLARE balance_sender DECIMAL(10,2);
	START TRANSACTION;
    UPDATE accounts SET balance = balance - p_amount
    WHERE accountID = p_account_id;
    
	SELECT balance INTO balance_sender FROM accounts
    WHERE accountID = p_account_id;
    
    IF balance_sender < 0 THEN
    ROLLBACK;
    SELECT 'Số dư không đủ' AS message;
    
    ELSEIF balance_sender >=0 THEN
    COMMIT;
    SELECT 'Rút tiền thành công' AS message;
    END IF;
END $$
	DELIMITER ;
    
-- KIỂM THỬ
SELECT * FROM accounts;
-- THÀNH CÔNG
CALL withdraw_money(2,500000);
-- THẤT BẠI
CALL withdraw_money(4,6000000);

