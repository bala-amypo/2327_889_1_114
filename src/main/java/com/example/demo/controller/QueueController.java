@RestController
@RequestMapping("/queue")
@Tag(name = "Queue Controller")
public class QueueController {

    private final QueueService queueService;

    public QueueController(QueueService queueService) {
        this.queueService = queueService;
    }

    @PutMapping("/position/{tokenId}/{newPosition}")
    @Operation(summary = "Update queue position")
    public ResponseEntity<?> updatePosition(
            @PathVariable Long tokenId,
            @PathVariable int newPosition) {
        return ResponseEntity.ok(queueService.updatePosition(tokenId, newPosition));
    }

    @GetMapping("/position/{tokenId}")
    @Operation(summary = "Get queue position for token")
    public ResponseEntity<?> getPosition(@PathVariable Long tokenId) {
        return ResponseEntity.ok(queueService.getPosition(tokenId));
    }
}