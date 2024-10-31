package com.sevsu.intercitydelivery.controller;

import com.sevsu.intercitydelivery.entity.Delivery;
import com.sevsu.intercitydelivery.request.DeliveryRequest;
import com.sevsu.intercitydelivery.request.UpdateDeliveryStatusRequest;
import com.sevsu.intercitydelivery.response.DeliveryResponse;
import com.sevsu.intercitydelivery.service.DeliveryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "DeliveryController", description = "Все операции над доставками")
@RestController
@RequestMapping("/api/delivery")
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @PostMapping("/execute")
    public DeliveryResponse executeDelivery(@RequestBody DeliveryRequest deliveryRequest) {
        return deliveryService.executeDelivery(deliveryRequest);
    }

    @GetMapping("/deliveries")
    public List<Delivery> getAllDeliveries(){
        return deliveryService.getAllDeliveries();
    }

    @GetMapping("/deliveries/{id}")
    public Delivery getDeliveryById(@PathVariable int id) {
        return deliveryService.getDeliveryById(id);
    }

    @PutMapping("/deliveries")
    public Delivery updateDeliveryStatus(@RequestBody UpdateDeliveryStatusRequest request) {
        return deliveryService.updateDeliveryStatus(request);
    }

}
