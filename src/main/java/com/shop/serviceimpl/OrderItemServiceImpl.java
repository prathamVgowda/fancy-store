package com.shop.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.shop.dto.OrderItemDTO;
import com.shop.entity.Order;
import com.shop.entity.Product;
import com.shop.entity.OrderItem;
import com.shop.mapper.OrderItemMapper;
import com.shop.repository.OrderItemRepository;
import com.shop.repository.OrderRepository;
import com.shop.repository.ProductRepository;
import com.shop.service.OrderItemService;

@Service
public class OrderItemServiceImpl implements OrderItemService {

	private final OrderItemRepository itemRepo;
	private final OrderRepository orderRepo;
	private final ProductRepository productRepo;

	public OrderItemServiceImpl(OrderItemRepository itemRepo, OrderRepository orderRepo,
			ProductRepository productRepo) {
		this.itemRepo = itemRepo;
		this.orderRepo = orderRepo;
		this.productRepo = productRepo;
	}

	@Override
	public OrderItemDTO createOrderItem(OrderItemDTO dto) {

		Order order = orderRepo.findById(dto.getOrderId()).orElseThrow(() -> new RuntimeException("Order not found"));

		Product product = productRepo.findById(dto.getProductId())
				.orElseThrow(() -> new RuntimeException("Product not found"));

		OrderItem item = OrderItemMapper.toEntity(dto, order, product);

		OrderItem saved = itemRepo.save(item);

		return OrderItemMapper.toDto(saved);
	}

	@Override
	public OrderItemDTO updateOrderItem(Long id, OrderItemDTO dto) {

		OrderItem existing = itemRepo.findById(id).orElseThrow(() -> new RuntimeException("Order item not found"));

		Order order = orderRepo.findById(dto.getOrderId()).orElseThrow(() -> new RuntimeException("Order not found"));

		Product product = productRepo.findById(dto.getProductId())
				.orElseThrow(() -> new RuntimeException("Product not found"));

		OrderItemMapper.copyToExisting(existing, dto, order, product);

		return OrderItemMapper.toDto(itemRepo.save(existing));
	}

	@Override
	public void deleteOrderItem(Long id) {
		itemRepo.deleteById(id);
	}

	@Override
	public OrderItemDTO getOrderItemById(Long id) {
		return OrderItemMapper
				.toDto(itemRepo.findById(id).orElseThrow(() -> new RuntimeException("Order item not found")));
	}

	@Override
	public List<OrderItemDTO> getAllOrderItems() {
		return itemRepo.findAll().stream().map(OrderItemMapper::toDto).collect(Collectors.toList());
	}
}
