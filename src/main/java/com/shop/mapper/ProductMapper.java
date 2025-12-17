package com.shop.mapper;

import com.shop.dto.ProductDTO;
import com.shop.entity.BrandMaster;
import com.shop.entity.Category;
import com.shop.entity.Product;

public class ProductMapper {

	public static ProductDTO toDto(Product product) {
		ProductDTO dto = new ProductDTO();

		dto.setId(product.getId());
		dto.setProductName(product.getProductName());
		dto.setPrice(product.getPrice());
		dto.setCategoryName(product.getCategory().getCategoryName());
		dto.setBrandName(product.getBrand().getBrandName());

		return dto;
	}

	public static Product toEntity(ProductDTO dto,	Category category, BrandMaster brandMaster) 
	{
		Product product = new Product();

		product.setId(dto.getId());
		product.setProductName(dto.getProductName());
		product.setCategory(category);
		product.setBrand(brandMaster);
		product.setPrice(dto.getPrice());
		return product;
	}

	public static void copyToExisting(Product existing, ProductDTO dto, Category category, BrandMaster brandMaster) {
		existing.setProductName(dto.getProductName());
		existing.setPrice(dto.getPrice());
		existing.setCategory(category);
		existing.setBrand(brandMaster);
		
	}
}
