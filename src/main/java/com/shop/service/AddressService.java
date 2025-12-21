package com.shop.service;

import java.util.List;

import com.shop.dto.AddressDTO;

public interface AddressService {

    AddressDTO createAddress(AddressDTO dto);

    AddressDTO updateAddress(Long id, AddressDTO dto);

    void deleteAddress(Long id);

    AddressDTO getAddressById(Long id);

    List<AddressDTO> getAllAddresses();
}
