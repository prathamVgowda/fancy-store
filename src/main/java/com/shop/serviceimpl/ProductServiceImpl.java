package com.shop.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.shop.dto.ProductDTO;
import com.shop.entity.Product;
import com.shop.entity.Category;
import com.shop.entity.BrandMaster;
import com.shop.mapper.ProductMapper;
import com.shop.repository.BrandMasterRepository;
import com.shop.repository.CategoryRepository;
import com.shop.repository.ProductRepository;
import com.shop.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepo;
	private final CategoryRepository categoryRepo;
	private final BrandMasterRepository brandRepo;

	public ProductServiceImpl(ProductRepository productRepo, CategoryRepository categoryRepo,
			BrandMasterRepository brandRepo) {
		this.productRepo = productRepo;
		this.categoryRepo = categoryRepo;
		this.brandRepo = brandRepo;
	}

	@Override
	public ProductDTO createProduct(ProductDTO dto) {

		Category category = categoryRepo.findById(dto.getId())
				.orElseThrow(() -> new RuntimeException("Category not found"));

		BrandMaster brand = brandRepo.findById(dto.getId()).orElseThrow(() -> new RuntimeException("Brand not found"));

		Product product = ProductMapper.toEntity(dto, category, brand);

		Product saved = productRepo.save(product);

		return ProductMapper.toDto(saved);
	}

	@Override
	public ProductDTO updateProduct(Long id, ProductDTO dto) {

		Product existing = productRepo.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));

		Category category = categoryRepo.findById(dto.getId())
				.orElseThrow(() -> new RuntimeException("Category not found"));

		BrandMaster brand = brandRepo.findById(dto.getId()).orElseThrow(() -> new RuntimeException("Brand not found"));

		ProductMapper.copyToExisting(existing, dto, category, brand);

		Product updated = productRepo.save(existing);

		return ProductMapper.toDto(updated);
	}

	@Override
	public void deleteProduct(Long id) {
		productRepo.deleteById(id);
	}

	@Override
	public ProductDTO getProductById(Long id) {
		Product product = productRepo.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));

		return ProductMapper.toDto(product);
	}

	@Override
	public List<ProductDTO> getAllProducts() {
		return productRepo.findAll().stream().map(ProductMapper::toDto).collect(Collectors.toList());
	}
}
