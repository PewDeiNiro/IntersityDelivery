package com.sevsu.intercitydelivery.controller;

import com.sevsu.intercitydelivery.request.UpdateBalanceRequest;
import com.sevsu.intercitydelivery.response.UpdateBalanceResponse;
import com.sevsu.intercitydelivery.service.PaymentService;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Hidden
@RequestMapping("/api/payment")
@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/update")
    public UpdateBalanceResponse updateBalance(@RequestBody UpdateBalanceRequest request) {
        return paymentService.updateBalance(request);
    }

}
