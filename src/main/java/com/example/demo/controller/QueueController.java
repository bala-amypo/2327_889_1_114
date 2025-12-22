package com.example.demo.controller;

import com.example.demo.dto.QueuePositionResponse;
import com.example.demo.entity.QueuePosition;
import com.example.demo.service.QueueService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/queue")
public class QueueController {

    private final QueueService queueService;

    public QueueController(QueueService queueService) {
        this.queueService = queueService;
    }

    @PutMapping("/position/{tokenId}/{newPosition}")
    public QueuePositionResponse update(@PathVariable Long tokenId,
                                        @PathVariable Integer newPosition) {

        QueuePosition qp = queueService.updateQueuePosition(tokenId, newPosition);

        return new QueuePositionResponse(
                qp.getToken().getTokenNumber(),
                qp.getPosition(),
                qp.getUpdatedAt()
        );
    }

    @GetMapping("/position/{tokenId}")
    public QueuePosition get(@PathVariable Long tokenId) {
        return queueService.getPosition(tokenId);
    }
}
