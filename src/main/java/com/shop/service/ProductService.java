package com.shop.service;

import java.util.List;
import com.shop.dto.ProductDTO;

public interface ProductService {

	ProductDTO createProduct(ProductDTO dto);

	ProductDTO updateProduct(Long id, ProductDTO dto);

	void deleteProduct(Long id);

	ProductDTO getProductById(Long id);

	List<ProductDTO> getAllProducts();
}
