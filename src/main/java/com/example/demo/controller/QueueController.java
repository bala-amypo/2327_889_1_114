// src/main/java/com/example/demo/controller/QueueController.java
package com.example.demo.controller;

import com.example.demo.entity.QueuePosition;
import com.example.demo.service.QueueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/queue")
@RequiredArgsConstructor
public class QueueController {
    private final QueueService queueService;

    @PutMapping("/position/{tokenId}/{newPosition}")
    public ResponseEntity<QueuePosition> updateQueuePosition(
            @PathVariable Long tokenId,
            @PathVariable Integer newPosition) {
        QueuePosition updatedPosition = queueService.updateQueuePosition(tokenId, newPosition);
        return ResponseEntity.ok(updatedPosition);
    }

    @GetMapping("/position/{tokenId}")
    public ResponseEntity<Integer> getPosition(@PathVariable Long tokenId) {
        Integer position = queueService.getPosition(tokenId);
        return ResponseEntity.ok(position);
    }
}