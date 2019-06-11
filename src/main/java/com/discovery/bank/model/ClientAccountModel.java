package com.discovery.bank.model;

import java.math.BigDecimal;

public class ClientAccountModel {
	
	private String accountNumber;
	private String accountType;
	private String currency;
	private Double accountBalance;
	private Double accountConvertedBalance;
	private BigDecimal conversionRate;
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public Double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}
	public Double getAccountConvertedBalance() {
		return accountConvertedBalance;
	}
	public void setAccountConvertedBalance(Double accountConvertedBalance) {
		this.accountConvertedBalance = accountConvertedBalance;
	}
	public BigDecimal getConversionRate() {
		return conversionRate;
	}
	public void setConversionRate(BigDecimal bigDecimal) {
		this.conversionRate = bigDecimal;
	}


}
