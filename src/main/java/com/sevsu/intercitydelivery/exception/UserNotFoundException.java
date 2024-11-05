package com.sevsu.intercitydelivery.exception;

public class UserNotFoundException extends BadRequestException {

    public UserNotFoundException() {
        super("Пользователя с таким уникальным идентификатором не существует");
    }

}
