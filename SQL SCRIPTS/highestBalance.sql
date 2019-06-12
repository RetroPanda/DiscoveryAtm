SELECT client.client_id, client.surname, client_account_number, description, display_balance
FROM(
        SELECT client_id AS id, client_account_number, display_balance, client_account.account_type_code AS code
        FROM client_account
        WHERE display_balance IN (
                SELECT MAX(display_balance) AS display_balance
                FROM client_account
                INNER JOIN account_type 
                ON client_account.account_type_code = account_type.account_type_code
                WHERE account_type.transactional = true
                GROUP BY client_id
         ) 
) INNER JOIN client 
ON id = client.client_id
INNER JOIN account_type 
ON code = account_type.account_type_code
ORDER BY client.client_id;