package com.sevsu.intercitydelivery.exception;

public class AmountCanNotBeLessZeroException extends BadRequestException{

    public AmountCanNotBeLessZeroException(String message) {
        super(message);
    }

}
