package com.jp.insurance.exception;

public class TicketException extends Exception {
    private static final long serialVersionUID = -1648287564068549359L;

    public TicketException() {
        super();
    }
    public TicketException(String message) {
        super(message);
    }
}
