package com.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.shop.dto.AddressDTO;
import com.shop.service.AddressService;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

	@Autowired
	private AddressService addressService;

	public AddressController(AddressService addressService) {
		this.addressService = addressService;
	}

	@PostMapping
	public AddressDTO create(@RequestBody AddressDTO dto) {
		return addressService.createAddress(dto);
	}

	@GetMapping("/{id}")
	public AddressDTO getById(@PathVariable Long id) {
		return addressService.getAddressById(id);
	}

	@GetMapping
	public List<AddressDTO> getAll() {
		return addressService.getAllAddresses();
	}

	@PutMapping("/{id}")
	public AddressDTO update(@PathVariable Long id, @RequestBody AddressDTO address) {
		return addressService.updateAddress(id, address);
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable Long id) {
		addressService.deleteAddress(id);
		return "Address deleted successfully";
	}
}
