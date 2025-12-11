package com.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.shop.entity.Products;
import com.shop.service.ProductsService;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

	@Autowired
	private ProductsService productsService;

	@PostMapping("/create")
	public Products createProduct(@RequestBody Products product) {
		return productsService.createProduct(product);
	}

	@GetMapping("/{productId}")
	public Products getProductById(@PathVariable Long productId) {
		return productsService.getByIdProduct(productId);
	}

	@GetMapping("/all")
	public List<Products> getAllProducts() {
		return productsService.getAllProducts();
	}

	@PutMapping("/update/{productId}")
	public Products updateProduct(@PathVariable Long productId, @RequestBody Products product) {
		return productsService.updateByProduct(productId, product);
	}

	@DeleteMapping("/delete/{productId}")
	public String deleteProduct(@PathVariable Long productId) {
		return productsService.deleteByProduct(productId);
	}
}
