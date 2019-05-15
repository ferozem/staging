package com.jp.insurance.exception;
/** @author Feroze **/
public class PaymentException extends Exception {
	private static final long serialVersionUID = -1648287564068549359L;

	public PaymentException() {
		super();
	}
	public PaymentException(String message) {
		super(message);
	}
}
