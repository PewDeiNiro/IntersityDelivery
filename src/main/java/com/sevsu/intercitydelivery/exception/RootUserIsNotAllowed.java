package com.sevsu.intercitydelivery.exception;

public class RootUserIsNotAllowed extends BadRequestException{

    public RootUserIsNotAllowed() {
        super("Запрещено создавать пользователя с таким никнеймом");
    }

}
