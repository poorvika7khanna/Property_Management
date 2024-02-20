package com.mycompany.Property_Management.service.impl;

import com.mycompany.Property_Management.converter.UserConverter;
import com.mycompany.Property_Management.dto.UserDTO;
import com.mycompany.Property_Management.entity.UserEntity;
import com.mycompany.Property_Management.repository.UserRepository;
import com.mycompany.Property_Management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDTO register(UserDTO userDTO) {
        UserEntity userEntity=userConverter.convertDTOtoEntity(userDTO);
        userEntity=userRepository.save(userEntity);
        userDTO=userConverter.convertEntityToDTO(userEntity);
        return userDTO;
    }

    @Override
    public UserDTO login(String email, String password) {
        return null;
    }
}
