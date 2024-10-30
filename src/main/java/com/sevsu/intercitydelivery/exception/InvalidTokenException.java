package com.sevsu.intercitydelivery.exception;

public class InvalidTokenException extends UnauthorizedException{

    public InvalidTokenException(String message) {
        super(message);
    }

}
