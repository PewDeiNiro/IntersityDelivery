package com.sevsu.intercitydelivery.mapper;

import com.sevsu.intercitydelivery.exception.BadRequestException;
import com.sevsu.intercitydelivery.exception.HttpException;
import com.sevsu.intercitydelivery.response.ExceptionResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ExceptionResponseMapper {

    @Mapping(target = "message", source = "message")
    @Mapping(target = "code", expression = "java(httpException.getCode())")
    @Mapping(target = "httpStatus", expression = "java(httpException.getStatus())")
    ExceptionResponse mapExceptionToExceptionResponse(HttpException httpException);

}
