package com.shop.service;

import java.util.List;

import com.shop.dto.CategoryDTO;

public interface CategoryService {

	CategoryDTO create(CategoryDTO dto);

	CategoryDTO update(Long id, CategoryDTO dto);

	CategoryDTO getById(Long id);

	List<CategoryDTO> getAll();

	void delete(Long id);
}
