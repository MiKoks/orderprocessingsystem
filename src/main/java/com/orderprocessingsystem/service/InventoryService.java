package com.orderprocessingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @KafkaListener(topics = "order-events", groupId = "inventory-group")
    public void processOrder(String message) {
        // Parse message to check for "OrderCreatedEvent"
        if (message.contains("OrderCreatedEvent")) {
            System.out.println("Inventory checked and confirmed.");
            kafkaTemplate.send("order-events", "InventoryConfirmedEvent for " + message);
        }
    }
}
