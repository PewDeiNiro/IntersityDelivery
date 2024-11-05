package com.sevsu.intercitydelivery.controller;

import com.sevsu.intercitydelivery.entity.Delivery;
import com.sevsu.intercitydelivery.request.CreatePaymentRequest;
import com.sevsu.intercitydelivery.response.CreatePaymentResponse;
import com.sevsu.intercitydelivery.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "UserController", description = "Все операции связанные с пользователем")
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(summary = "Получение всех доставок пользователя")
    @GetMapping("/{id}")
    public List<Delivery> getAllUserDeliveries(@PathVariable int id){
        return userService.getAllUserDeliveries(id);
    }

    @Operation(summary = "Создание транзакции пополнение счета")
    @PostMapping("/payment/create")
    public CreatePaymentResponse createUserPayment(@RequestBody CreatePaymentRequest request){
        return userService.createUserPayment(request);
    }

}
