package com.sevsu.intercitydelivery.controller;

import com.sevsu.intercitydelivery.model.Coordinate;
import com.sevsu.intercitydelivery.response.DistanceResponse;
import com.sevsu.intercitydelivery.utils.DistanceCalculator;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "DistanceController", description = "Получение расстояния между двумя географическими координатами")
@RestController
@RequestMapping("/api")
public class DistanceController {

    @Operation(summary = "Определение расстояния между двумя географическими координатами")
    @GetMapping("/distance")
    public DistanceResponse getDistance(@RequestParam double departure_latitude, @RequestParam double departure_longitude,
                                        @RequestParam double destination_latitude, @RequestParam double destination_longitude) {
        Coordinate departure = new Coordinate(departure_latitude, departure_longitude),
                destination = new Coordinate(destination_latitude, destination_longitude);
        return new DistanceResponse(DistanceCalculator.calculateDistance(departure, destination));
    }

}
