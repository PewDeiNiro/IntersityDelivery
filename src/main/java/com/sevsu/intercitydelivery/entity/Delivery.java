package com.sevsu.intercitydelivery.entity;

import com.sevsu.intercitydelivery.enums.DeliveryStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "deliveries")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "departure_latitude")
    private double departureLatitude;

    @Column(name = "departure_longitude")
    private double departureLongitude;

    @Column(name = "destination_latitude")
    private double destinationLatitude;

    @Column(name = "destination_longitude")
    private double destinationLongitude;

    @Column(name = "weight")
    private double weight;

    @Column(name = "delivery_status")
    private DeliveryStatus deliveryStatus;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "user_id")
    private User client;

}
