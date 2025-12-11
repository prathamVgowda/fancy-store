package com.shop.service;

import java.util.List;

import com.shop.entity.Address;

public interface AddressService {

	Address createAddress(Address address);

	Address updateAddress(Long id, Address address);

	void deleteAddress(Long id);

	Address getAddressById(Long id);

	List<Address> getAllAddresses();
}
