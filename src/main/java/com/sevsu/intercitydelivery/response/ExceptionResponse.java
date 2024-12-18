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

    private int code;

    @JsonProperty("status")
    private HttpStatus httpStatus;

    private String message;

}
