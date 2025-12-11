package com.shop.service;

import java.util.List;

import com.shop.entity.Stock;

public interface StockService {

	Stock createStock(Stock stock);

	Stock getStockById(Long stockId);

	List<Stock> getAllStocks();

	Stock updateStock(Long stockId, Stock stock);

	String deleteStock(Long stockId);
}
