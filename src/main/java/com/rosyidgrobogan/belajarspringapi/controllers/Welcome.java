package com.rosyidgrobogan.belajarspringapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/welcome")
public class Welcome {

    @GetMapping
    public String welcome() {
        return "Selamat Datang";
    }
}
