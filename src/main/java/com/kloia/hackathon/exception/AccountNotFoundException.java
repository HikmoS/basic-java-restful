package com.kloia.hackathon.exception;

public class AccountNotFoundException extends Exception {

    private static final long serialVersionUID = -4847377249947206599L;

    public AccountNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
