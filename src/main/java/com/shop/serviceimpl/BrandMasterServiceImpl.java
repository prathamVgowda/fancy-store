package com.shop.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.entity.BrandMaster;
import com.shop.exception.ResourceNotFoundException;
import com.shop.repository.BrandMasterRepository;
import com.shop.service.BrandMasterService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BrandMasterServiceImpl implements BrandMasterService {

	@Autowired
	private BrandMasterRepository brandMasterRepository;

	@Override
	public BrandMaster createBrand(BrandMaster brand) {
		return brandMasterRepository.save(brand);
	}

	@Override
	public BrandMaster getByIdBrand(Long brandId) {

		BrandMaster brand = brandMasterRepository.findById(brandId).orElseThrow(() -> {
			return new ResourceNotFoundException("Brand with the given ID not found", 404, LocalDateTime.now());
		});

		return brand;
	}

	@Override
	public List<BrandMaster> getAllBrand() {
		return brandMasterRepository.findAll();
	}

	@Override
	public BrandMaster updateByBrand(Long brandId, BrandMaster brand) {

		BrandMaster existingBrand = brandMasterRepository.findById(brandId).orElseThrow(() -> {
			return new ResourceNotFoundException("Brand with the given ID not found", 404, LocalDateTime.now());
		});

		existingBrand.setBrandName(brand.getBrandName());

		BrandMaster updatedBrand = brandMasterRepository.save(existingBrand);
		return updatedBrand;
	}

	@Override
	public String deleteByBrand(Long brandId) {

		if (!brandMasterRepository.existsById(brandId)) {
			throw new ResourceNotFoundException("Brand with the given ID not found", 404, LocalDateTime.now());
		}

		brandMasterRepository.deleteById(brandId);

		return "Brand deleted successfully!";
	}
}
