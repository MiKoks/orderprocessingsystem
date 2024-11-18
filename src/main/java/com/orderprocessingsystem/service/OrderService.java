package com.orderprocessingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderprocessingsystem.controllers.OrderStatusWebSocketController;
import com.orderprocessingsystem.model.OrderEntity;
import com.orderprocessingsystem.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderStatusWebSocketController webSocketController;

    public OrderEntity createOrder(OrderEntity order) {
        order.setStatus("CREATED");
        OrderEntity savedOrder = orderRepository.save(order);

        // Send initial order status update
        webSocketController.sendOrderStatusUpdate(savedOrder.getId(), savedOrder.getStatus());

        // Example of processing other stages
        updateOrderStatus(savedOrder, "INVENTORY_CONFIRMED");
        updateOrderStatus(savedOrder, "PAYMENT_CONFIRMED");
        updateOrderStatus(savedOrder, "SHIPPED");

        return savedOrder;
    }

    private void updateOrderStatus(OrderEntity order, String newStatus) {
        order.setStatus(newStatus);
        orderRepository.save(order);
        webSocketController.sendOrderStatusUpdate(order.getId(), newStatus);
    }
}
