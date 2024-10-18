package com.example.OssComponent.microservice;

// Order Service - Calling Inventory Service using RestTemplate
String inventoryUrl = "http://localhost:8081/inventory/check/" + productId;
Boolean isAvailable = restTemplate.getForObject(inventoryUrl, Boolean.class);

if (isAvailable != null && isAvailable) {
        return ResponseEntity.ok("Order placed successfully.");
} else {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Product not available.");
}
