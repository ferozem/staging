package com.jp.insurance.exception;
/** @author Pradeep **/
public class CustomerException extends Exception {
    private static final long serialVersionUID = -1648287564068549359L;

    public CustomerException() {
        super();
    }
    public CustomerException(String message) {
        super(message);
    }
}
