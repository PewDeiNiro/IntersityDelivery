package com.sevsu.intercitydelivery.mapper;

import com.sevsu.intercitydelivery.request.UpdateBalanceRequest;
import com.sevsu.intercitydelivery.response.UpdateBalanceResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PaymentMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "url", source = "url")
    @Mapping(target = "amount", source = "amount")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "userId", source = "userId")
    @Mapping(target = "status", source = "status")
    UpdateBalanceResponse mapUpdateRequestToResponse(UpdateBalanceRequest request);

}
