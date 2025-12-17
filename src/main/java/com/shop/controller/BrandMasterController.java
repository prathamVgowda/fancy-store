package com.shop.controller;

import com.shop.dto.BrandMasterDTO;
import com.shop.service.BrandMasterService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/brands")
public class BrandMasterController {

    private final BrandMasterService service;

    public BrandMasterController(BrandMasterService service) {
        this.service = service;
    }

    @PostMapping
    public BrandMasterDTO create(@RequestBody BrandMasterDTO dto) {
        return service.create(dto);
    }

    @GetMapping("/{id}")
    public BrandMasterDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<BrandMasterDTO> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public BrandMasterDTO update(@PathVariable Long id, @RequestBody BrandMasterDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Brand deleted successfully";
    }
}