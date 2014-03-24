package com.screw.exception;

public class ScrewException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ScrewException() {
        super();
    }
    
    public ScrewException(String message) {
        super(message);
    }
}
