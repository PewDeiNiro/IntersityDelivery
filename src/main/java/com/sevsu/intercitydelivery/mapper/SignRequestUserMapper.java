package com.sevsu.intercitydelivery.mapper;

import com.sevsu.intercitydelivery.entity.User;
import com.sevsu.intercitydelivery.request.SignRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SignRequestUserMapper {

    User mapSignRequestToUser(SignRequest signRequest);

}
