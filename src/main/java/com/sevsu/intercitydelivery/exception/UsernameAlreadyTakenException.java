package com.sevsu.intercitydelivery.exception;

public class UsernameAlreadyTakenException extends BadRequestException {

    public UsernameAlreadyTakenException(String message) {
        super(message);
    }

}
