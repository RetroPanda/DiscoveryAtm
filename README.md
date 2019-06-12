# DiscoveryAtm
Sql scripts are in SQL SCRIPTS folder

Endpoints

 4.2.1 Display transactional accounts with balances
      http://localhost:8080/accounts/transactional?id=CLIENT_ID
      
 4.2.2 Display currency accounts with converted Rand values
      http://localhost:8080/accounts/currency?id=CLIENT_ID
 
 4.2.3 Withdraw cash
      http://localhost:8080/withdraw?accNumber=CLIENT_ACCOUNT_NUMBER&amount=AMOUNT&atmId=ATM_ID
