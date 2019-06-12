package com.discovery.bank.exception;

public class InsufficentFundsException extends RuntimeException {

	public InsufficentFundsException() {
	}

	public InsufficentFundsException(String message) {
		super(message);
	}

}
