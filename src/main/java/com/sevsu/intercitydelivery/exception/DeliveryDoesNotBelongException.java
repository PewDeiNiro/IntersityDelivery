package com.sevsu.intercitydelivery.exception;

public class DeliveryDoesNotBelongException extends NotAcceptableException{

    public DeliveryDoesNotBelongException(String message) {
        super(message);
    }

}
