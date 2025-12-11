package com.shop.serviceimpl;

import org.springframework.stereotype.Service;

import com.shop.entity.OrderItem;
import com.shop.repository.OrderItemRepository;
import com.shop.service.OrderItemService;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {

	private final OrderItemRepository repository;

	public OrderItemServiceImpl(OrderItemRepository repository) {
		this.repository = repository;
	}

	@Override
	public OrderItem createOrderItem(OrderItem item) {
		return repository.save(item);
	}

	@Override
	public OrderItem updateOrderItem(Long id, OrderItem updated) {
		OrderItem existing = repository.findById(id).orElseThrow(() -> new RuntimeException("Order item not found"));

		existing.setOrderId(updated.getOrderId());
		existing.setProductVariantId(updated.getProductVariantId());
		existing.setQuantity(updated.getQuantity());
		existing.setPrice(updated.getPrice());

		return repository.save(existing);
	}

	@Override
	public void deleteOrderItem(Long id) {
		repository.deleteById(id);
	}

	@Override
	public OrderItem getOrderItem(Long id) {
		return repository.findById(id).orElseThrow(() -> new RuntimeException("Order item not found"));
	}

	@Override
	public List<OrderItem> getAllOrderItems() {
		return repository.findAll();
	}

}
