package com.shop.serviceimpl;

import org.springframework.stereotype.Service;

import com.shop.repository.ProductRepository;
import com.shop.repository.StockRepository;
import com.shop.service.StockService;
import java.util.List;
import java.util.stream.Collectors;
import com.shop.dto.StockDTO;
import com.shop.entity.Product;
import com.shop.entity.Stock;
import com.shop.mapper.StockMapper;

@Service
public class StockServiceImpl implements StockService {

	private final StockRepository stockRepo;
	private final ProductRepository productRepo;

	public StockServiceImpl(StockRepository stockRepo, ProductRepository productRepo) {
		this.stockRepo = stockRepo;
		this.productRepo = productRepo;
	}

	@Override
	public StockDTO createStock(StockDTO dto) {

		Product product = productRepo.findById(dto.getProductId())
				.orElseThrow(() -> new RuntimeException("Product not found"));

		Stock stock = StockMapper.toEntity(dto, product);

		Stock saved = stockRepo.save(stock);

		return StockMapper.toDto(saved);
	}

	@Override
	public StockDTO updateStock(Long id, StockDTO dto) {

		Stock existing = stockRepo.findById(id).orElseThrow(() -> new RuntimeException("Stock not found"));

		Product product = productRepo.findById(dto.getProductId())
				.orElseThrow(() -> new RuntimeException("Product not found"));

		StockMapper.copyToExisting(existing, dto, product);

		return StockMapper.toDto(stockRepo.save(existing));
	}

	@Override
	public void deleteStock(Long id) {
		stockRepo.deleteById(id);
	}

	@Override
	public StockDTO getStockById(Long id) {
		return StockMapper.toDto(stockRepo.findById(id).orElseThrow(() -> new RuntimeException("Stock not found")));
	}

	@Override
	public List<StockDTO> getAllStocks() {
		return stockRepo.findAll().stream().map(StockMapper::toDto).collect(Collectors.toList());
	}
}
