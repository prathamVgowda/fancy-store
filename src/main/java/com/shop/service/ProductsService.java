package com.shop.service;

import java.util.List;

import com.shop.entity.Products;

public interface ProductsService {

    Products createProduct(Products product);

    Products getByIdProduct(Long productId);

    List<Products> getAllProducts();

    Products updateByProduct(Long productId, Products product);

    String deleteByProduct(Long productId);
}
