package com.example.OssComponent.microservice;

@KafkaListener(topics = "order-events", groupId = "notification-group")
public void sendNotification(String message) {
    System.out.println("Sending notification: " + message);
    // Logic to send email/SMS to the user
}
