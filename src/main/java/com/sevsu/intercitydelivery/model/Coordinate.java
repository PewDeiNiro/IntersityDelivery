package com.sevsu.intercitydelivery.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coordinate {

    @Schema(description = "Широта географической точки")
    private double latitude;

    @Schema(description = "Долгота географической точки")
    private double longitude;

}
