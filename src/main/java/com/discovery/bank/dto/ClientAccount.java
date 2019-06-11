package com.discovery.bank.dto;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ClientAccount {
	
	@Id 
	@Column(name = "CLIENT_ACCOUNT_NUMBER")
	private String clientAccountNumber;

	@Column(name = "CLIENT_ID")
	private int clientId;  
	  
	@Column(name = "ACCOUNT_TYPE_CODE")
	private String accountTypeCode;
	
	@Column(name = "CURRENCY_CODE")
	private String currencyCode;
	  
	@Column(name = "DISPLAY_BALANCE")
	private BigDecimal displayBalance;

	public BigDecimal getDisplayBalance() {
		return displayBalance;
	}

	public void setDisplayBalance(BigDecimal displayBalance) {
		this.displayBalance = displayBalance;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getClientAccountNumber() {
		return clientAccountNumber;
	}

	public void setClientAccountNumber(String clientAccountNumber) {
		this.clientAccountNumber = clientAccountNumber;
	}

	public String getAccountTypeCode() {
		return accountTypeCode;
	}

	public void setAccountTypeCode(String accountTypeCode) {
		this.accountTypeCode = accountTypeCode;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	
}
