package com.shop.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.entity.Category;
import com.shop.exception.ResourceNotFoundException;
import com.shop.repository.CategoryRepository;
import com.shop.service.CategoryService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category createCategory(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	@Override
	public Category getByIdCategory(Long categoryId) {
		Category category = categoryRepository.findById(categoryId).orElseThrow(() -> {
			return new ResourceNotFoundException("Category with the given ID not found", 404, LocalDateTime.now());
		});

		return category;
	}

	@Override
	public Category updateByCategory(Long categoryId, Category category) {

		Category existingCategory = categoryRepository.findById(categoryId).orElseThrow(() -> {
			return new ResourceNotFoundException("Category with the given ID not found", 404, LocalDateTime.now());
		});

		existingCategory.setCategoryName(category.getCategoryName());

		Category updatedCategory = categoryRepository.save(existingCategory);
		return updatedCategory;
	}

	@Override
	public String deleteByCategory(Long categoryId) {

		if (!categoryRepository.existsById(categoryId)) {
			throw new ResourceNotFoundException("Category with the given ID not found", 404, LocalDateTime.now());
		}

		categoryRepository.deleteById(categoryId);

		return "Category deleted successfully!";
	}
}
