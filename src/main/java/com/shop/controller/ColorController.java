package com.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.shop.entity.Color;
import com.shop.service.ColorService;

import java.util.List;

@RestController
@RequestMapping("/api/color")
public class ColorController {

	@Autowired
	private ColorService colorService;

	@PostMapping("/create")
	public Color createColor(@RequestBody Color color) {
		return colorService.createColor(color);
	}

	@GetMapping("/{colorId}")
	public Color getColorById(@PathVariable Long colorId) {
		return colorService.getByIdColor(colorId);
	}

	@GetMapping("/all")
	public List<Color> getAllColor() {
		return colorService.getAllColor();
	}

	@PutMapping("/update/{colorId}")
	public Color updateColor(@PathVariable Long colorId, @RequestBody Color color) {
		return colorService.updateByColor(colorId, color);
	}

	@DeleteMapping("/delete/{colorId}")
	public String deleteColor(@PathVariable Long colorId) {
		return colorService.deleteByColor(colorId);
	}
}
