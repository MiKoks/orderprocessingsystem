package com.orderprocessingsystem.orderprocessingsystem;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.orderprocessingsystem.controllers.OrderStatusWebSocketController;
import com.orderprocessingsystem.model.OrderEntity;
import com.orderprocessingsystem.repository.OrderRepository;
import com.orderprocessingsystem.service.OrderService;

@SpringBootTest
class OrderprocessingsystemApplicationTests {

	@Test
	void contextLoads() {
	}

}
