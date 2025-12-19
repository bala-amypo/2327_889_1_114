package com.example.demo.controller;

import com.example.demo.entity.QueuePosition;
import com.example.demo.service.QueueService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/queue")
public class QueueController {

    private final QueueService service;

    public QueueController(QueueService service) {
        this.service = service;
    }

    @PutMapping("/update/{tokenId}")
    public QueuePosition updateQueue(
            @PathVariable Long tokenId,
            @RequestParam Integer position) {
        return service.updateQueuePosition(tokenId, position);
    }

    @GetMapping("/{tokenId}")
    public QueuePosition getPosition(@PathVariable Long tokenId) {
        return service.getPosition(tokenId);
    }
}
