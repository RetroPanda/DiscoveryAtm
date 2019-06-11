SELECT CONCAT( Client.title,' ',Client.name, ' ', Client.surname) AS Client,  SUM(Client_Account.display_balance) AS Net_Position  FROM Client_Account 
INNER JOIN Client
               ON Client_Account.client_Id=Client.client_Id
WHERE Client_Account.client_Id IN ( SELECT Client.client_id FROM Client) GROUP BY Client_Account.client_Id;

SELECT CONCAT( Client.title,' ',Client.name, ' ', Client.surname) AS Client, SUM(Client_Account.display_balance) AS Loan_Balance  FROM Client_Account 
INNER JOIN Client
               ON Client_Account.client_Id=Client.client_Id
WHERE Client_Account.client_Id IN ( SELECT Client.client_id FROM Client) AND Client_Account.account_type_code LIKE '%LOAN'  GROUP BY Client_Account.client_Id;

SELECT CONCAT( Client.title,' ',Client.name, ' ', Client.surname) AS Client, SUM(Client_Account.display_balance) AS Transactional_Balance FROM Client_Account
INNER JOIN Client
               ON Client_Account.client_Id=Client.client_Id
INNER JOIN Account_Type
               ON Client_Account.account_type_code=Account_Type.account_type_code
WHERE Client_Account.client_Id IN ( SELECT Client.client_id FROM Client) AND Account_Type.transactional = 'TRUE' GROUP BY Client_Account.client_Id; 
