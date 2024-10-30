package com.sevsu.intercitydelivery.exception;

public class DeliveryDoesNotExistException extends BadRequestException{

    public DeliveryDoesNotExistException(String message) {
        super(message);
    }

}
