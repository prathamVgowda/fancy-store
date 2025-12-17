package com.shop.serviceimpl;

import org.springframework.stereotype.Service;

import com.shop.dto.CategoryDTO;
import com.shop.entity.Category;
import com.shop.mapper.CategoryMapper;
import com.shop.repository.CategoryRepository;
import com.shop.service.CategoryService;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repo;

    public CategoryServiceImpl(CategoryRepository repo) {
        this.repo = repo;
    }

    public CategoryDTO create(CategoryDTO dto) {
        return CategoryMapper.toDto(repo.save(CategoryMapper.toEntity(dto)));
    }

    public CategoryDTO update(Long id, CategoryDTO dto) {
        Category existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        CategoryMapper.copyToExisting(existing, dto);
        return CategoryMapper.toDto(repo.save(existing));
    }

    public CategoryDTO getById(Long id) {
        return CategoryMapper.toDto(
                repo.findById(id).orElseThrow(() -> new RuntimeException("Category not found")));
    }

    public List<CategoryDTO> getAll() {
        return repo.findAll().stream()
                .map(CategoryMapper::toDto)
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
