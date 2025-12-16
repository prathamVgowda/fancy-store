package com.shop.mapper;

import com.shop.dto.ProductDTO;
import com.shop.entity.Products;

public class ProductMapper {

	public static ProductDTO toDto(Products product) {
		ProductDTO dto = new ProductDTO();

		dto.setId(product.getId());
		dto.setProductName(product.getProductName());
		dto.setPrice(product.getPrice());
		dto.setCategoryName(product.getCategory().getCategoryName());
		dto.setBrandName(product.getBrand().getBrandName());

		return dto;
	}

	public static Products toEntity(ProductDTO dto) {
		Products product = new Products();

		product.setId(dto.getId());
		product.setProductName(dto.getProductName());
		product.setPrice(dto.getPrice());
		return product;
	}

	public static void copyToExisting(Products existing, ProductDTO dto) {
		existing.setProductName(dto.getProductName());
		existing.setPrice(dto.getPrice());
	}
}
