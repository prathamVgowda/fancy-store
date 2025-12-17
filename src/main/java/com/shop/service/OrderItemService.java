package com.shop.service;

import java.util.List;

import com.shop.dto.OrderItemDTO;

public interface OrderItemService {

    OrderItemDTO createOrderItem(OrderItemDTO dto);

    OrderItemDTO updateOrderItem(Long id, OrderItemDTO dto);

    void deleteOrderItem(Long id);

    OrderItemDTO getOrderItemById(Long id);

    List<OrderItemDTO> getAllOrderItems();
}
