package com.shop.mapper;

import com.shop.dto.OrderDTO;
import com.shop.entity.Address;
import com.shop.entity.Order;
import com.shop.entity.Order.Status;
import com.shop.entity.User;

public class OrderMapper {
	public static OrderDTO toDTO(Order order) {

		OrderDTO dto = new OrderDTO();
		dto.setId(order.getId());
		dto.setAddressId(order.getAddressId().getId());
		dto.setUserId(order.getUser().getUserId());
		dto.setTotalAmount(order.getTotalAmount());
		dto.setStatus(order.getStatus().toString());

		return dto;

	}

	public static Order toEntity(OrderDTO dto, User user, Address address) {
		Order order = new Order();

		order.setId(dto.getId());
		order.setAddressId(address);
		order.setUser(user);
		order.setTotalAmount(dto.getTotalAmount());
		order.setStatus(Status.valueOf(dto.getStatus()));

		return order;

	}

	public static void copyToExisting(Order existing, OrderDTO dto, User user, Address address) {
		existing.setAddressId(address);
		existing.setUser(user);
		existing.setTotalAmount(dto.getTotalAmount());
		existing.setStatus(Status.valueOf(dto.getStatus()));
	}

}
