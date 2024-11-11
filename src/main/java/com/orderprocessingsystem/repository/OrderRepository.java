package com.orderprocessingsystem.repository;

import com.orderprocessingsystem.model.OrderEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
