package com.sevsu.intercitydelivery.exception;

public class PaymentDoesNotSucceededException extends BadRequestException{

    public PaymentDoesNotSucceededException() {
        super("Транзакция не была выполнена");
    }

}
