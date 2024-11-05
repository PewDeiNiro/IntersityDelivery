package com.sevsu.intercitydelivery.request;

import com.sevsu.intercitydelivery.enums.PaymentStatus;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Hidden
@NoArgsConstructor
@AllArgsConstructor
public class UpdateBalanceRequest {

    private int id;

    private String url;

    private double amount;

    private String title;

    private int userId;

    private PaymentStatus status;


}
