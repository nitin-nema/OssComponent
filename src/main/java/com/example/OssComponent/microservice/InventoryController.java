package com.example.OssComponent.microservice;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @GetMapping("/check/{productId}")
    public ResponseEntity<Boolean> checkAvailability(@PathVariable String productId) {
        // Simulate product availability check
        boolean available = Math.random() > 0.2; // 80% chance of being available
        return ResponseEntity.ok(available);
    }
}
