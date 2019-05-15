package com.jp.insurance.exception;
/** @author Chandra **/
public class ClaimException extends Exception {
    private static final long serialVersionUID = -1648287564068549359L;

    public ClaimException() {
        super();
    }
    public ClaimException(String message) {
        super(message);
    }
}
