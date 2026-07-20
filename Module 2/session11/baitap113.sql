DELIMITER $$
CREATE PROCEDURE deposit_with_logging(
			p_account_id INT,
			p_amount DECIMAL
)
BEGIN

DECLARE EXIT HANDLER FOR SQLEXCEPTION
BEGIN
	ROLLBACK;
    SELECT 'Giao dịch thất bại' AS Message;
END;

START TRANSACTION;
	UPDATE accounts 
    SET balance = balance + p_amount
    WHERE accountID = p_account_id;
    INSERT INTO transactions(fromAccountID, toAccountID, amount, transactionDate)
    VALUES(null, p_account_id, p_amount, current_timestamp());
    
    COMMIT;

    SELECT 'Nạp tiền thành công' AS Message;
END $$
	DELIMITER ;

-- test
CALL deposit_with_logging(2,500000);
SELECT * FROM accounts;
SELECT * FROM transactions;