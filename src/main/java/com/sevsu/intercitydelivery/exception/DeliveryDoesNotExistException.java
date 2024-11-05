package com.sevsu.intercitydelivery.exception;

public class DeliveryDoesNotExistException extends BadRequestException{

    public DeliveryDoesNotExistException() {
        super("Доставки с таким уникальным идентификатором не существует");
    }

}
