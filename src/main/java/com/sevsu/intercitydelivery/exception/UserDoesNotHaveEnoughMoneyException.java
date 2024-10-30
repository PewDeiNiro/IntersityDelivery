package com.sevsu.intercitydelivery.exception;

public class UserDoesNotHaveEnoughMoneyException extends NotAcceptableException{

    public UserDoesNotHaveEnoughMoneyException(String message){
        super(message);
    }

}
