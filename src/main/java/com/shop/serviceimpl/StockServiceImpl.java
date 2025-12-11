package com.shop.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.entity.Stock;
import com.shop.exception.ResourceNotFoundException;
import com.shop.repository.StockRepository;
import com.shop.service.StockService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StockServiceImpl implements StockService {

	@Autowired
	private StockRepository stockRepository;

	@Override
	public Stock createStock(Stock stock) {
		return stockRepository.save(stock);
	}

	@Override
	public Stock getStockById(Long stockId) {
		return stockRepository.findById(stockId)
				.orElseThrow(() -> new ResourceNotFoundException("Stock entry with the given ID not found", 404,
						LocalDateTime.now()));
	}

	@Override
	public List<Stock> getAllStocks() {
		return stockRepository.findAll();
	}

	@Override
	public Stock updateStock(Long stockId, Stock stock) {
		Stock existingStock = stockRepository.findById(stockId)
				.orElseThrow(() -> new ResourceNotFoundException("Stock entry with the given ID not found", 404,
						LocalDateTime.now()));

		existingStock.setProduct(stock.getProduct());
		existingStock.setBalance(stock.getBalance());
		existingStock.setInward(stock.getInward());
		existingStock.setOutward(stock.getOutward());
		existingStock.setTransactionType(stock.getTransactionType());

		return stockRepository.save(existingStock);
	}

	@Override
	public String deleteStock(Long stockId) {
		if (!stockRepository.existsById(stockId)) {
			throw new ResourceNotFoundException("Stock entry with the given ID not found", 404, LocalDateTime.now());
		}

		stockRepository.deleteById(stockId);
		return "Stock entry deleted successfully!";
	}
}
