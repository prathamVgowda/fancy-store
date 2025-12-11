package com.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.shop.entity.BrandMaster;
import com.shop.service.BrandMasterService;

import java.util.List;

@RestController
@RequestMapping("/api/brand")
public class BrandMasterController {

	@Autowired
	private BrandMasterService brandMasterService;

	@PostMapping("/create")
	public BrandMaster createBrand(@RequestBody BrandMaster brand) {
		return brandMasterService.createBrand(brand);
	}

	@GetMapping("/{brandId}")
	public BrandMaster getBrandById(@PathVariable Long brandId) {
		return brandMasterService.getByIdBrand(brandId);
	}

	@GetMapping("/all")
	public List<BrandMaster> getAllBrand() {
		return brandMasterService.getAllBrand();
	}

	@PutMapping("/update/{brandId}")
	public BrandMaster updateBrand(@PathVariable Long brandId, @RequestBody BrandMaster brand) {
		return brandMasterService.updateByBrand(brandId, brand);
	}

	@DeleteMapping("/delete/{brandId}")
	public String deleteBrand(@PathVariable Long brandId) {
		return brandMasterService.deleteByBrand(brandId);
	}
}
