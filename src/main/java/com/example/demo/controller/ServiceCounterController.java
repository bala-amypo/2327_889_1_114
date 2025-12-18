@RestController
@RequestMapping("/counters")
@Tag(name = "Service Counter Controller")
public class ServiceCounterController {

    private final ServiceCounterService counterService;

    public ServiceCounterController(ServiceCounterService counterService) {
        this.counterService = counterService;
    }

    @PostMapping
    @Operation(summary = "Add new service counter")
    public ResponseEntity<?> addCounter(@RequestBody ServiceCounter counter) {
        return ResponseEntity.ok(counterService.addCounter(counter));
    }

    @GetMapping("/active")
    @Operation(summary = "List active counters")
    public ResponseEntity<?> getActiveCounters() {
        return ResponseEntity.ok(counterService.getActiveCounters());
    }
}