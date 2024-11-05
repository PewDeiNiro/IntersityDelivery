package com.sevsu.intercitydelivery.exception;

public class TooMuchWeightException extends BadRequestException{

    public TooMuchWeightException() {
        super("Слишком большой вес посылки, он не должен превышать 100 кг");
    }

}
