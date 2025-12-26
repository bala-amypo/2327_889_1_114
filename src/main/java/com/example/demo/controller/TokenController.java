package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tokens")
public class TokenController {

    @PostMapping("/issue/{counterId}")
    public String issue() {
        return "ok";
    }

    @PutMapping("/status/{tokenId}")
    public String update() {
        return "ok";
    }

    @GetMapping("/{tokenId}")
    public String get() {
        return "ok";
    }
}
