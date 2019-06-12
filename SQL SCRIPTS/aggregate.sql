SELECT CONCAT(client.title, ' ', client.name , ' ' , client.surname) "Client", c.transactional AS "Transactional Balance", c.loan AS "Loan Balance", c.transactional + c.loan AS "Net Position"
FROM client
RIGHT JOIN (
	SELECT a.client_id AS client_id, a.balance AS transactional, b.balance AS loan
	FROM(
		SELECT client.client_id, SUM(client_account.display_balance) AS balance
		FROM Client
		INNER JOIN client_account 
               	ON client.client_id = client_account.client_id
		INNER JOIN account_type 
                ON client_account.account_type_code = account_type.account_type_code
		WHERE account_type.transactional = true
		GROUP BY client.client_id 
	) a
	LEFT JOIN(
		SELECT client.client_id, SUM(client_account.display_balance) AS balance
		FROM Client
		INNER JOIN client_account 
                ON client.client_id = client_account.client_id
		INNER JOIN account_type 
                ON client_account.account_type_code = account_type.account_type_code
		WHERE account_type.transactional = false
		AND account_type.account_type_code <> 'CFCA'
		GROUP BY client.client_id
	) b 
	ON b.client_id = a.client_id
) 
c ON client.client_id = c.client_id
ORDER BY client.client_id;