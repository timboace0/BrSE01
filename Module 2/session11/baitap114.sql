DELIMITER $$
CREATE PROCEDURE transfer_money(
		p_sender_id INT,
        p_reciever_id INT,
        p_amount DECIMAL
)
BEGIN
	DECLARE balance_sender DECIMAL(10,2);

	DECLARE EXIT HANDLER FOR SQLEXCEPTION 
	BEGIN
		ROLLBACK;
		SELECT 'Giao dịch thất bại' AS Message;
	END;
    
    START TRANSACTION;
    
    SELECT balance INTO balance_sender FROM accounts
    WHERE accountID = p_sender_id;
    
    IF balance_sender >= p_amount THEN
    UPDATE accounts SET balance = balance - p_amount
    WHERE accountID = p_sender_id;
    
    UPDATE accounts SET balance = balance + p_amount
    WHERE accountID = p_reciever_id; 
    
    COMMIT;
    
    SELECT 'Giao dịch thành công' AS Message;
    ELSE 
		ROLLBACK;
        SELECT 'Giao dịch thất bại, số dư không đủ' AS Message;
	END IF;
END $$
	DELIMITER ;
    
CALL transfer_money(4,5, 300000);
SELECT * FROM accounts WHERE accountID IN (4,5);

CALL transfer_money(5,4, 400000);