CREATE SCHEMA demo_transactions;

SET search_path TO demo_transactions;

CREATE TABLE IF NOT EXISTS account (
	account_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	account_name VARCHAR(100) NOT NULL,
	balance DECIMAL(10, 2) NOT NULL
);

INSERT INTO
	account
	(account_name, balance)
VALUES
	('michel', 3000),
	('bernadette', 4000);

BEGIN;

UPDATE
	account
SET
	balance = balance - 1000
WHERE
	account_name = 'michel';

UPDATE
	account
SET
	balance = balance + 1000
WHERE
	account_name = 'bernadette';

SELECT * FROM account;

COMMIT;

ROLLBACK;