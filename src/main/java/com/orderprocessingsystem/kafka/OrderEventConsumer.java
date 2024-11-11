package com.orderprocessingsystem.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderEventConsumer {

    @KafkaListener(topics = "order-events", groupId = "order-group")
    public void consumeOrderEvent(String message) {
        System.out.println("Received Order Event: " + message);
        // Process the message here (e.g., update order status)
    }
}
