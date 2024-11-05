package com.sevsu.intercitydelivery.exception;

public class DeliveryDoesNotBelongException extends NotAcceptableException{

    public DeliveryDoesNotBelongException() {
        super("Доставка не принадлежит данному пользователю");
    }

}
