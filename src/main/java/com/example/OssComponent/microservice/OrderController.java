package com.example.OssComponent.microservice;

@RestController
@RequestMapping("/order") // base url
public class OrderController {

    private final RestTemplate restTemplate;

    public OrderController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping("/place/{productId}")
    public ResponseEntity<String> placeOrder(@PathVariable String productId) {
        String inventoryUrl = "http://localhost:8081/inventory/check/" + productId;

        // Call Inventory Service to check availability
        Boolean isAvailable = restTemplate.getForObject(inventoryUrl, Boolean.class);

        if (isAvailable != null && isAvailable) {
            return ResponseEntity.ok("Order placed successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Product not available.");
        }
    }
}
