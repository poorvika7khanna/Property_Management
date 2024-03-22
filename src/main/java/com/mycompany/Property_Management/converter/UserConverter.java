package com.mycompany.Property_Management.converter;

import com.mycompany.Property_Management.dto.UserDTO;
import com.mycompany.Property_Management.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    public UserEntity convertDTOtoEntity(UserDTO userDTO)
    {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setPhone(userDTO.getPhone());
        userEntity.setOwnerName(userDTO.getOwnerName());
        userEntity.setPassword(userDTO.getPassword());
        return userEntity;
    }

    public UserDTO convertEntityToDTO(UserEntity userEntity)
    {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userEntity.getId());
        userDTO.setEmail(userEntity.getEmail());
        userDTO.setPhone(userEntity.getPhone());
        userDTO.setOwnerName(userEntity.getOwnerName());
        return userDTO;
    }
}
