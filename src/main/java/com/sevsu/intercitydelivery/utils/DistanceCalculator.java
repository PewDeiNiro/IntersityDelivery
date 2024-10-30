package com.sevsu.intercitydelivery.utils;

import com.sevsu.intercitydelivery.model.Coordinate;

import static java.lang.Math.*;

public class DistanceCalculator {

    private static final int EARTH_RADIUS = 6372795;

    public static double calculateDistance(Coordinate destination, Coordinate departure) {
        double departureLatitude = departure.getLatitude(), departureLongitude = departure.getLongitude(),
                destinationLatitude = destination.getLatitude(), destinationLongitude = destination.getLongitude();

        double departureLatitudeRadians = departureLatitude * Math.PI / 180.0,
            departureLongitudeRadians = departureLongitude * Math.PI / 180.0,
            destinationLatitudeRadians = destinationLatitude * Math.PI / 180.0,
            destinationLongitudeRadians = destinationLongitude * Math.PI / 180.0,
            delta = destinationLongitudeRadians - departureLongitudeRadians,
            departureLatitudeSin = sin(departureLatitudeRadians), departureLatitudeCos = cos(departureLatitudeRadians),
            destinationLatitudeSin = sin(destinationLatitudeRadians), destinationLatitudeCos = cos(destinationLatitudeRadians),
            deltaCos = cos(delta), deltaSin = sin(delta);

        double y = sqrt(pow(destinationLatitudeCos * deltaSin, 2) + pow(departureLatitudeCos * destinationLatitudeSin - departureLatitudeSin * destinationLatitudeCos * deltaCos, 2));
        double x = departureLatitudeSin * destinationLatitudeSin + departureLatitudeCos * destinationLatitudeCos * deltaCos;
        return atan2(y, x) * EARTH_RADIUS;
    }

}
