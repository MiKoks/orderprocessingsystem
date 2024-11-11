package com.orderprocessingsystem.controllers;

import com.orderprocessingsystem.kafka.OrderEventProducer;
import com.orderprocessingsystem.model.Order;
import com.orderprocessingsystem.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderEventProducer orderEventProducer;

    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        order.setStatus("CREATED");
        Order savedOrder = orderRepository.save(order);

        // Send order creation event to Kafka
        orderEventProducer.sendOrderEvent("Order created with ID: " + savedOrder.getId());

        return savedOrder;
    }
}
