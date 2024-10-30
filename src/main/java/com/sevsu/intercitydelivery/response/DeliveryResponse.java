package com.sevsu.intercitydelivery.response;

import com.sevsu.intercitydelivery.enums.DeliveryStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryResponse {

    private int deliveryId;

    private double cost;

    private DeliveryStatus deliveryStatus;

}
