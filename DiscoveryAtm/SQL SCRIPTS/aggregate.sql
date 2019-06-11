SELECT CONCAT( Client.title,' ',Client.name, ' ', Client.surname) AS Client, 
      (SELECT SUM(display_balance) FROM Client_Account  WHERE account_type_code LIKE '%LOAN'  ) Loan_Balance,
      ( SELECT SUM(display_balance) FROM Client_Account INNER JOIN Account_Type
       ON Client_Account.account_type_code=Account_Type.account_type_code WHERE Account_Type.transactional = 'TRUE') Transactional_Balance ,
      (SELECT SUM(display_balance) FROM Client_Account) Net_Position 
from Client