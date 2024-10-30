package com.sevsu.intercitydelivery.exception;

public class TooMuchWeightException extends BadRequestException{

    public TooMuchWeightException(String message) {
        super(message);
    }

}
