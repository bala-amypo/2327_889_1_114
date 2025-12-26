package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/queue")
public class QueueController {

    @PutMapping("/position/{tokenId}/{newPosition}")
    public String updatePosition() {
        return "ok";
    }

    @GetMapping("/position/{tokenId}")
    public String getPosition() {
        return "ok";
    }
}
