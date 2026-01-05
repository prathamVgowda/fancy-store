package com.shop.controller;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.config.JwtUtil;
import com.shop.dto.AuthRequest;
import com.shop.dto.AuthResponse;
import com.shop.dto.RefreshTokenRequest;
import com.shop.entity.User;
import com.shop.repository.UserRepository;
import com.shop.service.EmailService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private EmailService emailService;

	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody User user) {
		if (!isValidEmail(user.getEmail())) {
			return ResponseEntity.badRequest().body("Invalid email format.");
		}

		User existingUser = userRepository.findByEmail(user.getEmail());
		if (existingUser != null) {
			if (existingUser.isVerified()) {
				return ResponseEntity.badRequest().body("Email already registered and verified. Please login.");
			} else {
				return ResponseEntity.badRequest()
						.body("Email is already registered but not verified. Please check your email.");
			}
		}

		user.setPassword(passwordEncoder.encode(user.getPassword()));

		String inputRole = user.getRoles().toUpperCase();
		if (!inputRole.startsWith("ROLE_")) {
			inputRole = "ROLE_" + inputRole;
		}
		user.setRoles(inputRole);

		String verificationCode = UUID.randomUUID().toString();
		user.setVerificationCode(verificationCode);
		user.setVerified(false);

		userRepository.save(user);

		emailService.sendVerificationEmail(user.getEmail(), user.getUsername(), verificationCode);

		return ResponseEntity.ok("Verification code sent to your email. Please verify to complete registration.");
	}

	private boolean isValidEmail(String email) {
		if (email == null) {
			return false;
		}
		String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
		return email.matches(emailRegex);
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
		try {
			Authentication auth = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));

			UserDetails userDetails = (UserDetails) auth.getPrincipal();
			String accessToken = jwtUtil.generateAccessToken(userDetails.getUsername());
			String refreshToken = jwtUtil.generateRefreshToken(userDetails.getUsername());

			return ResponseEntity.ok(new AuthResponse(accessToken, refreshToken));

		} catch (BadCredentialsException ex) {
			System.out.println("Invalid credentials!");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
		} catch (UsernameNotFoundException ex) {
			System.out.println("User not found!");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not found");
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Authentication failed: " + ex.getMessage());
		}
	}

	@PostMapping("/refresh-token")
	public ResponseEntity<?> refreshToken(@RequestBody RefreshTokenRequest request) {
		try {
			String refreshToken = request.getRefreshToken();
			String username = jwtUtil.extractUsername(refreshToken);

			if (!jwtUtil.validateToken(refreshToken, username)) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid refresh token");
			}

			String newAccessToken = jwtUtil.generateAccessToken(username);

			return ResponseEntity.ok(new AuthResponse(newAccessToken, refreshToken));

		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Expired or invalid refresh token");
		}
	}

}
