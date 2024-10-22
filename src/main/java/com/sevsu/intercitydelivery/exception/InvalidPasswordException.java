package com.sevsu.intercitydelivery.exception;

public class InvalidPasswordException extends BadRequestException {

    public InvalidPasswordException(String message) {
        super(message);
    }

}
