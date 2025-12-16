package com.shop.serviceimpl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.entity.User;
import com.shop.exception.ResourceNotFoundException;
import com.shop.repository.UserRepository;
import com.shop.service.UserService;


@Service
public class UserServiceImple implements UserService
{
	@Autowired
    private UserRepository userRepository;

	
    @Override
    public User saveUser(User user) {
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    @Override
    public User getByIdUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> {
                    return new ResourceNotFoundException("User with the given ID not found", 404, LocalDateTime.now());
                });
        return user;
    }

    @Override
    public User updateByUser(Long userId, User user) {
        User user2 = userRepository.findById(userId)
                .orElseThrow(() -> {
                    return new ResourceNotFoundException("User with the given ID not found", 404, LocalDateTime.now());
                });

        user2.setUserId(user.getUserId());
        user2.setEmail(user.getEmail());
        user2.setUsername(user.getEmail());
        user2.setPassword(user.getPassword());

        User updated = userRepository.save(user2);
        return updated;
    }

    @Override
    public String DeletByUser(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException("User with the given ID not found", 404, LocalDateTime.now());
        }

        userRepository.deleteById(userId);
        return "Deleted " + userId + " Successfully";
    }

}
