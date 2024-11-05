package com.sevsu.intercitydelivery.exception;

public class UserDoesNotExistException extends BadRequestException{

    public UserDoesNotExistException() {
        super("Пользователя с таким уникальным идентификатором не существует");
    }

}
