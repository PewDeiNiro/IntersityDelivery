package com.sevsu.intercitydelivery.exception;

public class UserDoesNotExistException extends BadRequestException{

    public UserDoesNotExistException(String message) {
        super(message);
    }

}
