package com.sevsu.intercitydelivery.controller;

import com.sevsu.intercitydelivery.exception.HttpException;
import com.sevsu.intercitydelivery.mapper.ExceptionResponseMapper;
import com.sevsu.intercitydelivery.response.ExceptionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @Autowired
    private ExceptionResponseMapper exceptionResponseMapper;

    @ExceptionHandler(HttpException.class)
    public ResponseEntity<ExceptionResponse> handleHttpException(HttpException exception){
        ExceptionResponse exceptionResponse = exceptionResponseMapper.mapExceptionToExceptionResponse(exception);
        return new ResponseEntity<>(exceptionResponse, exceptionResponse.getHttpStatus());
    }

}
