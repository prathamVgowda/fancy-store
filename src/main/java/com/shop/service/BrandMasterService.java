package com.shop.service;

import java.util.List;

import com.shop.entity.BrandMaster;

public interface BrandMasterService {

    BrandMaster createBrand(BrandMaster brand);

    BrandMaster getByIdBrand(Long id);

    List<BrandMaster> getAllBrand();

    BrandMaster updateByBrand(Long id, BrandMaster brand);

    String deleteByBrand(Long id);
}
