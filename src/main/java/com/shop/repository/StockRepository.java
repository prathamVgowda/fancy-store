package com.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.entity.Products;
import com.shop.entity.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
	List<Stock> findByProduct(Products product);
}
