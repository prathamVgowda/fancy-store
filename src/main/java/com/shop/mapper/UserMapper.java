package com.shop.mapper;

import com.shop.dto.UserDTO;
import com.shop.entity.User;

public class UserMapper {

	public static UserDTO toDto(User user) {
		UserDTO dto = new UserDTO();

		dto.setId(user.getUserId());
		dto.setUsername(user.getUsername());
		dto.setEmail(user.getEmail());
		dto.setRoles(user.getRoles());
		dto.setMobileno(user.getMobileno());

		return dto;
	}

	public static User toEntity(UserDTO dto) {
		User user = new User();

		user.setUserId(dto.getId());
		user.setUsername(dto.getUsername());
		user.setEmail(dto.getEmail());
		user.setRoles(dto.getRoles());
		user.setMobileno(dto.getMobileno());

		return user;
	}

	public static void copyToExisting(User existing, UserDTO dto) {
		existing.setUsername(dto.getUsername());
		existing.setEmail(dto.getEmail());
		existing.setRoles(dto.getRoles());
		existing.setMobileno(dto.getMobileno());
	}
}
