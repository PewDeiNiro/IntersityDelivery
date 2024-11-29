package com.sevsu.intercitydelivery.mapper;

import com.sevsu.intercitydelivery.request.UpdateBalanceRequest;
import com.sevsu.intercitydelivery.response.UpdateBalanceResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PaymentMapper {

    UpdateBalanceResponse mapUpdateRequestToResponse(UpdateBalanceRequest request);

}
