package com.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.shop.dto.UserDTO;
import com.shop.service.UserService;

import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@Tag(name = "Order API", description = "Order management APIs")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO dto) {
		UserDTO savedUser = userService.createUser(dto);
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<UserDTO> getByUserId(@PathVariable Long userId) {
		UserDTO user = userService.getUserById(userId);
		return ResponseEntity.ok(user);
	}

	@GetMapping
	public ResponseEntity<List<UserDTO>> getAllUsers() {
		return ResponseEntity.ok(userService.getAllUsers());
	}

	@PutMapping("/{userId}")
	public ResponseEntity<UserDTO> updateByUserId(@PathVariable Long userId, @RequestBody UserDTO dto) {

		UserDTO updatedUser = userService.updateUser(userId, dto);
		return ResponseEntity.ok(updatedUser);
	}

	@DeleteMapping("/{userId}")
	public ResponseEntity<String> deleteByUser(@PathVariable Long userId) {
		userService.deleteUser(userId);
		return ResponseEntity.ok("User deleted successfully");
	}
}
