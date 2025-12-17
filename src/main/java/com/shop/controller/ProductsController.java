package com.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.shop.service.ProductService;
import java.util.List;
import com.shop.dto.ProductDTO;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

	@Autowired
	private ProductService productService;

	@PostMapping("/create")
	public ProductDTO createProduct(@RequestBody ProductDTO dto) {
		return productService.createProduct(dto);
	}

	@GetMapping("/{productId}")
	public ProductDTO getProductById(@PathVariable Long productId) {
		return productService.getProductById(productId);
	}

	@GetMapping("/all")
	public List<ProductDTO> getAllProducts() {
		return productService.getAllProducts();
	}

	@PutMapping("/update/{productId}")
	public ProductDTO updateProduct(@PathVariable Long productId, @RequestBody ProductDTO dto) {
		return productService.updateProduct(productId, dto);
	}

	@DeleteMapping("/delete/{productId}")
	public String deleteProduct(@PathVariable Long productId) {
		productService.deleteProduct(productId);
		return "Product deleted successfully!";
	}
}
