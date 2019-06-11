package com.discovery.bank.exception;

public class RemainderException extends RuntimeException {

	public RemainderException(int i) {
		super(String.valueOf(i));
	}

}
