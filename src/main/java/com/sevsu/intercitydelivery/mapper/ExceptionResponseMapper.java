package com.sevsu.intercitydelivery.mapper;

import com.sevsu.intercitydelivery.exception.HttpException;
import com.sevsu.intercitydelivery.response.ExceptionResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ExceptionResponseMapper {

    @Mapping(target = "code", expression = "java(httpException.getCode())")
    @Mapping(target = "httpStatus", expression = "java(httpException.getStatus())")
    ExceptionResponse mapExceptionToExceptionResponse(HttpException httpException);

}
