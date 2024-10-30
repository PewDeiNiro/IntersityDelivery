package com.sevsu.intercitydelivery.utils;

import com.sevsu.intercitydelivery.model.Coordinate;

public class CostCalculator {

    private static final double KM_PER_KG_COST = 1.0;

    public static double calculateDeliveryCost(Coordinate departure, Coordinate destination, double weight){
        return DistanceCalculator.calculateDistance(departure, destination) * weight * KM_PER_KG_COST;
    }

}
