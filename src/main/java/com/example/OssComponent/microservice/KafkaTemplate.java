package com.example.OssComponent.microservice;

@Autowired
private KafkaTemplate<String, String> kafkaTemplate;

public void placeOrder(String orderId) {
    kafkaTemplate.send("order-events", "Order Created: " + orderId);
    System.out.println("Order event published.");
}
