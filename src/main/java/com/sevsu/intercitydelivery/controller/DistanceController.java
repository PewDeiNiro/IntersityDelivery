package com.sevsu.intercitydelivery.controller;

import com.sevsu.intercitydelivery.exception.BadRequestException;
import com.sevsu.intercitydelivery.request.CoordinatesRequest;
import com.sevsu.intercitydelivery.response.DistanceResponse;
import com.sevsu.intercitydelivery.utils.DistanceCalculator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DistanceController {

    @GetMapping("/distance")
    public DistanceResponse getDistance(@RequestBody CoordinatesRequest request) {
        if (request == null) throw new BadRequestException("Отсутствуют входные данные");
        return new DistanceResponse(DistanceCalculator.calculateDistance(request.getDepartureLatitude(), request.getDepartureLongitude(),
                request.getDestinationLatitude(), request.getDestinationLongitude()));
    }

}
