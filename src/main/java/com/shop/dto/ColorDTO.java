package com.shop.dto;

import jakarta.validation.constraints.NotBlank;

public class ColorDTO {
	
	private Long id;
	
	@NotBlank(message = "Color name is required")
	private String colorName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getColorName() {
		return colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

}
