package com.sevsu.intercitydelivery.feign;

import com.sevsu.intercitydelivery.request.CreatePaymentRequest;
import com.sevsu.intercitydelivery.response.CreatePaymentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "PaymentClient",
        url = "${services.payment.url}")
public interface PaymentClient {

    @PostMapping("/invoice")
    CreatePaymentResponse createInvoice(@RequestBody CreatePaymentRequest request);

}
