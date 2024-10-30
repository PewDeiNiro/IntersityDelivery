package com.sevsu.intercitydelivery.exception;

import org.springframework.http.HttpStatus;

public class NotAcceptableException extends HttpException{

    private int code = HttpStatus.NOT_ACCEPTABLE.value();

    private HttpStatus status = HttpStatus.NOT_ACCEPTABLE;

    public NotAcceptableException(String message) {
        super(message);
    }

}
