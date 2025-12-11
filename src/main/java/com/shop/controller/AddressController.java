package com.shop.controller;

import org.springframework.web.bind.annotation.*;

import com.shop.entity.Address;
import com.shop.service.AddressService;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

	private final AddressService addressService;

	public AddressController(AddressService addressService) {
		this.addressService = addressService;
	}

	@PostMapping
	public Address create(@RequestBody Address address) {
		return addressService.createAddress(address);
	}

	@GetMapping("/{id}")
	public Address getById(@PathVariable Long id) {
		return addressService.getAddressById(id);
	}

	@GetMapping
	public List<Address> getAll() {
		return addressService.getAllAddresses();
	}

	@PutMapping("/{id}")
	public Address update(@PathVariable Long id, @RequestBody Address address) {
		return addressService.updateAddress(id, address);
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable Long id) {
		addressService.deleteAddress(id);
		return "Address deleted successfully";
	}
}
