package com.shop.service;

import java.util.List;

import com.shop.entity.Category;

public interface CategoryService {

	Category createCategory(Category category);

	Category getByIdCategory(Long categoryId);

	List<Category> getAllCategories();

	Category updateByCategory(Long categoryId, Category category);

	String deleteByCategory(Long categoryId);
}
