package com.sevsu.intercitydelivery.controller;

import com.sevsu.intercitydelivery.request.SignRequest;
import com.sevsu.intercitydelivery.response.SignResponse;
import com.sevsu.intercitydelivery.service.SignService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "SignController", description = "Операции регистрации/авторизации пользователя")
@RestController
@RequestMapping("/api")
public class SignController {

    @Autowired
    private SignService signService;

    @Operation(summary = "Регистрация пользователя")
    @PostMapping("/signup")
    public SignResponse signup(@RequestBody SignRequest signRequest) {
        return signService.signUp(signRequest);
    }

    @Operation(summary = "Авторизация пользователя")
    @PostMapping("/signin")
    public SignResponse signin(@RequestBody SignRequest signRequest) {
        return signService.signIn(signRequest);
    }

}
