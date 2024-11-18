package com.orderprocessingsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.orderprocessingsystem.model.OrderStatusMessage;

@Controller
public class OrderStatusWebSocketController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    // Send a message to a specific topic when an order is created or updated
    public void sendOrderStatusUpdate(Long orderId, String status) {
        messagingTemplate.convertAndSend("/topic/orders/" + orderId, new OrderStatusMessage(orderId, status));
    }
}
