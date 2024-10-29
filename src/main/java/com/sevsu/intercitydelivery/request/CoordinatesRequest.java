package com.sevsu.intercitydelivery.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Schema(description = "Географические координаты для нахождения расстояния между ними в метрах")
@NoArgsConstructor
@AllArgsConstructor
public class CoordinatesRequest {

    @Schema(description = "Широта места отправления")
    @JsonProperty("departure_latitude")
    private double departureLatitude;

    @Schema(description = "Долгота места отправления")
    @JsonProperty("departure_longitude")
    private double departureLongitude;

    @Schema(description = "Широта конечной точки")
    @JsonProperty("destination_latitude")
    private double destinationLatitude;

    @Schema(description = "Долгота конечной точки")
    @JsonProperty("destination_longitude")
    private double destinationLongitude;

}
