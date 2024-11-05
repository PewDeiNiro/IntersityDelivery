package com.sevsu.intercitydelivery.controller;

import com.sevsu.intercitydelivery.entity.Delivery;
import com.sevsu.intercitydelivery.request.CancelDeliveryRequest;
import com.sevsu.intercitydelivery.request.DeliveryRequest;
import com.sevsu.intercitydelivery.request.UpdateDeliveryStatusRequest;
import com.sevsu.intercitydelivery.response.DeliveryResponse;
import com.sevsu.intercitydelivery.service.DeliveryService;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "Создание доставки пользователем")
    @PostMapping("/execute")
    public DeliveryResponse executeDelivery(@RequestBody DeliveryRequest deliveryRequest) {
        return deliveryService.executeDelivery(deliveryRequest);
    }

    @Operation(summary = "Получение всех доставок в системе")
    @GetMapping
    public List<Delivery> getAllDeliveries(){
        return deliveryService.getAllDeliveries();
    }

    @Operation(summary = "Получение доставки по её уникальному идентификатору")
    @GetMapping("/{id}")
    public Delivery getDeliveryById(@PathVariable int id) {
        return deliveryService.getDeliveryById(id);
    }

    @Operation(summary = "Обновление статуса доставки ДРОНОМ (не использовать)")
    @PutMapping
    public Delivery updateDeliveryStatus(@RequestBody UpdateDeliveryStatusRequest request) {
        return deliveryService.updateDeliveryStatus(request);
    }

    @Operation(summary = "Отмена доставки пользователем")
    @DeleteMapping
    public String cancelDelivery(@RequestBody CancelDeliveryRequest request) {
        return deliveryService.cancelDelivery(request);
    }

}
