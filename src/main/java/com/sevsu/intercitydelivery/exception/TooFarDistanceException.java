package com.sevsu.intercitydelivery.exception;

public class TooFarDistanceException extends BadRequestException{

    public TooFarDistanceException(String message) {
        super(message);
    }

}
