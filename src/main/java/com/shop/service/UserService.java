package com.shop.service;

import com.shop.entity.User;

public interface UserService 
{

	public User saveUser(User user);
		
	public User getByIdUser(Long userId);
	
	public User updateByUser(Long userId, User user);
	
	public String DeletByUser(Long userId);
}
