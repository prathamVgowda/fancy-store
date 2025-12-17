package com.shop.service;

import java.util.List;
import com.shop.dto.StockDTO;

public interface StockService {

    StockDTO createStock(StockDTO dto);

    StockDTO updateStock(Long id, StockDTO dto);

    void deleteStock(Long id);

    StockDTO getStockById(Long id);

    List<StockDTO> getAllStocks();
}
