package com.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.dto.OrderItemDTO;
import com.shop.service.OrderItemService;

@RestController
@RequestMapping("/api/orderitem")
public class OrderItemController {
	@Autowired
	private OrderItemService service;

	@PostMapping
	public OrderItemDTO create(@RequestBody OrderItemDTO dto) {
		return service.createOrderItem(dto);
	}

	@GetMapping("/{id}")
	public OrderItemDTO getById(@PathVariable Long id) {
		return service.getOrderItemById(id);
	}

	@GetMapping
	public List<OrderItemDTO> getAll() {
		return service.getAllOrderItems();
	}

	@PutMapping("/{id}")
	public OrderItemDTO update(@PathVariable Long id, @RequestBody OrderItemDTO dto) {
		return service.updateOrderItem(id, dto);
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable Long id) {
		service.deleteOrderItem(id);
		return "Color deleted successfully";
	}

}
