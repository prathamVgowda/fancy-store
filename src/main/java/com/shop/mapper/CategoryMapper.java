package com.shop.mapper;

import com.shop.dto.CategoryDTO;
import com.shop.entity.Category;

public class CategoryMapper {

	public static CategoryDTO toDto(Category category) {
		CategoryDTO dto = new CategoryDTO();
		dto.setId(category.getId());
		dto.setName(category.getCategoryName());
		return dto;
	}

	public static Category toEntity(CategoryDTO dto) {
		Category category = new Category();
		category.setId(dto.getId());
		category.setCategoryName(dto.getName());
		return category;
	}

	public static void copyToExisting(Category existing, CategoryDTO dto) {
		existing.setCategoryName(dto.getName());
	}
}
