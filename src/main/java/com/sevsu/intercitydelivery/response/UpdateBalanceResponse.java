package com.sevsu.intercitydelivery.response;

import com.sevsu.intercitydelivery.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateBalanceResponse {

    private int id;

    private String url;

    private double amount;

    private String title;

    private int userId;

    private PaymentStatus status;


}
