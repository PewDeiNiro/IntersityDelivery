package com.sevsu.intercitydelivery.controller;

import com.sevsu.intercitydelivery.exception.BadRequestException;
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

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<ExceptionResponse> handleBadRequestException(BadRequestException exception){
        ExceptionResponse exceptionResponse = exceptionResponseMapper.mapBadRequestExceptionToExceptionResponse(exception);
        return new ResponseEntity<>(exceptionResponse, exceptionResponse.getHttpStatus());
    }

}
