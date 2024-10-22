package com.sevsu.intercitydelivery.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponse {

    private final int code = HttpStatus.BAD_REQUEST.value();

    @JsonProperty("status")
    private final HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

    private String message;

}
