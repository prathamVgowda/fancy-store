package com.shop.serviceimpl;

import org.springframework.stereotype.Service;

import com.shop.dto.BrandMasterDTO;
import com.shop.entity.BrandMaster;
import com.shop.mapper.BrandMasterMapper;
import com.shop.repository.BrandMasterRepository;
import com.shop.service.BrandMasterService;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandMasterServiceImpl implements BrandMasterService {

	private final BrandMasterRepository repo;

	public BrandMasterServiceImpl(BrandMasterRepository repo) {
		this.repo = repo;
	}

	@Override
	public BrandMasterDTO create(BrandMasterDTO dto) 
	{
		BrandMaster brand = BrandMasterMapper.toEntity(dto);
		return BrandMasterMapper.toDto(repo.save(brand));
	}

	@Override
	public BrandMasterDTO update(Long id, BrandMasterDTO dto) {
		BrandMaster existing = repo.findById(id).orElseThrow(() -> new RuntimeException("Brand not found"));

		BrandMasterMapper.copyToExisting(existing, dto);
		return BrandMasterMapper.toDto(repo.save(existing));
	}

	@Override
	public BrandMasterDTO getById(Long id) {
		return BrandMasterMapper.toDto(repo.findById(id).orElseThrow(() -> new RuntimeException("Brand not found")));
	}

	@Override
	public List<BrandMasterDTO> getAll() {
		return repo.findAll().stream().map(BrandMasterMapper::toDto).collect(Collectors.toList());
	}

	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}
}