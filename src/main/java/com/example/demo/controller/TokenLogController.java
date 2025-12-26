package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/logs")
public class TokenLogController {

    @PostMapping("/{tokenId}")
    public String addLog() {
        return "ok";
    }

    @GetMapping("/{tokenId}")
    public String getLogs() {
        return "ok";
    }
}
