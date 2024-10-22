package com.sevsu.intercitydelivery.mapper;

import com.sevsu.intercitydelivery.exception.BadRequestException;
import com.sevsu.intercitydelivery.response.ExceptionResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ExceptionResponseMapper {

    @Mapping(target = "message", source = "badRequestException.message")
    ExceptionResponse mapBadRequestExceptionToExceptionResponse(BadRequestException badRequestException);

}
