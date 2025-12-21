package com.shop.mapper;

import org.springframework.stereotype.Component;

import com.shop.dto.AddressDTO;
import com.shop.entity.Address;
import com.shop.entity.User;

@Component
public class AddressMapper {

	public AddressDTO toDto(Address address) {
		AddressDTO dto = new AddressDTO();

		dto.setId(address.getId());
		dto.setAddress(address.getAddress());
		dto.setCity(address.getCity());
		dto.setFullName(address.getFullName());
		dto.setPincode(address.getPincode());
		dto.setState(address.getState());
		dto.setType(address.getType());
		dto.setUserId(address.getUser().getUserId());
		dto.setUsername(address.getUser().getUsername());
		dto.setEmail(address.getUser().getEmail());

		return dto;
	}

	public Address toEntity(AddressDTO dto, User user) {
		Address address = new Address();

		address.setAddress(dto.getAddress());
		address.setCity(dto.getCity());
		address.setFullName(dto.getFullName());
		address.setPincode(dto.getPincode());
		address.setState(dto.getState());
		address.setType(dto.getType());
		address.setUser(user);

		return address;
	}

	public void copyToExisting(Address address, AddressDTO dto, User user) {
		address.setAddress(dto.getAddress());
		address.setCity(dto.getCity());
		address.setFullName(dto.getFullName());
		address.setPincode(dto.getPincode());
		address.setState(dto.getState());
		address.setType(dto.getType());
		address.setUser(user);
	}
}
