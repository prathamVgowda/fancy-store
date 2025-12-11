package com.shop.service;

import java.util.List;

import com.shop.entity.Order;

public interface OrderService {

	Order createOrder(Order order);

	Order updateOrder(Long id, Order order);

	void deleteOrder(Long id);

	Order getOrderById(Long id);

	List<Order> getAllOrders();

}
