package com.microservices_payment_system.notification_service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationListener {
	
	@KafkaListener(topics = "payment-topic", groupId = "notification-group")
    public void listen(String message) {
        System.out.println("Received Notification: " + message);
    }

}
