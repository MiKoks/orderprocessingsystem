package com.orderprocessingsystem.repository;

import com.orderprocessingsystem.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
