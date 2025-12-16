package com.shop.serviceimpl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.shop.entity.Order;
import com.shop.repository.OrderRepository;
import com.shop.service.OrderService;
import java.util.stream.Collectors;
import com.shop.dto.OrderDTO;
import com.shop.entity.User;
import com.shop.entity.Address;
import com.shop.repository.UserRepository;
import com.shop.repository.AddressRepository;
import com.shop.mapper.OrderMapper;

@Service
public class OrderServiceImpl implements OrderService {

	private final OrderRepository orderRepository;
	private final UserRepository userRepository;
	private final AddressRepository addressRepository;

	public OrderServiceImpl(OrderRepository orderRepository, UserRepository userRepository,
			AddressRepository addressRepository) {
		this.orderRepository = orderRepository;
		this.userRepository = userRepository;
		this.addressRepository = addressRepository;
	}

	@Override
	public OrderDTO createOrder(OrderDTO dto) {

		User user = userRepository.findById(dto.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));

		Address address = addressRepository.findById(dto.getAddressId()).orElseThrow(() -> new RuntimeException("Address not found"));

		Order entity = OrderMapper.toEntity(dto, user, address);

		Order saved = orderRepository.save(entity);

		return OrderMapper.toDTO(saved);
	}

	@Override
	public OrderDTO updateOrder(Long id, OrderDTO dto) {

		Order existing = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));

		User user = userRepository.findById(dto.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));

		Address address = addressRepository.findById(dto.getAddressId()).orElseThrow(() -> new RuntimeException("Address not found"));

		OrderMapper.copyToExisting(existing, dto, user, address);

		Order updated = orderRepository.save(existing);

		return OrderMapper.toDTO(updated);
	}

	@Override
	public void deleteOrder(Long id) {
		orderRepository.deleteById(id);
	}

	@Override
	public OrderDTO getOrderById(Long id) {
		Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));

		return OrderMapper.toDTO(order);
	}

	@Override
	public List<OrderDTO> getAllOrders() {
		return orderRepository.findAll().stream().map(OrderMapper::toDTO).collect(Collectors.toList());
	}
}
