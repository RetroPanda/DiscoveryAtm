package com.discovery.bank.exception;
public class AtmNotFoundException extends RuntimeException {
 
    public AtmNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

	public AtmNotFoundException(String message) {
		 super(message);
	}

	public AtmNotFoundException() {
	}
}