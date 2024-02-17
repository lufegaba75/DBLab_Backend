package com.lufegaba.datalab.exceptions;

public class BadRequestException extends RuntimeException{

    private static final long serialversionUID = 1L;

    public BadRequestException(String message) {
        super(message);
    }
}
