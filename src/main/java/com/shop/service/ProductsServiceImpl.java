package com.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.entity.Products;
import com.shop.exception.ResourceNotFoundException;
import com.shop.repository.ProductsRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductsServiceImpl implements ProductsService {

	@Autowired
	private ProductsRepository productsRepository;

	@Override
	public Products createProduct(Products product) {
		return productsRepository.save(product);
	}

	@Override
	public Products getByIdProduct(Long productId) {
		Products product = productsRepository.findById(productId).orElseThrow(() -> {
			return new ResourceNotFoundException("Product with the given ID not found", 404, LocalDateTime.now());
		});

		return product;
	}

	@Override
	public List<Products> getAllProducts() {
		return productsRepository.findAll();
	}

	@Override
	public Products updateByProduct(Long productId, Products product) {

		Products existingProduct = productsRepository.findById(productId).orElseThrow(() -> {
			return new ResourceNotFoundException("Product with the given ID not found", 404, LocalDateTime.now());
		});

		existingProduct.setCategoryLink(product.getCategoryLink());
		existingProduct.setProductName(product.getProductName());
		existingProduct.setDescription(product.getDescription());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setBrandLink(product.getBrandLink());
		existingProduct.setStatus(product.getStatus());
		existingProduct.setCreatedBy(product.getCreatedBy());
		existingProduct.setUpdatedBy(product.getUpdatedBy());

		return productsRepository.save(existingProduct);
	}

	@Override
	public String deleteByProduct(Long productId) {

		if (!productsRepository.existsById(productId)) {
			throw new ResourceNotFoundException("Product with the given ID not found", 404, LocalDateTime.now());
		}

		productsRepository.deleteById(productId);
		return "Product deleted successfully!";
	}
}
