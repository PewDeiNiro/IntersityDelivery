package com.sevsu.intercitydelivery.mapper;

import com.sevsu.intercitydelivery.entity.Delivery;
import com.sevsu.intercitydelivery.request.DeliveryRequest;
import com.sevsu.intercitydelivery.response.DeliveryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DeliveryMapper {

    @Mapping(target = "departureLatitude", expression = "java(deliveryRequest.getDeparture().getLatitude())")
    @Mapping(target = "departureLongitude", expression = "java(deliveryRequest.getDeparture().getLongitude())")
    @Mapping(target = "destinationLatitude", expression = "java(deliveryRequest.getDestination().getLatitude())")
    @Mapping(target = "destinationLongitude", expression = "java(deliveryRequest.getDestination().getLongitude())")
    @Mapping(target = "weight", source = "weight")
    Delivery mapDeliveryRequestToDeliveryEntity(DeliveryRequest deliveryRequest);

    @Mapping(target = "deliveryId", source = "id")
    @Mapping(target = "deliveryStatus", source = "deliveryStatus")
    DeliveryResponse mapDeliveryEntityToDeliveryResponse(Delivery delivery);

}
