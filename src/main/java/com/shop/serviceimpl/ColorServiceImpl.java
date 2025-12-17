package com.shop.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.shop.dto.ColorDTO;
import com.shop.entity.Color;
import com.shop.mapper.ColorMapper;
import com.shop.repository.ColorRepository;
import com.shop.service.ColorService;

@Service
public class ColorServiceImpl implements ColorService {

	private final ColorRepository repo;

	public ColorServiceImpl(ColorRepository repo) {
		this.repo = repo;
	}

	public ColorDTO create(ColorDTO dto) {
		return ColorMapper.toDto(repo.save(ColorMapper.toEntity(dto)));
	}

	public ColorDTO update(Long id, ColorDTO dto) {
		Color existing = repo.findById(id).orElseThrow(() -> new RuntimeException("Color not found"));
		ColorMapper.copyToExisting(existing, dto);
		return ColorMapper.toDto(repo.save(existing));
	}

	public ColorDTO getById(Long id) {
		return ColorMapper.toDto(repo.findById(id).orElseThrow(() -> new RuntimeException("Color not found")));
	}

	public List<ColorDTO> getAll() {
		return repo.findAll().stream().map(ColorMapper::toDto).collect(Collectors.toList());
	}

	public void delete(Long id) {
		repo.deleteById(id);
	}
}
