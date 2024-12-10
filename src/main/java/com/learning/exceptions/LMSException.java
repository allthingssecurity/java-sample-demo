package com.learning.exceptions;

public class LMSException extends RuntimeException {
    public LMSException(String message) {
        super(message);
    }

    public LMSException(String message, Throwable cause) {
        super(message, cause);
    }
}
