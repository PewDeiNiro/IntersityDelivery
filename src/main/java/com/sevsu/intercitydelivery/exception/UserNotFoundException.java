package com.sevsu.intercitydelivery.exception;

public class UserNotFoundException extends BadRequestException {

    public UserNotFoundException(String message) {
        super(message);
    }

}
