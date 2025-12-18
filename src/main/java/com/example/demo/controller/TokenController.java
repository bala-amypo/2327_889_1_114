@RestController
@RequestMapping("/tokens")
@Tag(name = "Token Controller")
public class TokenController {

    private final TokenService tokenService;

    public TokenController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping("/issue/{counterId}")
    @Operation(summary = "Issue new token")
    public ResponseEntity<?> issueToken(@PathVariable Long counterId) {
        return ResponseEntity.ok(tokenService.issueToken(counterId));
    }

    @PutMapping("/status/{tokenId}")
    @Operation(summary = "Update token status")
    public ResponseEntity<?> updateStatus(
            @PathVariable Long tokenId,
            @RequestParam String status) {
        return ResponseEntity.ok(tokenService.updateStatus(tokenId, status));
    }

    @GetMapping("/{tokenId}")
    @Operation(summary = "Get token details")
    public ResponseEntity<?> getToken(@PathVariable Long tokenId) {
        return ResponseEntity.ok(tokenService.getToken(tokenId));
    }
}