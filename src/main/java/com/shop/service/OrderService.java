package com.shop.service;

import java.util.List;

import com.shop.dto.OrderDTO;

public interface OrderService {

    OrderDTO createOrder(OrderDTO orderDto);

    OrderDTO updateOrder(Long id, OrderDTO orderDto);

    void deleteOrder(Long id);

    OrderDTO getOrderById(Long id);

    List<OrderDTO> getAllOrders();
}