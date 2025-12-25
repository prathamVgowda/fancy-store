package com.shop.mapper;

import com.shop.dto.StockDTO;
import com.shop.entity.Product;
import com.shop.entity.Stock;
import com.shop.entity.Stock.TransactionType;

public class StockMapper {

	public static StockDTO toDto(Stock stock) {
		StockDTO dto = new StockDTO();

		dto.setId(stock.getId());
		dto.setProductId(stock.getProduct().getId());
		dto.setBalance(stock.getBalance());
		dto.setInward(stock.getInward());
		dto.setOutward(stock.getOutward());
		dto.setTransactionType(stock.getTransactionType().name());
		return dto;
	}

	public static Stock toEntity(StockDTO dto, Product product) {
		Stock stock = new Stock();

		stock.setProduct(product);
		stock.setBalance(dto.getBalance());
		stock.setInward(dto.getInward());
		stock.setOutward(dto.getOutward());
		stock.setTransactionType(TransactionType.valueOf(dto.getTransactionType())); // string → enum

		return stock;
	}

	public static void copyToExisting(Stock existing, StockDTO dto, Product product) {
		existing.setProduct(product);
		existing.setBalance(dto.getBalance());
		existing.setInward(dto.getInward());
		existing.setOutward(dto.getOutward());
		existing.setTransactionType(TransactionType.valueOf(dto.getTransactionType()));
	}
}
