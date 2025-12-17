package com.shop.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserDTO {
	private Long id;

	@NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
	private String username;

	@NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
	private String email;

	@NotBlank(message = "Role is required")
	private String roles;

	@NotBlank(message = "Mobile number is mandatory")
	private String Mobileno;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getMobileno() {
		return Mobileno;
	}

	public void setMobileno(String mobileno) {
		Mobileno = mobileno;
	}

	
}
