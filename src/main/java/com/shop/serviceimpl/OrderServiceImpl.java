package com.shop.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shop.entity.Order;
import com.shop.repository.OrderRepository;
import com.shop.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	private final OrderRepository repository;

	public OrderServiceImpl(OrderRepository repository) {
		this.repository = repository;
	}

	@Override
	public Order createOrder(Order order) {
		return repository.save(order);
	}

	@Override
	public Order updateOrder(Long id, Order updated) {
		Order existing = repository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));

		existing.setUser(updated.getUser());
		existing.setAddressId(updated.getAddressId());
		existing.setTotalAmount(updated.getTotalAmount());
		existing.setStatus(updated.getStatus());

		return repository.save(existing);
	}

	@Override
	public void deleteOrder(Long id) {
		repository.deleteById(id);
	}

	@Override
	public Order getOrderById(Long id) {
		return repository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
	}

	@Override
	public List<Order> getAllOrders() {
		return repository.findAll();
	}

}
