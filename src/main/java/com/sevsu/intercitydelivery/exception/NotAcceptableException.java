package com.sevsu.intercitydelivery.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotAcceptableException extends HttpException{

    private int code = HttpStatus.NOT_ACCEPTABLE.value();

    private HttpStatus status = HttpStatus.NOT_ACCEPTABLE;

    public NotAcceptableException(String message) {
        super(message);
    }

}
