package com.shop.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shop.entity.Address;
import com.shop.repository.AddressRepository;
import com.shop.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

	private final AddressRepository addressRepository;

	public AddressServiceImpl(AddressRepository addressRepository) {
		this.addressRepository = addressRepository;
	}

	@Override
	public Address createAddress(Address address) {
		return addressRepository.save(address);
	}

	@Override
	public Address updateAddress(Long id, Address address) {
		Address existing = addressRepository.findById(id).orElseThrow(() -> new RuntimeException("Address not found"));

		existing.setCustomerId(address.getCustomerId());
		existing.setFullName(address.getFullName());
		existing.setAddress(address.getAddress());
		existing.setCity(address.getCity());
		existing.setState(address.getState());
		existing.setPincode(address.getPincode());
		existing.setType(address.getType());

		return addressRepository.save(existing);
	}

	@Override
	public void deleteAddress(Long id) {
		addressRepository.deleteById(id);
	}

	@Override
	public Address getAddressById(Long id) {
		return addressRepository.findById(id).orElseThrow(() -> new RuntimeException("Address not found"));
	}

	@Override
	public List<Address> getAllAddresses() {
		return addressRepository.findAll();
	}
}
