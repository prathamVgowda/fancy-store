package com.shop.controller;

import org.springframework.web.bind.annotation.*;

import com.shop.dto.ColorDTO;
import com.shop.service.ColorService;

import java.util.List;

@RestController
@RequestMapping("/api/colors")
public class ColorController {

	private final ColorService service;

	public ColorController(ColorService service) {
		this.service = service;
	}

	@PostMapping
	public ColorDTO create(@RequestBody ColorDTO dto) {
		return service.create(dto);
	}

	@GetMapping("/{id}")
	public ColorDTO getById(@PathVariable Long id) {
		return service.getById(id);
	}

	@GetMapping
	public List<ColorDTO> getAll() {
		return service.getAll();
	}

	@PutMapping("/{id}")
	public ColorDTO update(@PathVariable Long id, @RequestBody ColorDTO dto) {
		return service.update(id, dto);
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable Long id) {
		service.delete(id);
		return "Color deleted successfully";
	}
}
