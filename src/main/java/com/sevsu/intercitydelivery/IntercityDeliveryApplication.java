package com.sevsu.intercitydelivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EnableFeignClients
public class IntercityDeliveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(IntercityDeliveryApplication.class, args);
    }

}
