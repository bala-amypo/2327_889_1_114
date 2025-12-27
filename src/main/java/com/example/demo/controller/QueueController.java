// package com.example.demo.controller;

// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/queue")
// public class QueueController {

//     @PutMapping("/position/{tokenId}/{newPosition}")
//     public String updatePosition() {
//         return "ok";
//     }

//     @GetMapping("/position/{tokenId}")
//     public String getPosition() {
//         return "ok";
//     }
// }
package com.example.demo.controller;

import com.example.demo.service.impl.QueueServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/queue")
@Tag(name = "Queue Management", description = "APIs for managing queue positions")
public class QueueController {
    
    @Autowired
    private QueueServiceImpl queueService;
    
    @PutMapping("/{tokenId}/position/{position}")
    @Operation(summary = "Update queue position", description = "Update the position of a token in the queue")
    public ResponseEntity<?> updatePosition(@PathVariable Long tokenId, @PathVariable Integer position) {
        try {
            return ResponseEntity.ok(queueService.updateQueuePosition(tokenId, position));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @GetMapping("/{tokenId}/position")
    @Operation(summary = "Get queue position", description = "Get the current position of a token in the queue")
    public ResponseEntity<?> getPosition(@PathVariable Long tokenId) {
        try {
            return ResponseEntity.ok(queueService.getPosition(tokenId));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}