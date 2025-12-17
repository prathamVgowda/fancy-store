package com.shop.dto;

import jakarta.validation.constraints.NotBlank;

public class BrandMasterDTO {
	private Long id;

	@NotBlank(message = "Brand Name is required")
	private String brandName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

}
