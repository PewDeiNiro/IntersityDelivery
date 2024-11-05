package com.sevsu.intercitydelivery.exception;

public class PaymentDoesNotSucceededException extends BadRequestException{

    public PaymentDoesNotSucceededException(String message) {
        super(message);
    }

}
