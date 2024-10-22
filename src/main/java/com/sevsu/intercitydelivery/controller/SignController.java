package com.sevsu.intercitydelivery.controller;

import com.sevsu.intercitydelivery.request.SignRequest;
import com.sevsu.intercitydelivery.response.SignResponse;
import com.sevsu.intercitydelivery.service.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class SignController {

    @Autowired
    private SignService signService;


    @PostMapping("/signup")
    public SignResponse signup(@RequestBody SignRequest signRequest) {
        return signService.signUp(signRequest);
    }

    @PostMapping("/signin")
    public SignResponse signin(@RequestBody SignRequest signRequest) {
        return signService.signIn(signRequest);
    }

}
