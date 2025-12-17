package com.shop.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.shop.dto.UserDTO;
import com.shop.entity.User;
import com.shop.mapper.UserMapper;
import com.shop.repository.UserRepository;
import com.shop.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository repo;

	public UserServiceImpl(UserRepository repo) {
		this.repo = repo;
	}

	@Override
	public UserDTO createUser(UserDTO dto) {
		User user = UserMapper.toEntity(dto);
		return UserMapper.toDto(repo.save(user));
	}

	@Override
	public UserDTO updateUser(Long id, UserDTO dto) {

		User existing = repo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

		UserMapper.copyToExisting(existing, dto);

		return UserMapper.toDto(repo.save(existing));
	}

	@Override
	public void deleteUser(Long id) {
		repo.deleteById(id);
	}

	@Override
	public UserDTO getUserById(Long id) {
		return UserMapper.toDto(repo.findById(id).orElseThrow(() -> new RuntimeException("User not found")));
	}

	@Override
	public List<UserDTO> getAllUsers() {
		return repo.findAll().stream().map(UserMapper::toDto).collect(Collectors.toList());
	}
}