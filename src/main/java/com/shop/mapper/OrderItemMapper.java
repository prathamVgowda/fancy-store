package com.shop.mapper;

import com.shop.dto.OrderItemDTO;
import com.shop.entity.OrderItem;
import com.shop.entity.Order;
import com.shop.entity.Products;

public class OrderItemMapper {

	public static OrderItemDTO toDto(OrderItem item) {
		OrderItemDTO dto = new OrderItemDTO();

		dto.setId(item.getId());
		dto.setOrderId(item.getOrderId().getId());
		dto.setProductId(item.getProductVariantId().getId());
		dto.setQuantity(item.getQuantity());
		dto.setPrice(item.getPrice());

		return dto;
	}

	public static OrderItem toEntity(OrderItemDTO dto, Order order, Products product) {
		OrderItem item = new OrderItem();

		item.setId(dto.getId());
		item.setOrderId(order);
		item.setProductVariantId(product);
		item.setQuantity(dto.getQuantity());
		item.setPrice(dto.getPrice());

		return item;
	}

	public static void copyToExisting(OrderItem existing, OrderItemDTO dto, Order order, Products product) {
		existing.setOrderId(order);
		existing.setProductVariantId(product);
		existing.setQuantity(dto.getQuantity());
		existing.setPrice(dto.getPrice());
	}
}
