package com.orderprocessingsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private OrderStatusWebSocketController webSocketController;

    @GetMapping("/test-websocket")
    public String testWebSocket() {
        webSocketController.sendOrderStatusUpdate(1L, "TEST_STATUS");
        return "Test message sent";
    }
}
