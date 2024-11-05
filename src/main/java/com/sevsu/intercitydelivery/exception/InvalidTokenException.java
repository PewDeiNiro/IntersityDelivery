package com.sevsu.intercitydelivery.exception;

public class InvalidTokenException extends UnauthorizedException{

    public InvalidTokenException() {
        super("Невалидный токен пользователя");
    }

}
