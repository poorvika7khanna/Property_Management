package com.mycompany.Property_Management.service;

import com.mycompany.Property_Management.dto.UserDTO;

public interface UserService {
    UserDTO register(UserDTO userDTO);
    UserDTO login(String email, String password);
}
