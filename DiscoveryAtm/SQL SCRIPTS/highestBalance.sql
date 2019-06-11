SELECT Client.Client_id, Client.surname, Client_Account.client_account_number, Account_Type.description, Client_Account.display_balance 
FROM Client_Account
INNER JOIN Account_Type 
ON Client_Account.account_type_code=Account_Type.account_type_code
INNER JOIN Client
ON Client_Account.client_id=Client.client_id