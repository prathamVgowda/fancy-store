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

import com.shop.dto.OrderDTO;
import com.shop.service.OrderService;


@RestController
@RequestMapping("/api/order")
public class OrderController {
	@Autowired
	private OrderService service;

	@PostMapping
	public OrderDTO create(@RequestBody OrderDTO dto) {
		return service.createOrder(dto);
	}

	@GetMapping("/{id}")
	public OrderDTO getById(@PathVariable Long id) {
		return service.getOrderById(id);
	}

	@GetMapping
	public List<OrderDTO> getAll() {
		return service.getAllOrders();
	}

	@PutMapping("/{id}")
	public OrderDTO update(@PathVariable Long id, @RequestBody OrderDTO dto) {
		return service.updateOrder(id, dto);
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable Long id) {
		service.deleteOrder(id);
		return "Color deleted successfully";
	}

}
