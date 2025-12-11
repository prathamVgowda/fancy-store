package com.shop.service;

import java.util.List;

import com.shop.entity.OrderItem;

public interface OrderItemService {

	OrderItem createOrderItem(OrderItem item);

	OrderItem updateOrderItem(Long id, OrderItem item);

	void deleteOrderItem(Long id);

	OrderItem getOrderItem(Long id);

	List<OrderItem> getAllOrderItems();

}
