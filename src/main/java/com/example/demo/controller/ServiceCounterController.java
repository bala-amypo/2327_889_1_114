package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/counters")
public class ServiceCounterController {

    @PostMapping
    public String addCounter() {
        return "ok";
    }

    @GetMapping("/active")
    public String getActive() {
        return "ok";
    }
}
