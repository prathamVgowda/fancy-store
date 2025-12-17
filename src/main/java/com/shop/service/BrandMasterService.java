package com.shop.service;

import java.util.List;

import com.shop.dto.BrandMasterDTO;

public interface BrandMasterService {

	BrandMasterDTO create(BrandMasterDTO dto);

	BrandMasterDTO update(Long id, BrandMasterDTO dto);

	BrandMasterDTO getById(Long id);

	List<BrandMasterDTO> getAll();

	void delete(Long id);
}
