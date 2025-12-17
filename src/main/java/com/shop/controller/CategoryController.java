package com.shop.controller;

import org.springframework.web.bind.annotation.*;

import com.shop.dto.CategoryDTO;
import com.shop.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @PostMapping
    public CategoryDTO create(@RequestBody CategoryDTO dto) {
        return service.create(dto);
    }

    @GetMapping("/{id}")
    public CategoryDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<CategoryDTO> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public CategoryDTO update(@PathVariable Long id, @RequestBody CategoryDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Category deleted successfully";
    }
}
