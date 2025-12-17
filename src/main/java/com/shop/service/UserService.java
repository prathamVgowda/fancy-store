package com.shop.service;

import java.util.List;

import com.shop.dto.UserDTO;

public interface UserService {

    UserDTO createUser(UserDTO dto);

    UserDTO updateUser(Long id, UserDTO dto);

    void deleteUser(Long id);

    UserDTO getUserById(Long id);

    List<UserDTO> getAllUsers();
}