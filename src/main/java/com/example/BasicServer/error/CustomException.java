package com.example.BasicServer.error;

public class CustomException extends RuntimeException {

    public final ErrorCodes errorCodes;

    public CustomException(ErrorCodes errorCodes) {
        this.errorCodes = errorCodes;
    }
}
