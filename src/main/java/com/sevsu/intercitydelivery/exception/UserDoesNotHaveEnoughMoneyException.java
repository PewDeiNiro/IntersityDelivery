package com.sevsu.intercitydelivery.exception;

public class UserDoesNotHaveEnoughMoneyException extends NotAcceptableException{

    public UserDoesNotHaveEnoughMoneyException(){
        super("У пользователя недостаточно денег для совершения этой операции");
    }

}
