package com.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.shop.entity.Stock;
import com.shop.service.StockService;

import java.util.List;

@RestController
@RequestMapping("/api/stock")
public class StockController {

	@Autowired
	private StockService stockService;

	@PostMapping("/create")
	public Stock createStock(@RequestBody Stock stock) {
		return stockService.createStock(stock);
	}

	@GetMapping("/{stockId}")
	public Stock getStockById(@PathVariable Long stockId) {
		return stockService.getStockById(stockId);
	}

	@GetMapping("/all")
	public List<Stock> getAllStocks() {
		return stockService.getAllStocks();
	}

	@PutMapping("/update/{stockId}")
	public Stock updateStock(@PathVariable Long stockId, @RequestBody Stock stock) {
		return stockService.updateStock(stockId, stock);
	}

	@DeleteMapping("/delete/{stockId}")
	public String deleteStock(@PathVariable Long stockId) {
		return stockService.deleteStock(stockId);
	}
}
