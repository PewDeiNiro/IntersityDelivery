package com.sevsu.intercitydelivery.mapper;

import com.sevsu.intercitydelivery.request.UpdateBalanceRequest;
import com.sevsu.intercitydelivery.response.UpdateBalanceResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PaymentMapper {

    UpdateBalanceResponse mapUpdateRequestToResponse(UpdateBalanceRequest request);

}
