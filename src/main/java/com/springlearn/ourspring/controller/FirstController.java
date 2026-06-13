package com.springlearn.ourspring.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

    @Value("${creator.name}")
    private String creator;

    @Value("${creator.company}")
    private String creatorCompany;

    @GetMapping("/")
    public String getMessage() {
        return "Hello my world from " + creator + " and he works in " + creatorCompany;
    }
}
