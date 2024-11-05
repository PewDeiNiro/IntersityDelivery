package com.sevsu.intercitydelivery.exception;

public class AmountCanNotBeLessZeroException extends BadRequestException{

    public AmountCanNotBeLessZeroException() {
        super("Сумма пополнения не может быть меньше 0");
    }

}
