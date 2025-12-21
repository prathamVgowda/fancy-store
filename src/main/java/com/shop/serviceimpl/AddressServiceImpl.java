package com.shop.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dto.AddressDTO;
import com.shop.entity.Address;
import com.shop.entity.User;
import com.shop.mapper.AddressMapper;
import com.shop.repository.AddressRepository;
import com.shop.repository.UserRepository;
import com.shop.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AddressMapper mapper;

	@Override
	public AddressDTO createAddress(AddressDTO dto) {

		User user = userRepository.findById(dto.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));

		Address address = mapper.toEntity(dto, user);

		Address saved = addressRepository.save(address);

		return mapper.toDto(saved);
	}

	@Override
	public AddressDTO updateAddress(Long id, AddressDTO dto) {

		Address existing = addressRepository.findById(id).orElseThrow(() -> new RuntimeException("Address not found"));

		User user = userRepository.findById(dto.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));

		mapper.copyToExisting(existing, dto, user);

		return mapper.toDto(addressRepository.save(existing));
	}

	@Override
	public void deleteAddress(Long id) {
		addressRepository.deleteById(id);
	}

	@Override
	public AddressDTO getAddressById(Long id) {
		return mapper
				.toDto(addressRepository.findById(id).orElseThrow(() -> new RuntimeException("Address not found")));
	}

	@Override
	public List<AddressDTO> getAllAddresses() {
		return addressRepository.findAll().stream().map(mapper::toDto).toList();
	}
}