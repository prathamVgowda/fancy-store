package com.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.entity.BrandMaster;

@Repository
public interface BrandMasterRepository extends JpaRepository<BrandMaster, Long> {
}
