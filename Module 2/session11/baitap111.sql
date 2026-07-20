SELECT balance FROM accounts
WHERE accountID = 1;

START TRANSACTION;
UPDATE accounts SET balance = balance + 1000000
WHERE accountID = 1;
COMMIT;

SELECT balance FROM accounts
WHERE accountID = 1;