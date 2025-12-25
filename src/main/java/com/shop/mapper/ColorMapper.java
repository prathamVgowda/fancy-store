package com.shop.mapper;

import com.shop.dto.ColorDTO;
import com.shop.entity.Color;

public class ColorMapper {

	public static ColorDTO toDto(Color color) {
		ColorDTO dto = new ColorDTO();
		dto.setId(color.getId());
		dto.setColorName(color.getColorName());
		return dto;
	}

	public static Color toEntity(ColorDTO dto) {
		Color color = new Color();
		color.setColorName(dto.getColorName());
		return color;
	}

	public static void copyToExisting(Color existing, ColorDTO dto) {
		existing.setColorName(dto.getColorName());
	}
}
