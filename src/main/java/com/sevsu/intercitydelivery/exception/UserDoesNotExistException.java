package com.sevsu.intercitydelivery.exception;

public class UserDoesNotExistException extends RuntimeException{

    public UserDoesNotExistException(String message) {
        super(message);
    }

}
