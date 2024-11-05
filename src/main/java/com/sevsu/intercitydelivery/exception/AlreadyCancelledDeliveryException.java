package com.sevsu.intercitydelivery.exception;

public class AlreadyCancelledDeliveryException extends BadRequestException{

    public AlreadyCancelledDeliveryException() {
        super("Доставка уже была отменена");
    }

}
