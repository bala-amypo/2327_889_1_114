@RestController
@RequestMapping("/logs")
@Tag(name = "Token Log Controller")
public class TokenLogController {

    private final TokenLogService tokenLogService;

    public TokenLogController(TokenLogService tokenLogService) {
        this.tokenLogService = tokenLogService;
    }

    @PostMapping("/{tokenId}")
    @Operation(summary = "Add log for token")
    public ResponseEntity<?> addLog(
            @PathVariable Long tokenId,
            @RequestParam String message) {
        return ResponseEntity.ok(tokenLogService.addLog(tokenId, message));
    }

    @GetMapping("/{tokenId}")
    @Operation(summary = "Get logs for token")
    public ResponseEntity<?> getLogs(@PathVariable Long tokenId) {
        return ResponseEntity.ok(tokenLogService.getLogs(tokenId));
    }
}