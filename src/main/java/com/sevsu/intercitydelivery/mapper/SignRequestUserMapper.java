package com.sevsu.intercitydelivery.mapper;

import com.sevsu.intercitydelivery.entity.User;
import com.sevsu.intercitydelivery.request.SignRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SignRequestUserMapper {

    User mapSignRequestToUser(SignRequest signRequest);

}
