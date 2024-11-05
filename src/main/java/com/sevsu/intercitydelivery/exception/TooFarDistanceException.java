package com.sevsu.intercitydelivery.exception;

public class TooFarDistanceException extends BadRequestException{

    public TooFarDistanceException() {
        super("Слишком большое расстояние перевозки, оно не должно превышать 100 км");
    }

}
