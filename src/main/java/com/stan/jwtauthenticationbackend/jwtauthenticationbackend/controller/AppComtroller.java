package com.stan.jwtauthenticationbackend.jwtauthenticationbackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AppComtroller {

@GetMapping
public String testApp() {
    return "Hello Spring Security";
}
        }