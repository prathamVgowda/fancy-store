package com.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.shop.dto.UserDTO;
import com.shop.entity.User;
import com.shop.repository.UserRepository;
import com.shop.service.EmailService;
import com.shop.service.UserService;

import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@Tag(name = "Fancy Store", description = "APIs for managing Fancy Store")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private EmailService emailService;

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
	
	@PostMapping("/verify")
    public String verifyUser(@RequestParam String email, @RequestParam String code) {
        User user = userRepository.findByEmail(email);

        if (user == null) {
            return "User not found.";
        }

        if (user.isVerified()) {
            return "User already verified.";
        }

        if (user.getVerificationCode().equals(code)) {
            user.setVerified(true);
            user.setVerificationCode(null);
            userRepository.save(user);

            emailService.sendRegistrationSuccessEmail(user.getEmail(), user.getUsername());

            return "User verified and registered successfully!";
        } else {
            return "Invalid verification code.";
        }
    }
}
