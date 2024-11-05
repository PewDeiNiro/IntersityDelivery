package com.sevsu.intercitydelivery.exception;

public class InvalidPasswordException extends BadRequestException {

    public InvalidPasswordException() {
        super("Введен неправильный пароль");
    }

}
