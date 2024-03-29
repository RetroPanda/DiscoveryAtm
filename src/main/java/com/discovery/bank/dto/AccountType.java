package com.discovery.bank.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AccountType {
	
	@Id
	@Column(name = "ACCOUNT_TYPE_CODE")
	private String accountTypeCode;
	
	@Column(name = "DESCRIPTION")
	private String desciption;
	
	@Column(name = "TRANSACTIONAL")
	private boolean transactional;

	public String getAccountTypeCode() {
		return accountTypeCode;
	}
	public void setAccountTypeCode(String accountTypeCode) {
		this.accountTypeCode = accountTypeCode;
	}
	public String getDesciption() {
		return desciption;
	}
	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}
	public boolean isTransactional() {
		return transactional;
	}
	public void setTransactional(boolean transactional) {
		this.transactional = transactional;
	}
}