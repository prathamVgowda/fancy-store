package com.shop.mapper;

import com.shop.dto.BrandMasterDTO;
import com.shop.entity.BrandMaster;

public class BrandMasterMapper {

	public static BrandMasterDTO toDto(BrandMaster brand) {
		BrandMasterDTO dto = new BrandMasterDTO();
		dto.setId(brand.getId());
		dto.setBrandName(brand.getBrandName());
		return dto;
	}

	public static BrandMaster toEntity(BrandMasterDTO dto) {
		BrandMaster brand = new BrandMaster();
		brand.setId(dto.getId());
		brand.setBrandName(dto.getBrandName());
		return brand;
	}

	public static void copyToExisting(BrandMaster existing, BrandMasterDTO dto) {
		existing.setBrandName(dto.getBrandName());
	}
}
