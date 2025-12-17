package com.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.shop.dto.StockDTO;
import com.shop.service.StockService;
import java.util.List;

@RestController
@RequestMapping("/api/stock")
public class StockController {

	@Autowired
	private StockService stockService;

	@PostMapping("/create")
	public StockDTO createStock(@RequestBody StockDTO dto) {
		return stockService.createStock(dto);
	}

	@GetMapping("/{stockId}")
	public StockDTO getStockById(@PathVariable Long stockId) {
		return stockService.getStockById(stockId);
	}

	@GetMapping("/all")
	public List<StockDTO> getAllStocks() {
		return stockService.getAllStocks();
	}

	@PutMapping("/update/{stockId}")
	public StockDTO updateStock(@PathVariable Long stockId, @RequestBody StockDTO dto) {
		return stockService.updateStock(stockId, dto);
	}

	@DeleteMapping("/delete/{stockId}")
	public String deleteStock(@PathVariable Long stockId) {
		stockService.deleteStock(stockId);
		return "Stock deleted successfully!";
	}
}
