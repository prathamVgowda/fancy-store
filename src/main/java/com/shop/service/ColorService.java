package com.shop.service;

import java.util.List;

import com.shop.dto.ColorDTO;

public interface ColorService {
	ColorDTO create(ColorDTO dto);

	ColorDTO update(Long id, ColorDTO dto);

	ColorDTO getById(Long id);

	List<ColorDTO> getAll();

	void delete(Long id);
}
